<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- javascript to submit form -->
<script type="text/javascript">
	//submit form
	$(".btn-indicateuser").click(function() {
		
		var postdata = {
				username 		: $("#username"+$(this).attr('index-ref')).text()
			};
		
		function completedJSON(data){
			//success
			alert("ok");
		}
		
		function failJSON(data){
			//fail
			alert(data.args[0]);
		}
		
		$.postJSON($("#spanRef").attr('link-ref'),postdata,completedJSON,failJSON);
		
		return false;
	});
</script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	

<span id="spanRef" style="display:none" link-ref="<c:url value="/indicate"/>" ></span>	

<c:if test="${empty listUsers}">
		No Users found in the database.
	</c:if>
	
	<c:if test="${not empty listUsers}">
		<table class="table">
	    <thead>
	    <tr><td>#</td><td> User name</td><td>Previleges/Roles</td> <td>Action</td></tr>
	     </thead>
		     <tbody> 
		     <c:forEach var="user" items="${listUsers}" varStatus="status">
		     
	    <tr>
	    <td>${user.id}.</td>
	    <td><span id="username${status.index}">${user.username}</span></td>
	    <td>
	    <c:forEach var="role" items="${user.roleCollection}">
			${role.name}, 
		</c:forEach>
	    </td>
	    <td><button type="submit" class="btn btn-primary btn-indicateuser" index-ref="${status.index}">Become Editor</button></td></tr>
	    
    </c:forEach>
    </tbody>
</table>
	</c:if>