<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>Add New Song</title>
</head>
<body>
<a href="/dashboard">Dashboard</a>
<div>
	<form:form method="POST" action="/songs/new" modelAttribute="song">
<div class="form-group">
<form:label path="title"/>Title:
<form:errors path="title"/>
<form:input path="title"/>
</div>
<div class="form-group">
<form:label path="artist"/>Artist:
<form:errors path="artist"/>
<form:input path="artist"/>
</div>
<div class="form-group">
<form:label path="rating"/>Rating:
<form:errors path="rating"/>
<form:input path="rating"/>
</div>
<button>Add Song</button>

</form:form>
</div>
</body>
</html>