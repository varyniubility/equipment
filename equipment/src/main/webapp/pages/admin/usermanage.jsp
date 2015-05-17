<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="../../pages/common/import.jsp"/>
		<script src="/equipment/pages/admin/usermanage.js" type="text/javascript"></script>
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
				<div class="page-content">
					<div class="row">
						<div class="col-md-12">
							<div class="portlet box purple">
								<div class="portlet-title">
									<div class="caption">
										<i class="fa fa-gift"></i>用户管理
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
											<div class="col-sm-4">
												<label for="yhxm" class="col-sm-4 control-label">用户姓名:</label>
												<div class="col-sm-8">
													<input type="text" class="form-control" id="yhxm" name="yhxm" placeholder="用户姓名">
												</div>
											</div>
											<div class="col-sm-4">
												<label for="yhlb" class="col-sm-4 control-label">用户类别:</label>
												<div class="col-sm-8">
													<select type="text" class="form-control" name = "yhlb" id="yhlb">
														<option value="0">管理员</option>
														<option value="1">工程师</option>
													</select>
												</div>
											</div>
											<div class="col-md-3">
												<button type="button" id="searchbtn" class="btn btn-success">搜索</button>
												<button type="button" id="addbtn" class="btn btn-success">添加</button>
											</div>
										</div>
									</form>
									<div class="widget-body">
										<div id="circlediv">
											<table class="table table-striped table-bordered table-hover" style="white-space:nowrap;" id="usershow">
												<thead class="flip-content">
													<tr>
														<th style="text-align:center;">操作</th>
												        <th style="text-align:center;">用户姓名</th>
												        <th style="text-align:center;">性别</th>
												        <th style="text-align:center;">电话</th>
												        <th style="text-align:center;">用户地址</th>
												        <th style="text-align:center;">用户名</th>
												        <th style="text-align:center;">用户类别</th>
												        <th style="text-align:center;">district</th>
												        <th style="text-align:center;">city</th>
												        <th style="text-align:center;">province</th>
												        <th style="text-align:center;">yhdm</th>
												        <th style="text-align:center;">xxdz</th>
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
		<div class="modal fade" id="addmodal" tabindex="-1" role="dialog"
		     aria-labelledby="modalLabel" aria-hidden="true">
		    <div class="modal-dialog" style="width:60%;padding-top:4%;">
		        <div class="modal-content" style="padding:2%;">
		            <div class="modal-header">
		               	<h4 class="modal-title" id="modalLabel">添加用户</h4>
		            </div>
		            <form class="form-horizontal" style="padding:2%;" id = "addform" onsubmit="return false;">
						<div class="form-group">
							<div class="col-md-6">
								<label for="addyhxm" class="col-md-3 col-xs-12 control-label">用户姓名：</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name = "addyhxm" id="addyhxm"/>
								</div>
							</div>
							<div class="col-md-6">
								<label for="addyhxb" class="col-md-3 col-xs-12 control-label">性别：</label>
								<div class="col-md-9">
									<select type="text" class="form-control" name = "addyhxb" id="addyhxb">
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="addyhdh" class="col-md-3 col-xs-12 control-label">用户电话：</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name = "addyhdh" id="addyhdh"/>
								</div>
							</div>
							<div class="col-md-6">
								<label for="addyhm" class="col-md-3 col-xs-12 control-label">用户名：</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name = "addyhm" id="addyhm"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="addyhdz" class="col-md-3 col-xs-12 control-label">用户地址：</label>
								<div class="col-md-3">
									<select type="text" class="form-control" name = "addprovince" id="addprovince"></select>
								</div>
								<div class="col-md-3">
									<select type="text" class="form-control" name = "addcity" id="addcity"></select>
								</div>
								<div class="col-md-3">
									<select type="text" class="form-control" name = "adddistrict" id="adddistrict"></select>
								</div>
							</div>
							<div class="col-md-6">
								<label for="addyhlb" class="col-md-3 col-xs-12 control-label">用户类型：</label>
								<div class="col-md-9">
									<select type="text" class="form-control" name = "addyhlb" id="addyhlb">
										<option value="0">管理员</option>
										<option value="1">工程师</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="addxxdz" class="col-md-3 control-label">详细地址：</label>
								<div class="col-md-9">
									<textarea type="text" id="addxxdz" class="form-control"></textarea>
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
		    <div class="modal-dialog" style="width:60%;padding-top:4%;">
		        <div class="modal-content" style="padding:2%;">
		            <div class="modal-header">
		               <h4 class="modal-title" id="modalLabel">编辑用户</h4>
		            </div>
		             <form class="form-horizontal" style="padding:2%;" id = "modifyform" onsubmit="return false;">
		             	<input type="text" class="form-control" style="display:none;" name = "modifyyhdm" id="modifyyhdm"/>
						<div class="form-group">
							<div class="col-md-6">
								<label for="modifyyhxm" class="col-md-3 col-xs-12 control-label">用户姓名：</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name = "modifyyhxm" id="modifyyhxm"/>
								</div>
							</div>
							<div class="col-md-6">
								<label for="modifyyhxb" class="col-md-3 col-xs-12 control-label">性别：</label>
								<div class="col-md-9">
									<select type="text" class="form-control" name = "modifyyhxb" id="modifyyhxb">
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="modifyyhdh" class="col-md-3 col-xs-12 control-label">用户电话：</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name = "modifyyhdh" id="modifyyhdh"/>
								</div>
							</div>
							<div class="col-md-6">
								<label for="modifyyhm" class="col-md-3 col-xs-12 control-label">用户名:</label>
								<div class="col-md-9">
									<input type="text" class="form-control" name = "modifyyhm" id="modifyyhm"/>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="modifyyhdz" class="col-md-3 col-xs-12 control-label">用户地址：</label>
								<div class="col-md-3">
									<select type="text" class="form-control" name = "modifyprovince" id="modifyprovince"></select>
								</div>
								<div class="col-md-3">
									<select type="text" class="form-control" name = "modifycity" id="modifycity"></select>
								</div>
								<div class="col-md-3">
									<select type="text" class="form-control" name = "modifydistrict" id="modifydistrict"></select>
								</div>
							</div>
							<div class="col-md-6">
								<label for="modifyyhlb" class="col-md-3 col-xs-12 control-label">用户类型：</label>
								<div class="col-md-9">
									<select type="text" class="form-control" name = "modifyyhlb" id="modifyyhlb">
										<option value="0">管理员</option>
										<option value="1">工程师</option>
									</select>
								</div>
							</div>
						</div>
						<div class="form-group">
							<div class="col-md-6">
								<label for="modifyxxdz" class="col-md-3 control-label">详细地址：</label>
								<div class="col-md-9">
									<textarea type="text" id="modifyxxdz" class="form-control"></textarea>
								</div>
							</div>
						</div>
		            </form>
		            <div class="modal-footer">
		                <button type="button" class="btn btn-default" id="modalClose" data-dismiss="modal">关闭</button>
		                <button type="button" class="btn btn-primary" id="modifybtn">确定</button>
		            </div>
		        </div><!-- /.modal-content -->
		    </div><!-- /.modal -->
		</div>
		
		<!-- 删除确认框 -->
		<div class="modal small fade" id="deletemodal" tabindex="-2" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		    <div class="modal-dialog" style="padding-top:4%;">
		        <div class="modal-content">
				    <div class="modal-header">
				    	<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
				    	<h3 id="myModalLabel">删除确认</h3>
				    </div>
				    <div class="modal-body">
				    	<p class="error-text">确认要删除这条数据?</p>
				    </div>
				    <div class="modal-footer">
				    	<button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
				    	<button type="button" class="btn btn-danger" id="delconfirmbtn">删除</button>
			    	</div>
	    		</div>
	    	</div>
		</div>
	</body>
</html>