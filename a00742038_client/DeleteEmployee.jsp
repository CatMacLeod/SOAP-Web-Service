<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete Employee</title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/skeleton.css">

</head>
<body>
	<div class="container">
		<h2>Delete an Employee</h2>
		<form action="/a00742038_client" method="post">
		<div class="row">
			<label>ID: </label>
			<input type="text" name="deleteID"/>
			<c:if test="${delete_violation != null}">
				<c:out value="${delete_violation}"/>
			</c:if>
		</div>
			<input type="submit" name="delete" value="Delete" class="button-primary"/>
		</form>
		
		<p><c:if test="${delete_code != null}">
			<c:out value="Code: ${delete_code}"/><br>
			<c:out value="${delete_desc}"/>
		</c:if></p>
	</div>
</body>
</html>