<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body
	style="background-image: url('https://cdn.pixabay.com/photo/2018/02/22/23/06/security-camera-3174223_1280.jpg')">

	<div align="center" style="padding-top: 130px; padding-left: 1cm">
		<font face="Georgia" color="black" size="7"
			style="text-decoration: underline;"><b> New Register Here
		</b></font>
	</div>

	<div align="center" style="padding-top: 40px;">
		<form action="newUser">
			<table>
				<tr>
					<td><b> Enter User Id : </b></td>
					<td><input type="text" name="userid" required="required">
					</td>
				</tr>
				<tr>
					<td><b>Enter User Password :</b></td>
					<td><input type="text" name="password" required="required">
					</td>
				</tr>
				<tr>
					<td><b>Enter User Name :</b></td>
					<td><input type="text" name="name" required="required"></td>
				</tr>
			</table>
			<input type="submit" value="Register">
		</form>
	</div>
</body>
</html>