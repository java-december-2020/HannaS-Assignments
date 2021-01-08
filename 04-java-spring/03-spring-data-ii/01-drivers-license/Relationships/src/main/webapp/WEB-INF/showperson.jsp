<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>${person.firstName} ${person.lastName}</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
	<div>
		<a href="/">Back to all people</a>
	</div>
	<h3>${person.firstName} ${person.lastName}</h3><br>
	<label>License Number: </label><p>${person.license.numberToString()}</p><br>
	<label>State: </label><p>${person.license.state}</p><br>
	<label>Expiration Date: </label><p>${person.license.getExpirationDateFormatted()}</p><br>
</div>

</body>
</html>