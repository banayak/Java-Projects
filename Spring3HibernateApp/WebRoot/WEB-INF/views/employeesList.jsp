<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Employees</title>
</head>
<body>
<div style="align-content: right; float: right;">
	<B><a href="/demo">Home</a></B>
</div>
<h1>List Employees</h1>
<h3><a href="add.html">Add More Employee</a></h3>

<c:if test="${!empty employees}">
	<table align="left" border="1">
		<tr>
			<th>Employee ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>EMAIL</th>
			<th>PHONE_NUMBER</th>
			<th>HIRE_DATE (MM/DD/YYYY)</th>
			
			<th>JOB_ID</th>
			<th>SALARY</th>
			<th>COMMISSION_PCT</th>
			<th>MANAGER_ID</th>
			<th>DEPARTMENT_ID</th>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td><c:out value="${employee.empId}"/></td>
				<td><c:out value="${employee.firstName}"/></td>
				<td><c:out value="${employee.lastName}"/></td>
				<td><c:out value="${employee.email}"/></td>
				<td><c:out value="${employee.phoneNumber}"/></td>
				
				<td><c:out value="${employee.hireDate}"/></td>
				<td><c:out value="${employee.jobId}"/></td>
				<td><c:out value="${employee.salary}"/></td>
				<td><c:out value="${employee.commisionPct}"/></td>
				<td><c:out value="${employee.managerId}"/></td>
				<td><c:out value="${employee.deptId}"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>