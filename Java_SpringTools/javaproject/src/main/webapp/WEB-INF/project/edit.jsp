<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title><c:out value="${event.name}"></c:out></title>
</head>
<body>
	<div class="edittop">
		<h2 class="detailwelcome"><c:out value="${event.name}"/></h2>
		<a href="/dashboard" class="detaildash">Back to events</a>
	</div>
	<div class="editbulk">
		<h5>Edit Event</h5>
		<form:form method="post" action="/events/${id}/edit" modelAttribute="eventObj">
			<input type="hidden" name="_method" value="put">
			<h4 class="editform">
				<form:label path="name">Name:</form:label>
				<form:input path="name" type="text" cssClass="fields"/>
			</h4>
			<h4 class="editform">
				<form:label path="date">Date:</form:label>
				<form:input path="date" type="date" cssClass="fields"/>
			</h4>
			<h4 class="editform">
		<form:label path="location">Location:</form:label>
		<form:select path="state" cssClass="state">
			<c:forEach items="${states}" var="state">
				<form:option value="${state}"><c:out value="${state}"></c:out> </form:option>
			</c:forEach>
		</form:select>
				<form:input path="location" type="text" cssClass="smFields"/>
			</h4>			
			<form:hidden path="user" value="${user.id}"/>
			<input class="btn" type="submit" value="Edit"/>
		</form:form>
		<form:errors cssClass="red" path="eventObj.*"/>
	</div>
</body>
</html>