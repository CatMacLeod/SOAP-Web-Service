<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>	
	<link rel="stylesheet" type="text/css" href="css/normalize.css">
	<link rel="stylesheet" type="text/css" href="css/skeleton.css">
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="eight columns"><jsp:include flush="true" page='EmployeesList.jsp'/></div>
			<div class="four columns"><jsp:include flush="true" page='FindEmployee.jsp'/></div>	
		</div>
			<c:if test="${pageContext.request.remoteUser == 'admin'}">
		<div class="row">
			<div class="eight columns"><jsp:include flush="true" page='AddEmployee.jsp'/></div>
			<div class="four columns"><jsp:include flush="true" page='DeleteEmployee.jsp'/></div>
		</div>
			</c:if>
		<div class="four columns offset-by-eight"><jsp:include flush="false" page='Logout.jsp'/></div>
	</div>
</body>
</html>
