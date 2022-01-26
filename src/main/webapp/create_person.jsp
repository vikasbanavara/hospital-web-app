<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Person</title>
<link rel="stylesheet" href="css/register_form.css">
</head>
<body>

<!-- hihi -->

<%@ include file="staffnavbar.jsp" %>
	<div class="row">
		<div class="column"></div>
		<div class="column">
			<form action="createperson" method="post">
				<div class="container">
					<h1 align="center">Create Person</h1>
					
					<hr>
					<label><b>Name</b></label> <input type="text" name="name">
					<label><b>Email</b></label> <input type="text" name="email">
					<label><b>Phone</b></label> <input type="number" name="phone">
					<label><b>Age</b></label> <input type="number" name="age">
					<label><b>Gender</b></label> &nbsp;&nbsp; Male <input type="radio"
						name="gender" value="male"> &nbsp;&nbsp; Female <input
						type="radio" name="gender" value="female">


					<button type="submit" class="registerbtn">Register</button>
				</div>
			</form>
		</div>
		<div class="column"></div>
	</div>

</body>
</html>