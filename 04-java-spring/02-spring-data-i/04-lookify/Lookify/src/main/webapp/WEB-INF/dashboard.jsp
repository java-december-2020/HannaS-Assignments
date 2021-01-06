<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Lookify Dashboard</title>
</head>
<body>
<a href="/songs/new">Add New</a>
<a href="/search/topten">Top Songs</a>
<form action="songs/search" class="float-right">
				<input type="text" name="artist"/>
				<button class="btn btn-primary">Search Artists</button>
			</form>

<div class="container">
<table class="table table-dark">
<thead>
<tr>
<th>Title</th>
<th>Rating</th>
<th>Actions</th>

</tr>
</thead>
<tbody>
<c:forEach items="${allSongs}" var="song">
<tr>
<td>${song.title }</td>
<td>${song.rating }</td>
<td><a href="/delete/${song.id}">Delete</a></td>

</tr>
</c:forEach>
</tbody>
</table>
</div>

</body>
</html>