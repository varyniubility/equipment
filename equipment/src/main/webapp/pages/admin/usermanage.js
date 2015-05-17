$(document).ready( function () {
	$("#quesmanage").attr("class","start");
	$("#adminmian").attr("class","start");
	$("#servicemanage").attr("class","start");
	$("#sysmanage").attr("class","active open");
	$("#usermanage").attr("class","active");
	createTable();
	$("#addbtn").click(function(){
		queryprovince($("#addprovince"));
		querycity($("#addprovince").val(),$("#addcity"));
		querydistrict($("#addcity").val(),$("#adddistrict"));
		$("#addprovince").change(function(){
			querycity($("#addprovince").val(),$("#addcity"));
			querydistrict($("#addcity").val(),$("#adddistrict"));
		});
		$("#addcity").change(function(){
			querydistrict($("#addcity").val(),$("#adddistrict"));
		});
		$("#addmodal").modal("show");//弹出框show
	});
	
	//搜索按钮选中事件
	$("#searchbtn").click(function(){
		if(datatable == null){
			createTable();   //创建表格
		}else{
			datatable.draw();   //重绘数据表
		}
	});

	$("#confirmbtn").click(function(){
		var yhxm = $("#addyhxm").val();
		var yhxb = $("#addyhxb").val();
		var yhdh = $("#addyhdh").val();
		var yhm = $("#addyhm").val();
		var yhlb = $("#addyhlb").val();
		var province = $("#addprovince").val();
		var city = $("#addcity").val();
		var district = $("#adddistrict").val();
		var yhdm = $("#addyhdm").val();
		var xxdz = $("#addxxdz").val();
		
		var params = '{"xxdz":"'+ xxdz + '","cityid":"'+ city + '","districtid":"'+ district + '","yhdm":"'+ yhdm + '","yhm":"'+ yhm 
					+ '","yhlb":"'+ yhlb + '","provinceid":"'+ province + '","yhxm":"'+ yhxm 
					+ '","yhxb":"'+ yhxb + '","yhdh":"'+ yhdh + '"}';  
		$.ajax({
			url : 'adduser',//这个就是请求地址对应sAjaxSource
		    data : params, //这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
		    type : 'post',
		    dataType: "json",  
		    contentType: "application/json", 
		    async : true,
		    success : function(data) {
		    	var obj = eval('(' + data.result + ')');
		    	if (obj=="success") {
		    		$("#addmodal").modal("hide");//弹出框show
		    		$('#addform')[0].reset();
				    if(datatable == null){
			    		createTable();   //创建表格
			    	}else{
			    		datatable.draw();   //重绘数据表
			    	}
                };
		    },
		    error : function(msg) {

		    }
		});
	});
});

