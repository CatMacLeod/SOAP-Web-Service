<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error handler</title>
</head>
<body>
	
	
	<c:if test="${pageContext.response.status == 404}">
		<h1 style="color:red">File Not Found</h1>
	</c:if>
	<c:if test="${pageContext.response.status == 403}">
		<h1 style="color:red">Access is Forbidden</h1>
	</c:if>
	<c:if test="${pageContext.response.status == 500}">
		<h1 style="color:red">Internal Server Error</h1>
	</c:if>
	
	<h2>To return home go to: <a href="/a00742038_client">Home</a></h2>
</body>
</html>