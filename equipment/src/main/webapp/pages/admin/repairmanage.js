var map;
$(document).ready( function () {
	$("#quesmanage").attr("class","start");
	$("#adminmian").attr("class","start");
	$("#servicemanage").attr("class","start");
	$("#repairmanage").attr("class","start active");
	
	map = new BMap.Map("mapinfo");
	map.centerAndZoom(new BMap.Point(114.066, 22.616), 12);
	map.enableScrollWheelZoom();
	$("#submitbtn").click(function(){
		var province = $("#province").find("option:selected").text(); 
		var city = $("#city").find("option:selected").text(); 
		var district = $("#district").find("option:selected").text(); 
		var address = $("#address").val();
		var addressStr = province+city+district+address;
		//访问百度地图地址解析API
		//百度地图Geocoding API服务地址:http://api.map.baidu.com/geocoder/v2/
		//ak参数，用户申请注册的key
		//callback:回调函数
		//output:返回值类型json或者xml
		//address:用户输入的地址，格式：省+市+县/区+某条路n号
		var url = "http://api.map.baidu.com/geocoder/v2/?ak=2StkIHWGNTW8xE8w7ApZlofD&callback=renderOption&output=json&address="+addressStr
		$.ajax({
			type: "post",
			url: url,
			dataType: 'JSONP',
			success: function (data) {
				renderOption(data);  //请求成功回调函数
			},
			error: function (data) {
				renderOption(data);
			}
		});
	})
	queryprovince();
	var provinceid=$("#province").val();
	querycity(provinceid);
	var cityid=$("#city").val();
	querydistrict(cityid);
	$("#province").change(function(){
		querycity($("#province").val());
		querydistrict($("#city").val());
	});
	
	$("#city").change(function(){
		querydistrict($("#city").val());
	});

	$("#addbtn").click(function(){
		var province = $("#province").val(); 
		var city = $("#city").val(); 
		var district = $("#district").val(); 
		var address = $("#address").val();
		var name = $("#addname").val();
		var telphone = $("#addtelphone").val();
		var zdjd = $("#zdjd").val();
		var zdwd = $("#zdwd").val();
		var params = '{"province":"'+ province + '","city":"'
		+ city + '","district":"'+ district + '","address":"'+ address + '","name":"'+ name + '","telphone":"'
		+ telphone + '","zdjd":"'+ zdjd + '","zdwd":"'+ zdwd +'"}';
		$.ajax({
	        url : 'savepoint',
	        type : 'post',
	        data : params,
	        dataType: "json",  
	 		contentType: "application/json", 
	        async : false,
	        success : function(result) {
	        	$("#addmodal").modal("hide");   //点击标注弹出模态框
	        },
	        error : function(msg) {
	        }
	    });
		
	})
});

function renderOption(response) {
    var html = '';
    if (response.status) {
        var text = "无正确的返回结果:\n";
        return;
    } else {
        var location = response.result.location;
        createmap(location)
        return;
    }
}

//生成地图
function createmap(location){
	map = new BMap.Map("mapinfo");
	var point = new BMap.Point(location.lng,location.lat);
	var marker = new BMap.Marker(point); 
	marker.enableDragging();
	map.addOverlay(marker);
	marker.addEventListener("click", function(){    
		$("#zdjd").val(location.lng);
		$("#zdwd").val(location.lat);
		$("#addmodal").modal("show");   //点击标注弹出模态框
	});
	map.centerAndZoom(point, 12);                  // 将标注添加到地图中
	map.enableScrollWheelZoom(true);
}

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
        success : function(data) {
        	var resList = data.result;
        	var obj = eval('(' + resList + ')');
        	if(obj == "success"){
        		$("#submitbtn").popover('show');
	        	setTimeout(function(){
	        		$("#submitbtn").popover('hide');
	        	},3000);
        	}else{
        		$("#submitbtn").attr("data-content","保存失败！");
        	}
        },
        error : function(msg) {
        	$("#submitbtn").attr("data-content","保存失败！");
        }
    });
}
