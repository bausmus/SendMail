<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Link style sheet -->
<link rel="stylesheet" type="text/css" href="final.css">
<title>Calvary Church Camp</title>
</head>
<body>
<!-- Adding Navigation functionality to top of page -->
<div class="topnav" id="topnav">
			<a href="index.jsp">Home</a>
			<a href="sign_up.jsp" class="active">Sign-Up</a>
			<a href="contact.html">Contact Us</a>
		</div></br>
<form action="insertServer" method="post">
	<!-- Form titles and fields for user to fill out, name will be used for identification in servlet class -->
	Camper ID:<input type="text" name="camper_id"></br></br>
	First Name:<input type="text" name="first_name"></br></br>
	Last Name:<input type="text" name="last_name"></br></br>
	Church Name:<input type="text" name="church_name"></br></br>
	Email:<input type="text" name="email"></br></br>
	Phone:<input type="text" name="phone"></br></br>
	<!-- submit button user will click when form is filled out -->
	<input type="submit" value="Save">
</form>
</body>
</html>