function createTable(){
	datatable = $('#usershow').DataTable({
		"bDestory":true,
		"bAutoWidth":false,
    	"bProcessing": true, // 是否显示取数据时的那个等待提示
        "bServerSide": true,//这个用来指明是通过服务端来取数据
        "sAjaxSource": "queryuser",//这个是请求的地址
        "fnServerData": retrieveData, // 获取数据的处理函数
        'sClass': "text-center",
        "bLengthChange": false,
        "aoColumns": [
			{ "bSortable": false,"sWidth": "10%"},
			{ "bSortable": false},
			{ "bSortable": false},
			{ "bSortable": false},
			{ "bSortable": false},
			{ "bSortable": false},
			{ "bSortable": false},
			{ "bSortable": false},
			{ "bSortable": false},
			{ "bSortable": false},
			{ "bSortable": false},
			{ "bSortable": false}
		],
		"columnDefs": [{
            "targets": -0,//编辑
            "data": null,
            "defaultContent": "<button id='modifyrow' class='btn btn-primary' type='button'><i class='fa fa-edit'></i></button>"
            	+"<button id='deleterow' class='btn btn-danger' type='button'><i class='fa fa-trash-o'></i></button>"
		},{
    		"targets": -1,//xxdz
    		"visible":false
		},{
    		"targets": -2,//yhdm
    		"visible":false
		},{
    		"targets": -3,//province
    		"visible":false
		},{
    		"targets": -4,//city
    		"visible":false
		},{
    		"targets": -5,//district
    		"visible":false
    	},{
    		"render": function(data, type, row) {
    			if(data==0){
    				return "男";
    			}else{
    				return "女";
    			}
            },
            "targets": 2
    	},{
    		"render": function(data, type, row) {
    			if(data==0){
    				return "管理员";
    			}else{
    				return "工程师";
    			}
            },
            "targets": 6
    	}],
        "aLengthMenu": [
            [5, 15, 20, -1],
            [5, 15, 20, "All"] // change per page values here
        ],
        // set the initial value
        "iDisplayLength": 30,
        "searching":false,
        "oLanguage": {
        	"sLengthMenu": "每页显示 _MENU_ 条记录",
        	"sInfo": "从 _START_ 到 _END_ /共 _MAX_条数据",
        	"sInfoEmpty": "没有数据",
        	"sInfoFiltered": "(从 _MAX_ 条数据中检索)",
        	"sSearch": "搜索",
        	"oPaginate": {
        		"sFirst": "首页",
        		"sPrevious": "前一页",
        		"sNext": "后一页",
        		"sLast": "尾页"
        	},
        	"sZeroRecords": "没有检索到数据",
        	"sProcessing": "<img src='/equipment/assets/img/loading.gif'/>"
        	},
	});
	
	var currentRow;
	//编辑
	$('#usershow tbody').on('click', 'button#modifyrow', function () {
		var data = datatable.row( $(this).parents('tr') ).data();
		$("#modifyprovince").change(function(){
			querycity($("#modifyprovince").val(),$("#modifycity"));
			querydistrict($("#modifycity").val(),$("#modifydistrict"));
		});
		
		$("#modifycity").change(function(){
			querydistrict($("#modifycity").val(),$("#modifydistrict"));
		});
		queryprovince($("#modifyprovince"));
		$("#modifyyhxm").val(data[1]);
		$("#modifyyhxb").val(data[2]);
		$("#modifyyhdh").val(data[3]);
		$("#modifyyhm").val(data[5]);
		$("#modifyyhlb").val(data[6]);
		$("#modifyprovince").val(data[9]);
		querycity(data[9],$("#modifycity"));
		$("#modifycity").val(data[8]);
		querydistrict(data[8],$("#modifydistrict"));
		$("#modifydistrict").val(data[7]);
		$("#modifyyhdm").val(data[10]);
		$("#modifyxxdz").val(data[11]);
		$("#modifymodal").modal("show");//弹出框show
	});
	
	$('#modifybtn').click(function(){
		var yhxm = $("#modifyyhxm").val();
		var yhxb = $("#modifyyhxb").val();
		var yhdh = $("#modifyyhdh").val();
		var yhm = $("#modifyyhm").val();
		var yhlb = $("#modifyyhlb").val();
		var province = $("#modifyprovince").val();
		var city = $("#modifycity").val();
		var district = $("#modifydistrict").val();
		var yhdm = $("#modifyyhdm").val();
		var xxdz = $("#modifyxxdz").val();
		
		var params = '{"xxdz":"'+ xxdz + '","cityid":"'+ city + '","districtid":"'+ district + '","yhdm":"'+ yhdm + '","yhm":"'+ yhm 
					+ '","yhlb":"'+ yhlb + '","provinceid":"'+ province + '","yhxm":"'+ yhxm 
					+ '","yhxb":"'+ yhxb + '","yhdh":"'+ yhdh + '"}';  
		$.ajax({
			url : 'modifyuser',//这个就是请求地址对应sAjaxSource
		    data : params, //这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
		    type : 'post',
		    dataType: "json",  
		    contentType: "application/json", 
		    async : true,
		    success : function(data) {
		    	var obj = eval('(' + data.result + ')');
		    	if (obj=="success") {
		    		$("#modifymodal").modal("hide");//弹出框show
		    		$('#modifyform')[0].reset();
				    if(datatable == null){
			    		createTable();   //创建表格
			    	}else{
			    		datatable.draw();   //重绘数据表
			    	}
                };
		    },
		    error : function(msg) {

		    }
		});
	});
	
	//删除按钮点击事件
	$('#usershow tbody').on( 'click', 'button#deleterow', function () {
		currentRow = $(this);
		$("#deletemodal").modal("show");//弹出框show
	});
	
	//删除对话框删除按钮点击事件
	$("#delconfirmbtn").click(function(){
		var data = datatable.row(currentRow.parents('tr') ).data();
		var yhdm= data[10];
		var params = yhdm; 
		$.ajax({
			url : 'deleteuser',
		    data : params, 
		    type : 'post',
		    dataType: "json",  
		 	contentType: "application/json", 
		    async : true,
		    success : function(data) {
		    	var obj = eval('(' + data.result + ')');
		    	if (obj=="success") {
		    		$("#deletemodal").modal("hide");//弹出框show
				    if(datatable == null){
			    		createTable();   //创建表格
			    	}else{
			    		datatable.draw();   //重绘数据表
			    	}
		    	}
		    },
		    error : function(msg) {
		    	
		    }
		});
	})
}

