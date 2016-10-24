<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>登录</title>
		<!-- CSS -->
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/login_register.css">
		<link rel="shortcut icon" href="img/favicon.png">
	</head>

	<body>
		<div class="container" style="margin-top: 30px;">
			<div class="row">
				<div class="col-sm-6 form-box">
					<form role="form" action="LoginServlet" method="post" class="registration-form">
						<fieldset>
							<div class="form-top">
								<div class="form-top-left">
									<h3>用户登录</h3>
								</div>
								<div class="form-top-right">
									<i class="glyphicon glyphicon-user"></i>
								</div>
							</div>
							<div class="form-bottom">
								<div class="form-group">
									<label class="mlabel"></label>
									<input type="text" name="username" placeholder="输入用户名" class="form-control" id="login_username">
								</div>
								<div class="form-group" style="margin-bottom: 15px;">
									<label class="mlabel"></label>
									<input type="password" name="password" placeholder="输入密码" class="form-control" id="login_password">
								</div>
								<button type="submit" class="btn btn-block" id="popup-submit">登录</button>
								<div id="popup-captcha"></div>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
		<!-- Javascript -->
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.js"></script>
		<script src="js/jquery.backstretch.min.js"></script>
		<script src="js/login_register.js"></script>
		<script src="js/login_validate.js"></script>
		<script src="http://static.geetest.com/static/tools/gt.js"></script>
		<script>
			$(function(){     
				var handlerPopup = function (captchaObj) {  
				   // 成功的回调
				   captchaObj.onSuccess(function () {
				   var validate = captchaObj.getValidate();
				   $.ajax({
				     url: "", // 进行二次验证
				     type: "post",
				     dataType: "json",
				     data: {
				             geetest_challenge: validate.geetest_challenge,
				             geetest_validate: validate.geetest_validate,
				             geetest_seccode: validate.geetest_seccode
				            },
				     success: function (data) {
				    		 if (data && (data.status === "success")) {
		                        $(document.body).html('<h1>登录成功</h1>');
		                    } else {
		                        $(document.body).html('<h1>登录失败</h1>');
		                    }
				     });				    
					   	  
				     });		
				    
				    };
				    // 验证开始需要向网站主后台获取id，challenge，success（是否启用failback）
				    $.ajax({
				        url: "?t=" + (new Date()).getTime(), // 加随机数防止缓存
				        type: "get",
				        dataType: "json",
				        success: function (data) {
				            // 使用initGeetest接口
				            // 参数1：配置参数
				            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它做appendTo之类的事件
				           var member = eval("("+data+")");			        
				            initGeetest({
				                gt: member.gt,
				                challenge: member.challenge,
				                product: "popup", // 产品形式，包括：float，embed，popup。注意只对PC版验证码有效
				                offline: !member.success // 表示用户后台检测极验服务器是否宕机，一般不需要关注
				            }, handlerPopup);
				        }
				  });
				});	  
		</script>
	</body>
</html>