<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<%
	String style=request.getAttribute("style").toString();
	String s1=new String();
	String s2=new String();
	String s3=new String();
	String s4=new String();
	String s5=new String();
	String s6=new String();
	switch(style){
	case "1":
		s1="active";
		break;
	case "2":
		s2="active";
		break;
	case "3":
		s3="active";
		break;
	case "4":
		s4="active";
		break;
	case "5":
		s5="active";
		break;
	case "6":
		s6="active";
		break;
	}
%>
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
				<li class="start <%=s1%> ">
					<a href="/equipment/sbjbxx?sbxlh=0">
						<i class="fa fa-home"></i>
						<span class="title">
							设备基本信息
						</span>
						<span class="selected">
						</span>
					</a>
				</li>
				<li class="start <%=s2%>">
					<a href="/equipment/sbcjwt?sblx=0">
						<i class="fa fa-file-word-o"></i>
						<span class="title">
							设备常见问题
						</span>
						<span class="selected">
						</span>
					</a>
				</li>
				<li class="start <%=s3%>">
					<a href="/equipment/sbwtfk?sbxlh=0">
						<i class="fa fa-home"></i>
						<span class="title">
							设备问题反馈
						</span>
						<span class="selected">
						</span>
					</a>
				</li>
				
				<li class="start">
					<a href="javascript:; ">
						<i class="fa fa-cog"></i>
						<span class="title">设备服务</span>
						<span class="selected"></span>
						<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<li>
							<a href="ecommerce_index.html">
							<i class="icon-home"></i>
							维修站点查询</a>
						</li>
						<li>
							<a href="ecommerce_index.html">
							<i class="icon-home"></i>
							快递维修申请</a>
						</li>
						<li>
							<a href="ecommerce_index.html">
							<i class="icon-home"></i>
							上门维修申请</a>
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