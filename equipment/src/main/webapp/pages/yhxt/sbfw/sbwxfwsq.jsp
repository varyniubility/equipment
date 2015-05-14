<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="com.equipment.pojo.Province"%>
<%@ page import="com.equipment.pojo.District"%>
<%@ page import="com.equipment.pojo.City"%>
<%@ page import="com.equipment.pojo.Fwsqd" %>
<%@ page import="com.equipment.pojo.DmZsly" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<jsp:include page="../../../pages/common/import.jsp" />
<link href="/equipment/assets/css/custom.css" rel="stylesheet"
	type="text/css" id="style_color" />


<script src="/equipment/pages/yhxt/sbfw/sbwxfwsq.js"
	type="text/javascript"></script>
<title>设备维修服务申请</title>
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
					List<Province> prolist = (List<Province>) request
							.getAttribute("prolist");
				%>
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box yellow-saffron">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-plus"></i>设备维修服务申请
								</div>
								<div class="tools">
									<a href="" class="collapse"> </a> <a href="#portlet-config"
										data-toggle="modal" class="config"> </a> <a href=""
										class="reload"> </a> <a href="" class="remove"> </a>
								</div>
							</div>
							<div class="portlet-body">
								<div class="form">
									<form action="shwxfwsqadd" id="sbwxfwsqdadd" method="post" class="form-horizontal" onsubmit="javascript:if(submitok1()==1)return true;else return false;">
										<div>
											<input type="hidden" value="" name="khsfid" id="khsfid" /> 
											<input type="hidden" value="" name="khsid" id="khsid" /> 
											<input type="hidden" value="" name="khqid" id="khqid" />
											<input type="hidden" value="" name="zslydm1" id="zslydm1"/>
											<input type="hidden" value="" name="zslydm2" id="zslydm2"/>
											<input type="hidden" value="" name="zslydm3" id="zslydm3"/>
										</div>
										<div class="form-group">
											<div class="col-md-9">
												<label for="sbxlh" class="col-md-4 col-xs-12 control-label">设备序列号:</label>
												<div class="col-md-8">
													<input type="text" class="form-control" name="sbxlh" readonly="true" value=<%=session.getAttribute("sbxlh") %>
														id="sbxlh" />
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-9">
												<label for="sbwtms" class="col-md-4 col-xs-12 control-label">设备知识领域:</label>
												<div class="col-md-8">
													<%
														List<DmZsly> zslylist = (List<DmZsly>)request.getAttribute("zslylist");
															for(int j = 0;j<zslylist.size();j++){
																
													%>
													<input type="checkbox" class="form-control" value="<%=zslylist.get(j).getZslydm()%>" name="zsly"><%=zslylist.get(j).getZslymc() %>
													<%
													}
													%>
												</div>
											</div>
										</div>
										
										<div class="form-group">
											<div class="col-md-9">
												<label for="sbwtms" class="col-md-4 col-xs-12 control-label">设备问题描述:</label>
												<div class="col-md-8">
													<textarea rows="5" cols="120" class="form-control" 
														name="sbwtms" id="sbwtms"></textarea>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-9">
												<label for="sbwtms" class="col-md-4 col-xs-12 control-label">用户地址:</label>
												<div class="col-md-8">
													<table width="490">
														<tr>
															<td width="160"><select id="select_province"
																class="form-control">
																	<option value="0">--请选择省--</option>
																	<%
																		if (prolist != null && prolist.size() != 0) {
																			for (int i = 0; i < prolist.size(); i++) {
																	%>
																	<option value="<%=prolist.get(i).getProvinceid()%>"><%=prolist.get(i).getProvincename()%></option>
																	<%
																		}
																		}
																	%>
															</select></td>
															<td width="160"><select id="select_city"
																class="form-control">
																	<option value="0">--请选择市--</option>
															</select></td>

															<td width="160"><select id="select_district"
																class="form-control">
																	<option value="0">--请选择区--</option>
															</select></td>
														</tr>
													</table>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-9">
												<label for="khxxdz" class="col-md-4 col-xs-12 control-label">详细地址:</label>
												<div class="col-md-8">
													<textarea rows="5" cols="120" class="form-control" 
														name="khxxdz" id="khxxdz"></textarea>
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-9">
												<label for="khxm" class="col-md-4 col-xs-12 control-label">姓名:</label>
												<div class="col-md-8">
													<input type="text" class="form-control" name="khxm" value=""
														id="khxm" />
												</div>
											</div>
										</div>
										<div class="form-group">
											<div class="col-md-9">
												<label for="khhm" class="col-md-4 col-xs-12 control-label">联系方式:</label>
												<div class="col-md-8">
													<input type="text" class="form-control" name="khdh" value=""
														id="khdh" />
												</div>
											</div>
										</div>
										<div class="form-group">
										<div class="col-md-9">
											<label class="col-md-10 col-xs-12 control-label"></label>
											<div class="col-md-2">
												<input class="form-control" type="submit" value="提交">
											</div>
										</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>

				<!-- 框体结束 -->
				<!-- 历史申请单框开始 -->
				<div class="row">
					<div class="col-md-12">
						<div class="portlet box yellow-saffron">
							<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>历史服务申请单
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
								<form class="form-horizontal" id="lsfwsqd" onsubmit="return false;">
								<div class="form-group">
									<div class="col-md-12">
										<label class="col-md-4 col-xs-12 control-label">申请单编号</label>
										<label class="col-md-4 col-xs-12 control-label">申请单状态</label>
									</div>
								</div>
								<%
									List<Fwsqd> fwsqdlist = (List<Fwsqd>)request.getAttribute("fwsqdlist");
									if(fwsqdlist!=null && fwsqdlist.size()!=0){
										String json;
										for(int i=0;i<fwsqdlist.size();i++){
											/* json="{sqdbh:"+fwsqdlist.get(i).getSqdbh()+",sbxlh:"+fwsqdlist.get(i).getSbxlh()+",sbwtms:"+fwsqdlist.get(i).getSbwtms()
												+",gcsmc:"+fwsqdlist.get(i).getGcsmc()+",gcsdh:"+fwsqdlist.get(i).getGcsdh()+",yhpj:"+fwsqdlist.get(i).getYhpj()+ "}";
											System.out.println(json); */
											
								%>
									<div class="form-group">
										<div class="col-md-12">
											<a class="col-md-4 col-xs-12 control-label" href="javascript:void(0)" onclick="showsqdmx(<%=fwsqdlist.get(i).getSqdbh()%>)"><%=fwsqdlist.get(i).getSqdbh() %></a>
											<p class="col-md-4 col-xs-12 control-label" ><%=fwsqdlist.get(i).getJdmc() %></p>
										</div>
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
				<!-- 历史申请单框结束 -->
				
				
				
				
				<!--申请单明细弹出框  -->
				<div class="modal fade" id="sqdmx" tabindex="-1" role="dialog"
		     aria-labelledby="modalLabel" aria-hidden="true">
		    <div class="modal-dialog" style="padding-top:4%;">
		        <div class="modal-content" style="padding:2%;">
		            <div class="modal-header">
		               <h4 class="modal-title" id="modalLabel">申请单明细</h4>
		            </div>
		            <form class="form-horizontal" style="padding:2%;" id = "sqdmxform" onsubmit="return false;">
			            <div class="form-group">
			            	<div class="col-md-12">
								<label for="lssqdbh" class="col-md-3 col-xs-12 control-label">申请单编号：</label>
								<div class="col-md-8">
									<input type="text" readonly="readonly" class="form-control" name = "lssqdbh" id="lssqdbh"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<label for="lssbxlh" class="col-md-3 col-xs-12 control-label">设备序列号：</label>
								<div class="col-md-8">
									<input type="text" readonly="readonly" class="form-control" name = "lssbxlh" id="lssbxlh"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<label for="lssbwtms" class="col-md-3 col-xs-12 control-label">问题描述：</label>
								<div class="col-md-8">
									<textarea rows="5" cols="" readonly="readonly" class="form-control" name="lssbwtms" id="lssbwtms"></textarea>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-12">
								<label for="lsgcsxm" class="col-md-3 col-xs-12 control-label">工程师姓名：</label>
								<div class="col-md-8">
									<input type="text" readonly="readonly" class="form-control" name = "lsgcsxm" id="lsgcsxm"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-12">
								<label for="lsgcsdh" class="col-md-3 col-xs-12 control-label">工程师电话：</label>
								<div class="col-md-8">
									<input type="text" readonly="readonly" class="form-control" name = "lsgcsdh" id="lsgcsdh"/>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-12">
								<label for="lsyhpj" class="col-md-3 col-xs-12 control-label">服务评价：</label>
								<div class="col-md-8">
									<textarea rows="5" cols="" class="form-control" name="lsyhpj" id="lsyhpj"></textarea>
								</div>
							</div>
						</div>
		            </form>
		            <div class="modal-footer">
		            	<button type="button" class="btn btn-default" id="modalok" data-dismiss="modal">提交</button>
		                <button type="button" class="btn btn-default" id="modalClose" data-dismiss="modal">关闭</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		<!-- 申请单明细弹出框结束 -->
		
				
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