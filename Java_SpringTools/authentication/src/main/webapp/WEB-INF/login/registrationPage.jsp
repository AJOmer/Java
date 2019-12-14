<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
<body>
    <h1>Register!</h1>

    <form:form method="POST" action="/register" modelAttribute="user">
        <p>
            <form:label path="email">Email:</form:label>
            <form:input type="email" path="email"/>
            
        </p>
        <p>
            <form:label path="password">Password:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Password Confirmation:</form:label>
            <form:password path="passwordConfirmation"/>
            <form:errors path="passwordConfirmation"></form:errors>
        </p>
        <input type="submit" value="Register!"/>
    </form:form>

</body>
</html>