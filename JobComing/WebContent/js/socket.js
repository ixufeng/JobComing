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




var ws = $.ws.init("ws://localhost:8080/JobComing/websocket");
console.log(ws);
console.log("链接成功了吗");
ws.onopen = function(){
	
	console.log("链接成功");
}

ws.onmessage = function(data){
	console.log(data.data);
}
$("#websocketSend").click(function(){
	var content = $("#websocketContent").val();
	ws.send(content);
});