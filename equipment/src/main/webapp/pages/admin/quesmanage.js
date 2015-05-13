var datatable=null;
var userid;
$(document).ready( function () {
	$("#quesmanage").attr("class","start active");
	$("#adminmian").attr("class","start");
	$("#servicemanage").attr("class","start");
	userid = $("#userid").val();
})

$("#searchbtn").click(function(){
	if(datatable == null){
		createTable();
	}else{
		datatable.draw();
	}
});

function createJdSelect(obj){
	for(var i=0;i<obj.length;i++){
		$("#modifyjd").append("<option value='Value'>Text</option>"); 
		$('#modifyjd').get(0).options[i].value=obj[i].jddm;
		$('#modifyjd').get(0).options[i].text = obj[i].jdmc;
	}
}

function createTable(){
	datatable = $('#serviceshow').DataTable({
		"bDestory":true,
		"bAutoWidth":false,
    	"bProcessing": true, // 是否显示取数据时的那个等待提示
        "bServerSide": true,//这个用来指明是通过服务端来取数据
        "sAjaxSource": "query",//这个是请求的地址
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
			{ "bSortable": false},
			{ "bSortable": false}
		],
		"columnDefs": [{
            "targets": -1,//编辑
            "data": null,
            "defaultContent": "<button id='modifyrow' class='btn btn-primary' type='button'><i class='fa fa-edit'></i></button>"
		},{
    		"targets": -2,//问题编号
    		"visible":false
    	},{
    		"targets": -3,//进度代码
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
	$('#serviceshow tbody').on('click', 'button#modifyrow', function () {
		var data = datatable.row( $(this).parents('tr') ).data();
		$("#sbmc").val(data[0]);
		$("#sbxh").val(data[1]);
		$("#sbwt").val(data[4]);
		$("#jddm").val(data[11]);
		$("#wtdm").val(data[12]);
		var jddm = $("#jddm").val();
		var params = jddm;  
		$.ajax({
	        url : 'queryjd',//这个就是请求地址对应sAjaxSource
	        data : params, //这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
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
		$("#modifymodal").modal("show");//弹出框show
		$("#modifyconfirm").click(function(){
			var wtdm = $("#wtdm").val();
			var jddm = $("#modifyjd").val();
			var wtjd = $("#modifyques").val();
			var gcszj = $("#gcszj").val();
			var params = '{"wtdm":"'+ wtdm + '","jddm":"'+ jddm + '","wtjd":"'+ wtjd + '","gcszj":"'+ gcszj + '"}';
			$.ajax({
		        url : 'modifyques',//这个就是请求地址对应sAjaxSource
		        data : params, //这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
		        type : 'post',
		        dataType: "json",  
		 		contentType: "application/json", 
		        async : true,
		        success : function(result) {
		        	var resList = result.list;
		        	$("#modifymodal").modal("hide");//弹出框show
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