
package views.html

import play.twirl.api._
import play.twirl.api.TemplateMagic._


     object chatRoom_Scope0 {
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

class chatRoom extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template6[String,String,Collection[String],String,Integer,Integer,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(email: String, member: String, messages: Collection[String], chatHistory: String, currentPage: Integer,maxPage: Integer):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {

def /*3.2*/display/*3.9*/(message: String):play.twirl.api.HtmlFormat.Appendable = {_display_(

Seq[Any](format.raw/*3.30*/("""
    """),_display_(/*4.6*/for(tag <- message.split("\",\"")) yield /*4.40*/ {_display_(Seq[Any](format.raw/*4.42*/("""
        """),_display_(/*5.10*/if(tag.indexOf("username") != -1)/*5.43*/ {_display_(Seq[Any](format.raw/*5.45*/("""
            """),_display_(/*6.14*/for(user <- tag.replace("\"","").split(":")) yield /*6.58*/ {_display_(Seq[Any](format.raw/*6.60*/("""
                """),_display_(/*7.18*/if(user!="username")/*7.38*/ {_display_(Seq[Any](format.raw/*7.40*/("""
                    """),format.raw/*8.21*/("""<span>"""),_display_(/*8.28*/user),format.raw/*8.32*/(""" """),format.raw/*8.33*/(""": </span>
                """)))}),format.raw/*9.18*/("""
            """)))}),format.raw/*10.14*/("""
        """)))}),_display_(/*11.11*/if(tag.indexOf("message") != -1)/*11.43*/ {_display_(Seq[Any](format.raw/*11.45*/("""
            """),_display_(/*12.14*/for(value <- tag.replace("\"","").split(":")) yield /*12.59*/ {_display_(Seq[Any](format.raw/*12.61*/("""
                """),_display_(/*13.18*/if(value!="message")/*13.38*/ {_display_(Seq[Any](format.raw/*13.40*/("""
                    """),format.raw/*14.21*/("""<span>"""),_display_(/*14.28*/value),format.raw/*14.33*/("""</span>
                """)))}),format.raw/*15.18*/("""
            """)))}),format.raw/*16.14*/("""
        """)))}),format.raw/*17.10*/("""
    """)))}),format.raw/*18.6*/("""
""")))};
Seq[Any](format.raw/*1.123*/("""

"""),format.raw/*19.2*/("""

"""),_display_(/*21.2*/main(email)/*21.13*/ {_display_(Seq[Any](format.raw/*21.15*/("""
    """),format.raw/*22.5*/("""<div class="page-header">
        <h1>Welcome to Asapp Chat</h1>
    </div>

    <div id="onError" class="alert-message error">
        <p>
            <strong>Oops!</strong> <span></span>
        </p>
    </div>
    <div id="onopen" class="row">
        <div class="span10" id="main">
                <ul id="messages">"""),_display_(/*33.36*/for(message <- messages) yield /*33.60*/ {_display_(Seq[Any](format.raw/*33.62*/("""
                    """),format.raw/*34.21*/("""<li>"""),_display_(/*34.26*/display(message)),format.raw/*34.42*/("""</li>""")))}),format.raw/*34.48*/("""</ul>
            <textarea id="message"></textarea>
            <button id="sendButton" class="btn primary" type="submit">Send</button>
        </div>
        <div class="span4">
            <h2>Member</h2>
            <ul id="members">
                """),_display_(/*41.18*/member),format.raw/*41.24*/("""
            """),format.raw/*42.13*/("""</ul>
        </div>
        """),_display_(/*44.10*/pagination(currentPage,maxPage,member,chatHistory)),format.raw/*44.60*/("""
    """),format.raw/*45.5*/("""</div>
    <script>
    window.onload = function() """),format.raw/*47.32*/("""{"""),format.raw/*47.33*/("""
    """),format.raw/*48.5*/("""var chatSocket = new WebSocket(""""),_display_(/*48.38*/routes/*48.44*/.HomeController.chat().webSocketURL(request)),format.raw/*48.88*/("""");
    var username = """"),_display_(/*49.22*/email),format.raw/*49.27*/("""";
    var member = """"),_display_(/*50.20*/member),format.raw/*50.26*/("""";
    var chatHistory = """"),_display_(/*51.25*/chatHistory),format.raw/*51.36*/("""";
    chatSocket.onerror = function(error) """),format.raw/*52.42*/("""{"""),format.raw/*52.43*/("""
            """),format.raw/*53.13*/("""console.log('WebSocket Error: ' + error);
        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/(""";

        chatSocket.onopen = function(event) """),format.raw/*56.45*/("""{"""),format.raw/*56.46*/("""
            """),format.raw/*57.13*/("""$('#status').text('Connected to WebSocket');
        """),format.raw/*58.9*/("""}"""),format.raw/*58.10*/(""";

        chatSocket.onmessage = function(event) """),format.raw/*60.48*/("""{"""),format.raw/*60.49*/("""
            """),format.raw/*61.13*/("""var message = JSON.parse(event.data);
            console.log(message);
            $('#messages').append('<li class="received">'+message.username+' : '+ message.message + '</li>');
        """),format.raw/*64.9*/("""}"""),format.raw/*64.10*/(""";

        chatSocket.onclose = function(event) """),format.raw/*66.46*/("""{"""),format.raw/*66.47*/("""
            """),format.raw/*67.13*/("""$('#status').text('Disconnected from WebSocket.');
        """),format.raw/*68.9*/("""}"""),format.raw/*68.10*/(""";

        $('#memberbuttons').click(function(e) """),format.raw/*70.47*/("""{"""),format.raw/*70.48*/("""
            """),format.raw/*71.13*/("""$('#message').removeClass('hide');
            e.preventDefault();
            username1 = $('#username').val();
            console.log(username);
            chatSocket.send(JSON.stringify("""),format.raw/*75.44*/("""{"""),format.raw/*75.45*/("""type: 'join', username: username"""),format.raw/*75.77*/("""}"""),format.raw/*75.78*/("""));
            $('#username').val('');
            return false;
        """),format.raw/*78.9*/("""}"""),format.raw/*78.10*/(""");

        $('#sendButton').click(function(e) """),format.raw/*80.44*/("""{"""),format.raw/*80.45*/("""
            """),format.raw/*81.13*/("""e.preventDefault();
            var message = $('#message').val();

            chatSocket.send(JSON.stringify("""),format.raw/*84.44*/("""{"""),format.raw/*84.45*/("""type: "talk", username: username, chatHistory: chatHistory,chatMessage: message"""),format.raw/*84.124*/("""}"""),format.raw/*84.125*/("""));
            $('#message').val('');
            return false;
        """),format.raw/*87.9*/("""}"""),format.raw/*87.10*/(""");
"""),format.raw/*88.1*/("""}"""),format.raw/*88.2*/("""
    """),format.raw/*89.5*/("""</script>
""")))}))
      }
    }
  }

  def render(email:String,member:String,messages:Collection[String],chatHistory:String,currentPage:Integer,maxPage:Integer): play.twirl.api.HtmlFormat.Appendable = apply(email,member,messages,chatHistory,currentPage,maxPage)

  def f:((String,String,Collection[String],String,Integer,Integer) => play.twirl.api.HtmlFormat.Appendable) = (email,member,messages,chatHistory,currentPage,maxPage) => apply(email,member,messages,chatHistory,currentPage,maxPage)

  def ref: this.type = this

}


}

/**/
object chatRoom extends chatRoom_Scope0.chatRoom
              /*
                  -- GENERATED --
                  DATE: Thu Oct 12 21:34:23 EDT 2017
                  SOURCE: /home/aishwarya/Dev/chat-websocket-akka-play/app/views/chatRoom.scala.html
                  HASH: ca76b195b60399c7ae59f0a4740f5da77ef18199
                  MATRIX: 800->1|999->125|1013->132|1110->153|1141->159|1190->193|1229->195|1265->205|1306->238|1345->240|1385->254|1444->298|1483->300|1527->318|1555->338|1594->340|1642->361|1675->368|1699->372|1727->373|1784->400|1829->414|1870->425|1911->457|1951->459|1992->473|2053->518|2093->520|2138->538|2167->558|2207->560|2256->581|2290->588|2316->593|2372->618|2417->632|2458->642|2494->648|2536->122|2565->650|2594->653|2614->664|2654->666|2686->671|3034->992|3074->1016|3114->1018|3163->1039|3195->1044|3232->1060|3269->1066|3551->1321|3578->1327|3619->1340|3676->1370|3747->1420|3779->1425|3858->1476|3887->1477|3919->1482|3979->1515|3994->1521|4059->1565|4111->1590|4137->1595|4186->1617|4213->1623|4267->1650|4299->1661|4371->1705|4400->1706|4441->1719|4518->1769|4547->1770|4622->1817|4651->1818|4692->1831|4772->1884|4801->1885|4879->1935|4908->1936|4949->1949|5166->2139|5195->2140|5271->2188|5300->2189|5341->2202|5427->2261|5456->2262|5533->2311|5562->2312|5603->2325|5822->2516|5851->2517|5911->2549|5940->2550|6041->2624|6070->2625|6145->2672|6174->2673|6215->2686|6354->2797|6383->2798|6491->2877|6521->2878|6621->2951|6650->2952|6680->2955|6708->2956|6740->2961
                  LINES: 27->1|31->3|31->3|33->3|34->4|34->4|34->4|35->5|35->5|35->5|36->6|36->6|36->6|37->7|37->7|37->7|38->8|38->8|38->8|38->8|39->9|40->10|41->11|41->11|41->11|42->12|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|46->16|47->17|48->18|50->1|52->19|54->21|54->21|54->21|55->22|66->33|66->33|66->33|67->34|67->34|67->34|67->34|74->41|74->41|75->42|77->44|77->44|78->45|80->47|80->47|81->48|81->48|81->48|81->48|82->49|82->49|83->50|83->50|84->51|84->51|85->52|85->52|86->53|87->54|87->54|89->56|89->56|90->57|91->58|91->58|93->60|93->60|94->61|97->64|97->64|99->66|99->66|100->67|101->68|101->68|103->70|103->70|104->71|108->75|108->75|108->75|108->75|111->78|111->78|113->80|113->80|114->81|117->84|117->84|117->84|117->84|120->87|120->87|121->88|121->88|122->89
                  -- GENERATED --
              */
          