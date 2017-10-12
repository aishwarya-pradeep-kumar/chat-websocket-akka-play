package actors;

import akka.actor.UntypedActor;
import com.fasterxml.jackson.databind.JsonNode;
import play.libs.Json;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import static controllers.HomeController.publisher;

public class ChatActor extends UntypedActor {

    public JedisPool jedisPool = new JedisPool("localhost");

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

                    JsonNode talkToClient =
                            Json.newObject()
                                    .put("type", "text")
                                    .put("username", talkedUser)
                                    .put("message", chatMessage)
                                    .put("metaData", "video");
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
}
