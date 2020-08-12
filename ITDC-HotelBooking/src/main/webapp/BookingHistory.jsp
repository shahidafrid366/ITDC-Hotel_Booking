<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
<link href='https://fonts.googleapis.com/css?family=Arbutus Slab' rel='stylesheet'>
<link href='https://fonts.googleapis.com/css?family=Emblema One' rel='stylesheet'>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table, tr, th, td {
	text-align: center;
	border-collapse: collapse;
	border-spacing: 0;
	padding: 5px;
	border-collapse: separate;
}

th {
	font-family: cursive;
	font-size: medium;
	color: white;
	background-color: black;
}

td {
	font-family: 'Arbutus Slab';
}

caption{
	text-decoration:underline;
	padding-top: 1cm;
	font-size: 10;
	font-family: 'Emblema One';font-size: 22px;
}

p {
	text-align: center;
	font-size: small;
	line-height: 200%;
}
.wrap {
    width: 100%;
}
.image, html {
	background:
		url(https://images.pexels.com/photos/768472/pexels-photo-768472.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940)
		no-repeat center center fixed;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	-o-background-size: cover;
	background-size: cover;
    
}
.image:before{
    content: '';
    position: absolute;
    top: 0;
    right: 0;
    left: 0;
    bottom: 0;
    background: rgba(0,0,0,0.5);
}
.text {
    color: #FFF;
    position: relative;
}
/* top-left border-radius */
table tr:first-child th:first-child {
	border-top-left-radius: 10px;
}

/* top-right border-radius */
table tr:first-child th:last-child {
	border-top-right-radius: 10px;
}

/* bottom-left border-radius */
table tr:last-child td:first-child {
	border-bottom-left-radius: 10px;
}

/* bottom-right border-radius */
table tr:last-child td:last-child {
	border-bottom-right-radius: 10px;
}

</style>
</head>
<body><div class="wrap"><div class="image"><div class="text">

	<table>
	<caption>Booking's History</caption>
		<thead>
			<tr>
				<th>User Id</th>
				<th>User Phone Number</th>
				<th>Hotel Name</th>
				<th>Hotel Address</th>
				<th>Hotel Phone Number</th>
				<th>Rooms Booked</th>
				<th>Cost On Booking</th>
				<th>Boarding Date</th>
				<th>Vacating Date</th>
				<th>Room Booked Date</th>
				<th>Status</th>
				<th>Request For Cancel</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${list}">
			<form action="userGaveCancelRequest">
			<tr>
					<td><input type="hidden" name="userid" value="${s.userid}">${s.userid}</td>
					<td><input type="hidden" name="phone" value="${s.phone}">${s.phone}</td>
					<td><input type="hidden" name="hotelName" value="${s.hotelName}">${s.hotelName}</td>
					<td><input type="hidden" name="address" value="${s.address}">${s.address}</td>
					<td><input type="hidden" name="hotelPhone" value="${s.hotelPhone}">${s.hotelPhone}</td>
					<td><input type="hidden" name="room" value="${s.room}">${s.room}</td>
					<td><input type="hidden" name="cost" value="${s.cost}">${s.cost}</td>
					<td><input type="hidden" name="fromDate" value="${s.fromDate}">${s.fromDate}</td>
					<td><input type="hidden" name="toDate" value="${s.toDate}">${s.toDate}</td>
					<td><input type="hidden" name="bookedDate" value="${s.bookedDate}">${s.bookedDate}</td>
					<td><input type="hidden" name="status" value="${s.status}">${s.status}</td>
					<td><button id="firstbutton" onclick="disablefirstbutton()">Cancel</button></td>
				</tr>
			</form>
				
				
			</c:forEach>
		</tbody>
	</table>
	
	<hr>
	<p>--------   *Reached End Of The Booking History   --------</p>
	</div></div></div>
</body>
</html>