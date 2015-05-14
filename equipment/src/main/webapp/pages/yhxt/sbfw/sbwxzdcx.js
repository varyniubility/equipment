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
	
	var map = new BMap.Map("map");
	map.centerAndZoom(new BMap.Point(114.066, 22.616), 12);
	map.enableScrollWheelZoom();
	 var content = '<div style="margin:0;line-height:20px;padding:2px;">' +
     '<img src="assets/img/search.jpg" alt="" style="float:right;zoom:1;overflow:hidden;width:120px;height:100px;margin-left:3px;"/>' +
     '地址：北京市海淀区上地十街10号<br/>电话：(010)59928888<br/>简介：百度大厦位于北京市海淀区西二旗地铁站附近，为百度公司综合研发及办公总部。' +
     '</div>';

		//创建检索信息窗口对象
		var searchInfoWindow = null;
		searchInfoWindow = new BMapLib.SearchInfoWindow(map, content, {
		   title  : "百度大厦",
		   width  : 290,
		   height : 105,
		   panel  : "panel",
		   enableAutoPan : true,
		   searchTypes   :[
		       BMAPLIB_TAB_SEARCH,
		       BMAPLIB_TAB_TO_HERE, 
		       BMAPLIB_TAB_FROM_HERE 
		   ]
		});
		
	   var points =[
	       new BMap.Point(114.066,22.616),
	       new BMap.Point(114.05,22.55),
         new BMap.Point(114.12,22.55),
         new BMap.Point(114.05,22.53),
         new BMap.Point(113.92,22.52),
         new BMap.Point(113.9,22.57),
         new BMap.Point(114.27,22.73),
         new BMap.Point(114.22,22.55)]; 
	
	   function addMarker(point){
	       var marker = new BMap.Marker(point);
	       marker.enableDragging();
         marker.addEventListener("click", function(e){
             searchInfoWindow.open(marker);
         })
	       map.addOverlay(marker);
	   }
	   for (var i = 0; i < points.length; i ++) {
	       var point = points[i];
	       addMarker(points[i]);
	   }
	   var curve = new BMapLib.CurveLine(points, {strokeColor:"blue", strokeWeight:3, strokeOpacity:0});
	   curve.addEventListener("mouseover",function(){
	       console.log(curve);
	      curve = new BMapLib.CurveLine(points, {strokeColor:"blue", strokeWeight:4, strokeOpacity:0.5});
	       map.addOverlay(curve);
	   });
	   curve.addEventListener("mouseout",function(){
	       curve.remove();
	       curve = new BMapLib.CurveLine(points, {strokeColor:"blue", strokeWeight:1, strokeOpacity:0.5});
	       map.addOverlay(curve);
	   });
	   map.addOverlay(curve);
	   curve.enableEditing();
	   map.enableScrollWheelZoom(true);

})



function getcitydate(proid){
	$.ajax({
		url:"../querycity?proid="+proid,
		type:"post",
		dataType:"json",
		async:false,
		success:function(result){
			creatcityselect(result.list);
		},
		error:function(msg){
			alert("出错");
		}
		
	});
	
}

function getdistrictdata(cityid){
	$.ajax({
		url:"../querydistrict?cityid="+cityid,//url地址
		type:"post",
		dataType:"json",
		async:false,
		success:function(result){
			creatdistrictselect(result.list);
		},
		error:function(msg){
			alert("出错");
		}
		
	});
	
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




