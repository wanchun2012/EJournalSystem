<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div id="navbar" class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<div class="container-fluid">
			<a class="btn btn-navbar" data-toggle="collapse"
				data-target=".nav-collapse"> <span class="icon-bar"></span> <span
				class="icon-bar"></span> <span class="icon-bar"></span>
			</a> <a class="brand" href="<c:url value="/"/>"><img
				src="<c:url value="/resources/img/favicon.png"/>" alt="icon" /> <!--  <img src="/images/w3r.png" width="10" height="10" alt="w3resource logo" />--></a>
			<div class="nav-collapse">
				<ul class="nav">
					<sec:authorize access="isAuthenticated()">
						<sec:authentication property="principal.userId" var="userId" />
						<sec:authorize access="hasRole('ROLE_EDITOR')">
							<li><a class="navbar-link"
								href="<c:url value="/editor/${userId}/loadContent?cname=home"/>">Home</a></li>
						</sec:authorize>

						<sec:authorize access="hasRole('ROLE_AUTHOR')">
							<li><a class="navbar-link"
								href="<c:url value="/author/${userId}/loadContent?cname=status"/>">My
									Articles</a></li>
						</sec:authorize>


						<sec:authorize access="hasRole('ROLE_REVIEWER')">
							<li><a class="navbar-link"
								href="<c:url value="/reviewer/${userId}/loadContent?cname=status"/>">My
									Reviews</a></li>
							<li><a class="navbar-link"
								href="<c:url value="/reviewer/${userId}/loadContent?cname=review"/>">Review</a></li>
						</sec:authorize>
					</sec:authorize>
					<sec:authorize access="isAnonymous()">
						<li><a class="navbar-link"
							href="<c:url value="/loadContent?cname=search"/>">Search</a></li>
						<li><a class="navbar-link"
							href="<c:url value="/loadContent?cname=register"/>">Register
						</a></li>
					</sec:authorize>

					<li><a class="navbar-link"
						href="<c:url value="/loadContent?cname=help"/>">Help</a></li>
					<li><a class="navbar-link"
						href="<c:url value="/loadContent?cname=contact"/>">Contact</a></li>

				</ul>
				<form class="navbar-form pull-right">

					<sec:authorize access="isAuthenticated()">
						<div style="margin-top: 14px">
							Logged in as <a class="navbar-link"
								href="<c:url value="/loadContent?cname=search"/>"> <sec:authentication
									property="principal.username" />
							</a>. <a href="<c:url value="/j_spring_security_logout"/>">
								Logout</a>
						</div>
					</sec:authorize>

					<sec:authorize access="isAnonymous()">
						<div style="margin-top: 4px">
							<input id="form_username" class="span2" type="text"
								placeholder="Email" /> <input id="form_password" class="span2"
								type="password" placeholder="Password" />
							<button id="btnLogin" type="submit" class="btn">Sign in</button>
						</div>
					</sec:authorize>
				</form>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</div>