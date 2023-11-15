<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>
<body>
	<form action="changePassword" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" disabled="disabled">
				</td>
			</tr>
			<tr>
				<td>Old Password</td>
				<td><input type="password" name="oldPassword" required="required">
				</td>
			</tr>
			<tr>
				<td>New Password</td>
				<td><input type="password" name="newPassword"
					required="required"></td>
			</tr>
			<tr>
				<td>Confirm New Password</td>
				<td><input type="password" name="confirmNewPassword"
					required="required"></td>
			</tr>
			<tr>
				<td><input type="submit" name="submit" value="Change">
				</td>
			</tr>
		</table>
	</form>
	<h5 style="color: red;">${message}</h5>
</body>
</html>