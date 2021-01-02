<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Book</title>
</head>
<body>
<p><c:out value="${book.title}"/></p>
<p><c:out value="${book.description}"/></p>
<p><c:out value="${book.language}"/></p>
<p><c:out value="${book.numberOfPages}"/></p>
</body>
</html>