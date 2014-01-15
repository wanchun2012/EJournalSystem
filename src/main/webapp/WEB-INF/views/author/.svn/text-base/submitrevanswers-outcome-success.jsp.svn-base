<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="leaderboard">
	<h3>Article Uploaded Successfully</h3>
	<p>Your article was uploaded correctly, an email has been sent to the main author</p>
	<p>In the mean time why don't you search for interesting articles?? </p>
	<hr/>
	<a id="upload-success-btn" href="<c:url value='/loadContent?cname=search'/>" 
	style="margin:1px 10px 5px" class="btn btn-warning btn-small">
	</i>Search articles</a>
</div>
<script type="text/javascript">
	$("#upload-success-btn").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
</script>