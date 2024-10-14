<!-- Import date bean -->
<%@ page import="mypack.ChurchBean" %>
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
<!-- set top navigation to switch between tabs -->
<div class="topnav" id="topnav">
			<a href="index.jsp" class="active">Home</a>
			<a href="sign_up.jsp">Sign-Up</a>
			<a href="contact.html">Contact Us</a>
		</div></br>
<h1 style="text-align:center;">Calvary Church Camp</h1>
	<!-- embed image -->
	<div style="text-align:center;">
		<img src="${pageContext.request.contextPath}/img/churchcamp.jpg" height="275" width="500" >
	</div>
	<p style="text-align:center;">Welcome to this year's summer church camp! Thank you for considering sending your child to our camp.<br>
	You will find that we strive to give meaningful experiences to your child and allow them to build strong<br>
	relationships with other like-minded youth! Have fun and we look forward to meeting you and your child soon!</p>
	<hr>
	<!-- access the date bean class and property -->
	<jsp:useBean id="ChurchBean" class="mypack.ChurchBean">
		<jsp:setProperty name="ChurchBean" property="*"/>
	</jsp:useBean>
	<h3 style="text-align:center;">Today's Date:</h3>
	<!-- get the current date from method in date bean class -->
	<p style="text-align:center;"><jsp:getProperty property="currentDate" name="ChurchBean"/><br><br>
	The current date above is a reminder that time flies by! Our final camp for this year<br>
	will be held the week of August 25th. As this time is approaching quickly, please<br>
	sign up as soon as you are able. Please see the sign-up tab for further instructions.</p>
	<hr>
	<h3 style="text-align:center;">Camp Address</h3>
	<p style="text-align:center;">1217 North Camp Rd.<br>
	Colorado Springs, CO 81765</p>
</body>
</html>