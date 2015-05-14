var map;
$(document).ready(function(){
	$("#sbcjwtMain").attr("class","start");
	$("#sbjbxxMain").attr("class","start");
	$("#sbwtfkMain").attr("class","start");
	$("#sbfwMain").attr("class","active open")
	$("#sbwxzdcxMain").attr("class","active");
	$("#sbwxfwsqMain").attr("class","start");
	
	$("#select_province").change(function(){
		var val = this.value;
		initCity();
		initDistrict();
		if(val!="0"){
			clearCity();
			clearDistrict();
			getcitydate(val);
		}
			
	});
	
	$("#select_city").change(function(){
		var val = this.value;
		initDistrict();
		if(val!="0"){
			clearDistrict();
			getdistrictdata(val);
		}
	});
	
	map = new BMap.Map("map");
	map.centerAndZoom(new BMap.Point(114.066, 22.616), 12);
	map.enableScrollWheelZoom();
	
	$("#confirmbtn").click(function(){
		var province = $("#select_province").val();
		var city = $("#select_city").val();
		var district = $("#select_district").val();
		
		var params = '{"province":"'+ province + '","city":"'+ city + '","district":"'+ district +'"}';
		$.ajax({
	        url : 'querypoint',//这个就是请求地址对应sAjaxSource
	        data : params, //这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
	        type : 'post',
	        dataType: "json",  
	 		contentType: "application/json", 
	        success : function(result) {
	        	var resList = result.list;
	        	var obj = eval('(' + resList + ')');
	        	createmap(obj);
	        },
	        error : function(msg) {
	        }
	    });
	});
	
	

})

function getcitydate(proid){
	$.ajax({
		url:"../querycity?proid="+proid,
		type:"post",
		dataType:"json",
		success:function(result){
			creatcityselect(result.list);
		},
		error:function(msg){
			
		}
		
	});
	
}

function getdistrictdata(cityid){
	$.ajax({
		url:"../querydistrict?cityid="+cityid,//url地址
		type:"post",
		dataType:"json",
		success:function(result){
			creatdistrictselect(result.list);
		},
		error:function(msg){
			
		}
		
	});
	
}

function createmap(list){
	map = new BMap.Map("map");
	for (var i = 0; i < list.length; i ++) {
		var content = list[i];
		var sContent = '<div style="margin:0;line-height:20px;padding:2px;"><h4 style="margin:0 0 5px 0;padding:0.2em 0">'+content.zdmc+'</h4>'+
		  	'地址：'+content.provincename+content.cityname+content.districtname+content.xxdz+'<br/>电话：'+content.zddh+'<br/>'+
		    	'</div>';
		var infoWindow = new BMap.InfoWindow(sContent);
		var point = new BMap.Point(content.zdjd,content.zdwd);
		console.log(point);
		addMarker(point,infoWindow);
	}
	var length = list.length;
	var lastpoint = list[length-1];
	map.centerAndZoom(new BMap.Point(lastpoint.zdjd, lastpoint.zdwd), 12);
	map.enableScrollWheelZoom(true);
}

function addMarker(point,infoWindow){
    var marker = new BMap.Marker(point);
    marker.enableDragging();
    marker.addEventListener("click", function(e){
    	 this.openInfoWindow(infoWindow);
  })
    map.addOverlay(marker);
}

function creatdistrictselect(list){
	var obj = JSON.parse(list);
	var s_district =$("#select_district");
	clearDistrict();

	for(var i = 0;i<obj.length;i++){
		s_district.append("<option value="+obj[i].districtid+">"+obj[i].districtname+"</option>");
	}
}

function creatcityselect(list){
	var obj = JSON.parse(list);
	var s_city =$("#select_city");
	if(obj[0].cityid!=null){
		getdistrictdata(obj[0].cityid);
	}

	for(var i = 0;i<obj.length;i++){
		s_city.append("<option value="+obj[i].cityid+">"+obj[i].cityname+"</option>");
	}
}

function initCity(){
	$("#select_city option").remove();
	$("#select_city").append("<option value="+0+">--请选择市--</option>");
	
}
function initDistrict(){
	$("#select_district option").remove();
	$("#select_district").append("<option value="+0+">--请选择区--</option>");
	
}

function clearCity(){
	var city = $("#select_city option");
	city.remove();
	
}

function clearDistrict(){
	var distrinct = $("#select_district option");
	distrinct.remove();
}




