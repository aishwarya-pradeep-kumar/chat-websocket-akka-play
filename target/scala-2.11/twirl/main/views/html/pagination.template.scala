
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object pagination_Scope0 {
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

class pagination extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template4[Integer,Integer,String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(currentPage: Integer, maxPage: Integer, member: String, history: String):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.75*/("""

"""),format.raw/*3.1*/("""<div class="pagination">
    <ul>
        """),_display_(/*5.10*/if(currentPage == 1)/*5.30*/ {_display_(Seq[Any](format.raw/*5.32*/("""
        """),format.raw/*6.9*/("""<li class="disabled"><span>&laquo;</span></li>
        """)))}/*7.11*/else/*7.16*/{_display_(Seq[Any](format.raw/*7.17*/("""
        """),format.raw/*8.9*/("""<li><a href=""""),_display_(/*8.23*/controllers/*8.34*/.routes.HomeController.paginator(currentPage - 1,maxPage,member,history)),format.raw/*8.106*/("""">&laquo;</a></li>
        """)))}),format.raw/*9.10*/("""

        """),_display_(/*11.10*/for(index <- 1 to maxPage) yield /*11.36*/ {_display_(Seq[Any](format.raw/*11.38*/("""
        """),_display_(/*12.10*/if(currentPage == index)/*12.34*/ {_display_(Seq[Any](format.raw/*12.36*/("""
        """),format.raw/*13.9*/("""<li class="disabled"><span>"""),_display_(/*13.37*/index),format.raw/*13.42*/("""</span></li>
        """)))}/*14.11*/else/*14.16*/{_display_(Seq[Any](format.raw/*14.17*/("""
        """),format.raw/*15.9*/("""<li><a href=""""),_display_(/*15.23*/controllers/*15.34*/.routes.HomeController.paginator(index,maxPage,member,history)),format.raw/*15.96*/("""">"""),_display_(/*15.99*/index),format.raw/*15.104*/("""</a></li>
        """)))}),format.raw/*16.10*/("""
        """)))}),format.raw/*17.10*/("""

        """),_display_(/*19.10*/if(currentPage == maxPage)/*19.36*/ {_display_(Seq[Any](format.raw/*19.38*/("""
        """),format.raw/*20.9*/("""<li class="disabled"><span>&raquo;</span></li>
        """)))}/*21.11*/else/*21.16*/{_display_(Seq[Any](format.raw/*21.17*/("""
        """),format.raw/*22.9*/("""<li><a href=""""),_display_(/*22.23*/controllers/*22.34*/.routes.HomeController.paginator(currentPage + 1,maxPage,member,history)),format.raw/*22.106*/("""">&raquo;</a></li>
        """)))}),format.raw/*23.10*/("""
    """),format.raw/*24.5*/("""</ul>
</div>"""))
      }
    }
  }

  def render(currentPage:Integer,maxPage:Integer,member:String,history:String): play.twirl.api.HtmlFormat.Appendable = apply(currentPage,maxPage,member,history)

  def f:((Integer,Integer,String,String) => play.twirl.api.HtmlFormat.Appendable) = (currentPage,maxPage,member,history) => apply(currentPage,maxPage,member,history)

  def ref: this.type = this

}


}

/**/
object pagination extends pagination_Scope0.pagination
              /*
                  -- GENERATED --
                  DATE: Thu Oct 12 21:00:36 EDT 2017
                  SOURCE: /home/aishwarya/Dev/chat-websocket-akka-play/app/views/pagination.scala.html
                  HASH: 78b33ce06e40a63dc98090f9ba596540dc379def
                  MATRIX: 778->1|946->74|974->76|1043->119|1071->139|1110->141|1145->150|1219->207|1231->212|1269->213|1304->222|1344->236|1363->247|1456->319|1514->347|1552->358|1594->384|1634->386|1671->396|1704->420|1744->422|1780->431|1835->459|1861->464|1902->487|1915->492|1954->493|1990->502|2031->516|2051->527|2134->589|2164->592|2191->597|2241->616|2282->626|2320->637|2355->663|2395->665|2431->674|2506->731|2519->736|2558->737|2594->746|2635->760|2655->771|2749->843|2808->871|2840->876
                  LINES: 27->1|32->1|34->3|36->5|36->5|36->5|37->6|38->7|38->7|38->7|39->8|39->8|39->8|39->8|40->9|42->11|42->11|42->11|43->12|43->12|43->12|44->13|44->13|44->13|45->14|45->14|45->14|46->15|46->15|46->15|46->15|46->15|46->15|47->16|48->17|50->19|50->19|50->19|51->20|52->21|52->21|52->21|53->22|53->22|53->22|53->22|54->23|55->24
                  -- GENERATED --
              */
          