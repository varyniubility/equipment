var datatable=null;
$(document).ready( function () {
	$("#answer").attr("class","start");
	$("#engineerMain").attr("class","start");
	$("#repair").attr("class","start active");
	$("#baseinfo").attr("class","");
	createTable();
})

$("#searchbtn").click(function(){
	if(datatable == null){
		createTable();
	}else{
		datatable.draw();
	}
});

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
			{ "bSortable": false}
		],
		"columnDefs": [{
            "targets": -1,//编辑
            "data": null,
            "defaultContent": "<button id='modifyrow' class='btn btn-primary' type='button'><i class='fa fa-edit'></i></button>"
		},{
    		"targets": -2,//进度代码
    		"visible":false
    	},{
    		"targets": -3,//申请单编号
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
	
	$('#serviceshow tbody').on('dblclick','tr',function(){
		var data = datatable.row($(this)).data();
		$("#sqdsbmc").val(data[0]);
		$("#sqdsbxh").val(data[1]);
		$("#sqdsblx").val(data[3]);
		$("#sqdfwlx").val(data[4]);
		$("#sqdkhdz").val(data[0]);
		$("#sqdzsly").val(data[0]);
		$("#sqdgcs").val(data[0]);
		$("#sqdgly").val(data[0]);
		$("#sqdjd").val(data[5]);
		$("#detailmodal").modal("show");//弹出框show
	})

	//更新进度按钮点击事件
	$('#serviceshow tbody').on('click', 'button#modifyrow', function () {
		var data = datatable.row( $(this).parents('tr') ).data();
		$("#sbmc").val(data[0]);
		$("#sbxh").val(data[1]);
		$("#jddm").val(data[6]);
		$("#sqdbh").val(data[7]);
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
			console.log($("#sqdbh").val());
			var sqdbh = $("#sqdbh").val();
			var jddm = $("#modifyjd").val();
			var params = '{"sqdbh":"'+ sqdbh + '","jddm":"'+ jddm + '"}';
			$.ajax({
		        url : 'modifyjd',//这个就是请求地址对应sAjaxSource
		        data : params, //这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
		        type : 'post',
		        dataType: "json",  
		 		contentType: "application/json", 
		        async : true,
		        success : function(result) {
		        	var resList = result.list;
		        	$("#modifymodal").modal("hide");//弹出框show
		        	datatable.draw();
		        },
		        error : function(msg) {
		        }
		    });
		})
	})
}



function createJdSelect(obj){
	for(var i=0;i<obj.length;i++){
		$("#modifyjd").append("<option value='Value'>Text</option>"); 
		$('#modifyjd').get(0).options[i].value=obj[i].jddm;
		$('#modifyjd').get(0).options[i].text = obj[i].jdmc;
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
	var params = '{"iDisplayStart":"'+ iDisplayStart + '","iDisplayLength":"'+ iDisplayLength + '","sEcho":"'+ sEcho + '"}';  
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