<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="UTF-8">
<title>All Categories</title>
</head>
<body>
<div class="container">
<h1>Categories</h1>
<table class="table table-dark">
<tbody>
<c:forEach items="${allCategories}" var="category">
<tr>
<td><a href="/categories/${category.id}">${category.name}</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<br>
<h5><a href="/categories/new">Create New Category</a></h5>
</div>
</body>
</html>