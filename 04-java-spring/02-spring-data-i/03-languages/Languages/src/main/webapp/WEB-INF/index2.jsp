<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<title>Welcome To Languages.com</title>
</head>
<div class="container">
<h1>Welcome to Languages.com</h1>
<table class="table table-dark">
<thead>
<tr>
<th>Name</th>
<th>Creator</th>
<th>Version</th>
<th>Action</th>
</tr>
</thead>
<tbody>
<c:forEach items="${allLangs}" var="langs">
<tr>
<td><a href="languages/${langs.id}">${langs.name}</a></td>
<td>${langs.creator }</td>
<td>${langs.version }</td>
<td><a href="/languages/edit/${langs.id}">Edit</a> <a href="/languages/delete/${langs.id}">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<div>
	<form:form method="POST" action="/languages" modelAttribute="language">
<div class="form-group">
<form:label path="name"/>Name:
<form:errors path="name"/>
<form:input path="name"/>
</div>
<div class="form-group">
<form:label path="creator"/>Creator:
<form:errors path="creator"/>
<form:input path="creator"/>
</div>
<div class="form-group">
<form:label path="version"/>Version:
<form:errors path="version"/>
<form:input path="version"/>
</div>
<button>Add New Language</button>

</form:form>
</div>
</body>
</html>