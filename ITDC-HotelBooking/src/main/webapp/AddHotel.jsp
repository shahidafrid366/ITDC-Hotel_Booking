<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body
	style="background-image: url('https://cdn.pixabay.com/photo/2018/02/22/23/06/security-camera-3174223_1280.jpg');">

	<div align="center" style="padding-top: 130px; padding-left: 1cm">
		<font face="Georgia" color="black" size="7"
			style="text-decoration: underline;"><b> Add Hotel </b></font>
	</div>

	<div align="center" style="padding-top: 40px;">
		<form action="addHotel">
			<table>
				<tr>
					<td><b> Enter Hotel Name : </b></td>
					<td><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<td><b>Enter Hotel Address :</b></td>
					<td><input type="text" name="address" required="required"></td>
				</tr>
				<tr>
					<td><b>Enter Phone Number :</b></td>
					<td><input type="text" name="hotelPhone" required="required"></td>
				</tr>
				<tr>
					<td><b>Enter Number Of Rooms : </b></td>
					<td><input type="text" name="rooms" required="required"></td>
				</tr>
				<tr>
					<td><b> Enter Cost Of Rooms :</b></td>
					<td><input type="text" name="cost" required="required"></td>
				</tr>
			</table>
			<br> <input type="submit" value="Add Hotel">
		</form>
	</div>
</body>
</html>