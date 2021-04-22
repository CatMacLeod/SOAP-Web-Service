<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="ca.bcit.comp3656.a00742038.assignment1.types.Employee"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/skeleton.css">	
	<title>Find Employee</title>
</head>
<body>
	<div class="container">
			<form action="/a00742038_client" method="post">
				<h2>Find An Employee By ID</h2>
				<div class="row">
					<label>	ID: </label>
					<input type="text" name="searchID">
				</div>
				<input type="submit" name="find" value="Search" class="button-primary"/>	
			</form>
			
			<c:if test="${find_name != null}">
				<c:out value="${find_name}"/>
			</c:if>
			<br>
			<c:if test="${find_code != null}">
				<c:out value="Code: ${find_code}"/><br>
				<c:out value="${find_desc}"/>
			</c:if>	
	</div>
</body>
</html>