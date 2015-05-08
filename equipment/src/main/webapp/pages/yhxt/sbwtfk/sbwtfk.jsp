<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../../../pages/common/import.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.equipment.pojo.Sbwtfk"%>
<%@ page import="com.equipment.pojo.DmZsly"%>

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

<script src="/equipment/pages/yhxt/sbwtfk/sbwtfk.js"
	type="text/javascript"></script>
<title>设备常见问题反馈</title>
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
				<!-- onsubmit="javascript:if(submitok()==1)return true;else return false;"  -->

				<form action="addsbwt"
					onsubmit="javascript:if(submitok()==1)return true;else return false;"
					method="post">
					<input type="hidden" name="zslydm1" id="zslydm1" value="" /> <input
						type="hidden" name="zslydm2" id="zslydm2" value="" /> <input
						type="hidden" name="zslydm3" id="zslydm3" value="" />
					<!-- <span style="font-family: 华文中宋; font-size: 20px;">设备问题反馈</span><br> -->
					<a href="javascript:void(0);" onclick="zslyxz();">分类选择</a>
					<div id="zslyxz" style="display: none">
						<div>
							<span class="spanzs">请最多选择三个</span>
						</div>
						<table width="800">

							<%
								List<DmZsly> zslylist = (List<DmZsly>) request
										.getAttribute("zslylist");
								if (zslylist != null) {
									for (int i = 0; i < zslylist.size(); i++) {
										if (i % 4 == 0) {
							%>
							<tr>
								<%
									}
								%>
								<td><input type="checkbox" name="zsly"
									value="<%=zslylist.get(i).getZslydm()%>"><span
									class="spanzsly"><%=zslylist.get(i).getZslymc()%></span></td>
								<%
									if (i % 4 == 3) {
								%>
							</tr>
							<%
								}
									}
								}
							%>

						</table>
					</div>
					<div>
						<span class="spanzs">请填写您的设备问题:</span><br>
						<textarea id="sbwt" name="sbwt" rows="5" cols="110" class="textareasty"
							placeholder="设备问题描述" maxlength="200"></textarea>

						<table width="800">
							<tr>
								<td width="220"></td>
								<td width="220"></td>
								<td width="200"></td>
								<td><input type="submit" id="form_submit" value="提交" /></td>
							</tr>
						</table>

					</div>
				</form>
				<!-- 表单结束 -->


				<%
					List<Sbwtfk> list = (List<Sbwtfk>) request.getAttribute("sbwtlist");
					if (list != null) {
				%>
				<!-- 表单开始 -->
				<!--onsubmit="javascript:if(addpj()==1)return true;else return false;"  -->
				<form action="updatewtpj" method="post" id="form_update">
					<input type="hidden" id="wtbh" name="wtbh" value="" /> <input
						type="hidden" id="yhpj" name="yhpj" value="" />
					<%
						if (list.size() == 0) {
					%>
					<div>
						<span class="spanzs""> 您未提交过问题。 </span>
					</div>
					<%
						} else {
					%>
					<div>
						<!--<span style="font-family: 华文中宋; color: red; font-size: 10px;">
						您提交过的问题如下：： </span>  -->
					</div>
					<%
						}
					%>

					<%
						for (int i = 0; i < list.size(); i++) {
					%>


					<div>
						<table width="1000">
							<tr>
								<td width="80%"><span class="spanwt">●<%=list.get(i).getSbwt()%></span>
								</td>
								<td width="20%"><span class="spanwtjd">问题进度:<span
										class="spanzs"><%=list.get(i).getJdmc()%></span></span></td>
							</tr>
							<%
								if (list.get(i).getSbwtjd() != null) {
							%>
							<tr>
								<td width="80%"><span class="spanwtjd">&nbsp&nbsp&nbsp&nbsp答：<%=list.get(i).getSbwtjd()%></span></td>
								<td width="20%"><a style="font-size: 13px"
									href="javascript:void(0);" onclick="showpj(<%=i%>)">评价</a></td>
							</tr>
							<tr id="pjdrv<%=i%>" style="display: none">
								<%
									if (list.get(i).getYhpj() == null) {
								%>
								<td width="75%"><textarea id="yhpj<%=i%>" class="textareasty"
										name="yhpj<%=i%>" rows="5" cols="100" placeholder="请输入评价"
										maxlength="200"></textarea></td>
								<%
									} else {
								%>
								<td width="80%"><textarea id="yhpj<%=i%>" class="textareasty"
										name="yhpj<%=i%>" rows="5" cols="100" placeholder="请输入评价"
										maxlength="200"><%=list.get(i).getYhpj()%></textarea></td>
								<%
									}
								%>
								<td width="20%"><input type="button" value="提交"
									onclick="addpj(<%=i%>,<%=list.get(i).getWtbh()%>);" /></td>
							</tr>

							<%
								}
							%>
						</table>
					</div>
					<%
						}
						}
					%>
				</form>
				<!--表单结束  -->
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