<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.equipment.pojo.Sbwtfk"%>
<%@ page import="com.equipment.pojo.DmZsly"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<jsp:include page="../../../pages/common/import.jsp" />
<link href="/equipment/assets/css/custom.css" rel="stylesheet"type="text/css" id="style_color" />
<script src="/equipment/pages/yhxt/sbwtfk/sbwtfk.js"
	type="text/javascript"></script>
<style type="text/css">
	body{font-size:14px;font-family:"微软雅黑";}
</style>
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
				
				
				<!-- <div class="row">
					<div class="col-md-12">
						<div class="portlet box yellow-saffron">
							<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>选择分类
									</div>
									<div class="tools">
										<a href="" class="collapse">
										</a>
										<a href="#portlet-config" data-toggle="modal" class="config">
										</a>
										<a href="" class="reload">
										</a>
										<a href="" class="remove">
										</a>
									</div>
							</div>
							<div class="portlet-body">
							</div>
						</div>
					</div>
				</div> -->
				

				<form action="addsbwt"
					onsubmit="javascript:if(submitok()==1)return true;else return false;"
					method="post">
					<input type="hidden" name="zslydm1" id="zslydm1" value="" /> <input
						type="hidden" name="zslydm2" id="zslydm2" value="" /> <input
						type="hidden" name="zslydm3" id="zslydm3" value="" />
					<!-- <span style="font-family: 华文中宋; font-size: 20px;">设备问题反馈</span><br> -->
					
					
					<div class="row">
					<div class="col-md-12">
						<div class="portlet box yellow-saffron">
							<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>选择问题分类
									</div>
									<div class="tools">
										<a href="" class="collapse">
										</a>
										<a href="" class="reload">
										</a>
										<a href="" class="remove">
										</a>
									</div>
							</div>
							<div class="portlet-body">
								<div>
							<span class="spanzs">请最多选择三个</span>
						</div>
						<div>
						<table width="800" align="center" >

							<%
								List<DmZsly> zslylist = (List<DmZsly>) request.getAttribute("zslylist");
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
							</div>
						</div>
					</div>
				</div>
					
					
					<div class="row">
					<div class="col-md-12">
						<div class="portlet box yellow-saffron">
							<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>设备问题描述
									</div>
									<div class="tools">
										<a href="" class="collapse">
										</a>
										<a href="" class="reload">
										</a>
										<a href="" class="remove">
										</a>
									</div>
							</div>
							<div class="portlet-body">
								<div>
						<textarea id="sbwt" name="sbwt" rows="5" cols="150" class="textareasty"
							placeholder="设备问题描述" maxlength="200"></textarea>
						<input type="submit" id="form_submit" value="提交" />

					</div>
					</div>
					</div>
						</div>
					</div>
				</form>
				<!-- 表单结束 -->
							
					
					
					


				<%
					List<Sbwtfk> list = (List<Sbwtfk>) request.getAttribute("sbwtlist");
					if (list != null) {
				%>
				<!-- 表单开始 -->
				<!--onsubmit="javascript:if(addpj()==1)return true;else return false;"  -->
				
				
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box yellow-saffron">
							<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>已经提问过问题
									</div>
									<div class="tools">
										<a href="" class="collapse">
										</a>
										<a href="" class="reload">
										</a>
										<a href="" class="remove">
										</a>
									</div>
							</div>
							<div class="portlet-body">
								<div class="">
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
						}
					%>

					<%
						for (int i = 0; i < list.size(); i++) {
					%>


					<div>
						<table width="1000">
							<tr>
								<td width="85%"><span class="spanwt">●<%=list.get(i).getSbwt()%></span>
								</td>
								<td width="15%"><span class="spanwtjd">问题进度:<span
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
										name="yhpj<%=i%>" rows="5" cols="150" placeholder="请输入评价"
										maxlength="200"></textarea></td>
								<%
									} else {
								%>
								<td width="80%"><textarea id="yhpj<%=i%>" class="textareasty"
										name="yhpj<%=i%>" rows="5" cols="150" placeholder="请输入评价"
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
								</div>
							</div>
						</div>
					</div>
				</div>
				</div>
				
				<!--表单结束  -->
		<!-- 页面内容结束 -->
	<!-- 页面容器结束 -->

	<!-- 底部版权栏开始 -->
	<div class="footer">
		<jsp:include page="/pages/common/footer.jsp" />
	</div>
	<!-- 底部版权栏结束 -->
</body>
</html>