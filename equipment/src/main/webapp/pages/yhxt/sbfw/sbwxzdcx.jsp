<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../../../pages/common/import.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.equipment.pojo.Province"%>
<%@ page import="com.equipment.pojo.District"%>
<%@ page import="com.equipment.pojo.City"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
		<link href="/equipment/assets/plugins/font-awesome/css/font-awesome.min.css"rel="stylesheet" type="text/css" />
		<link href="/equipment/assets/plugins/bootstrap/css/bootstrap.min.css"rel="stylesheet" type="text/css" />
		<link href="/equipment/assets/plugins/uniform/css/uniform.default.css"rel="stylesheet" type="text/css" />
		<link href="/equipment/assets/css/layout.css" rel="stylesheet"type="text/css" />
		<link href="/equipment/assets/css/darkblue.css" rel="stylesheet"type="text/css" id="style_color" />
		<link href="/equipment/assets/css/custom.css" rel="stylesheet"type="text/css" id="style_color" />
	
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
				<form action="sbwxzdcx" id="form_sbwxzdcx">
					<div>
						<!-- 选择地点表格开始 -->
						<table width="600">
							<tr>
								<td width="200"><select id="select_province" onChange="selectprovalue(this.value);"
									class="select_css">
										<option value="0">--请选择省份--</option>
										<%
											if (prolist != null && prolist.size()!=0) {
												for(int i=0;i<prolist.size();i++){
													%>
													<option value="<%=prolist.get(i).getProvinceid() %>"><%=prolist.get(i).getProvincename() %></option>
													<%
												}
											}
										%>
								</select></td>
								<td width="200"></td>
								<td width="200"></td>
							</tr>
						</table>
					</div>
					<!-- 表格结束 -->
				</form>
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