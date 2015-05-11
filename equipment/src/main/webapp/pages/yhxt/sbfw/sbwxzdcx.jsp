<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.equipment.pojo.Province"%>
<%@ page import="com.equipment.pojo.District"%>
<%@ page import="com.equipment.pojo.City"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	 <style type="text/css">
        #map {width:100%;height:820px;overflow: hidden;padding-top:30%;font-family:"微软雅黑";}
    </style>
	<script type="text/javascript" src="/equipment/assets/plugins/map/api?v=2.0&ak=2StkIHWGNTW8xE8w7ApZlofD"></script>
    <script type="text/javascript" src="/equipment/assets/plugins/map/CurveLine.min.js"></script>
    <script type="text/javascript" src="/equipment/assets/plugins/map/InfoBox_min.js"></script>
    <script type="text/javascript" src="/equipment/assets/plugins/map/SearchInfoWindow_min.js"></script>
    <link rel="stylesheet" href="/equipment/assets/plugins/map/SearchInfoWindow_min.css" /> 
	<jsp:include page="../../../pages/common/import.jsp" />	
	<link href="/equipment/assets/css/custom.css" rel="stylesheet"type="text/css" id="style_color" />
	<script src="/equipment/pages/yhxt/sbfw/sbwxzdcx.js"type="text/javascript"></script>
	<title>设备维修站点查询</title>
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
				<%
					List<Province> prolist = (List<Province>) request.getAttribute("prolist");
				%>
				 <div class="row">
					<div class="col-md-12">
						<div class="portlet box yellow-saffron">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-plus"></i>选择地区
								</div>
								<div class="tools">
									<a href="" class="collapse"></a>
									<a href="#portlet-config" data-toggle="modal" class="config"></a>
									<a href="" class="reload"></a>
									<a href="" class="remove"></a>
								</div>
							</div>
							<div class="portlet-body">
								<form action="sbwxzdcx" id="form_sbwxzdcx" class="form-horizontal">
									<div class="form-group">
										<div class="col-sm-2">
											<select id="select_province" class="form-control">
												<option value="0">--请选择省--</option>
													<%
														if (prolist != null && prolist.size()!=0) {
															for(int i=0;i<prolist.size();i++){
																%>
																<option value="<%=prolist.get(i).getProvinceid() %>"><%=prolist.get(i).getProvincename() %></option>
																<%
															}
														}
													%>
											</select>
										</div>
										<div class="col-sm-2">
											<select id="select_city" class="form-control" >
												<option value="0">--请选择市--</option>
											</select>
										</div>
										<div class="col-sm-2">
											<select id="select_district" class="form-control" >
												<option value="0">--请选择区--</option>
											</select>
										</div>
										<div class="col-sm-2">
						                	<button type="button" class="btn btn-primary" id="confirmbtn">确定</button>
		            					</div>
									</div>
								</form>
								<div id="map">
								
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