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
<title>Lookify</title>
</head>
<body>
    <form action="/search" method="post" class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="artist">
      <input class="Submit" type="submit">
    </form>
<a href="/songs/new">Add New!</a>
<a href="/search/topTen">Top Songs</a>
<div class="lookifylist">
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Song Title</th>
      <th scope="col">Rating</th>
      <th scope="col">Artist</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${lookify}" var="look">
    <tr>
	<td><a href="/songs/${look.id}">${look.title}</a></td>
	<td>${look.rating}</td>
	<td>${look.artist}</td>
	<td><a href="/songs/${look.id}/delete">Delete</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
</body>
</html>