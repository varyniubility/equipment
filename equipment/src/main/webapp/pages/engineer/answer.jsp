<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="../../pages/common/import.jsp"/>
		<script src="/equipment/pages/engineer/answer.js" type="text/javascript"></script>
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
										<i class="fa fa-gift"></i>疑难问题解答
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
												<button type="button" id="searchbtn" class="btn btn-success">搜索疑难问题</button>
											</div>
										</div>
										<div class="form-group">
											<input type="text" id="userid" name="userid" style="display:none;" value=${userid}>
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
												        <th>设备问题</th>
												        <th>设备问题答案</th>
												        <th>知识领域1</th>
												        <th>知识领域2</th>
												        <th>知识领域3</th>
												        <th>进度</th>
												        <th>工程师建议</th>
												        <th>进度代码</th>
												        <th>问题编号</th>
												        <th>问题解答</th>
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
		<!-- 修改对话框 -->
		<div class="modal fade" id="modifymodal" tabindex="-1" role="dialog"
		     aria-labelledby="modalLabel" aria-hidden="true">
		    <div class="modal-dialog" style="padding-top:4%;">
		        <div class="modal-content" style="padding:2%;">
		            <div class="modal-header">
		               <h4 class="modal-title" id="modalLabel">问题解答</h4>
		            </div>
		            <form class="form-horizontal" style="padding:2%;" id = "modifyform" onsubmit="return false;">
		            	<div><input style="display:none;" id="jddm" name="jddm"></div>
		            	<div><input style="display:none;" id="wtdm" name="wtdm"></div>
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
								<label for="sbwt" class="col-md-3 col-xs-12 control-label">设备问题：</label>
								<div class="col-md-8">
									<input type="text" readonly="true" class="form-control" name = "sbwt" id="sbwt"></textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<label for="modifyques" class="col-md-3 col-xs-12 control-label">问题解答：</label>
								<div class="col-md-8">
									<textarea type="text" class="form-control" name = "modifyques" id="modifyques"></textarea>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-12">
								<label for="gcszj" class="col-md-3 col-xs-12 control-label">建议：</label>
								<div class="col-md-8">
									<textarea type="text" class="form-control" name = "gcszj" id="gcszj"></textarea>
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