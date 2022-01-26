<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Home</title>
</head>
<body>
	<%
		String name = (String)session.getAttribute("name");
		String role = (String)session.getAttribute("role");
		if(name == null || role == null) {
			response.sendRedirect("login.jsp");
		}
		if(role !=null && !role.equals("user")) {
			response.sendRedirect("login.jsp");
		}
	%>
	<h1>User home page</h1>
</body>
</html>