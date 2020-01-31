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
<div class="detailtop">
	<h2 class="detailwelcome"><c:out value="${event.name}"></c:out></h2>
	<a class="detaildash" href="/dashboard">Back to events</a>
</div>
<div class="detailmid">
	<div class="deetsLeft">
		<h3 class="deetsSpecs">Host:<c:out value="${event.user.firstName }"/> <c:out value="${event.user.lastName}"></c:out></h3>
		<h3 class="deetsSpecs">Date:<fmt:formatDate pattern="MMMM dd, yyyy" value="${event.date}"/></h3>
		<h3 class="deetsSpecs">Location: <c:out value="${event.location}"></c:out></h3>
		<h3 class="deetsSpecs">People Attending: <c:out value="${event.joinedUsers.size()}"></c:out></h3>
		<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Location</th>
    </tr>
  </thead>
  <tbody>
	<c:forEach items="${attendees}" var="attendee">
    <tr>
      <td><c:out value="${attendee.firstName}"/> <c:out value="${attendee.lastName}"/></td>
      <td><c:out value="${attendee.location}"/></td>
    </tr>
	</c:forEach>
  </tbody>
</table>
	</div>
	<div class="commentbox">
		<h3 class="msgs">Message Wall</h3>
		<div class="msgbox">
			<c:forEach items="${messages}" var="msg">
				<p>${msg.user.firstName} says: ${msg.message}</p>
				<p>--*--*--*--*--*--*--*--*--*--*</p>
			</c:forEach>
		</div>
		<form:form method="post" action="/events/addmsg" modelAttribute="messageObj">
			<h5>
				<form:input path="message" cssClass="txtbox" type="textarea"/>
			</h5>
			<form:hidden path="user" value="${user.id}"/>
			<form:hidden path="event" value="${event.id}"/>
			<input class="btn" value="Submit" type="submit">
		</form:form>
		<form:errors cssClass="red" path="messageObj.*"/>
	</div>
</div>
</body>
</html>