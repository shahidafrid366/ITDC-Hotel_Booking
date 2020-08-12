<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href='https://fonts.googleapis.com/css?family=Lemon' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Lemonada' rel='stylesheet'>
<style>
h1{
	text-align:center;
	text-decoration:underline;
	font-family: 'Lemon';font-size: 40px;
	padding-top: 20px;
	}
	h4{
	font-family: 'Lemonada';
	font-size: 20px;
	}
	html {
	background:
		url(https://image.freepik.com/free-vector/flat-man-hotel-booking-background_23-2148136539.jpg)
		no-repeat center center fixed;
	
    height: auto;
    width: auto;
}



</style>
</head>


<body>  

	<c:forEach var="hotel" items="${list}">
	
<div align="center" style="width: 300px; float:left; height:250px; margin:30px; padding-top: 1cm;">
		<form action = "book">
			<h2><input type="hidden" name="name" value="${hotel.name}">Hotel Name : ${hotel.name}</h2>
			<h4><input type="hidden" name="address" value="${hotel.address}">Address : ${hotel.address}</h4>
			<details> <summary>view more</summary>
			<h4><input type="hidden" name="hotelPhone" value="${hotel.hotelPhone}"> Hotel Phone Number : ${hotel.hotelPhone}</h4>
			<h4><input type="hidden" name="rooms" value="${hotel.rooms}">Number Of Rooms : ${hotel.rooms}</h4>
			<h4><input type="hidden" name="cost" value="${hotel.cost}">Cost : ${hotel.cost}</h4>
			</details>
			<input type ="submit" value="Book Now">
		</form>  
	  
	  </div>
	  
	</c:forEach>
	
</body>
</html>