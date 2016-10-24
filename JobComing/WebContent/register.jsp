<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>三级注册</title>
		<!-- CSS -->
		<link rel="stylesheet" href="css/bootstrap.css">
		<link rel="stylesheet" href="css/login_register.css">
		<link rel="shortcut icon" href="img/favicon.png">
	</head>

	<body>
		<div class="container" style="margin-top: 30px;">
			<div class="row">
				<div class="col-sm-6 form-box">
					<form role="form" action="RegisterServlet" method="post" class="registration-form">
						<fieldset>
							<div class="form-top">
								<div class="form-top-left">
									<h3>步骤 1 / 3</h3>
								</div>
								<div class="form-top-right">
									<i class="glyphicon glyphicon-user"></i>
								</div>
							</div>
							<div class="form-bottom">
								<div class="form-group">
									<label class="mlabel"></label>
									<input type="text" name="username" placeholder="输入用户名" class="form-control" id="register_username">
								</div>
								<div class="form-group">
									<label class="mlabel"></label>
									<input type="password" name="password1" placeholder="设置密码" class="form-control" id="register_password1">
								</div>
								<div class="form-group" style="margin-bottom: 25px;">
									<label class="mlabel"></label>
									<input type="password" name="password2" placeholder="再次输入密码" class="form-control" id="register_password2">
								</div>
								<button type="button" class="btn btn-next">下一步</button>
							</div>
						</fieldset>

						<fieldset>
							<div class="form-top">
								<div class="form-top-left">
									<h3>步骤 2 / 3</h3>
								</div>
								<div class="form-top-right">
									<i class="glyphicon glyphicon-user"></i>
								</div>
							</div>
							<div class="form-bottom">
								<div class="form-group">
									<label class="mlabel"></label>
									<input type="text" name="email" placeholder="邮箱" class="form-control" id="register_email">
								</div>
								<div class="form-group">
									<label class="mlabel"></label>
									<input type="text" name="phone" placeholder="绑定手机" class="form-control" id="register_phone">
								</div>
								<div class="form-group" style="margin-bottom: 25px;">
									<label class="mlabel"></label>
									<input type="text" name="realname" placeholder="真实姓名" class="form-control" id="register_realname">
								</div>
								<button type="button" class="btn btn-previous">上一步</button>
								<button type="button" class="btn btn-next">下一步</button>
							</div>
						</fieldset>

						<fieldset>
							<div class="form-top">
								<div class="form-top-left">
									<h3>步骤 3 / 3</h3>
								</div>
								<div class="form-top-right">
									<i class="glyphicon glyphicon-user"></i>
								</div>
							</div>
							<div class="form-bottom">
								<div class="form-group" style="margin-bottom: 25px;">
									<select class="form-control" id="sel_year" style="height: 48px;">
										<option value=" ">选择出生年份</option>
									</select>
								</div>
								<div class="form-group">
									<select class="form-control" id="sel_month" style="height: 48px;">
										<option value=" ">选择出生月份</option>
									</select>
								</div>
								<div class="form-group">
									<div class="radio col-xs-4 col-sm-3">
										<label>
											<input type="radio" name="sex" id="male" value="男" checked="checked">
										</label>
										<span>
											<img src="img/male.png" class="img-responsive" style="width: 20px; height:20px;display: inline-block;margin-top: -2px;">
										</span>
									</div>
									<div class="radio col-xs-4 col-sm-3" style="margin-top: 10px;">
										<label>
											<input type="radio" name="sex" id="female" value="女">
										</label>
										<span>
											<img src="img/female.png" class="img-responsive" style="width: 20px; height:20px;display: inline-block;margin-top: -2px;">
										</span>
									</div>
								</div>
								<div class="clearfix"></div>
								<button type="button" class="btn btn-previous">上一步</button>
								<button type="submit" class="btn" id="register">注册</button>
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
		<script src="js/register_validate.js" ></script>
		
	</body>

</html>