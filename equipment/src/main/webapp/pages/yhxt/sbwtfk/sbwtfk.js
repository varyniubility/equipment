$(document).ready(function(){
	$("#sbcjwtMain").attr("class","start");
	$("#sbjbxxMain").attr("class","start");
	$("#sbwtfkMain").attr("class","start active");
	
})


function zslyxz() {
	var sty = document.getElementById('zslyxz').style.display;
	if (sty == 'none') {
		document.getElementById('zslyxz').style.display = 'inline';
	} else if (sty == 'inline') {
		document.getElementById('zslyxz').style.display = 'none';
	}

	/*
	 * if($('#zslyxz').css('display')=='inline'){
	 * $('#zslyxz').css('display','none'); }else
	 * if($('#zslyxz').css('display')=='none'){
	 * $('#zslyxz').css('display','inline'); }
	 */

}
var submitok = function() {
	var zsly = document.getElementsByName("zsly");
	var xzcd = 0;
	for (var i = 0; i < zsly.length; i++) {
		if (zsly[i].checked == true) {
			xzcd++;
		}
	}
//	alert(xzcd);
	if (xzcd > 3) {
		alert("请最多选择三个涉及领域！")
		return 0;
	}
	xzcd = 1;
	for (i = 0; i < zsly.length; i++) {
		if (zsly[i].checked == true) {
			var zslydm = "zslydm" + xzcd;
//			alert(zslydm)
			xzcd++;
			document.getElementById(zslydm).value = zsly[i].value;
//			alert(zsly[i].value);
		}
	}
	return 1;

}

function addpj(i,wtbh){
	var str = "yhpj"+i;
	document.getElementById("yhpj").value = document.getElementById(str).value;
	document.getElementById("wtbh").value = wtbh;
	document.getElementById("form_update").submit();
}

function showpj(i) {
	var str = "pjdrv"+i;
	var sty = document.getElementById(str).style.display;
	if (sty == 'none') {
		document.getElementById(str).style.display = 'inline';
	} else if (sty == 'inline') {
		document.getElementById(str).style.display = 'none';
	}
}