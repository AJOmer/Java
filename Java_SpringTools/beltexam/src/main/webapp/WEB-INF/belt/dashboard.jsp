<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>
<h1>Welcome ${firstName}</h1>
<h3>Ideas</h3>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">Idea</th>
      <th scope="col">Created By:</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${ideas}" var="dea">
    <tr>
      <td><a href="/idea/${dea.id}">${dea.idea}</td>
      <td>${dea.author}
    </tr>
    </c:forEach>
  </tbody>
</table>
<a href="/idea/new">Create a new Idea!</a>
<a href="/logout">Logout</a>
</body>
</html>