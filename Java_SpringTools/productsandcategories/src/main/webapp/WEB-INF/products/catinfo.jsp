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
<title>Category Page</title>
</head>
<body>
<h1>${category.categoryName}</h1>
<div>
<h2>Products:</h2>
	<c:forEach items="${caegory}" var="prod">
		<h3>-<c:out value="${prod.name}"/></h3>
	</c:forEach>
</div>
<div>
<form action="/addProduct" method="POST">
	<label for="product_id">Add Product:</label>
<select name="product_id">
<c:forEach items="${availProducts}" var="avail">
	<option value="${avail.id}">${avail.name}</option>
</c:forEach>
</select>
	<input type="hidden" name="category_id" value=${category.id}>
	<input type="submit" value="Add">
</form>
</div>
<a href="/categories/new">Home</a>
</body>
</html>




