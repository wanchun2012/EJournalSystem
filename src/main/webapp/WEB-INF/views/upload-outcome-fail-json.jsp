<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="leaderboard">
	<h3>Could not upload the article:</h3>
	<p> Article transmission error </p>
	<div id="error-data">:
	</div>
	<hr/>
	<a id="upload-err-back-btn" href="<c:url value='/loadContent?cname=submit-guide'/>" 
	style="margin:1px 10px 5px" class="btn btn-warning btn-small">
	<i class="icon-white icon-folder-open "></i>TRY AGAIN</a>
</div>
<script type="text/javascript">
	$("#upload-err-back-btn").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
</script>