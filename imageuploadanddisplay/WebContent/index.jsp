<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Fill Details</h1>
	<form action="saveprofile" method="POST" enctype="multipart/form-data">
		<table>
			<tr>
				<td colspan="2" align="center">${errorMsg}</td>
			</tr>
			<tr>
				<td>Fullname</td>
				<td><input type="text" name="fullname" /></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="tel" name="mobile" /></td>
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
				<td>Upload Profile Image</td>
				<td><input type="file" name="image" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>