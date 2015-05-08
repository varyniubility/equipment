<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:include page="../../../pages/common/import.jsp"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.equipment.pojo.Sbcjwt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<link
	href="/equipment/assets/plugins/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css" />
<link href="/equipment/assets/plugins/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="/equipment/assets/plugins/uniform/css/uniform.default.css"
	rel="stylesheet" type="text/css" />
<link href="/equipment/assets/css/layout.css" rel="stylesheet"
	type="text/css" />
<link href="/equipment/assets/css/darkblue.css" rel="stylesheet"
	type="text/css" id="style_color" />
<link href="/equipment/assets/css/custom.css" rel="stylesheet"
	type="text/css" id="style_color" />

<script src="/equipment/pages/yhxt/sbcjwt/sbcjwt.js" type="text/javascript"></script>
<title>设备常见问题</title>
</head>
<body
	class="page-header-fixed page-quick-sidebar-over-content page-sidebar-closed-hide-logo page-container-bg-solid">
	<!-- 页面头开始 -->
	<div class="page-header -i navbar navbar-fixed-top">
		<jsp:include page="/pages/common/topmenu.jsp" />
	</div>
	<!-- 页面头结束 -->

	<!-- 页面容器开始 -->
	<div class="page-container">
		<jsp:include page="/pages/common/customersidebar.jsp" />
		<!-- 页面内容开始 -->
		<div class="page-content-wrapper">
			<div class="page-content">
				<%-- <span>${sbcjwtlist }</span>
				<c.forEach items="${sbcjwtlist}" var="test">
				${test}
				<li><span>${test.cjwt}</span></li>
				<li><span>${test.cjwtjd}</span></li> 
				</c.forEach> --%>
				<%
					List<Sbcjwt> list = (List<Sbcjwt>) request.getAttribute("wtlist");
					for (int i = 0; i < list.size(); i++) {
				%>
				
				<span class="spanwt"><p>●<%=list.get(i).getCjwt()%></p></span>
				<span class="spanwtjd"><p>●&nbsp&nbsp答：<%=list.get(i).getCjwtjd()%></p></span>
				
				<%
					}
				%>
			</div>
		</div>
		<!-- 页面内容结束 -->
	</div>
	<!-- 页面容器结束 -->

	<!-- 底部版权栏开始 -->
	<div class="footer">
		<jsp:include page="/pages/common/footer.jsp" />
	</div>
	<!-- 底部版权栏结束 -->
</body>
</html>