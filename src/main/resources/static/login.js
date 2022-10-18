var data;

$(document).ready(function() {
	bindLoginButton();
	//login();

});


function bindLoginButton() {
	$("#login-button").click(function() {
	    login();

	});
}

function login() {
	
	$.ajax({
		type : "POST",
		url : "/login",
		headers : {
			'Accept' : 'application/json'
		},
		data : {
			username : $("#user").val(),
			password : $("#pass").val(),
		},
		success : function(response, Url, xhr) {
			window.location.href="/";
		},
		error : function(response, statusText) {
	        window.alert("invalid credentials");
			console.log(response);

		}
	});
}
