
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object main_Scope0 {
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

class main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(connected: String)(content: Html):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.36*/("""

"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
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
            <div class="fill">
                <div class="container">
                    <a class="brand" href=""""),_display_(/*18.45*/routes/*18.51*/.HomeController.index()),format.raw/*18.74*/("""">Asapp Chat</a>

                    """),_display_(/*20.22*/if(connected != null)/*20.43*/ {_display_(Seq[Any](format.raw/*20.45*/("""
                        """),format.raw/*21.25*/("""<p class="pull-right">
                            Logged in as """),_display_(/*22.43*/connected),format.raw/*22.52*/(""" """),format.raw/*22.53*/("""—
                            <a href=""""),_display_(/*23.39*/routes/*23.45*/.HomeController.index()),format.raw/*23.68*/("""">Disconnect</a>
                        </p>
                    """)))}/*25.23*/else/*25.28*/{_display_(Seq[Any](format.raw/*25.29*/("""
                        """),format.raw/*26.25*/("""<form action=""""),_display_(/*26.40*/routes/*26.46*/.HomeController.login()),format.raw/*26.69*/("""" class="pull-right">
                            <input id="email" name="email" class="input-small" type="text" placeholder="Email Id">
                            <input id="password" name="password" class="input-small" type="password" placeholder="Password">
                            <button class="btn" type="submit">Sign in</button>
                        </form>
                    """)))}),format.raw/*31.22*/("""

                """),format.raw/*33.17*/("""</div>
            </div>
        </div>

        <div class="container">

            <div class="content">
                """),_display_(/*40.18*/content),format.raw/*40.25*/("""
            """),format.raw/*41.13*/("""</div>

        </div>

    </body>
</html>
"""))
      }
    }
  }

  def render(connected:String,content:Html): play.twirl.api.HtmlFormat.Appendable = apply(connected)(content)

  def f:((String) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (connected) => (content) => apply(connected)(content)

  def ref: this.type = this

}


}

/**/
object main extends main_Scope0.main
              /*
                  -- GENERATED --
                  DATE: Thu Oct 12 21:13:30 EDT 2017
                  SOURCE: /home/aishwarya/Dev/chat-websocket-akka-play/app/views/main.scala.html
                  HASH: c9bd41ec1313300cb739bc71e9483ece85cf5b94
                  MATRIX: 748->1|877->35|905->37|1050->156|1064->162|1131->208|1209->260|1223->266|1284->307|1367->364|1381->370|1441->409|1489->430|1504->436|1577->488|1838->722|1853->728|1897->751|1963->790|1993->811|2033->813|2086->838|2178->903|2208->912|2237->913|2304->953|2319->959|2363->982|2449->1050|2462->1055|2501->1056|2554->1081|2596->1096|2611->1102|2655->1125|3080->1519|3126->1537|3279->1663|3307->1670|3348->1683
                  LINES: 27->1|32->1|34->3|38->7|38->7|38->7|39->8|39->8|39->8|40->9|40->9|40->9|41->10|41->10|41->10|49->18|49->18|49->18|51->20|51->20|51->20|52->21|53->22|53->22|53->22|54->23|54->23|54->23|56->25|56->25|56->25|57->26|57->26|57->26|57->26|62->31|64->33|71->40|71->40|72->41
                  -- GENERATED --
              */
          