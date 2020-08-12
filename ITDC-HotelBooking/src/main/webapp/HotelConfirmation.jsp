<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
html{
	background: url(https://image.freepik.com/free-vector/person-buying-tickets-travel-website_1262-21291.jpg)
	no-repeat center center fixed;
	background-size: cover;
	
}

</style>
</head>
<body>
<div align="center" style="padding-top: 2cm;"> 
<fieldset style="width: 380px; height: 400px; border-radius: 10px; border: solid 2px black;">
<form action="confirmed">
	<h2><input type="hidden" name="name" value="${hotel.name}">Hotel Name : ${hotel.name}</h2>
	<h4><input type="hidden" name="address" value="${hotel.address}">Address : ${hotel.address}</h4>
	<h4><input type="hidden" name="hotelPhone" value="${hotel.hotelPhone}">Hotel Phone Number : ${hotel.hotelPhone}</h4>
	<h4><input type="hidden" name="room" value="${booking.room}">Number Of Rooms Booked: ${booking.room}</h4>
		
	<c:set var="cost" value="${hotel.cost}"></c:set>		
	<c:set var="room" value="${booking.room}"></c:set>	
	<c:set var="totalcost" value="${room * cost}"></c:set>	
	<c:set var="phone" value="${booking.phone} "></c:set>
	<c:set var="fromDate" value="${booking.fromDate} "></c:set>
	<c:set var="toDate" value="${booking.toDate} "></c:set>
	<c:set var="bookedDate" value="${booking.bookedDate} "></c:set>

	<h4><input type="hidden" name="cost" value="${totalcost}">Cost : ${totalcost}</h4>
	<h4><input type="hidden" name="phone" value="${booking.phone}"> User Phone Number :${booking.phone} </h4>
	<h4><input type="hidden" name="fromDate" value="${booking.fromDate}">Boarding Date : ${booking.fromDate} </h4>
	<h4><input type="hidden" name="toDate" value="${booking.toDate }"> Vacating Date :${booking.toDate } </h4>
	<h4><input type="hidden" name="bookedDate" value="${booking.bookedDate}">Date You Booked : ${booking.bookedDate}  </h4>
	
	<input type="submit">
	
</form>
</fieldset></div>
</body>
</html>