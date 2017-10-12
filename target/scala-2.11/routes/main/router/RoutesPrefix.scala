
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/aishwarya/Dev/chat-websocket-akkastream-play2.5/conf/routes
// @DATE:Wed Oct 11 23:29:24 EDT 2017


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
