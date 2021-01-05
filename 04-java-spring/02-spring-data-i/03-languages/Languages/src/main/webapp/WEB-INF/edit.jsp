<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head> <meta charset="ISO-8859-1"> 
<title>${lang.name}</title>  
<link rel="stylesheet" type="text/css" href="/css/style1.css">
 </head>
<body>
<div class="container">
	<div id="delete">
		<a href="/languages/delete/${lang.id}">Delete</a>
		<a href="/languages" id="dashboard">Dashboard</a>
	</div>
	
<form:form method="POST" action="/languages/edit/${id}" modelAttribute="language">
  <div class="form-group">
    <form:label path="name">Name
    <form:errors path="name"></form:errors>
    <form:input path="name"/>
    </form:label>
  </div>
  <div class="form-group">
    <form:label path="creator">Creator
    <form:errors path="creator"></form:errors>
    <form:input path="creator"/>
    </form:label>
  </div>
  <div class="form-group">
    <form:label path="version">Version
    <form:errors path="version"></form:errors>
    <form:input path="version"/>
    </form:label>
  </div>
  <button >Submit</button>
</form:form>

</div>
</body>
</html>