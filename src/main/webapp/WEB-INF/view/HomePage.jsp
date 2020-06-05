<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>

<html>
	
	<head>
		<meta charset="ISO-8859-1">
		<title>Home</title>
	</head>

	<body>
		<h2>Hello user</h2>
		
		<hr>
			<p>
				User:<security:authentication property="principal.username"/>
			</p>
			
			<p>
				Role(s):<security:authentication property="principal.authorities"/>
			</p>
		<hr>
	
		<p>Spring security coming soon</p>
	</body>
	
	<!-- Display this content to manager only (i.e ROLE_Manager) -->
	<security:authorize access="hasRole('Manager')">
		<!-- Add a link to point to /leaders ... this is for the managers  -->
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership Meeting</a>(only for manager)
		</p>	
	</security:authorize>
		
	<!-- Display this content to admin only -->	
	<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link to point to /system ... this is for the Admin  -->
		<p>
			<a href="${pageContext.request.contextPath}/admin">Admin Meeting</a>(only for admin)
		</p>
	</security:authorize>	
	

	
	<!-- for logout we need form and navigate form to "/logout" Url which is handle
			by spring security filter  -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="logout">
	</form:form>

</html>