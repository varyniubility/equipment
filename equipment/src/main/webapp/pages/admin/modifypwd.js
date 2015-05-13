$(document).ready( function () {
	$("#quesmanage").attr("class","start");
	$("#adminmian").attr("class","start");
	$("#servicemanage").attr("class","start");
	$("#sysmanage").attr("class","active  open");
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
		   success:function(data){
		    	
		   },
		   error: function(data) {
		        
		   }
		});
	})
})