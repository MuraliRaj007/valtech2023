  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee List</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<h2>Employee Database</h2>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Employees</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Employees</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New Employee</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Age</th>
						<th>Salary</th>
						<th>Experience</th>
						<th>Seniority</th>
						<th>DeptID</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${empList}">

						<tr>
							<td><c:out value="${emp.id}" /></td>
							<td><c:out value="${emp.name}" /></td>
							<td><c:out value="${emp.age}" /></td>
							<td><c:out value="${emp.salary}" /></td>
							<td><c:out value="${emp.experience}" /></td>
							<td><c:out value="${emp.senoirity}" /></td>
							<td><c:out value="${emp.deptid}" /></td>
							<td><a href="edit?id=<c:out value="${emp.id}" />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?id=<c:out value="${emp.id}" />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="view?id=<c:out value="${emp.id}" />">View</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>