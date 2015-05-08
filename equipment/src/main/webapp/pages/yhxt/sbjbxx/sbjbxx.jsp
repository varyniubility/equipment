<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:include page="../../../pages/common/import.jsp"/>
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
<link href="/equipment/assets/css/yhxt.css" rel="stylesheet"
	type="text/css" id="style_color" />

<script src="/equipment/pages/yhxt/sbjbxx/sbjbxx.js" type="text/javascript"></script>
<title>设备基本信息</title>
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
				<table width="600" border="2" align="center" cellpadding="2" cellspacing="2">
					<tr class="fon" align="center">
						<td width="40%"><span>设备序列号</span></td>
						<td width="60%">${sbxlh }</td>
					</tr>
					<tr class="fon" align="center">
						<td width="40%"><span>设备型号</span></td>
						<td width="60%">${sbxh }</td>
					</tr>
					<tr class="fon" align="center">
						<td width="40%"><span>设备类型</span></td>
						<td width="60%">${sblx }</td>
					</tr>
					<tr class="fon" align="center">
						<td width="40%"><span>设备序毛重</span></td>
						<td width="60%">${sbmz }</td>
					</tr>
					<tr class="fon" align="center">
						<td width="40%"><span>设备名称</span></td>
						<td width="60%">${sbmc }</td>
					</tr>
					<tr class="fon" align="center">
						<td width="40%"><span>设备颜色</span></td>
						<td width="60%">${sbys }</td>
					</tr>
					<tr class="fon" align="center">
						<td width="40%"><span>设备上架时间</span></td>
						<td width="60%">${sjsj }</td>
					</tr>
				</table>
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