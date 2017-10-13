
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object onJoin_Scope0 {
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

class onJoin extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template2[String,Set[String],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(username: String,members: Set[String]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.41*/("""

"""),_display_(/*3.2*/main(username)/*3.16*/ {_display_(Seq[Any](format.raw/*3.18*/("""

"""),format.raw/*5.1*/("""<div class="page-header">
    <h1>Welcome to Asapp Chat <small>You are chatting as """),_display_(/*6.59*/username),format.raw/*6.67*/("""</small></h1>
</div>

<div id="onError" class="alert-message error">
    <p>
        <strong>Oops!</strong> <span></span>
    </p>
</div>

<div class="row">
    <div>
        <h2>Choose a member</h2>
        <ul id="memberbuttons">
            """),_display_(/*19.14*/for(member <- members) yield /*19.36*/ {_display_(Seq[Any](format.raw/*19.38*/("""
            """),format.raw/*20.13*/("""<li style="color:black;list-style-type: none;"><a href=""""),_display_(/*20.70*/routes/*20.76*/.HomeController.joinUsers(username,member)),format.raw/*20.118*/("""">"""),_display_(/*20.121*/member),format.raw/*20.127*/("""</a></li>
            """)))}),format.raw/*21.14*/("""
        """),format.raw/*22.9*/("""</ul>
    </div>
</div>
""")))}))
      }
    }
  }

  def render(username:String,members:Set[String]): play.twirl.api.HtmlFormat.Appendable = apply(username,members)

  def f:((String,Set[String]) => play.twirl.api.HtmlFormat.Appendable) = (username,members) => apply(username,members)

  def ref: this.type = this

}


}

/**/
object onJoin extends onJoin_Scope0.onJoin
              /*
                  -- GENERATED --
                  DATE: Fri Oct 13 10:25:25 GMT 2017
                  SOURCE: /code/app/views/onJoin.scala.html
                  HASH: a3c31b3a208953f514049037a3820c33a11086ad
                  MATRIX: 759->1|893->40|921->43|943->57|982->59|1010->61|1120->145|1148->153|1420->398|1458->420|1498->422|1539->435|1623->492|1638->498|1702->540|1733->543|1761->549|1815->572|1851->581
                  LINES: 27->1|32->1|34->3|34->3|34->3|36->5|37->6|37->6|50->19|50->19|50->19|51->20|51->20|51->20|51->20|51->20|51->20|52->21|53->22
                  -- GENERATED --
              */
          