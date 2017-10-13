package actors;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import com.fasterxml.jackson.databind.JsonNode;
import com.linkedin.urls.Url;
import com.linkedin.urls.detection.UrlDetector;
import com.linkedin.urls.detection.UrlDetectorOptions;
import play.libs.Json;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import static controllers.HomeController.publisher;

public class ChatActor extends UntypedActor {

    public JedisPool jedisPool = new JedisPool("localhost");
    private final LoggingAdapter logger = Logging.getLogger(getContext().system(), this);

    @Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof JsonNode) {
            JsonNode jsonMessage = (JsonNode) message;
            String type = jsonMessage.get("type").textValue();

            switch (type) {
                case "join":
                    String joinedUser = jsonMessage.get("username").asText();
                    JsonNode joinToClient =
                            Json.newObject()
                                    .put("type", "joined")
                                    .put("email", joinedUser);
                    publisher.broadcast(joinToClient);
                    break;

                case "talk":
                    String talkedUser = jsonMessage.get("username").asText();
                    String chatMessage = jsonMessage.get("chatMessage").asText();
                    String chatHistory = jsonMessage.get("chatHistory").asText();
                    String metaData = checkIncomingString(chatMessage,talkedUser);
                    JsonNode talkToClient =
                            Json.newObject()
                                    .put("type", "text")
                                    .put("username", talkedUser)
                                    .put("message", chatMessage)
                                    .put("metaData", metaData);
                    if(null!=jedisPool) {
                        Jedis jedis = jedisPool.getResource();
                        Long i=jedis.rpush(chatHistory, String.valueOf(talkToClient));
                    }
                    publisher.broadcast(talkToClient);
                    break;

                default:
                    System.out.println("Json Error: type is not allowed");
                    break;
            }
        } else {
            System.out.println("chatActor received not Json");
        }
    }

    //Using LinkedIn's URL detector https://engineering.linkedin.com/blog/2016/06/open-sourcing-url-detector--a-java-library-to-detect-and-normali
    private String checkIncomingString(String chatMessage, String talkedUser) {
        UrlDetector parser = new UrlDetector(chatMessage, UrlDetectorOptions.Default);
        List<Url> stringUrl = parser.detect();
        String metaData = "text";
        JsonNode talkToClient = Json.newObject();
        for (Url url : stringUrl) {
            logger.info("Scheme: " + url.getScheme());
            logger.info("Host: " + url.getHost());
            logger.info("Path: " + url.getPath());

            //Get HTTP Header for metadata
            //Not handling redirects
            URL obj = null;
            try {
                obj = new URL(url.getFullUrl());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            URLConnection conn = null;
            try {
                conn = obj.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Map<String, List<String>> map = conn.getHeaderFields();

            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                metaData += entry.getKey() + " : " + entry.getValue();
                logger.info(entry.getKey() + " : " + entry.getValue());
            }
        }
        return metaData;
    }
}
