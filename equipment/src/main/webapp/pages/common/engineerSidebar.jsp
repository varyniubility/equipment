<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 侧边栏开始 -->
<div class="page-sidebar-wrapper">
	<div class="page-sidebar navbar-collapse collapse">
		<!-- 侧边栏菜单开始 -->
		<ul class="page-sidebar-menu " data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
			<li class="sidebar-toggler-wrapper">
				<!-- 侧边栏收缩按钮 -->
				<div class="sidebar-toggler"></div>
			</li>
			<li id="engineerMain" class="start active ">
				<a href="/equipment/main/initEngineer">
					<i class="fa fa-home"></i>
					<span class="title">
						工程师主界面
					</span>
					<span class="selected">
					</span>
				</a>
			</li>
			<li id="repair" class="start">
				<a href="/equipment/repair/init">
					<i class="fa fa-file-word-o"></i>
					<span class="title">维修业务管理</span>
					<span class="selected"></span>
				</a>
			</li>
			<li id="answer" class="start">
				<a href="/equipment/answer/init">
					<i class="fa fa-file-word-o"></i>
					<span class="title">疑难问题解答</span>
					<span class="selected"></span>
				</a>
			</li>
			<li id="baseinfo" class="start">
				<a href="javascript:;">
					<i class="fa fa-cog"></i>
					<span class="title">基本信息管理</span>
					<span class="arrow"></span>
				</a>
				<ul class="sub-menu">
					<li id="modifyinfo"> 
						<a href="/equipment/baseinfo/modifyinfo">
							<i class=""></i>
							修改基本信息	
						</a>
					</li>
					<li id="modifypwd">
						<a href="/equipment/baseinfo/modifypassword">
							<i class=""></i>
							修改密码	
						</a>
					</li>
				</ul>
			</li>
		</ul>
		<!-- 侧边栏菜单结束 -->
	</div>
</div>
<!-- 侧边栏结束 -->