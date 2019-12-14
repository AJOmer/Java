<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Song information</title>
</head>
<body>
<h1><c:out value="${lookify.title}"/></h1>
<p>Artist: <c:out value="${lookify.artist}"/></p>
<p>Rating: <c:out value="${lookify.rating}"/></p>
<form action="/lookify/${lookify.id}/delete" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
<a href="/dashboard">Dashboard</a>
</body>
</html>