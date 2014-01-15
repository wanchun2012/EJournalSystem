<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="leaderboard">
	<sec:authentication property="principal.username" var="username" />
	<c:if test="${not empty username}">
		<h3>Welcome, ${username.split("@")[0]} !</h3>
		<p>Your Submitted Articles</p>
	</c:if>

	<hr />

	<c:if test="${empty listArticles}">
		No articles found.
	</c:if>

	<c:if test="${not empty listArticles}">
		<table class="table">
			<thead>
				<tr>
					<td>#</td>
					<td>Title</td>
					<td>Status</td>
					<td>Revisions</td>
					<td>Reviews</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${listArticles}">
					<tr>
						<td>${article.id}</td>
						<td>${article.title}</td>
						<c:if test="${article.status==0 || article.status==1}">
							<td>Waiting for revisions</td>
						</c:if>
						<c:if test="${article.status==2}">
							<td>Requires Author's Update</td>
						</c:if>
						<c:if test="${article.status==3}">
							<td>Waiting Author's payback reviews</td>
						</c:if>
						<c:if test="${article.status==4}">
							<td>Waiting to be published</td>
						</c:if>
						<c:if test="${article.status==5}">
							<td>Published</td>
						</c:if>

						<td>${article.numberReviewed}</td>
						<td><a href="#myModal${article.id}" role="button"
							class="btn btn-warning" data-toggle="modal">Show Reviews and
								Respond</a></td>
					</tr>
					<tbody>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>
<!-- Modal windows for every article-->
<c:forEach var="article" items="${listArticles}">
	<div id="myModal${article.id}" class="modal hide fade" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Title:</h3>
			<p>${article.title}</p>
		</div>
		<div class="modal-body">
			<div class="leaderboard">

				<!-- 0 waiting for revisions -->
				<!-- 1 needs update  -->
				<!-- 2 waiting for publication -->
				<!-- 3 published -->

				<p>First Upload Date: ${article.firstVersion.friendlyDate}</p>
				<p>Current Version: ${article.lastVersion.version}</p>
				<p>Current Version Upload Date: ${article.friendlyDate}</p>
				<p>Reviews received: ${article.numberReviewed}/3</p>
				<hr />
			</div>
			<div class="accordion" id="accordion2">
				<div class="accordion-group">
					<div class="accordion-heading">
						<a id="expand-form" class="accordion-toggle"
							data-toggle="collapse" data-parent="#accordion2"
							href="#collapseRev">Review Details </a>
					</div>
					<div id="collapseRev" class="accordion-body collapse">
						<span id="postRef" style="display: none"
							link-ref="<c:url value="/review_details"/>"></span>

						<form method="post" id="submit-review" class="form-horizontal">
							<fieldset>
								<c:forEach var="review" items="${article.reviewCollection}">
									<p>Review Date: ${review.whenUpdated}</p>
									<ul>
										<c:forEach var="comment" items="${review.commentCollection}">
											<!--  do not show secret comments -->
											<c:if test="${comment.friendlyType ne 'Secret'}">
												<li>Type: ${comment.friendlyType}</li>
												<li>Comment: ${comment.comment}</li>
												<div class="control-group">
													<label class="control-label" for="textarea">Answer</label>
													<div class="controls">
														<textarea class="input-xlarge"	id="answer-${comment.id}"
															name="answer-${comment.id}" style="resize: none"></textarea>
													</div>
												</div>
												<hr />
											</c:if>
											<br>
										</c:forEach>
									</ul>
								</c:forEach>
								<c:if test="${article.status==3}">
									<ul>
										<!-- 	<c:forEach var="reader-comment" items="$article.readerComment}">
											reader-comment
										</c:forEach> -->
										<li>reader comment1</li>
										<li>comment2</li>
									</ul>
								</c:if>
								<hr />
							</fieldset>
						</form>
						<div class="form-actions">
							<button id="btnRevAnswersSubmit" type="submit" class="btn btn-primary">Submit</button>
						</div>

					</div>
				</div>
			</div>

		</div>
		<div class="modal-footer">
			<c:if test="status=1">
				<a id="set-update-err-back-btn" href="<c:url value=''/>"
					style="margin: 1px 10px 5px" class="btn btn-warning btn-small">
					<i class="icon-white icon-folder-open "></i>Update
				</a>

			</c:if>
			<button class="btn" data-dismiss="modal" aria-hidden="true">Back</button>
		</div>
	</div>
</c:forEach>

<!-- javascript to submit form -->
<script type="text/javascript">
	//submit form
	$("#btnRevAnswersSubmit").click(
			function() {

				var reviewAnswers = {}
				
				var responses = $("[id^='answer-']");
				for (resp in responses) {
					if($.isNumeric(resp)){
						reviewAnswers [responses[resp].id.replace("answer-","")] = responses[resp].value;
					} 
				}

				function failJSON(data) {
					$('.modal-backdrop').remove();
					$("#main-content").load(
							$('#contentRef').attr('base-ref')
									+ "submitrevanswers-outcome-fail-json");
				}

				function completedJSON(data) {
					$('[id^=myModal]').modal('hide');
					$("#main-content").load(
							$('#contentRef').attr('base-ref')
									+ "submitrevanswers-outcome-success");
				}

				alert(reviewAnswers);
				$.postJSON($('#postRef').attr('link-ref'), reviewAnswers,
						completedJSON, failJSON);
				return false;

			});
</script>

