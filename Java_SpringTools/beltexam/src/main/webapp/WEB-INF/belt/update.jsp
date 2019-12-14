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
<p><form:errors path="thisIdea.*"/></p>
<form:form action="/idea/${thisIdea.id}/edit" method="PUT" modelAttribute="thisIdea">
<p>
    <form:label path="author"></form:label>
    <form:input path="author" type="hidden" value ="${name }"/>
</p>
<p>
	<form:label path="idea">Name</form:label>
	<form:input path="idea" type="text" value="${myidea.idea }"/>
</p>
<input type="submit" value="Update"/>
</form:form>
<a href= "/dashboard">Home</a>
<a href= "/idea/${thisIdea.id}/delete">Delete</a>
</body>
</html>
