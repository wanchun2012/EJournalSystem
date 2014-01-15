$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

$.postJSON = function(url, data, callbackSuccess,callbackFail) {
    return jQuery.ajax({
    headers: { 
        'Accept': 'application/json',
        'Content-Type': 'application/json' 
    },
    'url': url,
    'dataType': 'json',
    'contentType': 'application/json; charset=UTF-8', // This is the money shot
    'data': JSON.stringify(data),
    'type': 'POST',
    'success':  function(data){
    	if (data.response == "ok"){
    		callbackSuccess.call(this, data);
    	} else {
    		callbackFail.call(this, data);
    	}
    },
    'error': function (err){
    	callbackFail.call(this, err);
    },
    });
};

$.postFILE = function(url, file, callbackSuccess,callbackFail) {
	
	var fd = new FormData();
	fd.append("file", file);
	
    return jQuery.ajax({
    'url': url,
    'dataType': 'json',
    'processData': false,
    'contentType': false,
    'data': fd,
    'type': 'POST',
    'success':  function(data){
    	if (data.response == "ok"){
    		callbackSuccess.call(this, data);
    	} else {
    		callbackFail.call(this, data);
    	}
    },
    'error': function (err){
    	callbackFail.call(this, err);
    },
    });
};

$(document).ready(function() {

	var authUserName;
	var authUserRole;

	
	// loads the main content for the index pages of the different userds
	$('#main-content').load($('#contentRef').attr('base-ref')+$('#contentRef').attr('home-ref'));

	$(".navbar-link").click(function() {
		$("#main-content").load(this.href);
		return false;
	});

	
	$(".sidebar-link").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
	
	// alerts
	// /usage: createAutoClosingAlert(".alert-name", "message");
	function createAutoClosingAlert(selector, message) {
		   var alert = $(selector);
		   alert.find('p').html(message);
		   showAlert(alert);
		   window.setTimeout(function() {
			   dismissAlert(alert);
		   }, 2000);
	}
	
	function showAlert(alert){
		alert.removeClass("onbottom");
		alert.addClass("in ontop");
	}

	function dismissAlert(alert){
		alert.removeClass("in ontop");
		alert.addClass("onbottom");
	}
	
	// login form
	$("#btnLogin").click(function() {
		$.ajax({
			url : "j_spring_security_check",
			data : {
				j_username : $("#form_username").val(),
				j_password : $("#form_password").val()
			},
			type : "POST",
			success : function(result) {
				if (result == "fail") {
					// failed to login, display 'bad username/password'
					alert("fail");
					return false;
				} else {
					authUserName = result.principal.userId;
					authUserRole = "";
					for (var i=0; i<result.principal.authorities.length; i++) {
						role = result.principal.authorities[i].authority;
						if (authUserRole != "") {
							continue;
						} else if (role == "ROLE_EDITOR") {
							authUserRole = "editor/";
						} else if (role == "ROLE_AUTHOR") {
							authUserRole = "author/";
						} else if (role == "ROLE_REVIEWER") {
							authUserRole = "reviewer/";
						}
					}
					
					if (authUserRole != ""){
						location.href = authUserRole + authUserName;
					} else {
						//reload page
						window.location.href=window.location.href;
					}
					
					return true;
				}
			},
			error : function(XMLHttpRequest, textStatus, errorThrown) {
				// $("#ajax_login_error_" + suffix).html("Bad user/password");
				alert("Error Thrown: "+ errorThrown);
				return false;
			}
		});
		
		return false;
	});
/*
	{"principal":
		{"password":null,
		"username":"geo",
		"enabled":true,
		"accountNonLocked":true,
		"accountNonExpired":true,
		"credentialsNonExpired":true,
		"authorities":[{"authority":"ROLE_ADMIN"}]},
		"credentials":null,
		"details":{"sessionId":"7314F2980276FBBD8DD49B918919A328","remoteAddress":"0:0:0:0:0:0:0:1"},
		"authenticated":true,
		"name":"geo",
		"authorities":[{"authority":"ROLE_ADMIN"}]
	}
*/

	
});
