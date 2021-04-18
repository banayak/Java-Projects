<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	<form:form id="xyx" method="post" action="searchEmployee" modelAttribute="login">
		<c:choose>
			<c:when test="${empty userDetails}">
				<p>There are no users in system yet.</p>
			</c:when>
			<c:otherwise>
				<div
					style="height: 500px; width: 1905px;overflow-x: auto;overflow-y: auto; white-space: nowrap; font-size: 1em; color: #1572c1; font-family: Verdana, Arial, Sans-Serif; text-align: center;">
					<table border="1" cellpadding="10">
						<tr>
							<td>Sl.No</td>
							<td>Employee ID</td>
							<td>First Name</td>
							<td>Last Name</td>
							<td>Email</td>
							<td>Phone Number</td>
							<td>Job Id</td>
							<td>Salary</td>
						</tr>
						<c:forEach items="${userDetails}" var="user" varStatus="status">
							<tr valign="top">
								<td>${status.index}</td>
								<td>${user.employeeId}</td>
								<td>${user.firstName}</td>
								<td>${user.lastName}</td>
								<td>${user.email}</td>
								<td>${user.phoneNumber}</td>
								<td>${user.jobId}</td>
								<td>${user.salary}</td>
							</tr>
						</c:forEach>
					</table>
				</div>
				<div style="left: 321px; position: absolute;">
					<table border="0" cellpadding="10">
						<tr>
							<td colspan="8">
								<input type=submit value="BACK" name="cancel">
							</td>
						</tr>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</form:form>
</body>
</html>