<%@page import="com.valtech.springemployeemanagement.models.EmployeeModel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%EmployeeModel employee = (EmployeeModel) request.getAttribute("employee"); %>
<form method="post" action="save?id=<%= employee.getId()%>">
	<table>
		<tr>
			<td>Employee_ID</td>
			<td><input type="text" disabled="disabled" name="id" value="<%= employee.getId()%>"/></td>
		</tr>
		<tr>
			<td>Employee_Name</td>
			<td><input type="text" name="name" value="<%= employee.getName()%>"/></td>
		</tr>
		<tr>
			<td>Age</td>
			<td><input type="text" name="age" value="<%= employee.getAge()%>"/></td>
		</tr>
		<tr>
			<td>Experience</td>
			<td><input type="text" name="experience" value="<%= employee.getExperience()%>"/></td>
		</tr>
		<tr>
			<td>Seniority</td>
			<td><input type="text" name="seniority" value="<%= employee.getSeniority()%>"/></td>
		</tr>
		<tr>
			<td>Salary</td>
			<td><input type="text" name="salary" value="<%= employee.getSalary()%>"/></td>
		</tr>
		<tr>
			<td>Department_ID</td>
			<td><input type="text" name="department" value="<%= employee.getDepartment().getId()%>"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="submit" value="Create"/>
				<input type="submit" name ="cancel" value="Cancel"/>
			</td>
		</tr>
	</table>
</form>
</body>
</html>