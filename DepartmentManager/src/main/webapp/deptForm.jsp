<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Department Database</title>
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
			
				<c:if test="${ department !=null }">
					<form action="update" method="post">
					<h2>Edit Department</h2>
					
					<fieldset class="form-group">
					<label>Department ID</label> <input type="number" 
						value="<c:out value='${department.deptid}' />" class="form-control"  
						name="deptid" required="required" readonly/>
				</fieldset>
				</c:if>
				
				<c:if test="${department == null}">
					<form action="insert" method="post">
					<h2> Add New Department</h2>
					
					<fieldset class="form-group">
					<label>Department ID</label> <input type="number" 
						value="<c:out value='${department.deptid}' />" class="form-control"  
						name="deptid" required="required"/>
				</fieldset>
				</c:if>
				
				<fieldset class="form-group">
					<label>Department Name</label> <input type="text"
						value="<c:out value='${department.deptname}' />" class="form-control"
						name="deptname" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Department Location</label> <input type="text"
						value="<c:out value='${department.deptloc}' />" class="form-control"
						name="deptloc">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				<button type="button" class="btn btn-danger" onclick="cancelForm()">Cancel</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>