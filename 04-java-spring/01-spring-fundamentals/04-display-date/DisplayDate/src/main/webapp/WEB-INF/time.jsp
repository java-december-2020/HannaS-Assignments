<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Time</title>
<link rel="stylesheet" href="CSS/style.css" type="text/css">
<script src="${pageContext.request.contextPath}JavaScript/time.js"></script>
</head>
<body>
<p id="time">The time right now is <c:out value="${rightNow}"/></p>
</body>
</html>