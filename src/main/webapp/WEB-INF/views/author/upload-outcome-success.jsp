<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="leaderboard">
	<h3>Answers Submitted Successfully</h3>
	<p>Your answers to reviewes comments were uploaded correctly.</p>
	<p>Please upload the new revision of the article </p>
	<hr/><!-- 
	<a id="upload-success-btn" href="<c:url value='/loadContent?cname=search'/>" 
	style="margin:1px 10px 5px" class="btn btn-warning btn-small">
	</i>Search articles</a> -->
</div>
<script type="text/javascript">
	$("#upload-success-btn").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
</script>