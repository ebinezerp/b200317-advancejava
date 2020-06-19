<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%
		ResultSet rs = (ResultSet) session.getAttribute("resultSet");
	%>


	<table>
		<tr>
			<td><label>First Name</label></td>
			<td><%=rs.getString("firstname")%></td>
		</tr>
		<tr>
			<td><label>Last Name</label></td>
			<td><%=rs.getString("lastname")%></td>
		</tr>
		<tr>
			<td><label>Email</label></td>
			<td><%=rs.getString("email")%></td>
		</tr>
		<tr>
			<td><label>Mobile</label></td>
			<td><%=rs.getString("mobile")%></td>
		</tr>
		<tr>
			<td><label>Username</label></td>
			<td><%=rs.getString("username")%></td>
		</tr>

	</table>



</body>
</html>