<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="css/register_form.css">
</head>
<body>
	<div class="row">
		<div class="column"></div>
		<div class="column">
			<form action="login" method="post">
				<div class="container">
					<h1 align="center">Login</h1>
					
					<hr>
					<label><b>Email</b></label> <input type="text" name="email">
					<label><b>Password</b></label> <input type="password" name="password">
					<button type="submit" class="registerbtn">Login</button>
				</div>
			</form>
		</div>
		<div class="column"></div>
	</div>

</body>
</html>