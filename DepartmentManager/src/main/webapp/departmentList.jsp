<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Department List</title>
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

	<div class="row">
		<div class="container">
			<h3 class="text-center">List of Departments</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">
				Add New Department</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>DeptID</th>
						<th>DeptName</th>
						<th>DeptLoc</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="dept" items="${deptList}">
						<tr>
							<td><c:out value="${dept.deptid}" /></td>
							<td><c:out value="${dept.deptname}" /></td>
							<td><c:out value="${dept.deptloc}" /></td>
							<td><a href="edit?deptid=<c:out value="${dept.deptid}" />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; 
								<a href="delete?deptid=<c:out value="${dept.deptid}" />">Delete</a>
								&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="view?deptid=<c:out value="${dept.deptid}" />">View</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>