<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
<link rel="stylesheet" href="CSS/style.css" type="text/css">
</head>
<body class="wrapper">
<div class="info">
	<form method="POST" name="results" action="/result">
	<label>Your Name: <input class="name" type="text" name="name" placeholder="enter your name"></label>
	<br>
	<label>Dojo Locations: </label>
	<select name="locations" method="GET">
		<option value="San Jose">San Jose</option>
		<option value="Oakland">Oakland</option>
		<option value="Chicago">Chicago</option>
		<option value="LA">LA</option>
		<option value="Tulsa">Tulsa</option>
		<option value="online">Online</option>
	</select>
	<br>
	<label>Favorite Language: </label>
	<select name="languages" method="GET">
		<option value="Python">Python</option>
		<option value="Java">Java</option>
		<option value="Mern">Mern</option>
	</select>
	<br>
	<label>Comment (optional):</label>
	<textarea name="comment" rows="5" cols="45">
	</textarea>
	<button>Button</button>
	</form>
</div>
</body>
</html>