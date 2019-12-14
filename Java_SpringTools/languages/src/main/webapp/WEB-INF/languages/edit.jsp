<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit your post</title>
</head>
<body>
<form:form action="/languages/${languages.id}" method="put" modelAttribute="languages">

    <p>
        <form:label path="language">Title</form:label>
        <form:errors path="language"/>
        <form:input path="language"/>
    </p>
    <p>
        <form:label path="name">Description</form:label>
        <form:errors path="name"/>
        <form:textarea path="name"/>
    </p>
    <p>
        <form:label path="version">Language</form:label>
        <form:errors path="version"/>
        <form:input path="version"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
<a href="/languages">Dashboard</a>
</body>
</html>