<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<title>Search User Bookings</title>
<link href='https://fonts.googleapis.com/css?family=Lemonada' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Lemon' rel='stylesheet'>
<style>
.box {
	position: absolute;
	display: table; /* Make the width of box same as image */
}

.box .text {
	position: absolute;
	z-index: 999;
	margin: 0 auto;
	left: 0;
	right: 0;
	text-align: center;
	top: 40%;
	/* Adjust this value to move the positioned div up and down */
	background: rgba(0, 0, 0, 0.6);
	font-family: Arial, sans-serif;
	color: #fff;
	width: 30%; /* Set the width of the positioned div */
	padding-bottom: 30px;
	border-radius: 20px;
	
}
html{background-color: #F0F8FF;}
h1 {font-family: 'Lemon';font-size: 24px;}
td{font-family: 'Lemonada';font-size: 16px;}
p{color: white; font-size: 10px}

img.two {
	height: 45%;
	width: 50%;
}
table.center {
  margin-left:auto; 
  margin-right:auto;
}
</style>
</head>
<body>
	<div class="box">
		<center>
			<img class="two"
				src="https://cdn.pixabay.com/photo/2016/05/30/14/23/detective-1424831_1280.png"
				width="250" alt="Search Magnifier">
		</center>
		<div class="text">
			<h1 style="color: #FFFF00;">Search With Date</h1>

			<form action="dailyBookings">

				<table class="center">
					<tr>
						<td><b>Enter The Date : </b></td>
						<td><input type="text" name="bookedDate" required="required" placeholder="DD-MM-YYYY"></td>
					</tr>
				</table><br>
				<input type="submit" value="Search">
				<p>*Date Format Is Mandatory As Requested</p>
			</form>
		</div>
	</div>
</body>
</html>






<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>



h1 {
	padding-top: 12cm;
	padding-left: 550px;
	text-decoration: underline;
	color: black;
	font-weight: 700;
}

table.center {
  margin-left:auto; 
  margin-right:auto;
}
</style>
</head>
<body style="background-image: url('https://cdn.pixabay.com/photo/2016/05/30/14/23/detective-1424831_1280.png'); background-repeat:no-repeat; background-size: 45%; background-position: center;">
	<h1>Search With Date</h1>
	
	<form action="dailyBookings">
	
	<table class="center">	
		<tr>
			<td><b>Enter The Date : </b></td>
			<td><input type="text" name="bookedDate" required="required"></td>
			</tr>
	</table>
		<input type="submit" value="Search">
	</form>
	
</body>
</html> -->