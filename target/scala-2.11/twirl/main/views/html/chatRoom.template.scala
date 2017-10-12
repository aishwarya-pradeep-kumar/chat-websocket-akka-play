
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
<div class="container-fluid">
    <div id="onopen" class="row">
        <div class="span10" id="main">
                <ul id="messages" class="media-list">"""),_display_(/*34.55*/for(message <- messages) yield /*34.79*/ {_display_(Seq[Any](format.raw/*34.81*/("""
                    """),format.raw/*35.21*/("""<li class="media">
                        <div class="media-body">
                            <div class="media">
                                <div class="media-body">
                                    """),_display_(/*39.38*/display(message)),format.raw/*39.54*/("""
                                """),format.raw/*40.33*/("""</div>
                            </div>
                        </div></li>
                        """)))}),format.raw/*43.26*/("""</ul>
            <input id="message"></input>
            <button id="sendButton" type="submit">Send</button>
            """),_display_(/*46.14*/pagination(currentPage,maxPage,member,chatHistory)),format.raw/*46.64*/("""
        """),format.raw/*47.9*/("""</div>
        <div class="span4">
            <h2>Member</h2>
            <ul id="members">
                """),_display_(/*51.18*/member),format.raw/*51.24*/("""
            """),format.raw/*52.13*/("""</ul>
        </div>
    </div>
</div>
    <script>
    window.onload = function() """),format.raw/*57.32*/("""{"""),format.raw/*57.33*/("""
    """),format.raw/*58.5*/("""var chatSocket = new WebSocket(""""),_display_(/*58.38*/routes/*58.44*/.HomeController.chat().webSocketURL(request)),format.raw/*58.88*/("""");
    var username = """"),_display_(/*59.22*/email),format.raw/*59.27*/("""";
    var member = """"),_display_(/*60.20*/member),format.raw/*60.26*/("""";
    var chatHistory = """"),_display_(/*61.25*/chatHistory),format.raw/*61.36*/("""";
    chatSocket.onerror = function(error) """),format.raw/*62.42*/("""{"""),format.raw/*62.43*/("""
            """),format.raw/*63.13*/("""console.log('WebSocket Error: ' + error);
        """),format.raw/*64.9*/("""}"""),format.raw/*64.10*/(""";

        chatSocket.onopen = function(event) """),format.raw/*66.45*/("""{"""),format.raw/*66.46*/("""
            """),format.raw/*67.13*/("""$('#status').text('Connected to WebSocket');
        """),format.raw/*68.9*/("""}"""),format.raw/*68.10*/(""";

        chatSocket.onmessage = function(event) """),format.raw/*70.48*/("""{"""),format.raw/*70.49*/("""
            """),format.raw/*71.13*/("""var message = JSON.parse(event.data);
            console.log(message);
            $('#messages').append('<li class="received">'+message.username+' : '+ message.message + '</li>');
        """),format.raw/*74.9*/("""}"""),format.raw/*74.10*/(""";

        chatSocket.onclose = function(event) """),format.raw/*76.46*/("""{"""),format.raw/*76.47*/("""
            """),format.raw/*77.13*/("""$('#status').text('Disconnected from WebSocket.');
        """),format.raw/*78.9*/("""}"""),format.raw/*78.10*/(""";

        $('#memberbuttons').click(function(e) """),format.raw/*80.47*/("""{"""),format.raw/*80.48*/("""
            """),format.raw/*81.13*/("""$('#message').removeClass('hide');
            e.preventDefault();
            username1 = $('#username').val();
            console.log(username);
            chatSocket.send(JSON.stringify("""),format.raw/*85.44*/("""{"""),format.raw/*85.45*/("""type: 'join', username: username"""),format.raw/*85.77*/("""}"""),format.raw/*85.78*/("""));
            $('#username').val('');
            return false;
        """),format.raw/*88.9*/("""}"""),format.raw/*88.10*/(""");

        $('#sendButton').click(function(e) """),format.raw/*90.44*/("""{"""),format.raw/*90.45*/("""
            """),format.raw/*91.13*/("""e.preventDefault();
            var message = $('#message').val();

            chatSocket.send(JSON.stringify("""),format.raw/*94.44*/("""{"""),format.raw/*94.45*/("""type: "talk", username: username, chatHistory: chatHistory,chatMessage: message"""),format.raw/*94.124*/("""}"""),format.raw/*94.125*/("""));
            $('#message').val('');
            return false;
        """),format.raw/*97.9*/("""}"""),format.raw/*97.10*/(""");
"""),format.raw/*98.1*/("""}"""),format.raw/*98.2*/("""
    """),format.raw/*99.5*/("""</script>
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
                  DATE: Thu Oct 12 01:02:01 EDT 2017
                  SOURCE: /home/aishwarya/Dev/chat-websocket-akkastream-play2.5/app/views/chatRoom.scala.html
                  HASH: 92d1df9ac47fb163a9d2bea55dbf03469e984e21
                  MATRIX: 800->1|999->125|1013->132|1110->153|1141->159|1190->193|1229->195|1265->205|1306->238|1345->240|1385->254|1444->298|1483->300|1527->318|1555->338|1594->340|1642->361|1675->368|1699->372|1727->373|1784->400|1829->414|1870->425|1911->457|1951->459|1992->473|2053->518|2093->520|2138->538|2167->558|2207->560|2256->581|2290->588|2316->593|2372->618|2417->632|2458->642|2494->648|2536->122|2565->650|2594->653|2614->664|2654->666|2686->671|3083->1041|3123->1065|3163->1067|3212->1088|3449->1298|3486->1314|3547->1347|3681->1450|3832->1574|3903->1624|3939->1633|4076->1743|4103->1749|4144->1762|4255->1845|4284->1846|4316->1851|4376->1884|4391->1890|4456->1934|4508->1959|4534->1964|4583->1986|4610->1992|4664->2019|4696->2030|4768->2074|4797->2075|4838->2088|4915->2138|4944->2139|5019->2186|5048->2187|5089->2200|5169->2253|5198->2254|5276->2304|5305->2305|5346->2318|5563->2508|5592->2509|5668->2557|5697->2558|5738->2571|5824->2630|5853->2631|5930->2680|5959->2681|6000->2694|6219->2885|6248->2886|6308->2918|6337->2919|6438->2993|6467->2994|6542->3041|6571->3042|6612->3055|6751->3166|6780->3167|6888->3246|6918->3247|7018->3320|7047->3321|7077->3324|7105->3325|7137->3330
                  LINES: 27->1|31->3|31->3|33->3|34->4|34->4|34->4|35->5|35->5|35->5|36->6|36->6|36->6|37->7|37->7|37->7|38->8|38->8|38->8|38->8|39->9|40->10|41->11|41->11|41->11|42->12|42->12|42->12|43->13|43->13|43->13|44->14|44->14|44->14|45->15|46->16|47->17|48->18|50->1|52->19|54->21|54->21|54->21|55->22|67->34|67->34|67->34|68->35|72->39|72->39|73->40|76->43|79->46|79->46|80->47|84->51|84->51|85->52|90->57|90->57|91->58|91->58|91->58|91->58|92->59|92->59|93->60|93->60|94->61|94->61|95->62|95->62|96->63|97->64|97->64|99->66|99->66|100->67|101->68|101->68|103->70|103->70|104->71|107->74|107->74|109->76|109->76|110->77|111->78|111->78|113->80|113->80|114->81|118->85|118->85|118->85|118->85|121->88|121->88|123->90|123->90|124->91|127->94|127->94|127->94|127->94|130->97|130->97|131->98|131->98|132->99
                  -- GENERATED --
              */
          