<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Driver Info</title>
</head>
<body>
<h1>${license.person.firstName} ${license.person.lastName}</h1>
<h2>${license.number}</h2>
<h2>${license.state}</h2>
<h2>${license.expirationDate}</h2>
<a href="/persons/new">New Driver</a>
</body>
</html>