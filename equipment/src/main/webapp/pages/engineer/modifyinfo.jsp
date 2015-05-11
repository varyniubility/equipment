<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<%
			response.setHeader("Pragma","No-cache");
			response.setHeader("Cache-Control","no-cache");
			response.setDateHeader("Expires", -10);
		%>
		<jsp:include page="../../pages/common/import.jsp"/>
		<script src="/equipment/pages/engineer/modifyinfo.js" type="text/javascript"></script>
		<title>设备售后服务系统--工程师</title>
	</head>
	<body class="page-header-fixed page-sidebar-closed-hide-logo">
		<!-- 页面头开始 -->
		<div class="page-header -i navbar navbar-fixed-top">
			<%@ include file="../../pages/common/topmenu.jsp"%>
		</div>
		<!-- 页面头结束 -->

		<!-- 页面容器开始 -->
		<div class="page-container">
			<%@ include file="../../pages/common/engineerSidebar.jsp"%>
			<!-- 页面内容开始 -->
			<div class="page-content-wrapper">
				<div class="page-content">
					<div class="row">
						<div class="col-md-12">
							<div class="portlet box purple">
								<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>修改基本信息
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
									<form role="form" class="form-horizontal">
										<div class="form-body">
											<div class="form-group">
												<div class="col-md-2"></div>
												<div class="col-md-6">
													<label for="name" class="col-md-3 control-label">用户姓名：</label>
													<div class="col-md-9">
														<input type="text" id="name" class="form-control" placeholder="姓名">
													</div>
												</div>
												<div class="col-md-4"></div>
											</div>
											<div class="form-group">
												<div class="col-md-2"></div>
												<div class="col-md-6">
													<label for="sex" class="col-md-3 control-label">性别：</label>
													<div class="col-md-9">
														<select type="text" class="form-control" name = "sex" id="sex">
															<option value="0">男</option>
															<option value="1">女</option>
														</select>
													</div>
												</div>
												<div class="col-md-4"></div>
											</div>
											<div class="form-group">
												<div class="col-md-2"></div>
												<div class="col-md-6">
													<label for="phone" class="col-md-3 control-label">电话：</label>
													<div class="col-md-9">
														<input type="text" id="phone" class="form-control" placeholder="电话">
													</div>
												</div>
												<div class="col-md-4"></div>
											</div>
											<div class="form-group">
												<div class="col-md-2"></div>
												<div class="col-md-6">
													<label for="area" class="col-md-3 control-label">所在地：</label>
													<div class="col-md-3">
														<select type="text" class="form-control" name = "province" id="province"></select>
													</div>
													<div class="col-md-3">
														<select type="text" class="form-control" name = "city" id="city"></select>
													</div>
													<div class="col-md-3">
														<select type="text" class="form-control" name = "district" id="district"></select>
													</div>
												</div>
												<div class="col-md-4"></div>
											</div>
											<div class="form-group">
												<div class="col-md-2"></div>
												<div class="col-md-6">
													<label for="address" class="col-md-3 control-label">详细地址：</label>
													<div class="col-md-9">
														<textarea type="text" id="address" class="form-control"></textarea>
													</div>
												</div>
												<div class="col-md-4"></div>
											</div>
											<div class="form-group">
												<input type="text" id="userid" name="userid" style="display:none;" value=${userid}>
											</div>
											<div class="form-group">
												<div class="col-md-6"></div>
												<div class="col-md-4">
													<button type="button" id="submitbtn" class="btn btn-success">确认</button>
												</div>
												<div class="col-md-2"></div>
											</div>
										</div>
									</form>
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
			<%@ include file="../../pages/common/footer.jsp"%>
		</div>
		<!-- 底部版权栏结束 -->
	</body>
</html>