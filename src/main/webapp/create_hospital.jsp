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
	<div class="row">
		<div class="column"></div>
		<div class="column">
			<form action="createhospital" method="post">
				<div class="container">
					<h1 align="center">Create Hospital</h1>
					
					<hr>
					<label><b>Name</b></label> <input type="text" name="name">
					<label><b>Website</b></label> <input type="text" name="website">
					<label><b>GST number</b></label> <input type="text" name="gst">


					<button type="submit" class="registerbtn">Create</button>
				</div>
			</form>
		</div>
		<div class="column"></div>
	</div>

</body>
</html>