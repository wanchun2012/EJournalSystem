<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="leaderboard">
	<h3>Could not upload the template file:</h3>
	<p>File transmission error</p>

	<a id="set-update-err-back-btn" href="<c:url value='/loadContent?cname=journal-settings'/>"
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