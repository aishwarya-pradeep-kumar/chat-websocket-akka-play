
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/aishwarya/Dev/chat-websocket-akka-play/conf/routes
// @DATE:Thu Oct 12 18:18:43 EDT 2017

import play.api.routing.JavaScriptReverseRoute
import play.api.mvc.{ QueryStringBindable, PathBindable, Call, JavascriptLiteral }
import play.core.routing.{ HandlerDef, ReverseRouteContext, queryString, dynamicString }


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:1
package controllers.javascript {
  import ReverseRouteContext.empty

  // @LINE:1
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def paginator: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.paginator",
      """
        function(currentPage0,maxPage1,member2,history3) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "paginate" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("currentPage", currentPage0), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("maxPage", maxPage1), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("member", member2), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("history", history3)])})
        }
      """
    )
  
    // @LINE:3
    def addUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.addUser",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "signup"})
        }
      """
    )
  
    // @LINE:6
    def joinUsers: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.joinUsers",
      """
        function(email0,member1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "joinUsers" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("email", email0), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("member", member1)])})
        }
      """
    )
  
    // @LINE:5
    def chat: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.chat",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "chat"})
        }
      """
    )
  
    // @LINE:1
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
    // @LINE:4
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
