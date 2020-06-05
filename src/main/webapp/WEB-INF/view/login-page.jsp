<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>   
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html>

<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Custom Login Page</title>
		<style>
			.failed {
				color:red;
			}
		</style>
	</head>


	<body>
	
		<h2>My Custom Login Page</h2>
		
		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="Post"> 
		
			<!-- if ?error param is present in url then show msg -->
			<c:if test="${param.error !=null}">
				<i class="failed">!Invalid username or password</i>
			</c:if>

			<!-- if ?logout param is present in url then show msg -->
			<c:if test="${param.logout !=null}">
				<i class="failed">!User has been logged out</i>
			</c:if>
			
			
			<p>
				Username: <input type="text" name="username">		<!-- name=".." is default provided by spring security  -->
			</p>													<!-- using this name spring security process the form -->
			
			<p>
				password: <input type="password" name="password">
			</p>
				
			<input type="submit" value="Login">
		
		</form:form>
	</body>
</html>