<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Dojo</title>
</head>
<body>
<h1>New Dojo</h1>
<form:form action="/create" method="post" modelAttribute="dojoObject">
<p>
    <form:label path="name">First Name</form:label>
    <form:errors path="name"/>
    <form:input path="name"  placeholder="Enter Dojo Location/Name"/>
</p>
  <input type="submit" class="btn btn-primary" value="Create">
</form:form>
<a href="/ninjas/new">Create a new Ninja!</a>
</body>
</html>



