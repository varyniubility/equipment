$(document).ready(function(){
	$("#sbcjwtMain").attr("class","start");
	$("#sbjbxxMain").attr("class","start");
	$("#sbwtfkMain").attr("class","start");
	$("#sbfwMain").attr("class","active open")
	$("#sbwxzdcxMain").attr("class","active");
	$("#sbkdwxsqMain").attr("class","start");
	$("#sbsmwxsqMain").attr("class","start");
	
	$("#select_province").change(function(){
		var val = this.value;
		initCity();//初始化城市
		initDistrict();//初始化地区
		if(val!="0"){
			clearCity();//情况city
			clearDistrict();//清空地区
			getcitydate(val);//后台获取数据
		}
			
	});
	
	$("#select_city").change(function(){
		var val = this.value;
		initDistrict();//初始化地区
		if(val!="0"){
			clearDistrict();//清空地区
			getdistrictdata(val);
		}
	});
})



function getcitydate(proid){
	$.ajax({
		url:"../querycity?proid="+proid,//url地址
//		data:proid,
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
//		data:proid,
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

function creatdistrictselect(list){//拼接district select
	var obj = JSON.parse(list);
	var s_district =$("#select_district");
	clearDistrict();//清空地区
//	s_city.append("<option value="+0+">--请选择城市--</option>");
	for(var i = 0;i<obj.length;i++){
		s_district.append("<option value="+obj[i].districtid+">"+obj[i].districtname+"</option>");
	}
}

function creatcityselect(list){
	var obj = JSON.parse(list);
	var s_city =$("#select_city");
	if(obj[0].cityid!=null){		//选择省份 自动选择第一个城市和第一个地区
		getdistrictdata(obj[0].cityid);
	}
//	s_city.append("<option value="+0+">--请选择城市--</option>");
	for(var i = 0;i<obj.length;i++){
		s_city.append("<option value="+obj[i].cityid+">"+obj[i].cityname+"</option>");
	}
}

function initCity(){//初始化city select
	$("#select_city option").remove();
	$("#select_city").append("<option value="+0+">--请选择市--</option>");
	
}
function initDistrict(){//初始化 district select
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






