$(document).ready(function(){
		
		$('#main-content').load('home.jsp');
		
		$("#navbar a").click(function(){
			$("#main-content").load(this.href);
			return false;
		});
		
	
		 
		$('#submit-paper').validate(
			{
				rules : {
					name : {
						minlength : 2,
						required : true
					},
						surname : {
						minlength : 2,
						required : true
					},
					email : {
						required : true,
						email : true
					},
					affiliation : {
						minlength : 5,
						required : true
					},
					title : {
						minlength : 5,
						required : true
					},

					keywords : {
						minlength : 3,
						required : true
					},
				},
				highlight : function(element) {
					$(element).closest('.control-group').removeClass('success').addClass('error');
				},
				success : function(element) {
					$(element).closest('.control-group').removeClass('error')
							.addClass('success');
				}
			});
});

$.validateSetup({
    sendForm : false,
    onKeyup : true,
    eachValidField : function() {
		$(this).parents('.control-group').removeClass('error').addClass('success');
	},
	eachInvalidField : function() {
		$(this).parents('.control-group').removeClass('success').addClass('error');
	},
	//add isValid var
	valid : function() {
		$(this).attr('isvalid',true);
	},
	invalid : function() {
		$(this).attr('isvalid',false);
	},
	description : {
        mainDesc : {
            required : 'Required',
            valid : '',
            conditional : 'Please input at least one',
        }
    }
});
