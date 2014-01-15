<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="leaderboard">
	<span id="search-ref-vars" style="display: none" 
	search-ref-vars="<c:url value="/search"/>"></span>

	<h3>Search for articles</h3>
	<p>Search articles specifying title, author, keywords or search by
		date interval</p>
	<hr />

	<div class="accordion" id="accordion2">
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#accordion2" href="#collapseOne"> Search by Text </a>
			</div>
			<div id="collapseOne" class="accordion-body collapse"
				style="height: 0px;">
				<div class="accordion-inner">
					<div class="leaderboard">
						<h3>Academic Journal</h3>
						<form method="get" id="search-paper-text" class="well form-search">
							<div class="controls">
								<select class="input-xxlarge" id="text-search-type"
									name="text-search-type">
									<option value="title">Title or fragment</option>
									<option value="author">Author(s) name(s)</option>
									<option value="keyword">Tag Keywords</option>
								</select>
							</div>
							<br> <input id="txtToSearch" name="txtToSerach" type="text"
								class="input-xxlarge search-query" /> <br>
							<br>
							<button id="btnTextSearch" type="submit" class="btn btn-primary">Search</button>
						</form>

					</div>
				</div>
			</div>
		</div>
		<div class="accordion-group">
			<div class="accordion-heading">
				<a class="accordion-toggle" data-toggle="collapse"
					data-parent="#accordion2" href="#collapseTwo"> Search by Date </a>
			</div>
			<div id="collapseTwo" class="accordion-body collapse">
				<div class="accordion-inner">

					<form method="get" id="search-paper-date" class="well form-search">
						<div class="input-append date" id="dp1" data-date="12-02-2013"
							data-date-format="dd-mm-yyyy">
							<input name="dateStart" placeholder="start date" class="span7"
								type="text" id="date-start" /> <span class="add-on"><i
								class="icon-th"></i></span>

						</div>
						<div class="input-append date" id="dp1" data-date="12-02-2013"
							data-date-format="dd-mm-yyyy">
							<input name="dateEnd" placeholder="end date" class="span7"
								type="text" id="date-end" /> <span class="add-on"><i
								class="icon-th"></i></span>
						</div>
						<button id="btnDateSearch" type="submit" class="btn btn-primary">Search</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
	$("#art-detail-btn").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
</script>


<script type="text/javascript">
	$(".loadContentBtn").click(function() {
		$("#main-content").load(this.href);
		return false;
	});
</script>


<!-- js datepickers -->
<script>
	$(function() {
		var startDate = new Date(2012, 1, 20);
		var endDate = new Date(2012, 1, 25);
		$('#date-start').datepicker().on(
				'changeDate',
				function(ev) {
					if (ev.date.valueOf() > endDate.valueOf()) {
						$('#alert').show().find('strong').text(
								'The start date must be before the end date.');
					} else {
						$('#alert').hide();
						startDate = new Date(ev.date);
						$('#date-start-display').text(
								$('#date-start').data('date'));
					}
					$('#date-start').datepicker('hide');
				});
		$('#date-end').datepicker().on('changeDate', function(ev) {
			if (ev.date.valueOf() < startDate.valueOf()) {
				//alert('The end date must be after the start date.');
			} else {
				endDate = new Date(ev.date);
				$('#date-end-display').text($('#date-end').data('date'));
			}
			$('#date-end').datepicker('hide');
		});

	});
</script>


<!-- javascript for text form search -->
<script type="text/javascript">
	$("#search-paper-text").submit(
			function() {
				url  = $("#search-ref-vars").attr('search-ref-vars');
				form = "txtToSearch=" + $("#txtToSearch").val() + "&radio="
						+ $("#text-search-type").val();

				$.ajax({
					type : "GET",
					url : url,
					data : form,

					success : function(data) {
						$("#main-content").html(data);
					},
					error : function() {

					}
				});
				return false;
			});
</script>


<!-- javascript for date form search -->
<script type="text/javascript">
	$("#search-paper-date").submit(function() {
		var form = $(this).serialize();

		//alert(form);
		$.ajax({
			type : "GET",
			url : "search",
			data : form,

			success : function(data) {
				$("#main-content").html(data);
			},
			error : function() {

			}
		});
		return false;
	});
</script>
