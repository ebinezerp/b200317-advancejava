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

				<h1>Hotel Registration</h1>
				<form action="addhotel" method="POST">
					<table>
						<tr>
							<td><label>Hotel Name</label></td>
							<td><input type="text" name="hotelname" /></td>
							<td><span class="errMgs">${errorMessages.hotelNameError}</span></td>
						</tr>
						<tr>
							<td><label>GST No</label></td>
							<td><input type="text" name="gst" /></td>
							<td><span class="errMgs">${errorMessages.gstError}</span></td>
						</tr>
						<tr>
							<td><label>Hotel Rating</label></td>
							<td><select name="rating">
									<option value="1">1 Star</option>
									<option value="2">2 Star</option>
									<option value="3">3 Star</option>
									<option value="4">4 Star</option>
									<option value="5">5 Star</option>
							</select></td>
							<td><span class="errMgs">${errorMessages.ratingError}</span></td>
						</tr>
						<tr>
							<td colspan="2"><label><b>Type of Room Available</b></label></td>
							<td><span class="errMgs">${errorMessages.roomTypeError}</span></td>
							<td><span class="errMgs">${roomTypeError}</span></td>
						</tr>
						<tr>
							<td><label>Luxry AC Single Room(Price)</label></td>
							<td><input type="checkbox" name="roomtype" value="lac-s" /></td>
						</tr>
						<tr>
							<td><label>Delux AC Single Room(Price)</label></td>
							<td><input type="checkbox" name="roomtype" value="dac-s" /></td>
						</tr>
						<tr>
							<td><label>Delux AC Double Room(Price)</label></td>
							<td><input type="checkbox" name="roomtype" value="dac-d" /></td>
						</tr>
						<tr>
							<td><label>Normal Single Room</label></td>
							<td><input type="checkbox" name="roomtype" value="n-s" /></td>
						</tr>
						<tr>
							<td><label>Normal Double Room</label></td>
							<td><input type="checkbox" name="roomtype" value="n-d" /></td>
						</tr>
						<tr>
							<td colspan="2"><label><b>Facilities</b></label></td>
							<td><span class="errMgs">${errorMessages.facilitiesError}</span></td>
							<td><span class="errMgs">${facilitiesError}</span></td>
						</tr>
						<tr>
							<td>AC</td>
							<td><input type="checkbox" name="facilities" value="ac" /></td>
						</tr>
						<tr>
							<td>Gym</td>
							<td><input type="checkbox" name="facilities" value="gym" /></td>
						</tr>
						<tr>
							<td>Swimming Pool</td>
							<td><input type="checkbox" nam="facilities" value="pool" /></td>
						</tr>

						<tr>
							<td colspan="2" align="center"><input type="submit"
								value="Register" /></td>
						</tr>
					</table>

				</form>

			</div>
		</div>

	</section>
</body>
</html>