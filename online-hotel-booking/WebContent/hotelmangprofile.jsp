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

	<c:if test="${resultSet!=null}">
		<%-- 
	<%
		
		ResultSet rs = (ResultSet) session.getAttribute("resultSet");
	%> --%>


		<c:set var="rs" value="${resultSet}"></c:set>


		<section class="profile">
			<table>
				<tr>
					<td>Fullname</td>
					<td><%=rs.getString("fullname")%></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><%=rs.getString("email")%></td>
				</tr>
				<tr>
					<td>Mobile</td>
					<td><%=rs.getString("mobile")%></td>
				</tr>
				<tr>
					<td>Username</td>
					<td><%=rs.getString("username")%></td>
				</tr>
			</table>
		</section>

	</c:if>
</body>
</html>