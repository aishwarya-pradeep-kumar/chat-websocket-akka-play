package controllers;

import actors.ChatActor;
import actors.ChatBot;
import actors.Publisher;
import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.stream.javadsl.Flow;
import akka.stream.javadsl.Sink;
import akka.stream.javadsl.Source;
import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import views.html.*;

import javax.inject.Inject;
import java.util.*;

public class HomeController extends Controller {

    @Inject
    private FormFactory formFactory;
    @Inject
    public JedisPool jedisPool;
    private String email;
    private String chatHistory;
    private ActorSystem actorSystem = ActorSystem.create();
    private ActorRef chatRoomActor = actorSystem.actorOf(Props.create(ChatActor.class));
    public static final Publisher<JsonNode> publisher = new Publisher<>();

    public Result index() {
        return ok(index.render());
    }

    public Result login() {
        Set<String> members = new HashSet<>();
        DynamicForm dynamicForm = formFactory.form().bindFromRequest();
        String localEmail= dynamicForm.get("email");
        String localPass = dynamicForm.get("password");
        if(StringUtils.isEmpty(localEmail)) {
            flash("error", "Please choose a valid email.");
        } else if(localEmail != null)
        {
            if(null!=jedisPool) {
                Jedis jedis = jedisPool.getResource();
                if (jedis.exists(localEmail)) {
                    if(!localPass.equals(jedis.hget(localEmail,"password")))
                    {
                        flash("error", "Incorrect email password combination");
                        return redirect(routes.HomeController.index());
                    } else {
                        this.email = localEmail;
                        members = jedis.keys("*@*.*");
                        members.remove(localEmail);
                        return ok(views.html.onJoin.render(email,members));
                    }
                }
                else
                {
                    return ok(addUser.render());
                }
            }
        }
        return redirect(routes.HomeController.index());
    }

    public Result addUser() {
        Set<String> members = new HashSet<>();
        if(null!=jedisPool) {
            Jedis jedis = jedisPool.getResource();
            if(null!=formFactory)
            {
                DynamicForm dynamicForm = formFactory.form().bindFromRequest();
                String localEmail= dynamicForm.get("email");
                String localPass = dynamicForm.get("password");
                if(StringUtils.isEmpty(localEmail) && StringUtils.isEmpty(localEmail))
                    flash("error", "Please enter a valid email/password.");
                Long i = jedis.hset(localEmail, "password", localPass);
                this.email = localEmail;
                members = jedis.keys("*@*.*");
                members.remove(email);
                return ok(views.html.onJoin.render(email,members));
            }
            else throw new IllegalArgumentException();
        }
        return redirect(routes.HomeController.index());
    }

    public Result joinUsers(String email,String member) {
        Collection<String> messages = new ArrayList<>();
        int maxPage = 0;
        new ChatBot(chatRoomActor);
        if(null!=jedisPool) {
            Jedis jedis = jedisPool.getResource();
            chatHistory=jedis.hget(email,member);
            if(StringUtils.isEmpty(chatHistory))
            {
                String history = UUID.randomUUID().toString();
                long i= jedis.hset(email,member,history);
                long j= jedis.hset(member,email,history);
                chatHistory=history;
            }
            //if chat history exists get it else create new
            if(jedis.exists(chatHistory)) {
                messages = jedis.lrange(chatHistory, 0,9 );
            }
            maxPage = (int) Math.ceil(jedis.llen(chatHistory)/10L)+1;
        }
        return ok(views.html.chatRoom.render(email,member,messages,chatHistory,1,(maxPage==0)?1:maxPage));
    }

    public Result paginator(int currentPage,int maxPage, String member, String history) {
        Collection<String> messages = new ArrayList<>();
        if(null!=jedisPool)
        {
            Jedis jedis = jedisPool.getResource();
            if(jedis.exists(history))
            {
                long current = (long)((currentPage-1)*10);
                long noOfMess = (long)(currentPage*10-1);
                messages = jedis.lrange(history,current,noOfMess);
            }
        }
        return ok(views.html.chatRoom.render(email,member,messages,history,currentPage,(maxPage==0)?1:maxPage));
    }

    public WebSocket chat() {
        return WebSocket.Json.accept(requestHeader -> {
            Source<JsonNode, ?> source = publisher.register();
            Sink<JsonNode, NotUsed> sink = Sink.actorRef(chatRoomActor, "success");
            Flow<JsonNode, JsonNode, NotUsed> flow = Flow.fromSinkAndSource(sink, source);
            return flow;
        });
    }
}