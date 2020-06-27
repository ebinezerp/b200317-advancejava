<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="links.jsp"%>
</head>
<body>
	<%@include file="hotelmangheader.jsp"%>

	<c:if test="${hotelManagment!=null}">


		<section class="profile">
			<table>
				<tr>
					<td>Fullname</td>
					<td>${hotelManagment.fullname}</td>
				</tr>
				<tr>
					<td>Email</td>
					<td>${hotelManagment.email}</td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td>${hotelManagment.mobile}</td>
				</tr>
				<tr>
					<td>Username</td>
					<td>${hotelManagment.username}</td>
				</tr>
			</table>
		</section>

	</c:if>
</body>
</html>