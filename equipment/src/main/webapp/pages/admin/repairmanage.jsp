<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<script type="text/javascript" src="/equipment/assets/plugins/map/api?v=2.0&ak=2StkIHWGNTW8xE8w7ApZlofD"></script>
    	<script type="text/javascript" src="/equipment/assets/plugins/map/CurveLine.min.js"></script>
    	<script type="text/javascript" src="/equipment/assets/plugins/map/InfoBox_min.js"></script>
    	<script type="text/javascript" src="/equipment/assets/plugins/map/SearchInfoWindow_min.js"></script>
    	<link rel="stylesheet" href="/equipment/assets/plugins/map/SearchInfoWindow_min.css" /> 
		<jsp:include page="../../pages/common/import.jsp"/>
		<script src="/equipment/pages/admin/repairmanage.js" type="text/javascript"></script>
		<style type="text/css">
        	#mapinfo {width:100%;height:520px;overflow: hidden;padding-top:30%;font-family:"微软雅黑";}
    	</style>
		<style type="text/css">
			body{font-size:14px;font-family:"微软雅黑";}
		</style>
		<title>设备售后服务系统--管理员</title>
	</head>
	<body class="page-header-fixed page-sidebar-closed-hide-logo">
		<!-- 页面头开始 -->
		<div class="page-header -i navbar navbar-fixed-top">
			<%@ include file="../../pages/common/topmenu.jsp"%>
		</div>
		<!-- 页面头结束 -->

		<!-- 页面容器开始 -->
		<div class="page-container">
			<%@ include file="../../pages/common/adminSidebar.jsp"%>
			<!-- 页面内容开始 -->
			<div class="page-content-wrapper">
				<div class="page-content" style="height:700px">
					<div class="row">
						<div class="col-md-12">
							<div class="portlet box purple">
								<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>维修站点管理
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
												<div class="col-md-6">
													<label for="province" class="col-md-3 control-label">选择省：</label>
													<div class="col-md-9">
														<select id="province" name="province" class="form-control"></select>
													</div>
												</div>
												<div class="col-md-6">
													<label for="city" class="col-md-3 control-label">选择市：</label>
													<div class="col-md-9">
														<select class="form-control" name = "city" id="city"></select>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-md-6">
													<label for="district" class="col-md-3 control-label">选择县/区：</label>
													<div class="col-md-9">
														<select class="form-control" name = "district" id="district"></select>
													</div>
												</div>
												<div class="col-md-6">
													<label for="address" class="col-md-3 control-label">详细地址：</label>
													<div class="col-md-9">
														<textarea id="address" class="form-control"></textarea>
													</div>
												</div>
											</div>
											<div class="form-group">
												<div class="col-md-6"></div>
												<div class="col-md-4">
													<button type="button" id="submitbtn" class="btn btn-success popover-show" >查询</button>
												</div>
												<div class="col-md-2"></div>
											</div>
										</div>
									</form>
									<div id="mapinfo">
										
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
			<%@ include file="../../pages/common/footer.jsp"%>
		</div>
		<!-- 底部版权栏结束 -->
		
		<!-- 修改对话框 -->
		<div class="modal fade" id="addmodal" tabindex="-1" role="dialog"
		     aria-labelledby="modalLabel" aria-hidden="true">
		    <div class="modal-dialog" style="width:50%;padding-top:4%;">
		        <div class="modal-content" style="padding:2%;">
		            <div class="modal-header">
		               <h4 class="modal-title" id="modalLabel">添加维修点</h4>
		            </div>
		             <form class="form-horizontal" style="padding:2%;" id = "modifyform" onsubmit="return false;">
		             	<input type="text" class="form-control" style="display:none;" name = "zdjd" id="zdjd"/>
		             	<input type="text" class="form-control" style="display:none;" name = "zdwd" id="zdwd"/>
						<div class="form-group">
							<div class="col-md-9">
								<label for="addname" class="col-md-5 col-xs-12 control-label">维修点名称：</label>
								<div class="col-md-7">
									<input type="text" class="form-control" name = "addname" id="addname"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-9">
								<label for="addtelphone" class="col-md-5 control-label">维修点电话：</label>
								<div class="col-md-7">
									<input type="text" name="addtelphone" id="addtelphone" class="form-control"/>
								</div>
							</div>
						</div>
		            </form>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" id="modalClose" data-dismiss="modal">关闭</button>
		                <button type="button" class="btn btn-primary" id="addbtn">确定</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
	</body>
</html>