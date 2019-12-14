<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This Brilliant Idea</title>
</head>
<body>
<h1>${thisIdea.idea}</h1>
<h3>Created By: ${thisIdea.author}</h3>
<a href= "/dashboard">Home</a>
<a href ="/idea/${id}/edit">Edit this Idea!</a>
</body>
</html>