<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
html{
	background: linear-gradient(rgba(255,255,255,0.5), rgba(255,255,255,0.5)),
		url(https://image.freepik.com/free-vector/blue-background-with-booking-word_52683-145.jpg);
		background-repeat: no-repeat;
		background-size: 100%;
		height:100%;
		opacity:
   /*  height: auto;
    width: 100; */
}


</style>
</head>
<body onload="addDate();"><div>
<div align="center"	style="padding-top: 2cm">
<h1 style="text-decoration: underline;">Booking Form</h1>
<fieldset style="width: 380px; height: 345px; border-radius: 10px; border: solid 2px black;"> 
	
	<p>*Enter Date in Date-Mon-Year format only</p>
	
	<form action="formBooking">
	<table>	
		<tr>
		<td><b>Enter Your Phone Number:</b></td>
		<td><input type="text" name="phone" required="required"> </td>
		</tr>
		<tr>
			<td><b>Select The Boarding Date : </b></td>
			<td><input type="text" name="fromDate" required="required" placeholder="DD-MM-YYYY"></td>
		</tr> 
		<tr>
			<td><b>Select The Vacating Date :</b></td>
			<td><input type="text" name="toDate" required="required" placeholder="DD-MM-YYYY"></td>
		</tr>
		<tr>
			<td><b>Enter How Many Rooms You Want :</b></td>
			<td> <input type="text" name="room" required="required"></td>
		</tr>
		<tr>	
			<td><b>Day You are Booking :</b></td>
			<td> <input type="text" id="date" name="bookedDate" readonly="readonly"></td>
		</tr> 
		</table><br>
		<input type="submit" value="Book Now">
	</form>
	<script>
		function addDate() {
			date = new Date();
			var month = date.getMonth() + 1;
			var day = date.getDate();
			var year = date.getFullYear();

			if (document.getElementById('date').value == '') {
				document.getElementById('date').value = day + '-' + month + '-'
						+ year;
			}
		}
	</script>
</fieldset>
</div></div>
</body>
</html>