<?xml version="1.0" encoding="US-ASCII" ?>
<%@ page session="false" language="java"
	contentType="text/html; charset=utf-8" pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<!DOCTYPE html>
<!--  PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<title>${journalSettings.title}</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


<!-- Le styles -->
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/datepicker.css"/>"
	rel="stylesheet" type="text/css" />
	<link href="<c:url value="/resources/css/tagify-style.css"/>"
	rel="stylesheet" type="text/css" />
<link href="<c:url value="/resources/css/fluid-layout.css"/>"
	rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap-responsive.css"/>"
	rel="stylesheet" />
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      
    <![endif]-->
<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="img/favicon.ico" />

</head>
<body>

	<%@ include file="../navbar.jsp"%>
	<br />
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<%@ include file="../sidebar.jsp"%>
				
				<!--/.well -->
			</div>
			<!--/span-->
<span id="contentRef" style="display: none"
				 base-ref="<c:url value="/editor/${editorName}/loadContent?cname="/>"
					home-ref="home" ></span>
			<div class="span7" id="main-content">
				
				<hr />
				<div class="span3" id="alerts">
					<!-- Alerts -->
					<div class="alert alert-success fade onbottom">
						<h4 class="alert-heading">Saved!</h4>
					</div>

					<div class="alert alert-error fade onbottom">
						<h4 class="alert-heading">Error!</h4>
					</div>

					<div class="alert alert-info fade onbottom">
						<h4 class="alert-heading">Status</h4>
					</div>

					<div class="alert alert-warning fade onbottom">
						<h4 class="alert-heading">Processing request...</h4>
						<p></p>
						<img id="loading-indicator"
							src="<c:url value='/resources/img/ajax-loader.gif' />"
							alt='loading...' />
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-- Le javascript
   		Placed at the end of the document so the pages load faster -->
	<%@ include file="../includeJS.jsp"%>

</body>
</html>
