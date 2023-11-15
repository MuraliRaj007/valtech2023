<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<form action="register" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" required="required">
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required="required">
				</td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="confirmPassword"
					required="required"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Register">
				</td>
			</tr>
		</table>
	</form>
	<h5 style="color: red;">${message}</h5>
</body>
</html>