<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- javascript to submit form -->
<script type="text/javascript">
	//submit form
	$("#retire-editor").click(function() {
		
		$.getJSON($('#spanRef').attr('link-ref'), function(data) {
			if (data.response == "ok"){
				//success
				alert("You are retired successfully. Thank you.");
				window.location = "<c:url value='/j_spring_security_logout'/>";			
			}else{
				//fail
				//call the modal
				$('#myModal').modal();
			//	alert("Sorry yo can not retire beacause you are the only editor");
			}
		});

		return false;
	});
</script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<span id="spanRef" style="display:none" link-ref="<c:url value="/retire"/>" ></span>	


<h5>Editor Retirement...</h5>
<div>Confirm you retirement by clicking the button below.<br/> Please note that when you retire, you cannot logged in as an editor again.</div>
<div class="form-actions">
			<button type="submit" class="btn btn-primary" id="retire-editor">Confirm retirement</button>
		</div>

<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-header">
		<button type="button" class="close" data-dismiss="modal"
			aria-hidden="true">×</button>
		<h3 id="myModalLabel">Retirement fail</h3>
	</div>
	<div class="modal-body">
		<div class="leaderboard" >
			Sorry! retirement fail probably because you are the only editor, or there is a problem with the server.
		</div>
	</div>
	<div class="modal-footer">
		<button class="btn" data-dismiss="modal" aria-hidden="true">Back</button>
	</div>
</div>

		