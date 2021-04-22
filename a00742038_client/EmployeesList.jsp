<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="ca.bcit.comp3656.a00742038.assignment1.types.Employee"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/normalize.css">
	<link rel="stylesheet" href="css/skeleton.css">	
<title>Employee List</title>
</head>
<body>
	<div class="contain">
		<h2>List Employees</h2>
		<display:table name="empList" 
			id="emp" 
			pagesize="5" 
			requestURI="/" 
			decorator="ca.bcit.comp3656.a00742038.assignment1.controller.MyTableDecorator">
				<display:setProperty name="paging.banner.placement" value="bottom"/>
				<display:column property="id" title="ID"/>
				<display:column property="firstName" sortable="true" title="First Name"/>
				<display:column property="lastName" title="Last Name"/>
				<display:column property="dob" sortable="true" title="DOB" />
		</display:table>
	</div>
	
</body>
</html>