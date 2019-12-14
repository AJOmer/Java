<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Ninja</title>
</head>
<body>
<h1>New Ninja!</h1>
<form:form action="/addNinja" method="post" modelAttribute="myNinjaObject">
				<h2>
			        <form:label cssClass="label left" path="dojo">Dojo:</form:label>
			        <form:select cssClass="box" path="dojo">
						<c:forEach items="${dojo}" var="doejoe">
							<form:option value="${doejoe.id}"><c:out value="${doejoe.name}"/></form:option>
						</c:forEach>c:forEach>
					</form:select>
			    </h2>	  
			    <h2>
			        <form:label cssClass="label left" path="firstName">First Name:</form:label>
			        <form:input cssClass="box" path="firstName"/>
			    </h2>
   			    <h2>
			        <form:label cssClass="label left" path="lastName">Last Name:</form:label>
			        <form:input cssClass="box" path="lastName"/>
			    </h2>
   			    <h2>
			        <form:label cssClass="label left" path="age">Age:</form:label>
			        <form:input cssClass="box" path="age"/>
			    </h2>
			    <input id="btn" type="submit" value="Create"/>	 
			</form:form>
			<a href ="/dojos/new">Add a new Dojo Location</a>	
</body>
</html>