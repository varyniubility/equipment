var datatable=null;
var userid;
$(document).ready( function () {
	$("#quesmanage").attr("class","start");
	$("#adminmian").attr("class","start");
	$("#servicemanage").attr("class","start active");
	$("#sysmanage").attr("class","start");
	userid = $("#userid").val();
	queryjd();
	queryadmin();
	queryengineer();
	queryprovince();
	var provinceid=$("#province").val();
	querycity(provinceid);
	var cityid=$("#city").val();
	querydistrict(cityid);
	$("#searchbtn").click(function(){
		if(datatable == null){
			createTable();
		}else{
			datatable.draw();
		}
	});
	$("#province").change(function(){
		querycity($("#province").val());
		querydistrict($("#city").val());
	});
	
	$("#city").change(function(){
		querydistrict($("#city").val());
	});
	
	$("#submitbtn").click(function(){
		saveModify();
	})
	$("#sqdbtn").click(function(){
		$("#addmodal").modal("show");//弹出框show
	});
	
	$("#confirmbtn").click(function(){
		var sqdsbmc = $("#sqdsbmc").val();
		var sqdsbxh = $("#sqdsbxh").val();
		var sqdsblx = $("#sqdsblx").val();
		var sqdfwlx = $("#sqdfwlx").val();
		var province = $("#province").val();
		var city = $("#city").val();
		var district = $("#district").val();
		var sqdxxdz = $("#sqdxxdz").val();
		var sqdgcs = $("#sqdgcs").val();
		var sqdjd = $("#sqdjd").val();
		var sqdwt = $("#sqdwt").val();
		var sqdgly = $("#sqdgly").val();
		var sqdsbxlh = $("#sqdsbxlh").val();
		var params = '{"sqdsbxlh":"'+ sqdsbxlh + '","sqdsbmc":"'+ sqdsbmc + '","sqdsbxh":"'
			+ sqdsbxh + '","sqdsblx":"'+ sqdsblx + '","sqdfwlx":"'+ sqdfwlx + '","province":"'+ province + '","city":"'
			+ city + '","district":"'+ district + '","sqdxxdz":"'+ sqdxxdz +'","sqdgcs":"'+ sqdgcs + '","sqdjd":"'
			+ sqdjd + '","sqdwt":"'+ sqdwt + '","sqdgly":"'+ sqdgly +'"}';
		$.ajax({
	        url : 'savesqd',
	        type : 'post',
	        data:params,
	        dataType: "json",  
	 		contentType: "application/json", 
	        async : false,
	        success : function(result) {
	        },
	        error : function(msg) {
	        }
	    });
	})
});

function queryprovince(){
	$.ajax({
        url : 'queryprovince',
        type : 'post',
        dataType: "json",  
 		contentType: "application/json", 
        async : false,
        success : function(result) {
        	var resList = result.list;
        	var obj = eval('(' + resList + ')');
        	var obj2 = $("#province");
        	createSelect(obj,obj2);
        },
        error : function(msg) {
        }
    });
}

function queryjd(){
	$.ajax({
        url:'queryjd',
        type : 'post',
        dataType: "json",  
 		contentType: "application/json", 
        async : false,
        success : function(result) {
        	var resList = result.list;
        	var obj = eval('(' + resList + ')');
        	var obj2 = $("#sqdjd");
        	createSelect(obj,obj2);
        },
        error : function(msg) {
        }
    });
}

function queryengineer(){
	$.ajax({
        url : 'queryengineer',
        type : 'post',
        dataType: "json",  
 		contentType: "application/json", 
        async : false,
        success : function(result) {
        	var resList = result.list;
        	var obj = eval('(' + resList + ')');
        	var obj2 = $("#sqdgcs");
        	createSelect(obj,obj2);
        },
        error : function(msg) {
        }
    });
}

function queryadmin(){
	$.ajax({
        url : 'queryadmin',
        type : 'post',
        dataType: "json",  
 		contentType: "application/json", 
        async : false,
        success : function(result) {
        	var resList = result.list;
        	var obj = eval('(' + resList + ')');
        	var obj2 = $("#sqdgly");
        	createSelect(obj,obj2);
        },
        error : function(msg) {
        }
    });
}

function querycity(provinceid){
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
        	var obj2 = $("#city");
        	createSelect(obj,obj2);
        },
        error : function(msg) {
        }
    });
}

function querydistrict(cityid){
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
        	var obj2 = $("#district")
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

function createTable(){
	datatable = $('#serviceshow').DataTable({
		"bDestory":true,
		"bAutoWidth":false,
    	"bProcessing": true, // 是否显示取数据时的那个等待提示
        "bServerSide": true,//这个用来指明是通过服务端来取数据
        "sAjaxSource": "querysqd",//这个是请求的地址
        "fnServerData": retrieveData, // 获取数据的处理函数
        'sClass': "text-center",
        "bLengthChange": false,
        "aoColumns": [
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
			{ "bSortable": false},
			{ "bSortable": false},
			{ "bSortable": false}
		],
		"columnDefs": [{
    		"targets": -1,//问题编号
    		"visible":false
    	},{
    		"targets": -1,//进度代码
    		"visible":false
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
	var params = '{"userid":"'+ userid + '","iDisplayStart":"'+ iDisplayStart + '","iDisplayLength":"'+ iDisplayLength + '","sEcho":"'+ sEcho + '"}';  
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