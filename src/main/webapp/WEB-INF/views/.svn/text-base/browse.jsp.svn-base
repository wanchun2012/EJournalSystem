<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='fn' uri='http://java.sun.com/jsp/jstl/functions' %>
<%@ taglib prefix="sec"	uri="http://www.springframework.org/security/tags"%>
<div class="leaderboard">
	<h3>Journal Name</h3>
	<p>Click on article's title to see the details</p>
	<hr/>
	<c:if test="${empty listArticles}">
		No results found.
	</c:if>
	<c:if test="${not empty listArticles}">
		<table class="table">
			<thead>
				<tr>
					<td>#</td>
					<td>Title</td>
					<td>Date</td>
					<td>Contact editor</td>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="article" items="${listArticles}" varStatus="status">
					<tr>
						<td>${article.id}</td>
						<td><a onclick="showModal('#modalDetails${article.id}')">${article.title}</a></td>
						<td>${article.friendlyDate}</td>
						<td>
						<a id="contact-editor" onclick="sendMail('${article.id}','ecommteamo@gmail.com')" style="margin: 1px 10px 5px" class="btn btn-warning btn-small">Contact editor</a>
						</td>
					</tr>
					<!-- article details modal -->
					<!-- Modal -->
					<div id="modalDetails${article.id}" class="modal hide fade" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h3 id="myModalLabel">Article ${article.id} details</h3>
						</div>
						<div class="modal-body">
							<div class="leaderboard" id="server-response">
							<p>Title: ${article.title}</p>

							<p>Abstract: ${article.articleAbstract}</p>
							<p>${fn:length(article.keywordCollection)} Keywords: </p>
							<ul>
							<c:forEach var="keyword" items="${article.keywordCollection}">
								<li>${keyword.keyword} </li>
							</c:forEach>
							</ul>
							<p>Number of authors: ${fn:length(article.contactCollection)}</p>
							<p>Main author's contact: ${article.author.username}</p>
							<p>Date of last version: ${article.friendlyDate}</p>
							<span id="art-url-ref-span${article.id}" 
							style="display: none" art-url-ref="<c:url value="/${article.lastVersion.filePath}"/>"></span>
							</div>
						</div>
						<div class="modal-footer">
							<button onclick="downloadArticle('${article.id}')" class="btn btn-primary">Download</button>
							<button class="btn" data-dismiss="modal" aria-hidden="true">Back</button>
						</div>
					</div>
					<!-- end.Modal -->
				</c:forEach>
			</tbody>
		</table>
	</c:if>
</div>

<script type="text/javascript">



downloadArticle = function(artId){
	window.open(
	
		$("#art-url-ref-span"+artId).attr("art-url-ref").replace(/\+/g,"%20"),
		'_blank' // <- This is what makes it open in a new window.
		);
}

sendMail = function(artId,username){
    $(location).attr('href', 'mailto:ecommteamo@gmail.com?subject='
                             + encodeURIComponent("Reader Question ArticleId: "+artId)
                             + "&body=" 
                             + encodeURIComponent("Dear Editor, \n I have a question about the article "+artId
                             + "\n-------------------"
                             + "\nQUESTION BODY"
                             + "\n-------------------"
                             + "\nPlease send your answer at : "+ username
                             + "\nThank you")
    );
};

function showModal(details){
	$(details).modal();
};
</script>
