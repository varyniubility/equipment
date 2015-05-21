var datatable=null;
var userid;
$(document).ready( function () {
	$("#quesmanage").attr("class","start active");
	$("#adminmian").attr("class","start");
	$("#servicemanage").attr("class","start");
	userid = $("#userid").val();
	if(datatable == null){
		createTable();
	}else{
		datatable.draw();
	}
	$("#searchbtn").click(function(){
		if(datatable == null){
			createTable();
		}else{
			datatable.draw();
		}
	});
})

function createJdSelect(obj){
	for(var i=0;i<obj.length;i++){
		$("#gcs").append("<option value='Value'>Text</option>"); 
		$("#gcs").get(0).options[i].value=obj[i].id;
		$("#gcs").get(0).options[i].text = obj[i].name;
	}
}

function createTable(){
	datatable = $('#questionshow').DataTable({
		"bDestory":true,
		"bAutoWidth":false,
    	"bProcessing": true, // 是否显示取数据时的那个等待提示
        "bServerSide": true,//这个用来指明是通过服务端来取数据
        "sAjaxSource": "query",//这个是请求的地址
        "fnServerData": retrieveData, // 获取数据的处理函数
        'sClass': "text-center",
        "bLengthChange": false,
        "aoColumns": [
			{ "bSortable": false,"sWidth":"5%"},
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
            "targets": 0,//编辑
            "data": null,
            "defaultContent": "<button id='modifyrow' class='btn btn-primary' type='button'><i class='fa fa-edit'></i></button>"
		},{
    		"targets": -1,//问题编号
    		"visible":false
		},{
    		"targets": -2,//问题编号
    		"visible":false
		},{
    		"targets": -3,//问题编号
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

	//问题解答按钮点击事件
	$('#questionshow tbody').on('click', 'button#modifyrow', function () {
		console.log("safaf");
		var data = datatable.row( $(this).parents('tr') ).data();
		$("#sbmc").val(data[1]);
		$("#sbxh").val(data[2]);
		$("#sbwt").val(data[4]);
		$("#fwjd").val(data[9]);
		$("#wtdm").val(data[12]);
		$.ajax({
	        url : 'querygcs',//这个就是请求地址对应sAjaxSource
	        type : 'post',
	        dataType: "json",  
	 		contentType: "application/json", 
	        async : true,
	        success : function(result) {
	        	var resList = result.list;
	        	var obj = eval('(' + resList + ')');
	        	createJdSelect(obj);
	        },
	        error : function(msg) {
	        }
	    });
		$("#detailmodal").modal("show");//弹出框show
		$("#confirmbtn").click(function(){
			var glydm = $("#userid").val();
			var gcsdm = $("#gcs").val();
			var wtdm = $("#wtdm").val();
			var params = '{"wtdm":"'+ wtdm + '","glydm":"'+ glydm + '","gcsdm":"'+ gcsdm + '"}';
			$.ajax({
		        url : 'modifyques',//这个就是请求地址对应sAjaxSource
		        data : params, //这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
		        type : 'post',
		        dataType: "json",  
		 		contentType: "application/json", 
		        async : true,
		        success : function(result) {
		        	var resList = result.list;
		        	$("#detailmodal").modal("hide");//弹出框show
		        	$('#modifyform')[0].reset();
		        	datatable.draw();
		        },
		        error : function(msg) {
		        }
		    });
		})
	})
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