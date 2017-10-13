
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object index_Scope0 {
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

class index extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](_display_(/*1.2*/main(null)/*1.12*/ {_display_(Seq[Any](format.raw/*1.14*/("""

"""),_display_(/*3.2*/if(flash.containsKey("error"))/*3.32*/ {_display_(Seq[Any](format.raw/*3.34*/("""

"""),format.raw/*5.1*/("""<div class="alert-message error">
    <p>
        <strong>Oops!</strong> """),_display_(/*7.33*/flash/*7.38*/.get("error")),format.raw/*7.51*/("""
    """),format.raw/*8.5*/("""</p>
</div>

""")))}),format.raw/*11.2*/("""
"""),format.raw/*12.1*/("""<div class="alert-message block-message info">
    <p>
        <strong>Send a message Asapp!</strong>
        Enter your username and password to sign in.
    </p>
</div>

""")))}))
      }
    }
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}


}

/**/
object index extends index_Scope0.index
              /*
                  -- GENERATED --
                  DATE: Fri Oct 13 10:25:25 GMT 2017
                  SOURCE: /code/app/views/index.scala.html
                  HASH: 62346e1d648f92ec6f58b1b68918f2390f112f17
                  MATRIX: 827->1|845->11|884->13|912->16|950->46|989->48|1017->50|1117->124|1130->129|1163->142|1194->147|1238->161|1266->162
                  LINES: 32->1|32->1|32->1|34->3|34->3|34->3|36->5|38->7|38->7|38->7|39->8|42->11|43->12
                  -- GENERATED --
              */
          