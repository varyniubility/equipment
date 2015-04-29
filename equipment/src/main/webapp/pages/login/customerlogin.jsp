<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8"/>
		<link href="/equipment/assets/css/custom.css" rel="stylesheet" type="text/css"/>
		
		<script src="customerlogin.js" type="text/javascript"></script>
		<style type="text/css">
			body{font-size:14px;font-family:"微软雅黑";}
		</style>
		<title>用户系统登录</title>
	</head>
	<!-- BEGIN BODY -->
<body class="custom">
	<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
	<div class="menu-toggler sidebar-toggler"></div>
	<!-- END SIDEBAR TOGGLER BUTTON -->
	
	<!-- BEGIN LOGO -->
	<div class="logo">
		<a href="/equipment/pages/login/login.jsp">
			<img src="/equipment/assets/img/logo-big-white.png" style="height: 17px;" alt=""/>
		</a>
	</div>
	<!-- END LOGO -->

	<!-- BEGIN custom -->
	<div class="content">
		<!-- BEGIN custom FORM -->
		<form class="custom-form" action="custom" method="post">
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">设备序列号(S/N)：</label>
				<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="S/N" id="number" name="number"/>
			</div>
			<div class="form-actions">
				<button type="submit" onclick="customerlogin();" class="btn btn-primary btn-default">登录</button>
			</div>
		</form>
	</div>
</body>
</html>