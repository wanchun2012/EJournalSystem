<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<span id="postRef" style="display:none" link-ref="<c:url value="/submit_review"/>" ></span>

<form method="post" id="submit-review" class="form-horizontal">
	<fieldset>
		<div>
			<hr />
			<p style="padding-left: 10px">Article:</p>
			<div class="control-group">
				<label class="control-label" for="textarea">ID</label>
				<div class="controls">
					<textarea class="input-small" id="artId" name="artId"></textarea>
				</div>
			</div>
			<p style="padding-left: 10px">Overall Judgement</p>
			<div class="control-group">
				<label class="control-label" for="overall-judgement">Champion/Detractor</label>
				<div class="controls">
					<select class="input-xlarge" id="overall-judgement"
						name="overall-judgement">
						<option value="champion">Champion</option>
						<option value="favourable">Favourable</option>
						<option value="indifferent">Indifferent</option>
						<option value="detractor">Detractor</option>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="expertise-level">Expertise
					Level</label>
				<div class="controls">
					<select class="input-xlarge" id="expertise-level"
						name="expertise-level">
						<option value="expert">Expert</option>
						<option value="knowledgeable">Knowledgeable</option>
						<option value="outsider">Outsider</option>
					</select>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label" for="textarea">Summary</label>
				<div class="controls">
					<textarea class="input-xlarge" id="summary" name="summary"
						style="resize: none"></textarea>
				</div>
			</div>
			<hr />
			<div id="dynamicCriticism">
				<div class="control-group">
					<label class="control-label" for="textarea">Structured
						Criticism 1</label>
					<div class="controls">
						<textarea class="input-xlarge" id="criticism_1" name="criticism_1"></textarea>
					</div>
				</div>
			</div>
			<div style="margin-left: 10px">
				<input class="btn" type="button" value="Add criticism"
					onClick="addCriticism('dynamicCriticism');">
			</div>
			<hr />
			<div style="margin-top: 5px" id="dynamicTypo">
				<div class="control-group">
					<label class="control-label" for="textarea">Typographic
						Mistake 1</label>
					<div class="controls">
						<textarea class="input-xlarge" id="typo_1" name="typo_1"></textarea>
					</div>
				</div>
			</div>
			<div style="margin-left: 10px">
				<input class="btn" type="button" value="Add typo"
					onClick="addTypo('dynamicTypo');">
			</div>
			<hr />
			<div style="margin-top: 5px" id="dynamicSecretComment">
				<div class="control-group">
					<label class="control-label" for="textarea">Secret Comment
						1</label>
					<div class="controls">
						<textarea class="input-xlarge" id="secret_1" name="secret_1"></textarea>
					</div>
				</div>
			</div>
			<div style="margin-left: 10px">
				<input class="btn" type="button" value="Add secret comment"
					onClick="addSecretComment('dynamicSecretComment');">
			</div>
		</div>

		<div class="form-actions">
			<button id="btnRevSubmit" type="submit" class="btn btn-primary">Submit</button>
		</div>
	</fieldset>
</form>



<!-- javascript to add criticism dynamically -->
<script type="text/javascript">
	var critiCounter = 1;
	var typoCounter = 1;
	var secretCounter = 1;
	function addCriticism(divName) {

		critiCounter++;
		var newdiv = document.createElement('div');
		newdiv.innerHTML = '<div class="control-group">'
				+ '<label class="control-label" for="textarea">Criticism '
				+ critiCounter
				+ '</label>'
				+ '<div class="controls">'
				+ '<textarea class="input-xlarge" id="criticism_'+critiCounter+'" name="criticism_'+critiCounter+'"></textarea>'
				+ '</div>	</div>';

		document.getElementById(divName).appendChild(newdiv);

		// give focus to the newly added input
		$('html, body').animate({
			scrollTop : $("#criticism_" + critiCounter).offset().top - 90
		}, 500);
	}

	function addTypo(divName) {

		typoCounter++;
		var newdiv = document.createElement('div');
		newdiv.innerHTML = '<div class="control-group">'
				+ '<label class="control-label" for="textarea"> Typo '
				+ typoCounter
				+ '</label>'
				+ '<div class="controls">'
				+ '<textarea class="input-xlarge" id="typo_'+typoCounter+'" name="typo_'+typoCounter+'"></textarea>'
				+ '</div>	</div>';

		document.getElementById(divName).appendChild(newdiv);

		// give focus to the newly added input
		$('html, body').animate({
			scrollTop : $("#typo_" + typoCounter).offset().top - 90
		}, 500);
	}

	function addSecretComment(divName) {

		secretCounter++;
		var newdiv = document.createElement('div');
		newdiv.innerHTML = '<div class="control-group">'
				+ '<label class="control-label" for="textarea"> Secret '
				+ secretCounter
				+ '</label>'
				+ '<div class="controls">'
				+ '<textarea class="input-xlarge" id="secret_'+secretCounter+'" name="secret_'+secretCounter+'"></textarea>'
				+ '</div>	</div>';

		document.getElementById(divName).appendChild(newdiv);

		// give focus to the newly added input
		$('html, body').animate({
			scrollTop : $("#secret_" + secretCounter).offset().top - 90
		}, 500);
	}
</script>

<!-- javascript to submit form -->
<script type="text/javascript">
	//submit form
	$("#btnRevSubmit").click(
			function() {

				var review = {
					articleId  : $("#artId").val(),
					summary    : $("#summary").val(),
					commentsCritisize 	: [],
					commentsTypographic : [],
					commentsSecret 		: []
				};
				
				var judgement = $("#overall-judgement").val();
				if (judgement == "champion") {
					review.score = 3;
				} else if (judgement == "favourable") {
					review.score = 2;
				} else if (judgement == "indifferent") {
					review.score = 1;
				} else if (judgement == "detractor") {
					review.score = 0;
				}
				
				var expLevel = $("#expertise-level").val();
				if (expLevel == "expert") {
					review.expertise = 2;
				} else if (expLevel == "knowledgeable") {
					review.expertise = 1;
				} else if (expLevel == "outsider") {
					review.expertise = 0;
				}


				for ( var i = 1; i <= $('[id^=criticism]').length; i++) {
					review.commentsCritisize.push($('#criticism_' + i).val());
				}

				for ( var i = 1; i <= $('[id^=typo]').length; i++) {
					review.commentsTypographic.push($('#typo_' + i).val());
				}

				for ( var i = 1; i <= $('[id^=secret]').length; i++) {
					review.commentsSecret.push($('#secret_' + i).val());
				}

				function failJSON(data) {
					alert(data.args[0]);
					$("#main-content").load(
							$('#contentRef').attr('base-ref')
									+ "submitrev-outcome-fail-json");
				}
				
				function completedJSON(data) {
					$("#main-content").load(
							$('#contentRef').attr('base-ref')
									+ "submitrev-outcome-success");
				}

				$.postJSON($('#postRef').attr('link-ref'), review, completedJSON, failJSON);
				return false;

			});
</script>
