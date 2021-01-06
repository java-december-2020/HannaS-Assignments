<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>Top Ten</title>
</head>
<body>
<h1>Top Ten Songs: </h1>
<a href="/dashboard">Dashboard</a>
<table class="table table-bordered table-striped">
	  <thead class="thead-dark">
	    <tr>
	      <th>Rating</th>
	      <th>Name</th>
	      <th>Artist</th>
	    </tr>
	  </thead>
	  
	  <tbody>
	   <c:forEach items="${ratings}" var="song" >
	    <tr>
	      <td>${song.rating}</td>
	      <td><a href="/songs/${song.id}">${song.title}</a></td>
	      <td>${song.artist }</td>
	    </tr>
	    </c:forEach>
	  </tbody>
	</table>
</body>
</html>