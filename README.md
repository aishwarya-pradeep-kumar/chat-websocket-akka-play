The Details
-----------
Architecture overview:
----------------------
# WebSocket: Communication between the client and server
# Parallel processing using Akka toolkit
# Backend using Redis

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
# Low-latency two-way communication becomes possible on a single connection if you implement WebSocket. 
# Sending an HTTP request is no longer required every time a user sends a message, allowing more resources to be used efficiently.

When messages are transmitted over a single connection, both the servers and clients need to know the payload format to handle payloads properly. This is because they cannot separate the response format by the type of endpoints as they would normally do with Web API. The live chat implementation uses JSON payload format. And we've added one common field to the JSON format that indicates what each payload represents so that every one of them can be mapped to the corresponding class. This approach has enabled us to easily define a new payload type, such as a payload for implementing a pre-paid gift.

Sometimes connections go on and off especially when watching a particularly long live-stream on a mobile device. To prevent such connection problems, we keep watch on the payload transmissions and have the connection disconnect and reconnect when the network seems unstable.
* Create User
	
Takes a username and password and creates a new user in a persisted data store. For example, the endpoint might accept PUT or POST at /users.

* Send Message

Takes a sender, recipient, and message and saves that to the data store. For example, the endpoint might accept PUT or POST at /messages. Three different message types are supported. (1) is a basic text-only message. (2) is an image link. (3) is a video link. The image and video links are saved with some additional metadata: width and height for the image, length of the video and source (YouTube, Vevo) for the video. For the purpose of the challenge, you can hard-code the metadata to some fixed values when you're saving the message.

* Fetch Messages

Takes two users and loads all messages sent between them. This call should also take two optional parameters in order to support pagination: the number of message to show per page and which page to load. For example, the endpoint might accept GET at /messages.



Starter Kit
-----------
We've included a Docker-based starter kit with some commonly used languages. The kit includes a skeleton db and server code. You're welcome but not required to use this as the basis of your project. To use the starter kit, follow the readme in challenge-eng-base-master.

If opting not to use the starter kit, Please include a script that builds and launches your server.


Suggestions
-----------

* We very much value code quality and technical design. Think about the structure of your APIs, your data models, and the readability of your code.
* At ASAPP, we use a lot of Go and MySQL. For the challenge, we’d like you to be able to work in languages with which you’re comfortable, but we do suggest the following:
```
    Backend: Go, Python, Java, Node
    Database: SQL (including SQLite, MySQL, Postgres)
```
* Use open source libraries rather than reinventing the wheel. Here are a couple of relevant tools that we use:
```
    github.com/go-sql-driver/mysql
    golang.org/x/crypto/bcrypt
```
* Please include a sample request (cURL commands, Postman collection, etc) for each of your API endpoints.
* Please don't use the trademark ASAPP in the project. We hope the project is work that you're proud of, and we want you to be able to share it with others or make it public should you wish to.
* Have fun!

Resource: https://engineering.linecorp.com/en/blog/detail/85
