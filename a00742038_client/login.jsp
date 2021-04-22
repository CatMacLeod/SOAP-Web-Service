<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/normalize.css">
<link rel="stylesheet" href="css/skeleton.css">

</head>
<body>
	<div class="container">
		<h1>LOGIN</h1>
		<h2>Sorry, you must log in before accessing this resource.</h2>
		<form action="j_security_check" method="post">
			<div class="row">
				<div class="six columns">
					<label>Username: </label> 
					<input type="text" name="j_username">
				</div>
			</div>
			<div class="row">
				<div class="six columns">
					<label>Password: </label>
					<input type="text" name="j_password">
				</div>
			</div>	
			<input type="submit" value="Login" class="button-primary">
		</form>
	</div>
</body>
</html>