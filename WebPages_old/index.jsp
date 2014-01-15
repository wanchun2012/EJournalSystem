<?xml version="1.0" encoding="US-ASCII" ?>
<%@ page language="java" contentType="text/html; charset=utf-8"	pageEncoding="US-ASCII"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<!--  PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd"> -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="utf-8" />
<title>Academic Journal Variable Name</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


<!-- Le styles -->
<link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css"/>
<link href="<c:url value="/resources/css/fluid-layout.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/css/bootstrap-responsive.css"/>" rel="stylesheet" />
<link href="<c:url value="/resources/css/sticky-footer.css"/>" rel="stylesheet" />
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      
    <![endif]-->
<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>

<!-- Le fav and touch icons -->
<link rel="shortcut icon" href="img/favicon.ico" />
<link rel="apple-touch-icon" href="img/apple-touch-icon.png" />
<link rel="apple-touch-icon" sizes="72x72"
	href="img/apple-touch-icon-72x72.png" />
<link rel="apple-touch-icon" sizes="114x114"
	href="img/apple-touch-icon-114x114.png" />
</head>
<body>

	<%@ include file="navbar.jsp"%>
	<br />
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span3">
				<%@ include file="sidebar.jsp"%>
				<!--/.well -->
			</div>
			<!--/span-->
			<div class="span8" id="main-content">
			<span id="contentRef" style="display:none" 
			home-ref="<c:url value="/loadContent?cname=home" />"
			></span>
				
				<hr/>
			</div>
		</div>
	</div>


	<!-- Le javascript
   		Placed at the end of the document so the pages load faster -->
	<%@ include file="includeJS.jsp" %>

</body>
</html>
	