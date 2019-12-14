<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>New License</title>
</head>
<body>
<form:form action="/newdl" method="post" modelAttribute="myLicenseObject">
				<h2>
			        <form:label cssClass="label left" path="person">Person:</form:label>
			        <form:select cssClass="box" path="person">
						<c:forEach items="${people}" var="per">
							<form:option value="${per.id}"><c:out value="${per.firstName} ${per.lastName}"/></form:option>
						</c:forEach>c:forEach>
					</form:select>
			    </h2>	  
			    <h2>
			        <form:label cssClass="label left" path="state">State:</form:label>
    			    <form:select cssClass="box" path="state">
						<c:forEach items="${states}" var="state">
							<form:option value="${state}"><c:out value="${state}"/></form:option>
						</c:forEach>c:forEach>
					</form:select>
			    </h2>
			    <h2>
			        <form:label cssClass="label left" path="expirationDate">Expiration Date:</form:label>
			        <form:input cssClass="box" type="date" path="expirationDate"/>
			    </h2>
			    <input id="btn" type="submit" value="Create"/>	 
			</form:form>	
</body>
</html>