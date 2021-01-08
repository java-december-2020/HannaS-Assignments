<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="UTF-8">
<title>New Person</title>
</head>
<body>
<div class="container">
<h1>New Person</h1>
<div>
<form:form method="POST" action="/persons/new" modelAttribute="person">
<div class="form-group">
<form:label path="firstName"/> First Name: 
<form:errors path="firstName"/> 
<form:input path="firstName"/>
</div>
<div class="form-group">
<form:label path="lastName"/> Last Name: 
<form:errors path="lastName"/> 
<form:input path="lastName"/>
</div>
<button>Create</button>
</form:form>
</div>
</div>
</body>
</html>