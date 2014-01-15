<div id="navbar" class="navbar navbar-fixed-top">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".nav-collapse"> <span class="icon-bar"></span> <span
					class="icon-bar"></span> <span class="icon-bar"></span>
				</a> <a class="brand" href="home.jsp"><img src="img/favicon.png" alt="icon" />
					<!--  <img src="/images/w3r.png" width="10" height="10" alt="w3resource logo" />--></a>
				<div class="nav-collapse">
					<ul class="nav">
						<li><a href="<c:url value="/loadContent?cname=search"/>">Home</a></li>
						<li><a href="<c:url value="/loadContent?cname=help"/>">Help</a></li>
						<li><a href="<c:url value="/loadContent?cname=contact"/>">Contact</a></li>
					</ul>
					<form class="navbar-form pull-right">
						<input class="span2" type="text" placeholder="Email" /> <input
							class="span2" type="password" placeholder="Password" />
						<button type="submit" class="btn">Sign in</button>
					</form>
				</div>
				<!--/.nav-collapse -->
			</div>
		</div>
	</div>