<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<title>发布兼职</title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/site.min.css" rel="stylesheet">
		<link rel="stylesheet" href="css/main.css" />
		<link rel="stylesheet" href="css/jobPublish.css" />
		<link rel="shortcut icon" href="img/favicon.png">
	</head>

	<body class="home-template">
		<div class="site-notice">
			<a href=""><em>JobComing~</em></a>
		</div>
		<header class="site-header jumbotron">
			<c:choose>
		  	<c:when test="${empty sessionScope.user}">
				<div class="site-nav">
					<a href="login.jsp">登录</a> <span>/</span>
					<a href="register.jsp">注册</a>
				</div>
			</c:when>
			<c:otherwise>
				<div class="site-nav">
					<a href="PersonInforServlet.do">${sessionScope.user.userName}</a> <span>/</span>
					<a href="MainPageServlet">首页</a>
				</div>
			</c:otherwise>
		  </c:choose>
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-sm-offset-2">
						<form class="" role="search">
							<div class="form-group">
								<input type="text" class="form-control search clearable" placeholder="搜索兼职/单位/地点">
								<i class="glyphicon glyphicon-search"></i>
								<!--这个是键盘按下的时候搜索的ajax异步显示信息-->
									<ul class="list-group" id="hide-info">
										<li class="list-group-item">
											<a href="">java</a>
										</li>
										<li class="list-group-item">
											<a href="">java</a>
										</li>
										<li class="list-group-item">
											<a href="">java</a>
										</li>
									</ul>
							</div>
						</form>
					</div>
				</div>
			</div>
		</header>
		<div class="container" style="margin-top: 30px;">
			<div class="row">
				<div class="col-md-10 col-md-offset-1 job-info">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title" style="display: inline-block;">
            					分享一份兼职--JobComing
        					</h3>
        					
						</div>
						<div class="panel-body">
							<div class="row">
								<div class="col-md-8">
									<form action="ReleaseJob.do?action=release" method="post">
										<h5 class="desc">
											<span class="glyphicon glyphicon-tags"></span>&nbsp;选择兼职类型
										</h5>
										<div class="form-group">
											<select class="form-control" id="jobkind" name="jobKindId">
												<option value="0">--选择一个兼职类型--</option>
												<option value="1">[清洁]</option>
												<option value="2">[家教]</option>
												<option value="3">[促销]</option>
												<option value="4">[派送]</option>
												<option value="5">[调研]</option>
												<option value="6">[计时工]</option>
												<option value="7">[网络兼职]</option>
												<option value="8">[撰稿]</option>
												<option value="9">[翻译]</option>
												<option value="10">[导游]</option>
											</select>
										</div>
										<h5 class="desc">
											<span class="glyphicon glyphicon-map-marker"></span>&nbsp;选择兼职地点
										</h5>
										<div class="form-group">
											<select class="form-control" id="jobaddress" name="address">
												<option value="0">--选择兼职地点--</option>
												<option value="南京市">[南京]</option>
												<option value="上海市">[上海]</option>
												<option value="苏州市">[苏州]</option>
												<option value="常州市">[常州]</option>
												<option value="扬州市">[扬州]</option>
												<option value="杭州市">[杭州]</option>
												<option value="淮安市">[淮安]</option>
												<option value="北京市">[北京]</option>
												<option value="武汉市">[武汉]</option>
												<option value="吉林市">[吉林]</option>
											</select>
										</div>
										<h5 class="desc">
											<span class="glyphicon glyphicon-leaf"></span>&nbsp;开始时间
										</h5>
										<div class="form-group">
											<input type="date" class="form-control" id="begindate" name="beginTime"/>
										</div>
										<h5 class="desc">
											<span class="glyphicon glyphicon-leaf"></span>&nbsp;结束时间
										</h5>
										<div class="form-group">
											<input type="date" class="form-control" id="enddate" name="overTime"/>
										</div>
										<h5 class="desc">
											<span class="glyphicon glyphicon-info-sign"></span>&nbsp;内容描述
										</h5>
										<div class="form-group">
											<textarea id="descCon" class="form-control" rows="3" placeholder="对工作的内容进行简短的描述" name="describe"></textarea>
										</div>
										<button type="submit" class="btn btn-default btn-info" id="btn">发布信息</button>
									</form>	
								</div>
							
								<div class="col-md-4 visible-lg visible-md">
									<div class="panel panel-default">
										<div class="panel-heading">
											用户信息
										</div>
										<div class="panel-body">
											<p>
												<img src="${sessionScope.user.headPicture }" style="width: 60px;height: 60px;"  class="img-thumbnail"/>
											</p>
											<p>用户名: ${sessionScope.user.userName }</p>
											<p>用户积分: ${sessionScope.user.score}</p>
											<p>发布次数: ${requestScope.pCount }</p>
											<p>参与次数: ${requestScope.cCount }</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.js"></script>
		<script src="js/search.js"></script>
		<!--//提交判断-->
		<script>
			$("form").submit(function(){
				 var jobkind = $("#jobkind").val();
				 var jobaddress = $("#jobaddress").val();
				 var date1 = $("#begindate").val();
				 var start=new Date(date1.replace("-", "/").replace("-", "/"));
				 var date2 = $("#enddate").val();
				 var end=new Date(date2.replace("-", "/").replace("-", "/"));
				 var con = $("#descCon").val();
				 if(jobkind==""||jobaddress==""||date1==""||date2==""){
				 	return false;
				 }
				 else if(end<start){
				 	return false;
				 }
				 else{
				 	return true;
				 }
			})
		</script>
	</body>

</html>