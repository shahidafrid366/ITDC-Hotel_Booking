<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
table.center {
  margin-left:auto; 
  margin-right:auto;
}

</style>
</head>
<body>
	<table class="center">
	<caption> List Of Hotels </caption>
		<thead>
			<tr>
				<th>Name</th>
				<th>Address</th>
				<th>Hotel Phone</th>
				<th>Rooms</th>
				<th>Cost</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="s" items="${list}">
				<tr>
					<td><c:out value="${s.name}"></c:out></td>
					<td><c:out value="${s.address}"></c:out></td>
					<td><c:out value="${s.hotelPhone}"></c:out></td>
					<td><c:out value="${s.rooms}"></c:out></td>
					<td><c:out value="${s.cost}"></c:out></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<p>--------   *Reached End Of List Of Hotels  --------</p>
</body>
</html>