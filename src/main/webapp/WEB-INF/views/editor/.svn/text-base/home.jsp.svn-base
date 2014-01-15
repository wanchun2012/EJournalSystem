<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$("#art-detail-link").click(function() {
	$("#main-content").load(this.href);
	return false;
});</script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<script type="text/javascript">
$("#art-detail-link").click(function() {
	$("#main-content").load(this.href);
	return false;
});</script>

<!-- javascript to submit form --> 
<script type="text/javascript">
	//submit form
	$(".btn-publisharticle").click(function() {

		$.getJSON($('#postRef1').attr('link-ref'),"articleId="+$("#articleid"+$(this).attr('index-ref')).text(),function(data) {
			if (data.response == "ok"){
				//success
				alert("published.");
			}else{
				//fail
				//call the modal
				//$('#myModal').modal();
				alert("publish error");
			}
		});
		
		return false;
	});
	
	$(".btn-rejectarticle").click(function() {

		$.getJSON($('#postRef2').attr('link-ref'),"articleId="+$("#articleid"+$(this).attr('index-ref')).text(),function(data) {
			if (data.response == "ok"){
				//success
				alert("rejected.");
			}else{
				//fail
				//call the modal
				//$('#myModal').modal();
				alert("reject error");
			}
		});
		
		return false;
	});
</script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<span id="postRef1" style="display:none" link-ref="<c:url value="/publish_article"/>" ></span>	
<span id="postRef2" style="display:none" link-ref="<c:url value="/decline_article"/>" ></span>	

	<c:if test="${empty listArticles}">
		There are no articles.
	</c:if>
		
	<c:if test="${not empty listArticles}">
	
	<table class="table table-hover">
	<thead>
	<tr>
	<h4>List of Articles</h4>
	</tr>
	</thead>
	<c:forEach var="article" items="${listArticles}" varStatus="status">
 	<tbody>
 		<tr>
 			<td>
					 <dl class="dl-horizontal">
					  <dt>Article ID:</dt>
					  <dd><span id="articleid${status.index}">${article.id}</span></dd>
					  <dt>Title:</dt>
					  <dd>${article.title}</dd>
					  <dt>Abstract:</dt>
					  <dd>${article.articleAbstract}</dd>
					  <dt>Keywords:</dt>
					  <dd>
					  	<c:if test="${empty article.keywordCollection}">
							(No Keywords)
						</c:if>
					  	<c:forEach var="keyW" items="${article.keywordCollection}">
					  		${keyW.keyword},
					  	</c:forEach>
					  </dd>
					  <dt>Total Reviews:</dt>
					  <dd>${article.numberReviewed}</dd>
					  <dt>Status:</dt>
					  <dd>${article.friendlyStatus}</dd>
					</dl>
					
					 <!-- //******// --> 
					<div class="accordion" id="accordion-review-reviews">
					<div class="accordion-group">
						<div class="accordion-heading">
							<a class="accordion-toggle label label-info" data-toggle="collapse"
								data-parent="#accordion-review" href="#collapse${article.id}"> List of Reviews
							</a>
						</div>
						<div id="collapse${article.id}" class="accordion-body collapse" style="height: 0px;">
						
							<!-- display the list of reviews -->
							<div class="accordion-inner">
							
							<c:forEach var="review" items="${article.reviewCollection}"> 
							
							 <dl class="dl-horizontal">
								  <dt>Review ID:</dt>
								  <dd>${review.id}</dd>
								  <dt>Review Date:</dt>
								  <dd>${review.friendlyDate}</dd>
								  <dt>Reviewer:</dt>
								  <dd>${review.reviewer.username}</dd>
								  <dt>Status:</dt>
								  <dd>${review.friendlyStatus}</dd>
								  <dt>Expertise:</dt>
								  <dd>${review.friendlyExpertise}</dd>
								  <dt>Score:</dt>
								  <dd>${review.friendlyScore}</dd>
								  <dt>Summary:</dt>
								  <dd>${review.summary}</dd>
								  <dt>Comments:</dt>
								  <dd>
								  	<c:forEach var="comment" items="${review.commentCollection}">
								  		<dl class="dl-horizontal">
										  <dt>Type:</dt>
										  <dd>${comment.friendlyType}</dd>
										  <dt>Content:</dt>
										  <dd>${comment.comment}</dd>
										  <dt>Response:</dt>
										  <dd>${comment.response.comment}</dd>
										</dl>
										<hr>
								  	</c:forEach>
								  </dd>
								</dl>
								
										
							 	<button type="submit" class="btn btn-danger" >Reject Review</button>
							</c:forEach>
							<hr>
							</div>
							<!-- /*******/ -->
												
						</div>
					</div>
				</div>
					<!-- //******// --> 
				
		<c:if test="${article.status != 5}">
			<button type="submit" class="btn btn-publisharticle btn-success" index-ref="${status.index}">Publish article</button>
			<button type="submit" class="btn btn-rejectarticle btn-danger" index-ref="${status.index}">Reject article</button>
		</c:if>
	</td>
	</tr>
	</tbody>
  	</c:forEach>
	</table>
</c:if>	

