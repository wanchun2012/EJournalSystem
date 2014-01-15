<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<div id="sidebar" class="well sidebar-nav">
	<ul class="nav nav-list">
		<li class="nav-header">Menu</li>
		<sec:authorize access="isAuthenticated()">
		<sec:authentication property="principal.userId" var="userId" /> 
		</sec:authorize>
			<sec:authorize access="hasRole('ROLE_EDITOR')">
		<li><a class="sidebar-link" href="<c:url value="/editor/${userId}/loadContent?cname=home"/>">Home</a></li>
		</sec:authorize>
		<li><a class="sidebar-link" href="<c:url value='/loadContent?cname=search'/>">Search Article</a></li>
		<li><a class="sidebar-link" href="<c:url value='/loadContent?cname=browse'/>">Browse eJournal</a></li>
		<sec:authorize access="!hasRole('ROLE_EDITOR')">
			<li><a class="sidebar-link" href="<c:url value='/loadContent?cname=subscribe'/>">Mailing List Subscription</a></li>
			<li><a class="sidebar-link" href="<c:url value='/loadContent?cname=academic-goals'/>">Academic Goals</a></li>
			<li><a class="sidebar-link" href="<c:url value='/loadContent?cname=submit-guide'/>">Submit Article</a></li>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">

			<sec:authorize access="hasRole('ROLE_REVIEWER')">
		
				<li><a class="sidebar-link" href="<c:url value='/reviewer/${userId}/loadContent?cname=review'/>">Choose Articles to Review </a></li>
				<li><a class="sidebar-link" href="<c:url value='/reviewer/${userId}/loadContent?cname=submit-review'/>">Review Guide</a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_AUTHOR')">
				<li><a class="sidebar-link"  href="<c:url value="/author/${userId}/loadContent?cname=status"/>">My Articles</a></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ROLE_EDITOR')">
				<li><a class="sidebar-link"  href="<c:url value="/editor/${userId}/loadContent?cname=journal-settings"/>">Journal Settings</a></li>		
				<li><a class="sidebar-link"  href="<c:url value="/editor/${userId}/loadContent?cname=add-editor-form"/>">Add Editor</a></li>
				<li><a class="sidebar-link"  href="<c:url value="/editor/${userId}/loadContent?cname=retire"/>">Retire</a></li>
				<li><a class="sidebar-link"  href="<c:url value="/editor/${userId}/loadContent?cname=userslit"/>">Indicate Editor</a></li>
			</sec:authorize>
			
		</sec:authorize>
		<sec:authorize access="isAnonymous()">
				<li><a class="sidebar-link"  href="<c:url value="/loadContent?cname=register"/>">Register as a Reviewer</a></li>
		</sec:authorize>
	</ul>
</div>

