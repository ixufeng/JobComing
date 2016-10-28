<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width,initial-scale=1">
		<title>兼职详情</title>
		<link href="css/bootstrap.css" rel="stylesheet">
		<link href="css/site.min.css" rel="stylesheet">
		<link rel="stylesheet" href="css/main.css" />
		<link rel="stylesheet" href="css/jobInfo.css" />
		<link rel="shortcut icon" href="img/favicon.png">
	</head>

	<body class="home-template">
		<div class="site-notice">
			<a href=""><em>JobComing~</em></a>
		</div>
		<header class="site-header jumbotron">
			<div class="site-nav">
				<a href="">登录</a> <span>/</span>
				<a href="">注册</a>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-xs-12">
						<form class="" role="search">
							<div class="form-group">
								<input type="text" class="form-control search clearable" placeholder="搜索兼职/单位/地点">
								<i class="glyphicon glyphicon-search"></i>
							</div>
						</form>
					</div>
				</div>
			</div>
		</header>
		<div class="container" style="margin-top: 30px;">
			<div class="row">
				<div class="col-md-9 job-info">
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title">
            					闲着无聊做做兼职--JobComing
        					</h3>
						</div>
						<div class="panel-body">
							<table class="table">
								<tbody>
									<tr>
										<td width="60" class="txt">种类</td>
										<td><a>[${requestScope.jobdetail.jobKind.jobKindName}]</a></td>
										<td width="60" class="txt">开始</td>
										<td class="txt2">${requestScope.jobdetail.jobPublish.workBeginTime}</td>
										<td rowspan="4" width="90" class="hidden-xs">
											<img src="img/public.png" style="width: 80px;height: 90px;" class="img-thumbnail img-responsive" />
										</td>
									</tr>
									<tr>
										<td width="60" class="txt">发布者</td>
										<td class="txt2">${requestScope.jobdetail.user.userName }</td>
										<td width="60" class="txt">结束</td>
										<td class="txt2">${requestScope.jobdetail.jobPublish.workOverTime}</td>
									</tr>
									<tr>
										<td width="60" class="txt">性别</td>
										<td class="txt2">${requestScope.jobdetail.user.sex }</td>
										<td width="60" class="txt">地区</td>
										<td class="txt2"><a>[${requestScope.jobdetail.location}]</a></td>
									</tr>
									<tr>
										<td width="60" class="txt">信誉</td>
										<td class="txt2">${requestScope.jobdetail.user.score }</td>
										<td width="60" class="txt">详细</td>
										<td class="txt2"><a id="show">[查看]</a></td>
									</tr>
								</tbody>
							</table>
							<div class="alert alert-warning">
								<a href="#" class="close">
									&times;
								</a>
								<strong>${requestScope.jobdetail.jobPublish.detailAddress}</strong>
							</div>
							<h5 class="desc">
								<span class="glyphicon glyphicon-file"></span>
								兼&nbsp;职&nbsp;描&nbsp;述
							</h5>
							<p>${requestScope.jobdetail.jobPublish.workDescribe}</p>
							<h5 class="desc">
								<span class="glyphicon glyphicon-phone"></span>
								联&nbsp;系&nbsp;方&nbsp;式
							</h5>
							<p><a id="show2">[查看发布者联系方式]</a></p>
							<div class="alert alert-info">
								<a href="#" class="close close2">
									&times;
								</a>
								<strong>联系电话：${requestScope.jobdetail.user.phone}<br />
										邮箱：${requestScope.jobdetail.user.email}	
								 </strong>
							</div>
						
							<div style="margin-top: 30px;">
								<a href="" class="btn btn-default btn-info">
									<span class="glyphicon glyphicon-envelope"></span>
									邮件预约
								</a>
								
								<a href="" class="btn btn-default btn-success" style="margin-left: 30px;">
									<span class="glyphicon glyphicon-send"></span>
									私聊一下
								</a>
							</div>
						</div>
					</div>
				</div>
			
			
				<div class="col-md-3 adv visible-md visible-lg" style="padding-right: 0px;">
					<div class="panel panel-default">
					    <div class="panel-heading">
					       	<span class="glyphicon glyphicon-fire"></span>&nbsp;今&nbsp;日&nbsp;兼&nbsp;职&nbsp;推&nbsp;送
					    </div>
					     <ul class="list-group">
					     	<c:forEach var="hotList" items="${requestScope.hotList1 }">
					        <li class="list-group-item">
					        	<a>${hotList.location }</a>&nbsp;
					        	<a>[${hotList.jobKind.jobKindName}]</a>&nbsp;
					        	<a href="DetailJobPServlet.do?jobPublishId=${hotList.jobPublish.jobPublishId }">
					        		<span class="glyphicon glyphicon-map-marker"></span>
					        		&nbsp;${hotList.jobPublish.detailAddress}
					        		<span style="font-weight: bold;">...</span>
					        	</a>
					        </li>
					        </c:forEach>
					    </ul>
					</div>
				</div>
			</div>
		</div>
		<script src="js/jquery.js"></script>
		<script src="js/bootstrap.js"></script>
		<script>
			$("#show").click(function(){
				$(".alert-warning").css("display","block");
			})
			$(".close").click(function(){
				$(".alert-warning").css("display","none");
			})
			$("#show2").click(function(){
				$(".alert-info").css("display","block");
			})
			$(".close2").click(function(){
				$(".alert-info").css("display","none");
			})
		</script>
	</body>

</html>