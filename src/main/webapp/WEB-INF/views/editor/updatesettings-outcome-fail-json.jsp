<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="leaderboard">
	<h3>Could not update the settings:</h3>
	<p>JSON transmission error</p>
	<sec:authentication property="principal.userId" var="userId" />
	<a id="set-update-err-back-btn"
		href="<c:url value='/editor/${userId}/loadContent?cname=journal-settings'/>"
		style="margin: 1px 10px 5px" class="btn btn-warning btn-small"> <i
		class="icon-white icon-folder-open "></i>TRY AGAIN
	</a>
</div>

<script type="text/javascript">
	$("#set-update-err-back-btn").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
</script>