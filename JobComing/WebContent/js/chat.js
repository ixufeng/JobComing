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
$(document).ready(function () {
		/*当前正在聊天的人*/
		var currentPerson = "000000";
	    var preloadbg = document.createElement('img');
	    preloadbg.src = 'img/timeline1.png';
	    $('#searchfield').focus(function () {
	        if ($(this).val() == 'Search contacts...') {
	            $(this).val('');
	        }
	    });
	    $('#searchfield').focusout(function () {
	        if ($(this).val() == '') {
	            $(this).val('Search contacts...');
	        }
	    });
	    $('#sendmessage input').focus(function () {
	        if ($(this).val() == 'Send message...') {
	            $(this).val('');
	        }
	    });
	    $('#sendmessage input').focusout(function () {
	        if ($(this).val() == '') {
	            $(this).val('Send message...');
	        }
	    });
	    $("#friends").on("click",".friend",function(){
	    	
	    	currentPerson = $(this).attr("data-person");
            var childOffset = $(this).offset();
            var parentOffset = $(this).parent().parent().offset();
            var childTop = childOffset.top - parentOffset.top;
            var clone = $(this).find('img').eq(0).clone();
            var top = childTop + 12 + 'px';
            $(clone).css({ 'top': top }).addClass('floatingImg').appendTo('#chatbox');
            setTimeout(function () {
                $('#profile p').addClass('animate');
                $('#profile').addClass('animate');
            }, 100);
            setTimeout(function () {
                $('#chat-messages').addClass('animate');
                $('.cx, .cy').addClass('s1');
                setTimeout(function () {
                    $('.cx, .cy').addClass('s2');
                }, 100);
                setTimeout(function () {
                    $('.cx, .cy').addClass('s3');
                }, 200);
            }, 150);
            $('.floatingImg').animate({
                'width': '68px',
                'left': '108px',
                'top': '20px'
            }, 200);
            var name = $(this).find('p strong').html();
            var email = $(this).find('p span').html();
            $('#profile p').html(name);
            $('#profile span').html(email);
            $('.message').not('.right').find('img').attr('src', $(clone).attr('src'));
            $('#friendslist').fadeOut();
            $('#chatview').fadeIn();
            $('#close').unbind('click').click(function () {
                $('#chat-messages, #profile, #profile p').removeClass('animate');
                $('.cx, .cy').removeClass('s1 s2 s3');
                $('.floatingImg').animate({
                    'width': '40px',
                    'top': top,
                    'left': '12px'
                }, 200, function () {
                    $('.floatingImg').remove();
                });
                setTimeout(function () {
                    $('#chatview').fadeOut();
                    $('#friendslist').fadeIn();
                }, 50);
            });
	    });
	 
  
	    var ws = $.ws.init("ws://192.168.9.202:8080/JobComing/websocket");
		ws.onopen = function(){
			console.log("链接成功");
		}
		ws.onmessage = function(data){
			//接收消息
		var obj = eval("("+data.data+")"); 
		if(!$('#'+data.receivedUserName+'')){
			
			var friend = '<div class="friend">';
			friend+='<img src="img/2_copy.jpg" />';
			friend+='<p>';
			friend+='<strong>Martin Joseph</strong>';
			friend+='<span>marjoseph@gmail.com</span>';
			friend+='</p>';
			friend+='<div class="status away"></div>';
			friend+=' </div>';
			$("#friends").append(friend);
			
		}

			var html = '<div class="message">';
    		html += '<img src="img/2_copy.jpg" />';
    		html += '<div class="bubble">';
    		html += obj.content;
    		html += '<div class="corner"></div>';
    		html += '<span>3 min</span>';
    		html += '</div></div>';
	    	$('#chat-messages').append(html);	    	
	    	$("#chat-messages").animate({scrollTop: "300px"},300);
				
		}
		
		  //点击发送按钮
	    $("#send").click(function(){

	    	var content = $("#content").val();
	    	$("#content").val("");
	    	var html = '<div class="message right">';
	    		html += '<img src="img/2_copy.jpg" />';
	    		html += '<div class="bubble">';
	    		html += content;
	    		html += '<div class="corner"></div>';
	    		html += '<span>3 min</span>';
	    		html += '</div></div>';
	    	$('#chat-messages').append(html);	    	
	    	$("#chat-messages").animate({scrollTop: "300px"},300);
	    	
	    	//发送至服务器
	    	var json = "{'receivedUserKey':'"+currentPerson+"','content':'"+content+"'}";
			ws.send(json);
	    });
	    
	});
