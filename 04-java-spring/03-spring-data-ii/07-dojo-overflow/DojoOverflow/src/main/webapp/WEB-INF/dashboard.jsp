<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Questions Dashboard</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h1>Questions Dashboard</h1>
<table class="table table-dark">
<thead>
<tr>
<th>Question</th>
<th>Tags</th>
</tr>
</thead>
<tbody>


<c:forEach items="${allQuestions}" var="question">
<tr>
<td><a href="/${question.id}">${question.question}</a></td>
<c:forEach items="${question.tags}" var="tag">
<td>${tag.subject}</td>
</c:forEach>
</tr>
</c:forEach>
</tbody>
</table>
<a href="/questions/new">New Question</a>
</div>
</body>
</html>