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


	<section class="registration">
		<div id="content">
			<div class="nav">
				<a href="hotelreg.jsp">Book Your Hotel</a>
			</div>
			<div class="reg-form">
				<span class="errMsgs">${errorMsg}</span>
				<h1>Hotel Managment Registration</h1>
				<form action="hotelmangreg" method="POST">
					<table>
						<tr>
							<td><label>Full name</label></td>
							<td><input type="text" name="fullname"
								value="${param['fullname']}" /></td>
							<td><span class="errMsgs">${fullnameError}</span></td>
						</tr>
						<tr>
							<td><label>Email</label></td>
							<td><input type="email" name="email"
								value="${param['email']}" /></td>
							<td><span class="errMsgs">${emailError} </span></td>
						</tr>
						<tr>
							<td><label>Mobile</label></td>
							<td><input type="tel" name="mobile"
								value="${param['mobile']}" /></td>
							<td><span class="errMsgs">${mobileError} </span></td>
						</tr>
						<tr>
							<td><label>Username</label></td>
							<td><input type="text" name="username"
								value="${param['username']}" /></td>
							<td><span class="errMsgs"> ${usernameError} </span></td>
						</tr>

						<tr>
							<td><label>Password</label></td>
							<td><input type="password" name="password"
								value="${param['password']}" /></td>
							<td><span class="errMsgs"> ${passwordError} </span></td>
						</tr>

						<tr>
							<td><input type="submit" value="Register" /></td>
						</tr>
					</table>
				</form>

			</div>
		</div>

	</section>


</body>
</html>