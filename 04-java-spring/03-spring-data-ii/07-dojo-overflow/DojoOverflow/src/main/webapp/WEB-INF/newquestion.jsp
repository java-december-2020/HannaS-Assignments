<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>What is your Question?</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>What is your question?</h1>
<form:form method="POST" action="/questions" modelAttribute="question">
<div class="form-group">
<form:label path="question"/>Question:
<form:errors path="question"/>
<form:input path="question"/>
</div>
<div class="form-group">
<form:label path="tags"/>Tags:
<form:errors path="tags"/>
<form:input path="tags"/>
</div>
<button>Submit</button>
</form:form>

</div>
</body>
</html>