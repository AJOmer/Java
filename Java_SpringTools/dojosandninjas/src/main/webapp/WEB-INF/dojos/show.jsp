<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Dojo Info</title>
</head>
<body>
<h1>${dojo.name}</h1>
<table class="table table-dark">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${dojo.ninjas}" var="ninjaw">
    <tr>
      <td>${ninjaw.firstName}</td>
      <td>${ninjaw.lastName}</td>
      <td>${ninjaw.age}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<a href ="/dojos/new">Add a Dojo</a>
<a href="/ninjas/new">Add a Ninja!</a>
</body>
</html>



