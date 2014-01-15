<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="leaderboard">
	<sec:authentication property="principal.username" var="username" />
	<sec:authentication property="principal.userId" var="userId" />

	<c:if test="${not empty username}">
		<h3>Welcome, ${username} !</h3>
		<p>Your Articles</p>
	</c:if>
	<hr />
	<c:if test="${empty listArticles}">
		No articles found.
		<a id="choose-art-page-btn"
			href="<c:url value='/reviewer/${userId}/loadContent?cname=review'/>"
			style="margin: 1px 10px 5px" class="btn btn-warning btn-small"> <i
			class="icon-white icon-download-alt "></i>Choose Article to Review
		</a>
	</c:if>

	<c:if test="${not empty listArticles}">
		<table class="table">
			<thead>
				<tr>
					<td>#</td>
					<td>Article Title</td>
					<td>Status</td>
					<td>Revisions</td>
					<td>Review</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${listArticles}">
					<tr>
						<td>${article.id}</td>
						<td>${article.title}</td>
						<c:if test="${article.status==0}">
							<td>Requires Revision (Selected/Downloaded)</td>
						</c:if>
						<c:if test="${article.status==1}">
							<td>Review Submitted</td>
						</c:if>
						<c:if test="${article.status==2}">
							<td>Waiting for publication</td>
						</c:if>
						<c:if test="${article.status==3}">
							<td>Published</td>
						</c:if>

						<td>${article.numberReviewed}</td>
						<td><a href="#myModal${article.id}" role="button" class="btn btn-warning"
							data-toggle="modal">Review this article</a></td>
					</tr>
					<tbody>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>
<!-- Modal windows for every article-->
<c:forEach var="article" items="${listArticles}">
	<div style="width: 80%; display: hide; left: 33%;"
		id="myModal${article.id}" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Title:</h3>
			<p>${article.title}</p>
			<span id="artId-Ref" style="display: none" artId-ref="${article.id}"></span>
		</div>
		<div class="modal-body" style="max-height: 400px;">
			<div class="leaderboard" style="margin-bottom: 10;">
				<p>First Upload Date: ${article.firstVersion.friendlyDate}</p>
				<p>Current Version: ${article.lastVersion.version}</p>
				<p>Current Version Upload Date: ${article.friendlyDate}</p>
				<p>Revisions received: ${article.numberReviewed}/3</p>
				<hr />
				<c:forEach var="review" items="${article.reviewCollection}">
					<p>Review Date: ${review.friendlyDate}</p>
					<ul>
						<!--  show also the answers of the author?  -->
						<c:forEach var="comment" items="${review.commentCollection}">
							<li>Type: ${comment.friendlyType}</li>
							<li>Comment: ${comment.comment}</li>
							<br>
						</c:forEach>
					</ul>
				</c:forEach>
				<c:if test="status=0">
					<a id="status-download-art"
						href="<c:url value='${article.lastVersionURL}'/>"
						style="margin: 1px 10px 5px" class="btn btn-warning btn-small">
						<i class="icon-white icon-download-alt "></i>Download
					</a>
				</c:if>
			</div>
			<div class="accordion" id="accordion2">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a id="expand-form" class="accordion-toggle"
							data-toggle="collapse" data-parent="#accordion2"
							href="#collapseRev">Review Form </a>
					</div>
					<div id="collapseRev" class="accordion-body collapse">
						<span id="postRef" style="display: none"
							link-ref="<c:url value="/submit_review"/>"></span>

						<form method="post" id="submit-review" class="form-horizontal">
							<fieldset>
								<div>
									<hr />
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
												<textarea class="input-xlarge" id="criticism_1"
													name="criticism_1"></textarea>
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
											<label class="control-label" for="textarea">Secret
												Comment 1</label>
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
							</fieldset>
						</form>
						<div class="form-actions">
							<button id="btnRevSubmit" type="submit" class="btn btn-primary">Submit</button>
						</div>

					</div>
				</div>
			</div>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Back</button>
		</div>
	</div>
</c:forEach>

<script type="text/javascript">
	$("#choose-art-page-btn").click(function() {
		$("#main-content").load(this.href);
		return false;
	});

	$("#expand-form").click(function() {
		$('html, body').animate({
			scrollTop : $("#submit-paper").offset().top - 50
		}, 500);
	});
</script>



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
					articleId : parseInt($('#artId-Ref').attr('artId-Ref')),
					summary : $("#summary").val(),
					commentsCritisize : [],
					commentsTypographic : [],
					commentsSecret : []
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
				var selectedModal = "myModal"+review.articleId;
				for ( var i = 1; i <= $("#"+selectedModal+" [id^=criticism]").length; i++) {
					review.commentsCritisize.push($('#criticism_' + i).val());
				}

				for ( var i = 1; i <= $("#"+selectedModal+" [id^=typo]").length; i++) {
					review.commentsTypographic.push($('#typo_' + i).val());
				}

				for ( var i = 1; i <= $("#"+selectedModal+" [id^=secret]").length; i++) {
					review.commentsSecret.push($('#secret_' + i).val());
				}

				function failJSON(data) {
					$('.modal-backdrop').remove();
					$("#main-content").load(
							$('#contentRef').attr('base-ref')
									+ "submitrev-outcome-fail-json");
				}

				function completedJSON(data) {
					$('[id^=myModal]').modal('hide');
					$("#main-content").load(
							$('#contentRef').attr('base-ref')
									+ "submitrev-outcome-success");
				}

				$.postJSON($('#postRef').attr('link-ref'), review,
						completedJSON, failJSON);
				return false;

			});
</script>
