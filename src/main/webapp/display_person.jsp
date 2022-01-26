<%@page import="com.ty.hospital.dto.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Person</title>
<link rel="stylesheet" href="css/table.css">
</head>
<body>
	<%@ include file="staffnavbar.jsp"%>

	<%
		List<Person> persons = (List<Person>) request.getAttribute("personsList");
	%>

	<div style="padding-top: 2%">
		<table id="customers">

		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Gender</th>
			<th>Age</th>
			<th>Create Encounter</th>
			<th>View Encounter</th>
		</tr>
			<%
				for(Person person : persons) {
				%>
				<tr>
				<td><%= person.getId() %></td>
				<td><%= person.getName() %></td>
				<td><%= person.getEmail() %></td>
				<td><%= person.getPhone() %></td>
				<td><%= person.getGender() %></td>
				<td><%= person.getAge() %></td>
				<td><a href="create_encounter.jsp?personid=<%=person.getId()%>">Create</a></td>
				<td><a href="getencounters">View</a></td>
				</tr>	
			<%	}
			%>

	</table>
	</div>

</body>
</html>