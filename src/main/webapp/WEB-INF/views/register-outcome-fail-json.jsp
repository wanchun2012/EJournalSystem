<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="leaderboard">
	<h3>Review registration:</h3>
	<p> There was a problem and we could not register you as a reviewer. </p>
	<p> Please try again. </p>
	
	<div id="error-data">:
	</div>
	<hr/>
	<a id="register-err-back-btn" href="<c:url value='/loadContent?cname=register'/>" 
	style="margin:1px 10px 5px" class="btn btn-warning btn-small">
	<i class="icon-white icon-folder-open "></i>TRY AGAIN</a>
</div>
<script type="text/javascript">
	$("#register-err-back-btn").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
</script>