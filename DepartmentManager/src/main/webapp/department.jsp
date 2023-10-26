<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Department Details</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<h2>Department Database</h2>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Departments</a></li>
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
							<td><label>Department ID</label></td>
							<td><input type="number"
								value="<c:out value='${dept.deptid}' />" class="form-control"
								name="deptid" required="required" readonly /></td>
						</tr>

						<tr>
							<td><label>Department Name</label></td>
							<td><input type="text" value="<c:out value='${dept.deptname}' />"
								class="form-control" name="deptname" required="required" readonly /></td>
						</tr>

						<tr>
							<td><label>Department Location</label></td>
							<td><input type="text" value="<c:out value='${dept.deptloc}' />" class="form-control"
								name="deptloc" readonly /></td>
						</tr>   
					</table>
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
					</tr>
				</thead>
				<tbody>
					<c:forEach var="emp" items="${empListbyDept}">

						<tr>
							<td><c:out value="${emp.id}" /></td>
							<td><c:out value="${emp.name}" /></td>
							<td><c:out value="${emp.age}" /></td>
							<td><c:out value="${emp.salary}" /></td>
							<td><c:out value="${emp.experience}" /></td>
							<td><c:out value="${emp.senoirity}" /></td>
							<td><c:out value="${emp.deptid}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
					<button type="submit" class="btn btn-success">Back</button>				
				</form>
			</div>
		</div>
	</div>
</body>
</html>