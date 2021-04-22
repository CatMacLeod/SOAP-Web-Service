<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add employee</title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/skeleton.css">

</head>
<body>
	<div class="container"> 
		<h2>Add Employee</h2>
			<form action="/a00742038_client" method="post">
				<div class="row">
					<div class="u-full-width">
						<label>ID: </label>
						<input type="text" name="id"/>
						<c:if test="${id_violation != null}">
							<c:out value="${id_violation}"/>
						</c:if>
					</div>
				</div>
				<div class="row">
					<div class="u-full-width">
						<label>First Name: </label>
						<input type="text" name="firstName"/>
						<c:if test="${firstName_violation != null}">
							<c:out value="${firstName_violation}"/>
						</c:if>
					</div>
				</div>
				<div class="row">
					<div class="u-full-width">
						<label>Last Name: </label>
						<input type="text" name="lastName"/>
						<c:if test="${lastName_violation != null}">
							<c:out value="${lastName_violation}"/>
						</c:if>
					</div>
				</div>
				<div class="row">
					<div class="u-full-width">
						<label>DOB: </label>
						<input type="text" name="dob"/>
						<c:if test="${dob_violation != null}">
							<c:out value="${dob_violation}"/>
						</c:if>
					</div>
				</div>
				<input type="submit" name="add" value="Add Employees" class="button-primary"/>
				<p>
					<c:if test="${add_code != null}">
						<c:out value="Code: ${add_code}"/><br>
						<c:out value="${add_desc}"/>
					</c:if>
				</p>
			</form>
	</div>	
</body>
</html>