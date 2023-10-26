<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee Details</title>
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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">

				<form action="list" method="post">

					<table class="form-group">
						<tr>
							<td><label>Employee ID</label></td>
							<td><input type="number"
								value="<c:out value='${emp.id}' />" class="form-control"
								name="id" required="required" readonly /></td>
						</tr>

						<tr>
							<td><label>Employee Name</label></td>
							<td><input type="text" value="<c:out value='${emp.name}' />"
								class="form-control" name="name" required="required" readonly /></td>
						</tr>

						<tr>
							<td><label>Age</label></td>
							<td><input type="number"
								value="<c:out value='${emp.age}' />" class="form-control"
								name="age" readonly /></td>
						</tr>

						<tr>
							<td><label>Salary</label></td>
							<td><input type="number"
								value="<c:out value='${emp.salary}' />" class="form-control"
								name="salary" readonly /></td>
						</tr>

						<tr>
							<td><label>Experience</label></td>
							<td><input type="number"
								value="<c:out value='${emp.experience}' />" class="form-control"
								name="experience" readonly /></td>
						</tr>

						<tr>
							<td><label>Seniority</label></td>
							<td><input type="number"
								value="<c:out value='${emp.senoirity}' />" class="form-control"
								name="senoirity" readonly /></td>
						</tr>
						<tr>
							<td><label>DeptID</label></td>
							<td><input type="number"
								value="<c:out value='${emp.deptid}' />" class="form-control"
								name="deptid" readonly /></td>
						</tr>
					</table>
					<button type="submit" class="btn btn-success">Back</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>