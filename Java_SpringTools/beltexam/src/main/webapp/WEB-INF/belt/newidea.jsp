<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add an Idea</title>
</head>
<body>
<h1>Create a new Idea!</h1>
<form:form action="/newIdeas" method="post" modelAttribute="ideaObj">
<p>
    <form:label path="idea">Idea</form:label>
    <form:errors path="idea"/>
    <form:input path="idea" placeholder="Idea Name"/>
</p>
    <form:label path="author"></form:label>
    <form:input path="author" type="hidden" value="${firstName}" placeholder="Idea Name"/>
 
<input type="submit" class="btn btn-primary" value="Submit">
</form:form>
<a href= "/dashboard">Home</a>
</body>
</html>