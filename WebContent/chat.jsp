<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chat</title>
        <style media="screen" type="text/css">
        .chat {
                width: 100%;
                height: 200px;
                border: 1px solid silver;
                overflow-y: scroll;
        }
        #msg {width: 99%;}
        h1 {text-align: center;}
        </style>
    </head>
    <script type="text/javascript">
	    var wsUrl;
	    if (window.location.protocol == 'http:') {
	        wsUrl = 'ws://';
	    } else {
	        wsUrl = 'wss://';
	    }
	    var ws = new WebSocket(wsUrl + window.location.host + "/ProjectTest1/chat");
	        
	    ws.onmessage = function(event) {
	      var mySpan = document.getElementById("chat");
	      mySpan.innerHTML+=event.data+"<br/>";
	    };
	     
	    ws.onerror = function(event){
	        console.log("Error ", event)
	    } 
	    function sendMsg() {
	    	var user = document.getElementById("username").value;
	        var msg = user+": "+document.getElementById("msg").value;
	        if(msg)
	        {
	            ws.send(msg);
	        }
	        document.getElementById("msg").value="";
	    }
	</script>
    <body>
		<div>
			<a href='/ProjectTest1'> Main page </a>
			<a href='/ProjectTest1/posts'> Posts Board </a>
			<a href='/ProjectTest1/chat-page'> Chat room </a>
		</div>
        <h1>Chat room</h1>
		<div>
		    <div id="chat" class="chat"></div>
		    <div>
		    <input id="username" value="${user.username}" hidden="true">
			<input type="text" name="msg" id="msg" placeholder="Enter message here"/>
		        <button onclick="return sendMsg();">Enter</button>
		    </div>
		</div>
    </body>
</html>