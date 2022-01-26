<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Encounter</title>
<link rel="stylesheet" href="css/register_form.css">
</head>
<body>
<%
	String id = request.getParameter("personid");

%>
	<%@ include file="staffnavbar.jsp"%>
	
	<div class="row">
		<div class="column"></div>
		<div class="column">
			<form action="createhospital" method="post">
				<div class="container">
					<h1 align="center">Create Encounter</h1>
					
					<hr>
					<label><b>Person ID</b></label> <input type="text" value="<%=id%>" name="personid" readonly="readonly">
					<label><b>Admit Date Time</b></label> <input type="datetime-local" name="admitDateTime">
					<label><b>Reason</b></label> <input type="text" name="reason">


					<button type="submit" class="registerbtn">Create</button>
				</div>
			</form>
		</div>
		<div class="column"></div>
	</div>
	
</body>
</html>