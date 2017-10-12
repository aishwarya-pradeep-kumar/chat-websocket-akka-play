
// @GENERATOR:play-routes-compiler
// @SOURCE:/home/aishwarya/Dev/chat-websocket-akkastream-play2.5/conf/routes
// @DATE:Wed Oct 11 23:29:24 EDT 2017

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  HomeController_0: controllers.HomeController,
  // @LINE:8
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    HomeController_0: controllers.HomeController,
    // @LINE:8
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, Assets_1, "/")

  import ReverseRouteContext.empty

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """signup""", """controllers.HomeController.addUser()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.HomeController.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """chat""", """controllers.HomeController.chat()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """joinUsers""", """controllers.HomeController.joinUsers(email:String, member:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """paginate""", """controllers.HomeController.paginator(currentPage:Integer, maxPage:Integer, member:String, history:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      """""",
      this.prefix + """"""
    )
  )

  // @LINE:3
  private[this] lazy val controllers_HomeController_addUser1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("signup")))
  )
  private[this] lazy val controllers_HomeController_addUser1_invoker = createInvoker(
    HomeController_0.addUser(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "addUser",
      Nil,
      "POST",
      """""",
      this.prefix + """signup"""
    )
  )

  // @LINE:4
  private[this] lazy val controllers_HomeController_login2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_HomeController_login2_invoker = createInvoker(
    HomeController_0.login(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "login",
      Nil,
      "GET",
      """""",
      this.prefix + """login"""
    )
  )

  // @LINE:5
  private[this] lazy val controllers_HomeController_chat3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("chat")))
  )
  private[this] lazy val controllers_HomeController_chat3_invoker = createInvoker(
    HomeController_0.chat(),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "chat",
      Nil,
      "GET",
      """""",
      this.prefix + """chat"""
    )
  )

  // @LINE:6
  private[this] lazy val controllers_HomeController_joinUsers4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("joinUsers")))
  )
  private[this] lazy val controllers_HomeController_joinUsers4_invoker = createInvoker(
    HomeController_0.joinUsers(fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "joinUsers",
      Seq(classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """joinUsers"""
    )
  )

  // @LINE:7
  private[this] lazy val controllers_HomeController_paginator5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("paginate")))
  )
  private[this] lazy val controllers_HomeController_paginator5_invoker = createInvoker(
    HomeController_0.paginator(fakeValue[Integer], fakeValue[Integer], fakeValue[String], fakeValue[String]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "paginator",
      Seq(classOf[Integer], classOf[Integer], classOf[String], classOf[String]),
      "GET",
      """""",
      this.prefix + """paginate"""
    )
  )

  // @LINE:8
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      """""",
      this.prefix + """assets/""" + "$" + """file<.+>"""
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_HomeController_index0_route(params) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index())
      }
  
    // @LINE:3
    case controllers_HomeController_addUser1_route(params) =>
      call { 
        controllers_HomeController_addUser1_invoker.call(HomeController_0.addUser())
      }
  
    // @LINE:4
    case controllers_HomeController_login2_route(params) =>
      call { 
        controllers_HomeController_login2_invoker.call(HomeController_0.login())
      }
  
    // @LINE:5
    case controllers_HomeController_chat3_route(params) =>
      call { 
        controllers_HomeController_chat3_invoker.call(HomeController_0.chat())
      }
  
    // @LINE:6
    case controllers_HomeController_joinUsers4_route(params) =>
      call(params.fromQuery[String]("email", None), params.fromQuery[String]("member", None)) { (email, member) =>
        controllers_HomeController_joinUsers4_invoker.call(HomeController_0.joinUsers(email, member))
      }
  
    // @LINE:7
    case controllers_HomeController_paginator5_route(params) =>
      call(params.fromQuery[Integer]("currentPage", None), params.fromQuery[Integer]("maxPage", None), params.fromQuery[String]("member", None), params.fromQuery[String]("history", None)) { (currentPage, maxPage, member, history) =>
        controllers_HomeController_paginator5_invoker.call(HomeController_0.paginator(currentPage, maxPage, member, history))
      }
  
    // @LINE:8
    case controllers_Assets_versioned6_route(params) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
