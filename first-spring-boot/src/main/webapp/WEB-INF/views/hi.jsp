<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Hi <%= request.getAttribute("name") %></h1>
<h3><a href="changePassword">Change Password</a></h3>
</body>
</html>