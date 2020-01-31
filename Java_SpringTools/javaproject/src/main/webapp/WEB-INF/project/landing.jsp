<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css">
<link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
<title>Stitched</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<h2 class="helloUser">Welcome, <c:out value="${user.firstName}"></c:out></h2>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/"></a>
      </li>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Dropdown
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Action</a>
          <a class="dropdown-item" href="#">Another action</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Something else here</a>
        </div>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/logout" tabindex="-1" aria-disabled="true">Logout</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>
<div class = "inevents">
<h4>Here are some upcoming events in your state!</h4>
<c:if test="${instate.size() == 0}"><h5>There are currently no events in this area...</h5></c:if>
<c:if test="${instate.size() > 0}">
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date</th>
      <th scope="col">Location</th>
      <th scope="col">Host</th>
      <th scope="col">Action/Status</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${instate}" var="inside">
    <tr>
      <td><a href="/events/${inside.id}"><c:out value="${inside.name}"></c:out></a></td>
      <td><fmt:formatDate pattern="MMMM dd, yyyy" value="${inside.date}"/></td>
      <td><c:out value="${inside.location}"></c:out> </td>
      <td><c:out value="${inside.user.firstName}"></c:out></td>
      <c:choose>
      <c:when test="${inside.user == user}">
      <td>*Attending*|<a href="/events/${inside.id}/edit">Edit</a> | <a href="/events/${inside.id}/delete">Delete</a></td>
      </c:when>
      <c:otherwise>
		<c:set var="attending" value="${false}"/>
		<c:forEach items="${inside.getJoinedUsers()}" var="attendee">
			<c:if test="${attendee == user}">
			<c:set var="attending" value="${true}"/>
			</c:if>
		</c:forEach>
		<c:choose>
			<c:when test="${attending == false}">
				<td><a href="/events/${inside.id}/join">Join</a>			
			</c:when>
			<c:otherwise>
				<td>*Attending* | <a href="/events/${inside.id}/cancel">Cancel</a>
			</c:otherwise>			
		</c:choose>      
      </c:otherwise>
      </c:choose>
    </tr>
    </c:forEach>
  </tbody>
</table>
</c:if>
</div>
<div class="outevents">
<h4>Some cool events happening in other states!</h4>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Name</th>
      <th scope="col">Date</th>
      <th scope="col">Location</th>
      <th scope="col">Host</th>
      <th scope="col">Action/Status</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${outofstate}" var="outstate">
    <tr>
      <td><a href="/events/${outstate.id}"><c:out value="${outstate.name}"></c:out></a></td>
      <td><fmt:formatDate pattern="MMMM dd, yyyy" value="${outstate.date}"/></td>
      <td><c:out value="${outstate.location}"></c:out></td>
      <td><c:out value="${outstate.user.firstName}"></c:out></td>
      <c:choose>
      <c:when test="${outstate.user == user}">
      	<td>*Attending* | <a href="/events/${outstate.id}/edit">Edit</a> | <a href="/events/${outstate.id}/delete">Delete</a>
      </c:when>
      <c:otherwise>
      	<c:set var="attending" value="${false}"/>
      	<c:forEach items="${outstate.getJoinedUsers()}" var="goer">
      	<c:if test="${goer == user}">
      	<c:set var="attending" value="${true}"/>
      	</c:if>
      	</c:forEach>
      	<c:choose>
      		<c:when test="${attending == false}">
      		<td><a href="/events/${outstate.id}/join">Join</a></td>
      		</c:when>
      		<c:otherwise>
      		<td>*Attending* | <a href="/events/${outstate.id}/cancel">Cancel</a></td>
      		</c:otherwise>
      	</c:choose>
      </c:otherwise>
      </c:choose>
    </tr>
  </c:forEach>
  </tbody>
</table>
</div>
<div style="float:right" class="addevent">
<h3>Create an Event</h3>
<form:form method="post" action="/addevent" modelAttribute="eventObj">
	<h4 class="eventquestion">
		<form:label path="name">Name:</form:label>
		<form:input path="name" cssClass="fields" type="text"/>
	</h4>
	<h4 class="eventquestion">
		<form:label path="date">Date:</form:label>
		<form:input path="date" cssClass="fields" type="date"/>
	</h4>
	<h4 class="eventquestion">
		<form:label path="location">Location:</form:label>
		<form:select path="state" cssClass="state">
			<c:forEach items="${states}" var="state">
				<form:option value="${state}"><c:out value="${state}"></c:out> </form:option>
			</c:forEach>
		</form:select>
		<form:input cssClass="smFields" path="location" type="text"/>
	</h4>
	<form:hidden path="user" value="${user.id}"/>
	<input class="btn" type="submit" value="Create">
</form:form>
<form:errors cssClass="red" path="eventObj.*"/>
</div>
</body>
</html>