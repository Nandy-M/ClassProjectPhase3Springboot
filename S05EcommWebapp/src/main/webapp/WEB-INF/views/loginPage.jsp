<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	
	<form action="/doLogin" method="post">
		<p>User Name: <input type="text" name="username" /></p>
		<p>Password: <input type="password" name="password" /></p>
		<p><input type="submit" value="Sign In" />
	</form>
	
</body>
</html>
