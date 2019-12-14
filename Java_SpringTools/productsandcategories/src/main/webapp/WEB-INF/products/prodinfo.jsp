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
<title>Product Page</title>
</head>
<body>
<h1>${product.name}</h1>
<div>
<h2>Categories:</h2>
	<c:forEach items="${prodprod}" var="prod">
		<h3>-<c:out value="${prod.categoryName}"/></h3>
	</c:forEach>
</div>
<div>
<form action="/addCategory" method="POST">
	<label for="thisCat">Add Category:</label>
<select name="thisCat">
<c:forEach items="${availCategory}" var="avail">
	<option value="${avail.id}">${avail.categoryName}</option>
</c:forEach>
</select>
	<input type="hidden" name="thisProd" value=${product.id}>
	<input type="submit" value="Add">
</form>
</div>
<a href="/categories/new">Home</a>
</body>
</html>


