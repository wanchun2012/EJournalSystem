<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="leaderboard">
	<h3>Could not submit the review:</h3>
	<p>JSON transmission error</p>
	<sec:authentication property="principal.userId" var="userId" />
	<a id="subrev-err-back-btn"
		href="<c:url value='/reviewer/${userId}/loadContent?cname=submit-review'/>"
		style="margin: 1px 10px 5px" class="btn btn-warning btn-small"> <i
		class="icon-white icon-folder-open "></i>TRY AGAIN
	</a>
</div>

<script type="text/javascript">
	$("#subrev-err-back-btn").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
</script>