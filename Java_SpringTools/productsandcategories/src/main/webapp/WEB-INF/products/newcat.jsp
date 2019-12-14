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
<title>New Category</title>
</head>
<body>
<h1>Add a Category!</h1>
<form:form action="/newCat" method="post" modelAttribute="catObj">
<p>
    <form:label path="categoryName">Name</form:label>
    <form:errors path="categoryName"/>
    <form:input path="categoryName" placeholder="Category Name"/>
</p>
  <input type="submit" class="btn btn-primary" value="Submit">
</form:form>
</body>
</html>