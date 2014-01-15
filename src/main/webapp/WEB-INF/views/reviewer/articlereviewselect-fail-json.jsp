<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="leaderboard">
	<h3>Could not select article(s):</h3>
	<p> Transmission error </p>
	<div id="error-data">:
	</div>
	<hr/>
	<a id="article-review-select-err-back-btn" href="<c:url value='/loadContent?cname=review'/>" 
	style="margin:1px 10px 5px" class="btn btn-warning btn-small">
	<i class="icon-white icon-folder-open "></i>TRY AGAIN</a>
</div>
<script type="text/javascript">
	$("#article-review-select-err-back-btn").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
</script>