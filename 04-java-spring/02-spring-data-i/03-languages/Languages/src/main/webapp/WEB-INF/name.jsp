<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>${lang.name}</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/style.css">
 </head>
<body>
<div class="container">
	<div id="dashboard">
		<a href="/languages">Dashboard</a>
	</div>

	<label>Name: </label><p>${lang.name}</p><br>
	<label>Creator: </label><p>${lang.creator}</p><br>
	<label>Version: </label><p>${lang.version }</p><br>
	<a href="/languages/edit/${lang.id}">Edit</a>
	<a href="/languages/delete/${lang.id}">Delete</a>
</div>

</body>
</html>