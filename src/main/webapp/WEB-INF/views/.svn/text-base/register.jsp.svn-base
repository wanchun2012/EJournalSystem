<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- javascript to submit form -->
<script type="text/javascript">
	$("#btnRegister").click(function() {
			var newRev = {
				username : $("#email").val(),
				password : $('#password').val()
		};
	
		function failJSON(data) {
		$("#main-content").load(($('#contentRef').attr('base-ref') + "register-outcome-fail-json"), function() {
				alert(data.args[0]);
				$("#error-data").text(data.args[0]);
			});
		}
	
		function completedJSON(data) {
			$("#main-content").load($('#contentRef').attr('base-ref')+ "register-outcome-success");
		}
	
		$.postJSON($("#register-URL").attr('register-url'),newRev, completedJSON, failJSON);
		
		return false;
	});
</script>

<span id="register-URL" style="display: none"
	register-url="<c:url value="/register_reviewer"/>"></span>
<h3>Register as a Reviewer</h3>
<hr />
<form method="post" id="submit-article" class="form-horizontal">
	<fieldset>
		<label class="control-label" for="email">Username (email)</label>
		<div class="controls">
			<input class="input-xlarge" data-validate="submit" type="email"
				id="email" name="email" />
		</div>
		<br>
		<label class="control-label" for="password">Password</label>
		<div class="controls">
			<input class="input-xlarge" data-validate="submit" type="password"
				id="password" name="password" />
		</div>

		<div class="form-actions">
			<button id="btnRegister" type="submit" class="btn btn-primary">Register</button>
		</div>
	</fieldset>
</form>