<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Languages</title>
</head>
<body>
<div class="languagelist">
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Language</th>
      <th scope="col">Name</th>
      <th scope="col">Version</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${languages}" var="lang">
    <tr>
	<td><a href="/languages/${lang.id}"></a>${lang.language}</td>
	<td>${lang.name}</td>
	<td>${lang.version}</td>
	<td><a href="/languages/${lang.id}/delete">Delete</a>|| <a href="/languages/edit/${lang.id}">Edit</a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</div>
<h1>Create a new Language!</h1>

<form:form action ="/languages" method="post" modelAttribute="newLang">
<p>
<form:label path="language" >Language Name</form:label>
<form:errors path="language"/>
<form:input path="language"/>
</p>
<p>
<form:label path="name" >Creator Name</form:label>
<form:errors path="name"/>
<form:input path="name"/>
</p>
<p>
<form:label path="version" >Version Number</form:label>
<form:errors path="version"/>
<form:input path="version"/>
</p>
<input type="submit" value="Submit"/>
</form:form>
</body>
</html>