function queryprovince(obj2){
	$.ajax({
        url : 'queryprovince',
        type : 'post',
        dataType: "json",  
 		contentType: "application/json", 
        async : false,
        success : function(result) {
        	var resList = result.list;
        	var obj = eval('(' + resList + ')');
        	createSelect(obj,obj2);
        },
        error : function(msg) {
        }
    });
}

function querycity(provinceid,obj2){
	$.ajax({
        url : 'querycity',
        type : 'post',
        data:provinceid,
        dataType: "json",  
 		contentType: "application/json", 
        async : false,
        success : function(result) {
        	var resList = result.list;
        	var obj = eval('(' + resList + ')');
        	createSelect(obj,obj2);
        },
        error : function(msg) {
        }
    });
}

function querydistrict(cityid,obj2){
	$.ajax({
        url : 'querydistrict',
        data:cityid,
        type : 'post',
        dataType: "json",  
 		contentType: "application/json", 
        async : false,
        success : function(result) {
        	var resList = result.list;
        	var obj = eval('(' + resList + ')');
        	createSelect(obj,obj2);
        },
        error : function(msg) {
        }
    });
}

function createSelect(obj1,obj2){
	obj2.empty();
	for(var i=0;i<obj1.length;i++){
		obj2.append("<option value='Value'>Text</option>"); 
		obj2.get(0).options[i].value=obj1[i].id;
		obj2.get(0).options[i].text = obj1[i].name;
	}
}

function retrieveData(sSource,aoData, fnCallback) {
	var iDisplayStart;
	var iDisplayLength;
	var sEcho;
	for(var i=0;i<aoData.length;i++){		
		if(aoData[i].name === 'sEcho'){
			sEcho = aoData[i].value;
		}
		if(aoData[i].name === 'iDisplayStart'){
			iDisplayStart = aoData[i].value;
		}
		if(aoData[i].name === 'iDisplayLength'){
			iDisplayLength = aoData[i].value;
		}
	}
	var yhxm = $("#yhxm").val();
	var yhlb = $("#yhlb").val();
	var params = '{"yhxm":"'+ yhxm + '","yhlb":"'+ yhlb + '","iDisplayStart":"'+ iDisplayStart + '","iDisplayLength":"'+ iDisplayLength + '","sEcho":"'+ sEcho + '"}';  
	$.ajax({
		url : sSource,//这个就是请求地址对应sAjaxSource
	    data : params, //这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
	    type : 'post',
	    dataType: "json",  
	    contentType: "application/json", 
	    async : true,
	    success : function(result) {
	        var resList = result.list;
	        var obj = eval('(' + resList + ')');
	        fnCallback(obj);
	    },
	    error : function(msg) {
	    }
	});
}

