<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="links.jsp"%>
</head>
<body>
	<%@include file="headerpage.jsp"%>
	<section class="login">
		<div id="content">
			<div class="nav">
				<a href="hotelreg.jsp">Book Your Hotel</a>
			</div>
			<div class="login-form">
				<span class="errMsgs">${errorMsg}</span>
				<form action="hotellogin" method="post">
					<table>
						<tr>
							<td><label>Username</label></td>
							<td><input type="text" name="username" /></td>
						</tr>
						<tr>
							<td><label>Password</label></td>
							<td><input type="password" name="password" /></td>
						</tr>
						<tr>

							<td colspan="2"><input type="submit" value="Login" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

	</section>

</body>
</html>