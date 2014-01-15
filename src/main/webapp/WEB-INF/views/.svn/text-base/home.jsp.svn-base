<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body onload='document.f.j_username.focus();'>
<h1>
	Hello world!  jsssffsuxxx
	param.login:
	<c:if test="${not empty param.login}">
		<c:if test="${param.login}">
		aaaaaa
		</c:if>
		<c:if test="${!param.login}">
		nononono
		</c:if>
		
	</c:if>
	
</h1>

<P>  The time on the server is ${serverTime}. ${messages.test1} </P>
  
<sec:authorize access="isAnonymous()">    
 <form name='loginForm' action="j_spring_security_check"
  method='POST'>
  
  <table>
   <tr>
    <td>User:</td>
    <td><input type='text' name='j_username' value=''>
    </td>
   </tr>
   <tr>
    <td>Password:</td>
    <td><input type='password' name='j_password' />
    </td>
   </tr>
   <tr>
    <td colspan='2'>
        <input name="submit" type="submit" value="submit" />
    </td>
   </tr>
  </table>
  </form>
</sec:authorize>

<c:if test="${not empty loginStatus}">
	Status: ${loginStatus}
</c:if>    
  
  <sec:authorize access="isAuthenticated()">
    	<p>Logged in as <a href="#"><sec:authentication property="principal.username"/></a></p>
        <a href="<c:url value="/logout"/>">Logout</a>
    </sec:authorize>
  
</body>
</html>
