<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div id="submit-next" class="leaderboard">
	<h3>Submit a review</h3>
	<p>How to submit a review guide</p>
	<hr/>
	<div style="margin-top: 10px" class="row-fluid">
		<div class="accordion" id="accordion2">
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion2" href="#collapseOne"> How to
						peer-review pending articles </a>
				</div>
				<div id="collapseOne" class="accordion-body collapse"
					style="height: 0px;">
					<div class="accordion-inner">Clear instructions regarding how to peer-review pending articles</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion2" href="#collapseTwo"> Qualities
						sought </a>
				</div>
				<div id="collapseTwo" class="accordion-body collapse">
					<div class="accordion-inner">Sought qualities description</div>
				</div>
			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
					<a class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion2" href="#collapseFour"> How to
						complete the review form </a>
				</div>
				<div id="collapseFour" class="accordion-body collapse">
					<ul>
						<li>An overall judgement (using the "champion/detractor"
							pattern - see below</li>
						<li>The relevant expertise level of the reviewer (on 3-point
							scale: expert, knowledgeable, outsider)</li>
						<li>A summary of the content and novel contribution of the
							article (as proof that the reviewer has understood it and
							believes in its good points</li>
						<li>A structured criticism of any bad points (issues that the
							authors must explicitly address in their revision). Each
							substantive criticism should be described in a separate section
							of the form, to help editors track authors' responses to the same
							criticisms.</li>
						<li>A detailed list of small errors should be provided for
							the authors (typographical, or grammatical mistakes, etc.)</li>
					</ul>

				</div>

			</div>
			<div class="accordion-group">
				<div class="accordion-heading">
					<sec:authentication property="principal.userId" var="userId" />
					<a id="my-revs" class="accordion-toggle" data-toggle="collapse"
						data-parent="#accordion2" 
						href="<c:url value="/reviewer/${userId}/loadContent?cname=status"/>"> My Reviews</a>
				</div>

			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$("#my-revs").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
</script>
<script type="text/javascript">
	$("#expand-form").click(function() {
		$('html, body').animate({
			scrollTop : $("#submit-paper").offset().top - 50
		}, 500);
	});
</script>
