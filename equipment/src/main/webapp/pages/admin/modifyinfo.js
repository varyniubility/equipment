$(document).ready( function () {
	$("#quesmanage").attr("class","start");
	$("#adminmian").attr("class","start");
	$("#servicemanage").attr("class","start");
	$("#sysmanage").attr("class","active open");
	$("#modifyinfo").attr("class","active");
	var userid = $("#userid").val();
	queryInfo(userid);
	queryprovince();
	querycity();
	querydistrict();
	$("#province").change(function(){
		querycity();
	});
	
	$("#city").change(function(){
		querydistrict();
	});
	
	$("#submitbtn").click(function(){
		saveModify();
	})
})

function queryprovince(){
	$.ajax({
        url : 'queryprovince',
        type : 'post',
        dataType: "json",  
 		contentType: "application/json", 
        async : true,
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

function queryInfo(userid){
	$.ajax({
        url : 'queryInfo',
        data : userid,
        type : 'post',
        dataType: "json",  
 		contentType: "application/json", 
        async : true,
        success : function(result) {
        	var resList = result.info;
        	var obj = eval('(' + resList + ')');
        	$("#name").val(obj.name);
        	$("#sex").val(obj.sex);
        	$("#phone").val(obj.phone);
        	$("#province").val(obj.province);
        	$("#city").val(obj.city);
        	$("#district").val(obj.district);
        	$("#address").val(obj.address);
        },
        error : function(msg) {
        }
    });
}
function querycity(){
	var provinceid = $("#province").val();
	$.ajax({
        url : 'querycity',
        type : 'post',
        data:provinceid,
        dataType: "json",  
 		contentType: "application/json", 
        async : true,
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

function querydistrict(){
	var cityid = $("#city").val();
	$.ajax({
        url : 'querydistrict',
        data:cityid,
        type : 'post',
        dataType: "json",  
 		contentType: "application/json", 
        async : true,
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
	for(var i=0;i<obj1.length;i++){
		obj2.append("<option value='Value'>Text</option>"); 
		obj2.get(0).options[i].value=obj1[i].id;
		obj2.get(0).options[i].text = obj1[i].name;
	}
}

function saveModify(){
	var userid = $("#userid").val();
	var name = $("#name").val();
	var sex = $("#sex").val();
	var phone = $("#phone").val();
	var province = $("#province").val();
	var city = $("#city").val();
	var district = $("#district").val();
	var address = $("#address").val();
	var params = '{"userid":"'+ userid + '","name":"'
    		+ name + '","sex":"'+ sex + '","phone":"'+ phone + '","province":"'+ province + '","city":"'
    		+ city + '","district":"'+ district + '","address":"'+ address +'"}';
	$.ajax({
        url : 'savemodify',
        data:params,
        type : 'post',
        dataType: "json",  
 		contentType: "application/json", 
        async : true,
        success : function(result) {
        },
        error : function(msg) {
        }
    });
}