<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />
<jsp:include page="../../../pages/common/import.jsp" />
<<<<<<< HEAD
<link href="/equipment/assets/css/custom.css" rel="stylesheet"
	type="text/css" id="style_color" />
<script src="/equipment/pages/yhxt/sbjbxx/sbjbxx.js"
	type="text/javascript"></script>
=======
<link href="/equipment/assets/css/custom.css" rel="stylesheet"type="text/css" id="style_color" />
<script src="/equipment/pages/yhxt/sbjbxx/sbjbxx.js" type="text/javascript"></script>
<style type="text/css">
	body{font-size:14px;font-family:"微软雅黑";}
</style>
>>>>>>> master
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
					<div class="col-md-12">
						<div class="portlet box yellow-saffron">
							<div class="portlet-title">
								<div class="caption">
									<i class="fa fa-gift"></i>设备基本信息
								</div>
								<div class="tools">
									<a href="" class="collapse"> </a>
									<!-- <a href="#portlet-config" data-toggle="modal" class="config">
										</a>
										<a href="" class="reload">
										</a>
										<a href="" class="remove">
										</a> -->
								</div>
							</div>
							<div class="portlet-body table_fon">
								<div class="form">
								<form action="" onsubmit="return false" class="form-horizontal">
									<div class="form-group">
										<div class="col-md-8">
											<div class="col-md-5"></div>
											<label for="sbxlh" class="col-md-3 col-xs-12 control-label"><h4>设备序列号:</h4></label>
											<div class="col-md-4">
												<input type="text" class="form-control" readonly="readonly"
													name="sbxlh" id="sbxlh" value="${sbxlh }" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-8">
											<div class="col-md-5"></div>
											<label for="sbxh" class="col-md-3 col-xs-12 control-label"><h4>设备型号:</h4></label>
											<div class="col-md-4">
												<input type="text" class="form-control" readonly="readonly"
													name="sbxh" id="sbxh" value="${sbxh }" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-8">
											<div class="col-md-5"></div>
											<label for="sblx" class="col-md-3 col-xs-12 control-label"><h4>设备类型:</h4></label>
											<div class="col-md-4">
												<input type="text" class="form-control" readonly="readonly"
													name="sblx" id="sblx" value="${sblx }" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-8">
											<div class="col-md-5"></div>
											<label for="sbmz" class="col-md-3 col-xs-12 control-label"><h4>设备毛重:</h4></label>
											<div class="col-md-4">
												<input type="text" class="form-control" readonly="readonly"
													name="sbmz" id="sbmz" value="${sbmz }" />
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="col-md-8">
											<div class="col-md-5"></div>
											<label for="sbmc" class="col-md-3 col-xs-12 control-label"><h4>设备名称:</h4></label>
											<div class="col-md-4">
												<input type="text" class="form-control" readonly="readonly"
													name="sbmc" id="sbmc" value="${sbmc }" />
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="col-md-8">
											<div class="col-md-5"></div>
											<label for="sbys" class="col-md-3 col-xs-12 control-label"><h4>设备颜色:</h4></label>
											<div class="col-md-4">
												<input type="text" class="form-control" readonly="readonly"
													name="sbys" id="sbys" value="${sbys }" />
											</div>
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-8">
											<div class="col-md-5"></div>
											<label for="sjsj" class="col-md-3 col-xs-12 control-label"><h4>上架时间:</h4></label>
											<div class="col-md-4">
												<input type="text" class="form-control" readonly="readonly"
													name="sjsj" id="sjsj" value="${sjsj }" />
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