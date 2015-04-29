<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="utf-8"/>
		<script src="/equipment/pages/login/login.js" type="text/javascript"></script>
		<link href="/equipment/assets/css/login.css" rel="stylesheet" type="text/css"/>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta content="width=device-width, initial-scale=1" name="viewport"/>
		<meta content="" name="description"/>
		<meta content="" name="author"/>
		<link href="/equipment/assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
		<link href="/equipment/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<link href="/equipment/assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
		<link href="/equipment/assets/css/layout.css" rel="stylesheet" type="text/css"/>
		<link href="/equipment/assets/css/darkblue.css" rel="stylesheet" type="text/css" id="style_color"/>
	
		<script src="/equipment/assets/plugins/jquery.min.js" type="text/javascript"></script>
		<script src="/equipment/assets/plugins/jquery-migrate.min.js" type="text/javascript"></script>
		<script src="/equipment/assets/plugins/jquery-ui/jquery-ui.min.js" type="text/javascript"></script>
		<script src="/equipment/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="/equipment/assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
		<script src="/equipment/assets/plugins/jquery.blockui.min.js" type="text/javascript"></script>
		<script src="/equipment/assets/plugins/jquery.cokie.min.js" type="text/javascript"></script>
		<script src="/equipment/assets/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
		<script src="/equipment/assets/scripts/metronic.js" type="text/javascript"></script>
		<script src="/equipment/assets/scripts/layout.js" type="text/javascript"></script>
		<script>
			jQuery(document).ready(function() {    
		   		Metronic.init(); // init metronic core componets
		   		Layout.init(); // init layout
			});
		</script>
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
		<a href="/equipment/customer.jsp">
			<img src="/equipment/assets/img/logo-big-white.png" style="height: 17px;" alt=""/>
		</a>
	</div>
	<!-- END LOGO -->

	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="login-form" action="login" method="post">
			<div class="form-group" style="font-size:16px;font-family:'微软雅黑'">
				<label class="control-label visible-ie8 visible-ie9">登录角色</label>
				<select name="role" id = "role" class="form-control" >
					<option value="0">管理人员</option>
					<option value="1">工程师</option>       
				</select>
			</div>
			<div class="form-group" style="font-size:16px;font-family:'微软雅黑'">
				<label class="control-label visible-ie8 visible-ie9">用户名</label>
				<input class="form-control form-control-solid placeholder-no-fix" type="text" autocomplete="off" placeholder="用户名" id="username" name="username"/>
			</div>
			<div class="form-group" style="font-size:16px;font-family:'微软雅黑'">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<input class="form-control form-control-solid placeholder-no-fix" type="password" autocomplete="off" placeholder="密码" id="password" name="password"/>
			</div>
			<div class="form-actions" style="font-size:16px;font-family:'微软雅黑'">
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
</body>
</html>