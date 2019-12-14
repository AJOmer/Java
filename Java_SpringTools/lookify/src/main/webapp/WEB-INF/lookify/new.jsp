<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Create a Song</title>
</head>
<body>
<h1>Create a new Song!</h1>
<form:form action ="/create" method="post" modelAttribute="lookify">
<p>
<form:label path="title" >Song Title</form:label>
<form:errors path="title"/>
<form:input path="title"/>
</p>
<p>
<form:label path="artist" >Artist</form:label>
<form:errors path="artist"/>
<form:input path="artist"/>
</p>
<p>
<form:label path="rating" >Rating</form:label>
<form:errors path="rating"/>
<form:input path="rating"/>
</p>
<input type="submit" value="Add Song"/>
</form:form>
<a href="/dashboard">Dashboard</a>
</body>
</html>