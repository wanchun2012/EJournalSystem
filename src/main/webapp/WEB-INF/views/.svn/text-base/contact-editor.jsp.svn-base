

<!-- javascript to submit form -->
<script type="text/javascript">
	//submit form
	$("#btnRevSubmit").click(function() {

		var review = {
				judjement 		: $("#overall-judgement").val(),
				expertise 		: $("#expertise-level").val(),
				summary   		: $("#summary").val(),   
			    criticisms		: [],
				typos	  		: [],
				secretComments	: []
			};

		for(var i =1; i<= $('[id^=criticism]').length; i++) {
		    review.criticisms.push($('#criticism_'+i).val());
		}
		
		for(var i =1; i<= $('[id^=typo]').length; i++) {
		    review.typos.push($('#typo_'+i).val());
		}
		
		for(var i =1; i<= $('[id^=secret]').length; i++) {
		    review.secretComments.push($('#secret_'+i).val());
		}
	
		alert("prova");
		$.postJSON("submit_review",review,function(msg){
			alert(msg);
		});
		return false;


	});
</script>
<!-- 		$.ajax({
			type : "POST",
			url : "article_upload_initial_guest",
			data : $("#submit-review").serialize(),
			dataType : "json",

			success : function(msg) {
				alert("success");
			},
			error : function() {
				alert("error");
			}
		}); -->


<form method="post" id="submit-letter" class="form-horizontal">
	<fieldset>
		<div>
		<hr/>
			<p style="padding-left: 10px">Send letters to the editor to discuss particular articles, which may appear in edited form, with replies from the article's authors, in a later edition.</p>
			<div class="control-group" >
				<label class="control-label" for="overall-judgement">Comment</label>
				<div class="controls">
					<textarea class="input-xxlarge" id="comment" name="comment" style="resize: none"></textarea>
				</div>
			</div>
			<hr/>
		</div>
		<div class="form-actions">
			<button id="btnRevSubmit" type="submit" class="btn btn-primary">Submit</button>
		</div>
	</fieldset>
</form>