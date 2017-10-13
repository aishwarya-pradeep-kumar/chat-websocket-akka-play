
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object addUser_Scope0 {
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._

class addUser extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""<!DOCTYPE html>

<html>
<head>
    <title>Asapp Chat</title>
    <link rel="stylesheet" media="screen" href=""""),_display_(/*7.50*/routes/*7.56*/.Assets.versioned("stylesheets/bootstrap.css")),format.raw/*7.102*/("""">
    <link rel="stylesheet" media="screen" href=""""),_display_(/*8.50*/routes/*8.56*/.Assets.versioned("stylesheets/main.css")),format.raw/*8.97*/("""">
    <link rel="shortcut icon" type="image/png" href=""""),_display_(/*9.55*/routes/*9.61*/.Assets.versioned("images/favicon.png")),format.raw/*9.100*/("""">
    <script src=""""),_display_(/*10.19*/routes/*10.25*/.Assets.versioned("javascripts/jquery-1.7.1.min.js")),format.raw/*10.77*/("""" type="text/javascript"></script>
    </head>
    <body>
        
        <div class="topbar">
            <div class="fill">
                <div class="container">
                    <a class="brand" href=""""),_display_(/*17.45*/routes/*17.51*/.HomeController.index()),format.raw/*17.74*/("""">Asapp Chat</a>

                        <form method="POST" action=""""),_display_(/*19.54*/routes/*19.60*/.HomeController.addUser()),format.raw/*19.85*/("""" class="pull-right">
                            <input id="email" name="email" class="input-small" type="text" placeholder="Email Id">
                            <input id="password" name="password" class="input-small" type="password" placeholder="Password">
                            <button class="btn" type="submit">Sign Up</button>
                        </form>
                    
                </div>
            </div>
        </div>
        <div id="onAlert" class="alert-message">
            <p>
                <strong>Signup to chat</strong> <span></span>
            </p>
        </div>
    </body>
</html>
"""))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object addUser extends addUser_Scope0.addUser
              /*
                  -- GENERATED --
                  DATE: Thu Oct 12 18:18:44 EDT 2017
                  SOURCE: /home/aishwarya/Dev/chat-websocket-akka-play/app/views/addUser.scala.html
                  HASH: 6961777e645a4f58e7e02813b3c54e138237425f
                  MATRIX: 831->1|967->111|981->117|1048->163|1126->215|1140->221|1201->262|1284->319|1298->325|1358->364|1406->385|1421->391|1494->443|1732->654|1747->660|1791->683|1889->754|1904->760|1950->785
                  LINES: 32->2|37->7|37->7|37->7|38->8|38->8|38->8|39->9|39->9|39->9|40->10|40->10|40->10|47->17|47->17|47->17|49->19|49->19|49->19
                  -- GENERATED --
              */
          