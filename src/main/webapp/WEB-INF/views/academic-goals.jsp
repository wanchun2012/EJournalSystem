<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="leaderboard">
	<h3>Journal Name ${journalSettings.title}</h3>
	<hr/>
	<p>Goals:</p>
	<ul>
		<li>
			  ${journalSettings.academicGoals}
		</li>
		 
	</ul>

	<p>The journal publishes early results/fully mature work ${journalSettings.publishRules}</p>
	
	<a id="sub-guide" href="<c:url value='/loadContent?cname=submit-guide'/>"
		 class="btn btn-warning btn-small"> Submission Guide </a>

<script type="text/javascript">
$("#sub-guide").click(function() {
	$("#main-content").load(this.href);
	return false;
});</script>
</div>

