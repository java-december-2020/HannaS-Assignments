<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>${question.question}</title> 
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script> 
<script src="/webjars/bootstrap/4.5.2/js/bootstrap.min.js"></script> 
<link rel="stylesheet" type="text/css" href="/css/styles.css">
</head>
<body>
<div class="container">
	<h1>${question.question}</h1>
	<h5>Tags:</h5>
	<ul>
	<c:forEach items="${question.tags}" var="tag">
	<li>${tag.subject}</li>
	</c:forEach>
	</ul>
	<table class="table table-dark">
	<thead>
	<tr>
	<th>Answers</th>
	</tr>
	</thead>
	<tbody>
	<tr>
	<c:forEach items="${question.answers}" var="answer">
	<td>${answer.answer}</td>
	</c:forEach>
	</tr>
	</tbody>
	</table>
	
	<h5>Add Your Answer:</h5>
	<form:form action="/answers" method="POST" modelAttribute="answers">
	<div class="form-group">
	<form:label path="answer"/>Answer:
	<form:errors path="answer"/>
	<form:textarea class="form-control" path="answer"/>
	</div>
	<form:hidden path="question" value="${question.id}"/>
	<button>Answer it!</button>
	</form:form>
</div>
</body>
</html>