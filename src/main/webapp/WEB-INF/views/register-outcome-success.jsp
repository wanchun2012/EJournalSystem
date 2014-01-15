<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="leaderboard">
	<h3>Reviewer Registration Successful</h3>
	<p>Please check your email inbox and log in with the username and passowrd you chose</p>
	<hr/>
	<a id="register-success-btn" href="<c:url value='/loadContent?cname=search'/>" 
	style="margin:1px 10px 5px" class="btn btn-warning btn-small">
	</i>Search articles</a>
</div>
<script type="text/javascript">
	$("#register-success-btn").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
</script>