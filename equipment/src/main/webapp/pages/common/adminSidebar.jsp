<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<!-- 侧边栏开始 -->
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar navbar-collapse collapse">
			<!-- 侧边栏菜单开始 -->
			<ul class="page-sidebar-menu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
				<li class="sidebar-toggler-wrapper">
					<!-- 侧边栏收缩按钮 -->
					<div class="sidebar-toggler"></div>
				</li>
				<li class="start" id="adminmian">
					<a href="/equipment/main/initAdmin">
						<i class="fa fa-home"></i>
						<span class="title">
							管理员主界面
						</span>
						<span class="selected">
						</span>
					</a>
				</li>
				<li class="start" id="quesmanage">
					<a href="/equipment/question/initquestion">
						<i class="fa fa-file-word-o"></i>
						<span class="title">设备问题管理</span>
						<span class="selected"></span>
					</a>
				</li>
				<li class="start" id="servicemanage">
					<a href="/equipment/service/initservice">
						<i class="fa fa-file-word-o"></i>
						<span class="title">设备服务管理</span>
						<span class="selected"></span>
					</a>
				</li>
				<li class="start" id="repairmanage">
					<a href="/equipment/repair/initrepairmanage">
						<i class="fa fa-file-word-o"></i>
						<span class="title">维修点管理</span>
						<span class="selected"></span>
					</a>
				</li>
				<li class="start" id="sysmanage">
					<a href="javascript:;">
						<i class="fa fa-cog"></i>
						<span class="title">系统管理</span>
						<span class="selected"></span>
						<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li id="usermanage">
							<a href="/equipment/user/inituser">
							<i class="icon-home"></i>
							用户管理</a>
						</li>
						<li id="modifyinfo">
							<a href="/equipment/admininfo/initmodifyinfo">
							<i class="icon-home"></i>
							修改信息</a>
						</li>
						<li id="modifypwd">
							<a href="/equipment/admininfo/initmodifypwd">
							<i class="icon-home"></i>
							修改密码</a>
						</li>
						<li>
							<a href="/equipment/sys/logout">
							<i class="icon-home"></i>
							退出系统</a>
						</li>
					</ul>
				</li>
			</ul>
			<!-- 侧边栏菜单结束 -->
		</div>
	</div>
	<!-- 侧边栏结束 -->
</body>
</html>