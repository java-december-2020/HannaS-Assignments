    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>${artist }</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script> 
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<link rel="stylesheet" type="text/css" href="/css/style4.css">
 </head>
<body>
<div class="container">
	
	  <a class="navbar-brand" id="dashboard" href="/dashboard">Dashboard</a>
	   <form action="/songs/search">
				<input type="text" name="artist"/>
				<button class="btn btn-primary">Search Artists</button>
		</form>
	<table class="table table-bordered table-striped">
	  <thead class="thead-dark">
	    <tr>
	      <th>Name</th>
	      <th>Rating</th>
	      <th>actions</th>
	    </tr>
	  </thead>
	  <tbody>
	   <c:forEach items="${songs}" var="song" >
	    <tr>
	      <th scope="row"><a href="/songs/${song.id}">${song.title}</a></th>
	      <td>${song.rating}</td>
	      <td><a href="/delete/${song.id}">delete</a>
	    </tr>
	   </c:forEach>
	  </tbody>
	</table>
</div>
</body>
</html>