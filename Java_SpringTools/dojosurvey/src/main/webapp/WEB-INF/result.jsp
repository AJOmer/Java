<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Info</title>
<style>
h1{
	text-decoration: underline;
	
}
</style>
</head>
<body>
<h1>Submitted-Info:</h1>
<h2>Name: ${name}</h2>
<h2>Location: ${location}</h2>
<h2>Language: ${language}</h2>
<h2>Comment: ${comment}</h2>
<a href="/">Go Back</a>
</body>
</html>