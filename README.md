The Details
-----------
Architecture overview:
----------------------
1) WebSocket: Communication between the client and server
2) Parallel processing using Akka toolkit
3) Backend using Redis

Framework used for server: Play Framework

Why use Play Framework?
1) It's great for building a quick MVC
2) Play handles every request in an asynchronous, non-blocking way.
3) The controller code below, the returned Result is internally enclosed in a promise
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
public Result index() {
    return ok("Got request " + request() + "!");
}
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
4) Integration with Akka is easy

The application is configured to start a Netty Server.
Currently the API return text/html content type, this can be changed easily to accomodate JSON (I tried to focus on building a non-blocking scalable application)

Why use WebSocket?
---------------------
1) Low-latency two-way communication becomes possible on a single connection if you implement WebSocket. 
2) Sending an HTTP request is no longer required every time a user sends a message, allowing more resources to be used efficiently.
3) The payload format for websocket connection is JSON.
4) I have not implemented a mechanism to disconnect and reconnect in case of network unstability (Although there is a chatbot that tries to keep the session alive).

Why use Akka Streams?
-------------
1) Each actor is assigned its own light-weight thread and runs within that thread.
2) By using streams we get the added benefit of backpressure, a form of flow control which limits the incoming messages until there is demand downstream

The app handles the below scenarios:
![](https://media.giphy.com/media/xT9IgNBfKIX6LB5syc/giphy.gif)

* Create User
	
Takes a username and password and creates a new user in a persisted data store. For example, the endpoint might accept PUT or POST at /users.

* Send Message

Takes a sender, recipient, and message and saves that to the data store. For example, the endpoint might accept PUT or POST at /messages. Three different message types are supported. (1) is a basic text-only message. (2) is an image link. (3) is a video link. The image and video links are saved with some additional metadata: width and height for the image, length of the video and source (YouTube, Vevo) for the video. For the purpose of the challenge, you can hard-code the metadata to some fixed values when you're saving the message.

* Fetch Messages

Takes two users and loads all messages sent between them. This call should also take two optional parameters in order to support pagination: the number of message to show per page and which page to load. For example, the endpoint might accept GET at /messages.


Running the Application
-----------------------
1) Run docker-compose build (it builds the containers)
2) docker-compose up

Resource: https://engineering.linecorp.com/en/blog/detail/85
