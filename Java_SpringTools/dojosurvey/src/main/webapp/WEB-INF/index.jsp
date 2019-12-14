<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
h1{
text-align: center;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Dojo Survey</title>
</head>
<body>
<div>
<h1>Dojo Survey</h1>
</div>
<form method="post" action="/result">
  <div class="form-group">
    <label for="exampleFormControlInput1">Name</label>
    <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="name" name="myname" required=true>
  </div>
  <div class="form-group">
    <label for="exampleFormControlSelect1">Dojo Location</label>
    <select class="form-control" id="exampleFormControlSelect1" name="mylocation" required=false>
      <option>Seattle</option>
      <option>Burbank</option>
      <option>San Jose</option>
      <option>Dallas</option>
      <option>Yugoslavia</option>
    </select>
  </div>
  <div class="form-group">
    <label for="exampleFormControlSelect2">Favorite Language</label>
    <select multiple class="form-control" id="exampleFormControlSelect2" name="mylanguage" required=true>
      <option>Java</option>
      <option>MEAN</option>
      <option>Python</option>
      <option>C++</option>
      <option>JavaScript</option>
    </select>
  </div>
  <div class="form-group">
    <label for="exampleFormControlTextarea1">Comment</label>
    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="mycomment" required=false></textarea>
  </div>
  <input type="submit" value="Submit">
</form>
</body>
</html>