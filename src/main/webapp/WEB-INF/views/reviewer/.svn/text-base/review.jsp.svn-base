<script type="text/javascript">
	//submit form
	
	function downloadURL(url) {
    	var hiddenIFrameID = 'hiddenDownloader',
    	    iframe = document.getElementById(hiddenIFrameID);
    	if (iframe === null) {
    	    iframe = document.createElement('iframe');
    	    iframe.id = hiddenIFrameID;
       		iframe.style.display = 'none';
        	document.body.appendChild(iframe);
    	}
    	iframe.src = url;
    };
    var artIds;
    $("#btnRevDownArt").click(function(){
 
    	var checkedValues = $('input[name=checkboxlist]:checked').map(function() {
			 return $(this).parent().text();
		}).get();

    	if (checkedValues.length > 3) {
			alert("Yoy are not allowed to download more than 3 papers. Please select only 3 papers");
	  	} else {
	  		artIds = {
	  				articleIds : [],
	  		};
	  		for(var i =0; i< checkedValues.length; i++) {
	  			artIds.articleIds.push(checkedValues[i].trim());
	  		}
	  		
	  		function failJSON(data){
				$("#main-content").load($('#contentRef').attr('base-ref')+"articlereviewselect-fail-json", function(){
					alert(data.args[0]);
					$("#error-data").text(data.args[0]);
				});
			}
			
			function completedJSON(data){
				for(var i =0; i< artIds.articleIds.length; i++) {
					window.open(
						$("#art-url-ref-span"+artIds.articleIds[i]).attr("art-url-ref").replace(/\+/g,"%20"),
						'_blank' // <- This is what makes it open in a new window.
					);
				};
				$("#main-content").load($('#contentRef').attr('base-ref')+"status");
			}

			$.postJSON($('#postRef').attr('link-ref'), artIds, completedJSON, failJSON);
	  	}
    	return false;
    });
</script>


<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<span id="postRef" style="display: none" link-ref="<c:url value="/download_reviews"/>"></span>
<form id="download-reviews" class="form-horizontal">

	<div class="leaderboard">
		<h3>Articles to review</h3>
		<c:if test="${user.numberReviewAvailable > 0}">
			<p>By downloading the article the reviewer accepts the Terms and Conditions</p>
		</c:if>
		<c:if test="${user.numberReviewAvailable <= 0}">
			<p>You have already downloaded 3 articles</p>
		</c:if>
		<hr />
		<table class="table">
			

			<c:if test="${empty listArticles}">
				<p>No results found.</p>
			</c:if>
			<c:if test="${not empty listArticles}">
			<thead>
				<tr>
					<td>ID</td>
					<td>Title</td>
					<td>Details</td>
					<td>Main Author's Email</td>
					<td>Date</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${listArticles}">
					<tr>
						<c:if test="${user.numberReviewAvailable > 0}">
						<td><div class="control-group">
								<div class="controls span2">
									<label class="checkbox"> <input type="checkbox"
										name="checkboxlist" value="${article.id}"
										id="inlineCheckbox${article.id}">${article.id}
									</label>
								</div>
							</div></td>
						</c:if>
						<c:if test="${user.numberReviewAvailable <= 0}">
						<td>${article.id}</td>
						</c:if>
						<td>${article.title}</td>
						<td><a href="#myModal${article.id}" role="button" class="btn"
							data-toggle="modal">Show</a></td>
						<td>${article.author.username}</td>
						<td>${article.whenUpdated} </td>
						<td style="visibility: hidden;"><span id="art-url-ref-span${article.id}" 
							style="display: none" art-url-ref="<c:url value="/${article.lastVersion.filePath}"/>"></span>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</c:if> 
		</table>
	</div>
</form>
<c:if test="${user.numberReviewAvailable > 0}">
	<div class="form-actions">
		<button id="btnRevDownArt" class="btn btn-primary">Download</button>
	</div>
</c:if>
<c:forEach var="article" items="${listArticles}">
	<!-- Modal -->
	<div id="myModal${article.id}" class="modal hide fade" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal"
				aria-hidden="true">×</button>
			<h3 id="myModalLabel">Title: <br>${article.title}</h3>
		</div>
		<div class="modal-body">	
			<div class="leaderboard">
				<p>Abstract: <br>${article.articleAbstract}</p>
				<ul>
					<c:forEach var="keyword" items="${article.keywordCollection}">
						<li>${keyword.keyword}</li>
					</c:forEach>
				</ul>
				<ul>
					<c:forEach var="keyword" items="{article.authors}">
						<li>${article.author.username}</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<div class="modal-footer">
			<button class="btn" data-dismiss="modal" aria-hidden="true">Back</button>
		</div>
	</div>
</c:forEach>
