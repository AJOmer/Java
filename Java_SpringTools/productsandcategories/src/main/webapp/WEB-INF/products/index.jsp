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
<title>New Product</title>
</head>
<body>
<h1>Add a Product!</h1>
<form:form action="/newProd" method="post" modelAttribute="prodObj">
<p>
    <form:label path="name">Name</form:label>
    <form:errors path="name"/>
    <form:input path="name" placeholder="Product Name"/>
</p>
<p>
    <form:label path="description">Description</form:label>
    <form:errors path="description"/>
    <form:input path="description" placeholder="Describe your product"/>
</p>
<p>
    <form:label path="price">Price</form:label>
    <form:errors path="price"/>
    <form:input path="price" placeholder="$$$"/>
</p>
  <input type="submit" class="btn btn-primary" value="Submit">
</form:form>
</body>
</html>