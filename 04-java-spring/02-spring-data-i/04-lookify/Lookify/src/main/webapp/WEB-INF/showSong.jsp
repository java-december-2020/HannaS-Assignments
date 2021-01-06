<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>${song.title}</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div id="dashboard">
		<a href="/dashboard">Dashboard</a>
	</div>

	<label>Title: </label><p>${song.title}</p><br>
	<label>Artist: </label><p>${song.artist}</p><br>
	<label>Rating(1-10): </label><p>${song.rating}</p><br>
	<a href="/delete/${song.id}">Delete</a>
</div>

</body>
</html>