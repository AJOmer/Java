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
<title>New Person</title>
</head>
<body>
<h1>New Person</h1>
<form:form action="/create" method="post" modelAttribute="myPerson">
<p>
    <form:label path="firstName">First Name</form:label>
    <form:errors path="firstName"/>
    <form:input path="firstName"  placeholder="Enter First Name"/>
</p>
<p>
    <form:label path="lastName">Last Name</form:label>
    <form:errors path="lastName"/>
    <form:input path="lastName" placeholder="Enter Last Name"/>
</p>
  <input type="submit" class="btn btn-primary" value="Create">
</form:form>
<a href="/license/new">Create a license</a>
</body>
</html>