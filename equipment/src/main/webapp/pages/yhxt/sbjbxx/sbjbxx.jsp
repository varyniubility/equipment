<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<jsp:include page="../../../pages/common/import.jsp" />
<link href="/equipment/assets/css/custom.css" rel="stylesheet"type="text/css" id="style_color" />
<script src="/equipment/pages/yhxt/sbjbxx/sbjbxx.js" type="text/javascript"></script>
<style type="text/css">
	body{font-size:14px;font-family:"微软雅黑";}
</style>
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
			<div class="row">
				<div class="col-md-12" >
				<div class="portlet box yellow-saffron">
				<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>设备基本信息
									</div>
									<div class="tools">
										<a href="" class="collapse">
										</a>
										<!-- <a href="#portlet-config" data-toggle="modal" class="config">
										</a>
										<a href="" class="reload">
										</a>
										<a href="" class="remove">
										</a> -->
									</div>
				</div>
				<div class="portlet-body table_fon">
				<table width="600" border="2" align="center" cellpadding="2" cellspacing="2">
					<tr align="center">
						<td width="40%"><span>设备序列号</span></td>
						<td width="60%">${sbxlh }</td>
					</tr>
					<tr align="center">
						<td width="40%"><span>设备型号</span></td>
						<td width="60%">${sbxh }</td>
					</tr>
					<tr align="center">
						<td width="40%"><span>设备类型</span></td>
						<td width="60%">${sblx }</td>
					</tr>
					<tr align="center">
						<td width="40%"><span>设备序毛重</span></td>
						<td width="60%">${sbmz }</td>
					</tr>
					<tr  align="center">
						<td width="40%"><span>设备名称</span></td>
						<td width="60%">${sbmc }</td>
					</tr>
					<tr  align="center">
						<td width="40%"><span>设备颜色</span></td>
						<td width="60%">${sbys }</td>
					</tr>
					<tr  align="center">
						<td width="40%"><span >设备上架时间</span></td>
						<td width="60%">${sjsj }</td>
					</tr>
				</table>
				</div>
				</div>
				</div>
				</div>
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