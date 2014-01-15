<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:if test="${!ajaxRequest}">
<html>
<head>
	<title>fileupload | mvc-showcase</title>
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet" type="text/css" />	<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>	
</head>
<body>
</c:if>
	

	<div id="fileuploadContent">
		<h2>File Upload</h2>
		     
		   <form:form action="upload" modelAttribute="uploadItem" method="post" enctype="multipart/form-data">
            <fieldset>
                <legend> <code>Upload Fields </code></legend>
 
                <p>
                    <form:label for="name" path="name">Name</form:label><br/>
                    <form:input path="name"/>
                </p>
 
                <p>
                    <form:label for="fileData" path="fileData">File</form:label><br/>
                    <form:input path="fileData" type="file"/>
                </p>
 
                <p>
                    <input type="submit" />
                </p>
 
            </fieldset>
        </form:form>
        
        		   <form:form action="upload" modelAttribute="uploadItem" method="post" enctype="multipart/form-data">
            <fieldset>
                <p>
                    <form:label for="fileData" path="fileData">File</form:label><br/>
                    <form:input path="fileData" type="file"/>
                </p>
 
                <p>
                    <input type="submit" />
                </p>
 
            </fieldset>
        </form:form>
        
        <c:if test="${not empty message}">
			<div id="message" class="success">${message}</div>	  		
  		</c:if>

		<!-- form id="fileuploadForm" action="upload" method="POST" enctype="multipart/form-data" class="cleanform">
			<div class="header">
		  		<h2>Form</h2>
		  		<c:if test="${not empty message}">
					<div id="message" class="success">${message}</div>	  		
		  		</c:if>
			</div>
			<label for="file">File</label>
			<input id="file" type="file" name="file" />
			<p><button type="submit">Upload</button></p>		
		</form-->
		
		<!--  script type="text/javascript">
			$(document).ready(function() {
				$('<input type="hidden" name="ajaxUpload" value="true" />').insertAfter($("#file"));
				$("#fileuploadForm").ajaxForm({ success: function(html) {
						$("#fileuploadContent").replaceWith(html);
					}
				});
			});
		</script -->	
	</div>
<c:if test="${!ajaxRequest}">
</body>
</html>
</c:if>