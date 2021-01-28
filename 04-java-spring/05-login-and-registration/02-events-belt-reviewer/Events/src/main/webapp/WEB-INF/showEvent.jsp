<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
<meta charset="UTF-8">
<title>${event.name}</title>
</head>
<body class="container">
	<h1>${event.name}</h1>
	<label>Host: ${event.host.firstName} ${event.host.lastName }</label>
	<br>
	<label>Date:<fmt:formatDate value="${ event.date }" pattern="MMM dd, yyyy"/></label>
	<br>
	<label>Location: ${event.city}, ${event.state}</label>
	<br>
	<label>People who are attending this event: ${event.attendees.size()}</label>
	<table class="table table-dark">
		<thead>
			<tr>
				<th>Name</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${event.attendees}" var="user">
			<tr>
				<td>${user.firstName} ${user.lastName}</td>
				<td>${user.city }, ${user.state }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
<div>
<br>
	<h3>Message Wall</h3>
	<div>
		<c:forEach items="${event.messages }" var="message">
			<p>${message.user.firstName } says: ${message.content}</p>
		</c:forEach>
	</div>
	<br>
<form action="/comment/${event.id}" method="POST">
	<div class="form-group">
		<label for="content">Add Comment: </label>
		<span>${error }</span>
		<textarea name="content" id="content"></textarea>
		<button class="btn btn-dark">Submit</button>
	</div>
	</form>
</div>
</body>
</html>