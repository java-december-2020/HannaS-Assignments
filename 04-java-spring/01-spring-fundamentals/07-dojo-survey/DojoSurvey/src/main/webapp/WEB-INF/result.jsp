<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result</title>
<link rel="stylesheet" href="CSS/style.css" type="text/css">
</head>
<body>
<div class="info">
<c:set var="results" value="${results }"/>
	<h3>Submitted Info</h3>
	<label>Name: <c:out value="${name }"/> </label>
	<br>
	<label>Dojo Location: <c:out value="${locations }"/> </label>
	<br>
	<label>Favorite Language: <c:out value="${languages }"/> </label>
	<br>
	<label>Comment: <c:out value="${comment }"/> </label>
	<br>
	<a href="/"><button>Go Back</button></a>
</div>
</body>
</html>