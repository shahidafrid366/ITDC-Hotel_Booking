<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
body {
	font-family: Arial, Helvetica, sans-serif;
}

.navbar {
	overflow: hidden;
	background-color: #333;
	border-radius: 10px;
	padding-left: 10px;
		
}

.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-style: oblique;
}

.dropdown {
	float: right;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .dropdown:hover .dropbtn {
	background-color: red;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}



html{
	background: url(https://image.freepik.com/free-vector/hotel-booking-online-website-mobile-application_199252-27.jpg);
	height: 100%;
	width:100%;
	background-size: 100%;
}






</style>
</head>
<body>
	<div class="navbar">
		<a href="home.jsp">Home</a>

		<div class="dropdown">
			<button class="dropbtn">
				Login Here <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="AdminLogin.jsp">Admin Login</a> <br> <a
					href="UserLogin.jsp">User Login</a><br> <a
					href="NewUser.jsp">New User</a>
			</div>
		</div>
	</div>

	<h1 style="padding-top: 1cm; padding-left: 10cm; color:yellow">Indian Tourism Development Corporation</h1>
	
	
	
	
	
	
	
	
	
	
</body>
</html>