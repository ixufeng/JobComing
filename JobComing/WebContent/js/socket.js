/*websocket插件分装*/
(function($){
	
	var websocket = new Object();
	
	websocket.init = function(url){
		if ('WebSocket' in window) {
			 return new WebSocket(url);	 
		}
		return null;	
	}
	
	$.ws = websocket;
	
})(jQuery);




var ws = $.ws.init("ws://192.168.9.202:8080/JobComing/websocket");

ws.onopen = function(){
	console.log("链接成功");
}

ws.onmessage = function(data){
	$("#content").append("<li>"+data.data+"</li>");
}
$("#websocketSend").click(function(){
	
	var content = $("#websocketContent").val();
	var json = "{'receivedUserKey':'xufeng','content':'"+content+"'}";
	ws.send(json);
	$("#content").append("<li>"+content+"</li>");
});