<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8"/>
		<script src="/equipment/assets/scripts/login.js" type="text/javascript"></script>
		<link href="/equipment/assets/css/login.css" rel="stylesheet" type="text/css"/>
		<style type="text/css">
			body{font-size:14px;font-family:"微软雅黑";}
		</style>
		<title>登陆</title>
	</head>
	<!-- BEGIN BODY -->
<body class="login">
	<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
	<div class="menu-toggler sidebar-toggler"></div>
	<!-- END SIDEBAR TOGGLER BUTTON -->
	
	<!-- BEGIN LOGO -->
	<div class="logo">
		<a href="index.html">
			<img src="/equipment/assets/img/logo-big-white.png" style="height: 17px;" alt=""/>
		</a>
	</div>
	<!-- END LOGO -->

	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="login-form" action="login" method="post">
			<div class="form-title">
				<span class="form-title">欢迎，</span>
				<span class="form-subtitle">请登录.</span>
			</div>
			<div class="alert alert-danger display-hide">
				<button class="close" data-close="alert"></button>
				<span>请输入用户名和密码. </span>
			</div>
			<div class="form-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">用户名</label>
				<input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" id="username" name="username"/>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" id="password" name="password"/>
			</div>
			<div class="form-actions">
				<button type="submit" class="btn btn-primary btn-block uppercase">登录</button>
			</div>
			<div class="form-actions">
				<div class="pull-left">
					<label class="rememberme check">
					<input type="checkbox" name="remember" value="1"/>记住我 </label>
				</div>
			</div>
		</form>
		<!-- END REGISTRATION FORM -->
	</div>
	<!-- 底部版权栏开始 -->
	<div class="footer">
		<jsp:include page="../../pages/common/footer.jsp"/>
	</div>
	<!-- 底部版权栏结束 -->
</body>
</html>