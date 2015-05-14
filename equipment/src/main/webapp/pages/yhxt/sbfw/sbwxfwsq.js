$(document).ready(function(){
	$("#sbcjwtMain").attr("class","start");
	$("#sbjbxxMain").attr("class","start");
	$("#sbwtfkMain").attr("class","start");
	$("#sbfwMain").attr("class","active open")
	$("#sbwxzdcxMain").attr("class","start");
	$("#sbwxfwsqMain").attr("class","active");
	
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
	
	$("#modalok").click(function(){
		var sqdbh=$("#lssqdbh").val();
		var yhpj=$("#lsyhpj").val();
		alert(yhpj);
		$.ajax({
	        url : "../addyhpj?sqdbh="+sqdbh+"&yhpj="+encodeURI(yhpj),//这个就是请求地址对应sAjaxSource
//			url:"../getsqdmx?sqdbh="+sqdbh,
	        type : "post",
	        dataType: "String",  
	        async : false,
	        success : function(result) {
	        	alert(result);
	        },
	        error : function(msg) {
//	        	alert("");
	        	 alert("提交成功");
	        }
	       
	    });
	});
	
})


function showsqdmx(sqdbh){
	$.ajax({
		url:"../getsqdmx?sqdbh="+sqdbh,
		type:"post",
		dataType:"json",
		async:false,
		success:function(result){
			creatcitymodel(result.list);
		},
		error:function(msg){
			alert("出错");
		}
	});
}


function creatcitymodel(list){
	var obj = JSON.parse(list);
	for(var i=0;i<obj.length;i++){
		$("#lssbxlh").val(obj[i].sbxlh);
		$("#lssqdbh").val(obj[i].sqdbh);
		$("#lssbwtms").val(obj[i].sbwtms);
		$("#lsgcsxm").val(obj[i].gcsmc);
		$("#lsgcsdh").val(obj[i].gcsdh);
		$("#lsyhpj").val(obj[i].yhpj);
	}
	$("#sqdmx").modal("show");
}

	var submitok1 = function() {
		var zsly = document.getElementsByName("zsly");
		var xzcd = 0;
		for (var i = 0; i < zsly.length; i++) {
			if (zsly[i].checked == true) {
				xzcd++;
			}
		}
//		alert(xzcd);
		if (xzcd > 3) {
			alert("请最多选择三个涉及领域！")
			return 0;
		}
		if(xzcd==0){
			alert("请选择领域！");
			return 0;
		}
		xzcd = 1;
		for (i = 0; i < zsly.length; i++) {
			if (zsly[i].checked == true) {
				var zslydm = "zslydm" + xzcd;
//				alert(zslydm)
				xzcd++;
				document.getElementById(zslydm).value = zsly[i].value;
//				alert(zsly[i].value);
			}
		}
//		alert($("#zslydm1").val());
		var proid = $("#select_city option:selected").val();
		var citid = $("#select_province option:selected").val();
		var disid = $("#select_district option:selected").val();
		if(proid==null || proid=="0"){
			alert("请选择省份");
			return 0;
		}else if(citid==null || citid=="0"){
			alert("请选择城市");
			return 0;
		}else if(disid==null || disid=="0"){
			alert("请选择地区");
			return 0;
		}
		var khxm = $("#khxm").val();
		var khdh = $("#khdh").val();
		var sbwtms = $("#sbwtms").val();
		var khxxdz = $("#khxxdz").val();
		if(sbwtms.length==0){
			alert("请填写姓名!");
			return 0;
		}else if(khxxdz.length==0){
			alert("请填写联系方式!");
			return 0;
		}else if(khxm.length==0){
			alert("请填写问题描述!");
			return 0;
		}else if(khdh.length==0){
			alert("请填写详细地址!");
			return 0;
		}
		$("#khsfid").val(proid);
		$("#khsid").val(citid);
		$("#khqid").val(disid);
//		alert($("#khqid").val());
		return 1;

	}


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




