<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>
<div class="container">
		<h2>New Product</h2>
		<form:form action="/products/new" method="POST" modelAttribute="product">
			<div class="form-group">
		        <form:label path="name">Name: </form:label>
		        <form:errors path="name"/>
		        <form:input class="form-control" path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="description">Description: </form:label>
		        <form:errors path="description"/>
		        <form:input type="description" class="form-control" path="description"/>
		    </div>
		    <div class="form-group">
		        <form:label path="price">Price: </form:label>
		        <form:errors path="price"/>
		        <form:input type="price" class="form-control" path="price"/>
		    </div>
		    <button>Create</button>
		</form:form>
	</div>
</body>
</html>