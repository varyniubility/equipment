/*function check(){
	alert("111");
	if($("#number")==null){
		alert("序列号必填");
	}
}*/
 function customerlogin(){
	
}

/*var Login = function() {

    var handleLogin = function() {
    	alert(1111);
        $('.custom-form').validate({
            errorElement: 'span', //default input error message container
            errorClass: 'help-block', // default input error message class
            focusInvalid: false, // do not focus the last invalid input
            rules: {
                number: {
                    required: true
                }
            },

            messages: {
                number: {
                    required: "序列号必须填写！"
                }
            },

            invalidHandler: function(event, validator) { //display error alert on form submit   
                $('.alert-danger', $('.login-form')).show();
            },

            highlight: function(element) { // hightlight error inputs
                $(element)
                    .closest('.form-group').addClass('has-error'); // set error class to the control group
            },

            success: function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },

            errorPlacement: function(error, element) {
                error.insertAfter(element.closest('.input-icon'));
            },

            submitHandler: function(form) {
                form.submit(); // form validation success, call ajax form submit
            }
        });
    }
}();*/