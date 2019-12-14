<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit an Idea!</title>
</head>
<body>
<form:form action="/idea/${idea.id}" method="put" modelAttribute="thisIdea">
<p>
    <form:label path="idea">Idea</form:label>
    <form:input path="idea" placeholder="Idea Name"/>
</p>

 
<input type="submit" class="btn btn-primary" value="Submit">
</form:form>
<a href= "/dashboard">Home</a>
</body>
</html>