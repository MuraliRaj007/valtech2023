<%@page
	import="com.valtech.springemployeemanagement.models.DepartmentModel"%>
<%@page
	import="com.valtech.springemployeemanagement.models.EmployeeModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Departments</title>
</head>
<body>
	<h1>Department</h1>
	<%
	List<EmployeeModel> employees = (List<EmployeeModel>) request.getAttribute("employees");
	%>
	<%
	List<DepartmentModel> departments = (List<DepartmentModel>) request.getAttribute("departments");
	/* DepartmentModel departmentModel = (DepartmentModel) request.getAttribute("department"); */
	/* 	request.setAttribute("current", departmentModel.getId()); */
	%>
	<table>
		<tr>
			<th>Department_ID</th>
			<th>Department_Name</th>
			<th>Department_Location</th>
		</tr>
		<%
		for (DepartmentModel department : departments) {
			request.setAttribute("department", department);
		%>
		<tr>
			<td>${department.id}</td>
			<td>${department.name}</td>
			<td>${department.location}</td>
		</tr>

		<%
		}
		%>
		<tr>
			<td colspan="2">
				<form action="list" method="post">
					<input type="submit" name="submit" value="First" /> <input
						type="submit" name="submit" value="Previous" /> <input
						type="submit" name="submit" value="Next" /> <input type="submit"
						name="submit" value="Last" />
				</form>
			</td>
		</tr>
	</table>
	<h1>List of Employees</h1>
	<table>
		<tr>
			<th>Employee_ID</th>
			<th>Employee_Name</th>
			<th>Age</th>
			<th>Experience</th>
			<th>Seniority</th>
			<th>Salary</th>
			<th>Department_ID</th>
			<th>Actions</th>
		</tr>
		<%
		for (EmployeeModel employee : employees) {
			request.setAttribute("employee", employee);
		%>
		<tr>
			<td>${employee.id}</td>
			<td>${employee.name}</td>
			<td>${employee.age}</td>
			<td>${employee.experience}</td>
			<td>${employee.seniority}</td>
			<td>${employee.salary}</td>
			<td>${employee.department.id}</td>
			<td><a href="delete?id=${employee.id}">Delete</a> <a
				href="edit?id=${employee.id}">Edit</a></td>
		</tr>
		<%
		}
		%>
		<tfoot>
			<tr>
				<td colspan="5" align="right">
					<form method="get" action="new">
						<input type="submit" name="submit" value="Add New Employee" />
					</form>
				</td>
			</tr>
		</tfoot>
	</table>
</body>
</html>