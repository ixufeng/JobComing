//登录表单
//表单失去焦点的事件 --用户名
$("#login_username").blur(function(){
	var value = $(this).val();
	if(value==""){
		$(this).prev().html("用户名不能为空");
		$(this).addClass("input-error");
	}
	else{
		$(this).prev().html("");
		$(this).removeClass("input-error");
	}
});

$("#login_password").blur(function(){
	//验证密码
	var value = $(this).val();
	if(value==""){
		$(this).prev().html("密码不能为空");
		$(this).addClass("input-error");
	}
	else{
		$(this).prev().html("");
		$(this).removeClass("input-error");
	}
})