<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/default.css">
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
	<div class="htmleaf-content bgcolor-3">
			<div id="chatbox">
				<div id="friendslist">
			    	<div id="topmenu">
			        	JobComing...
			        </div>
			        
			        <div id="friends">
			        	<div class="friend" data-person="xufeng" id="xufeng">
			            	<img src="img/1_copy.jpg" />
			                <p>
			                	<strong>Miro Badev</strong>
				                <span>mirobadev@gmail.com</span>
			                </p>
			                <div class="status available"></div>
			            </div>
			            
			            <div class="friend">
			            	<img src="img/2_copy.jpg" />
			                <p>
			                	<strong>Martin Joseph</strong>
				                <span>marjoseph@gmail.com</span>
			                </p>
			                <div class="status away"></div>
			            </div>
			            
			            <div class="friend">
			            	<img src="img/3_copy.jpg" />
			                <p>
			                	<strong>Tomas Kennedy</strong>
				                <span>tomaskennedy@gmail.com</span>
			                </p>
			                <div class="status inactive"></div>
			            </div>
			            <div id="search">
				            <input type="text" id="searchfield" value="Search contacts..." />
			            </div>
			        </div>                
			        
			    </div>	
			    
			    <div id="chatview" class="p1">    	
			        <div id="profile">

			            <div id="close">
			                <div class="cy"></div>
			                <div class="cx"></div>
			            </div>
			            
			            <p>Miro Badev</p>
			            <span>miro@badev@gmail.com</span>
			        </div>
			        
			        <div id="chat-messages">
			        	<label>Thursday 02</label>
						<!-- 放入消息 -->
			        </div>
			    	
			        <div id="sendmessage">
			        	<input type="text" id="content" value="Send message..." />
			            <button id="send">发送</button>
			        </div>
			    
			    </div>        
			</div>	
		</div>	
	
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/chat.js"></script>
</html>
