<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="../../pages/common/import.jsp"/>
		<script src="/equipment/pages/engineer/modifypwd.js" type="text/javascript"></script>
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
										<i class="fa fa-gift"></i>修改密码
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
									<form role="form" class="form-horizontal" onsubmit="return false;">
										<div class="form-body">
											<div class="form-group">
												<div class="col-md-2"></div>
												<div class="col-md-6">
													<label for="oldpassword" class="col-md-5 control-label">原始密码：</label>
													<div class="col-md-7">
														<input type="password" class="form-control" placeholder="原始密码" id="oldpassword" name="oldpassword">
													</div>
												</div>
												<div class="col-md-4"></div>
											</div>
											<div class="form-group">
												<div class="col-md-2"></div>
												<div class="col-md-6">
													<label for="newpassword" class="col-md-5 control-label">新密码：</label>
													<div class="col-md-7">
														<input type="password" class="form-control" placeholder="新密码" id="newpassword" name="newpassword">
													</div>
												</div>
												<div class="col-md-4"></div>
											</div>
											<div class="form-group">
												<div class="col-md-2"></div>
												<div class="col-md-6">
													<label for="confirmpwd" class="col-md-5 control-label">确认新密码：</label>
													<div class="col-md-7">
														<input type="password" class="form-control" placeholder="确认新密码" id="confirmpwd" name="confirmpwd">
													</div>
												</div>
												<div class="col-md-4"></div>
											</div>
											<div class="form-group">
												<input type="text" id="userid" name="userid" style="display:none;" value=${userid}>
											</div>
											<div class="form-group">
												<div class="col-md-4"></div>
												<div class="col-md-4"></div>
												<div class="col-md-4">
													<button type="button" id="submitbtn" class="btn btn-success">确认</button>
													<button type="button" id="cancel" class="btn btn-success">取消</button>
												</div>
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