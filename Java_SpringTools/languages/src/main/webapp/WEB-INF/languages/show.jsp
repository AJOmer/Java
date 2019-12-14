<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My language info</title>
</head>
<body>
<h1><c:out value="${languages.language}"/></h1>
<p>Creator Name: <c:out value="${languages.name}"/></p>
<p>Version: <c:out value="${languages.version}"/></p>
<a href="/languages/edit/${languages.id}">Edit Language</a>
<form action="/languages/${languages.id}/delete" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
<a href="/languages">Dashboard</a>
</body>
</html>