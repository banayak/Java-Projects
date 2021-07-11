<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<div style="align-content: right; float: right;">
	<B><a href="/demo">Home</a></B>
</div>
<body>
	<h2>Add Employee Data</h2>


	<form:form method="POST" action="/demo/save.html"
		modelAttribute="command">
		<table>
			<tr>
				<td><form:label path="empId">Employee ID:</form:label></td>
				<td><form:input path="empId" value="${employee.empId}"
						readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="firstName">First Name:</form:label></td>
				<td><form:input path="firstName" value="${employee.firstName}" /></td>
			</tr>
			<tr>
				<td><form:label path="lastName">Last Name:</form:label></td>
				<td><form:input path="lastName" value="${employee.lastName}" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Email:</form:label></td>
				<td><form:input path="email" value="${employee.email}" /></td>
			</tr>
			<tr>
				<td><form:label path="phoneNumber">Phone Number:</form:label></td>
				<td><form:input path="phoneNumber"
						value="${employee.phoneNumber}" /></td>
			</tr>
			<tr>
				<td><form:label path="hireDate">Hire Date:</form:label></td>
				<td><form:input path="hireDate" value="${employee.hireDate}" />
					(MM/DD/YYYY)</td>
			</tr>
			<tr>
				<td><form:label path="jobId">Job ID:</form:label></td>
				<td><form:input path="jobId" value="${employee.jobId}" /></td>
			</tr>
			<tr>
				<td><form:label path="salary">Employee Salary:</form:label></td>
				<td><form:input path="salary" value="${employee.salary}" /></td>
			</tr>

			<tr>
				<td><form:label path="commisionPct">Commision PCT:</form:label></td>
				<td><form:input path="commisionPct"
						value="${employee.commisionPct}" /></td>
			</tr>
			<tr>
				<td><form:label path="managerId">Manager ID:</form:label></td>
				<td><form:input path="managerId" value="${employee.managerId}" /></td>
			</tr>
			<tr>
				<td><form:label path="deptId">Dept ID:</form:label></td>
				<td><form:input path="deptId" value="${employee.deptId}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>


		<c:if test="${!empty employees}">
			<h2>List Employees</h2>
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
						<td><c:out value="${employee.empId}" /></td>
						<td><c:out value="${employee.firstName}" /></td>
						<td><c:out value="${employee.lastName}" /></td>
						<td><c:out value="${employee.email}" /></td>
						<td><c:out value="${employee.phoneNumber}" /></td>

						<td><c:out value="${employee.hireDate}" /></td>
						<td><c:out value="${employee.jobId}" /></td>
						<td><c:out value="${employee.salary}" /></td>
						<td><c:out value="${employee.commisionPct}" /></td>
						<td><c:out value="${employee.managerId}" /></td>
						<td><c:out value="${employee.deptId}" /></td>
						<td align="center"><a
							href="/demo/edit.html?empId=${employee.empId}">Edit</a> | <a
							href="/demo/delete.html?empId=${employee.empId}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</form:form>
</body>
</html>