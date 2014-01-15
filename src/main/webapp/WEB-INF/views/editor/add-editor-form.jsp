<!-- javascript to submit form -->
<script type="text/javascript">
	//submit form
	$("#add-button").click(function() {
		var editor = {
				editorEmail	: $("#email").val(),
			};
		
		function failJSON(data){
			$("#server-response").text(data.args[0]);
			$('#myModal').modal();
		}
		
		function completedJSON(data){
			$("#server-response").text(data.args[0]);
			$("#email").val('');
			$('#myModal').modal();
		}
		
		$.postJSON($('#postRef').attr('link-ref'),editor,completedJSON,failJSON);
		
		return false;
	});
</script>
<div class="leaderboard">
	<h3>Add New Editor</h3>
	<p>Specify the email of the new editor </p>
	<hr/>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<span id="postRef" style="display:none" link-ref="<c:url value="/add_new_editor_by_email"/>" ></span>	
	
	<form method="post" id="add-editor" class="form-horizontal">
	<fieldset>
		<div class="control-group">
			<label class="control-label" for="email">Email address</label>
			<div class="controls">
				<input data-validate="submit" type="email" class="input-xlarge" id="email" />
			</div>
		</div>
		<div class="form-actions">
			<button type="submit" class="btn btn-primary" id="add-button">Add</button>
		</div>
	</fieldset>
</form>
</div>

<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">Adding an editor.</h3>
	</div>
	<div class="modal-body">
		<div class="leaderboard" id="server-response"> </div>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Back</button>
	</div>
</div>
