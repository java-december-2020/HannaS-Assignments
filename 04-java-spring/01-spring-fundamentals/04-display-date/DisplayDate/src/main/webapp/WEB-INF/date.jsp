<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Date</title>
<link rel="stylesheet" href="CSS/style.css" type="text/css">
<script src="${pageContext.request.contextPath}JavaScript/date.js"></script>
</head>
<body>
<p id="date">Today's date is <c:out value="${now}"/></p>
</body>
</html>