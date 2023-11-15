<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<form action="login" method="post">
	<label>Username</label> 
	<input type="text" name="username" required="required"><br/>
	<label>Password</label> 
	<input type="password" name="password" required="required"><br/>
	<button type="submit" name="submit">Login</button>
	</form>
	<h3><a href="register">New User Registration</a></h3>
</body>
</html>