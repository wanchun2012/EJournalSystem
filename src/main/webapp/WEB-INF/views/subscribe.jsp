<div class="leaderboard">
	<h3>Subscribe to the journal</h3>
	<p>Subscribe for the next editions or specify some keywords</p>
	<hr />
	<div class="accordion" id="accordion">
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#accordion" href="#collapseOne"> Subscribe by
					keywords </a>
			</div>
			<div id="collapseOne" class="accordion-body collapse"
				style="height: 0px;">
				<div class="accordion-inner">
					<form method="get" class="well form-postjson"
						link-ref="subscribe/keyword">
						<input name="keyword" id="keyword" type="text"
							class="input-xxlarge search-query" placeholder="Keywords" />
						<br><br> 
						<input name="email" id="email" type="email"
							class="input-xxlarge search-query" placeholder="Email address" />

						<br><br>
						<button type="submit" class="btn btn-primary">Subscribe</button>
					</form>
				</div>
			</div>
		</div>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#accordion" href="#collapseTwo"> Subscribe to all
					future editions </a>
			</div>
			<div id="collapseTwo" class="accordion-body collapse"
				style="height: 0px;">
				<div class="accordion-inner">
					<form class="well form-postjson" link-ref="subscribe/edition">
						<input name="email" type="email" class="input-xxlarge search-query"
							placeholder="Email address" />
							<br><br>
						<button type="submit" class="btn btn-primary">Subscribe</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

<!-- javascript for text form search -->
<script type="text/javascript">
	$(".form-postjson").submit(function() {
		var form = $(this).serializeObject();
		$.postJSON($(this).attr('link-ref'), form, null);
		return false;
	});
</script>


