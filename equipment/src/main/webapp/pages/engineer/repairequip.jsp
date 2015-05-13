<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="../../pages/common/import.jsp"/>
		<script src="/equipment/pages/engineer/repairequip.js" type="text/javascript"></script>
		<style type="text/css">
			body{font-size:14px;font-family:"微软雅黑";}
		</style>
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
										<i class="fa fa-gift"></i>设备维修
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
										<div class="form-group">					
											<div class="col-md-4">
												<button type="button" id="searchbtn" class="btn btn-success">搜索服务单</button>
											</div>
										</div>
									</form>
									<div class="widget-body">
										<div id="circlediv">
											<table class="table table-striped table-bordered table-hover" id="serviceshow">
												<thead class="flip-content">
													<tr>
												        <th>设备名称</th>
												        <th>设备型号</th>
												        <th>设备颜色</th>
												        <th>设备类型</th>
												        <th>服务类型</th>
												        <th>进度</th>
												        <th>进度代码</th>
												        <th>申请单编号</th>
												        <th>更新进度</th>
													</tr>
												</thead>
												<tbody id="tbody"></tbody>
											</table>
										</div>
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
		
		<!-- 添加对话框 -->
		<div class="modal fade" id="detailmodal" tabindex="-1" role="dialog"
		     aria-labelledby="modalLabel" aria-hidden="true">
		    <div class="modal-dialog" style="width:70%;padding-top:4%;">
		        <div class="modal-content" style="padding:2%;">
		            <div class="modal-header">
		               	<h4 class="modal-title" id="modalLabel">设备维修单</h4>
		            </div>
		            <form class="form-horizontal" style="padding:2%;" id = "addform" onsubmit="return false;">
						<div class="form-group">
							<div class="col-md-6">
								<label for="sqdsbmc" class="col-md-3 col-xs-12 control-label">设备名称：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sqdsbmc" id="sqdsbmc"/>
								</div>
							</div>
							<div class="col-md-6">
								<label for="sqdsbxh" class="col-md-3 col-xs-12 control-label">设备型号：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sqdsbxh" id="sqdsbxh"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="sqdsblx" class="col-md-3 col-xs-12 control-label">设备类型：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sqdsblx" id="sqdsblx"/>
								</div>
							</div>
							<div class="col-md-6">
								<label for="sqdfwlx" class="col-md-3 col-xs-12 control-label">服务类型：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sqdfwlx" id="sqdfwlx"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="sqdkhdz" class="col-md-3 col-xs-12 control-label">客户地址：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sqdkhdz" id="sqdkhdz"/>
								</div>
							</div>
							<div class="col-md-6">
								<label for="sqdzsly" class="col-md-3 col-xs-12 control-label">知识领域：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sqdzsly" id="sqdzsly"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="sqdgcs" class="col-md-3 col-xs-12 control-label">工程师：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sqdgcs" id="sqdgcs"/>
								</div>
							</div>
							<div class="col-md-6">
								<label for="sqdgly" class="col-md-3 col-xs-12 control-label">管理员：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sqdgly" id="sqdgly"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="sqdjd" class="col-md-3 col-xs-12 control-label">维修进度：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sqdjd" id="sqdjd"/>
								</div>
							</div>
						</div>
		            </form>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" id="modalClose" data-dismiss="modal">关闭</button>
		                <button type="button" class="btn btn-primary" id="confirmbtn">确定</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		
		<!-- 修改对话框 -->
		<div class="modal fade" id="modifymodal" tabindex="-1" role="dialog"
		     aria-labelledby="modalLabel" aria-hidden="true">
		    <div class="modal-dialog" style="padding-top:4%;">
		        <div class="modal-content" style="padding:2%;">
		            <div class="modal-header">
		               <h4 class="modal-title" id="modalLabel">更新进度</h4>
		            </div>
		            <form class="form-horizontal" style="padding:2%;" id = "modifyform" onsubmit="return false;">
		            	<div><input style="display:none;" id="jddm" name="jddm"></div>
		            	<div><input style="display:none;" id="sqdbh" name="sqdbh"></div>
			            <div class="form-group">
			            	<div class="col-md-12">
								<label for="sbmc" class="col-md-3 col-xs-12 control-label">设备名称：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sbmc" id="sbmc"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<label for="sbxh" class="col-md-3 col-xs-12 control-label">设备型号：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sbxh" id="sbxh"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<label for="modifyjd" class="col-md-3 col-xs-12 control-label">更新进度：</label>
								<div class="col-md-8">
									<select type="text" class="form-control" name = "modifyjd" id="modifyjd"></select>
								</div>
							</div>
						</div>
		            </form>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" id="modalClose" data-dismiss="modal">关闭</button>
		                <button type="button" class="btn btn-primary" id="modifyconfirm">确定</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
	</body>
</html>