<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee Database</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
	
	<script>
        function cancelForm() {
            window.location.href = "<%=request.getContextPath()%>/list";
        }
    </script>
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
			
				<c:if test="${ employee !=null }">
					<form action="update" method="post">
					<h2>Edit Employee</h2>
					
					<fieldset class="form-group">
					<label>Employee ID</label> <input type="number" 
						value="<c:out value='${employee.id}' />" class="form-control"  
						name="id" required="required" readonly/>
				</fieldset>
				</c:if>
				
				<c:if test="${employee == null}">
					<form action="insert" method="post">
					<h2> Add New Employee</h2>
					
					<fieldset class="form-group">
					<label>Employee ID</label> <input type="number" 
						value="<c:out value='${employee.id}' />" class="form-control"  
						name="id" required="required"/>
				</fieldset>
				</c:if>
				
				<fieldset class="form-group">
					<label>Employee Name</label> <input type="text"
						value="<c:out value='${employee.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Age</label> <input type="number"
						value="<c:out value='${employee.age}' />" class="form-control"
						name="age">
				</fieldset>
				
				<fieldset class="form-group">
					<label>Salary</label> <input type="number"
						value="<c:out value='${employee.salary}' />" class="form-control"
						name="salary">
				</fieldset>

				<fieldset class="form-group">
					<label>Experience</label> <input type="number"
						value="<c:out value='${employee.experience}' />" class="form-control"
						name="experience">
				</fieldset>

				<fieldset class="form-group">
					<label>Seniority</label> <input type="number"
						value="<c:out value='${employee.senoirity}' />" class="form-control"
						name="senoirity">
				</fieldset>

				<fieldset class="form-group">
					<label>DeptID</label> <input type="number"
						value="<c:out value='${employee.deptid}' />" class="form-control"
						name="deptid">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				
				<button type="button" class="btn btn-danger" onclick="cancelForm()">Cancel</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>