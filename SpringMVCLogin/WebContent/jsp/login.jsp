
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	
	<c:if test="${empty message}">
			<p><font color="red">${message}</font></p>
	</c:if>
		
	<form:form id="loginForm" method="post" action="searchEmployee"	modelAttribute="searchBean">
		<div
			style="height: 900px; width: 1905px; font-size: 1em; color: #1572c1; font-family: Verdana, Arial, Sans-Serif; text-align: left: ;">
			
			<table border="1" cellpadding="1">

				<form:label path="employeeId">Enter Employee Id</form:label>
				<form:input path="employeeId" />
				<br>
				<form:label path="firstName">Please enter your First Name</form:label>
				<form:input  path="firstName"/>
				<br>
				<input type="submit" name="Search" value="Search"/>
			</table>
		</div>
	</form:form>
</body>
</html>