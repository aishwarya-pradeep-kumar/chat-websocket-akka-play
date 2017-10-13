package actors;

import akka.actor.ActorRef;
import akka.stream.javadsl.Source;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.libs.Akka;
import play.libs.Json;
import scala.concurrent.duration.Duration;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.concurrent.TimeUnit.SECONDS;


public class ChatBot {
    public static final Publisher<JsonNode> publisher = new Publisher<>();

    public ChatBot(ActorRef chat) {

        ObjectNode chatBotJoin = Json.newObject();
        chatBotJoin.put("type", "joined");
        chatBotJoin.put("username", "chatbot");

        ObjectNode chatBotTalk = Json.newObject();
        chatBotTalk.put("type", "talk");
        chatBotTalk.put("username", "chatbot");
        chatBotTalk.put("chatHistory", "botChat");
        chatBotTalk.put("chatMessage", "Staying Alive!!");

        chat.tell(chatBotJoin, null);

        // Make the robot talk every 30 seconds
        Akka.system().scheduler().schedule(
                Duration.create(20, MINUTES),
                Duration.create(20, MINUTES),
                chat,
                chatBotTalk,
                Akka.system().dispatcher(),
                /** sender **/null
        );

    }
}
