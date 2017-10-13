
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/aishwarya/Dev/chat-websocket-akka-play/conf/routes
// @DATE:Thu Oct 12 18:18:43 EDT 2017


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
