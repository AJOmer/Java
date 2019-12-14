<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Great Guessing Game</title>
</head>
<body>
<div class="container">
	<h1>Hello, I'm thinking of a number between 1-100; guess it!!</h1>
	<h3>Take a guess:</h3>
	<div class = "guess">
		<% String theResponse = (String) session.getAttribute("response");
		if(theResponse == "Correct"){ %>
		<div class = "correct">
		<h1>Correct</h1>
		</div>
		<% } else if(theResponse == "low") {%>
		<div class = "low">
			<h1>Too Low!</h1>
		</div>
		<% } else if(theResponse == "high") { %>
		<div class = "high">
			<h1>Too high!</h1>
		</div>
		<% } %>
	</div>
	<form action="/GreatNumberGame/Index" method="post">
		<p><input type = "text" name ="guess"></p>
		<p><input type = "submit" value = "Submit"></p>
	</form>
</div>
</body>
</html>