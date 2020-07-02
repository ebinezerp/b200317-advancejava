<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="imagePath"
	value="${pageContext.request.servletContext.contextPath}/images"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<body>
	<table>
		<tr>
			<td>Profile Image</td>
			<td><img src="${imagePath}/${user.username}.jpg" width=200
				height=200 /></td>
		</tr>
		<tr>
			<td>Fullname</td>
			<td>${user.fullname}</td>
		</tr>
		<tr>
			<td>Mobile</td>
			<td>${user.mobile}</td>
		</tr>
		<tr>
			<td>Username</td>
			<td>${user.username}</td>
		</tr>
	</table>
</body>
</html>