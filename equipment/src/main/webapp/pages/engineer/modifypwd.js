$(document).ready( function () {
	$("#answer").attr("class","start");
	$("#engineerMain").attr("class","start");
	$("#repair").attr("class","start");
	$("#baseinfo").attr("class","active open");
	$("#modifypwd").attr("class","active");
	
	$("#submitbtn").click(function(){
		var userid = $("#userid").val();
		var oldpassword = $("#oldpassword").val();
		var newpassword = $("#newpassword").val();
		var confirmpwd = $("#confirmpwd").val();
		var params = '{"userid":"'+ userid + '","oldpassword":"'
		    + oldpassword + '","newpassword":"'+ newpassword + '","confirmpwd":"'+ confirmpwd + '"}';  
		$.ajax({
		   url:"password",
		   data:params,
		   type:"post", 
		   dataType: "json",  
		   contentType: "application/json", 
		   success : function(data) {
	        	var resList = data.result;
	        	var obj = eval('(' + resList + ')');
	        	$("#submitbtn").attr("data-content",obj);
	        	$("#submitbtn").popover('show');
	        	$('#element')[0].reset();
		        setTimeout(function(){
		        	$("#submitbtn").popover('hide');
		        },3000);
	        },
	        error : function(msg) {
	        	$("#submitbtn").attr("data-content","保存失败！");
	        }
		});
	})
})