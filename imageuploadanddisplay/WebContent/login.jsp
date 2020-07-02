<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="POST">
		<table>
			<tr>
				<td colspan="2" align="center">${errorMsg}</td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Logins" /></td>
			</tr>
		</table>
	</form>
</body>
</html>