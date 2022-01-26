<%@page import="com.ty.hospital.dto.Encounter"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="staffnavbar.jsp"%>
	<%
		List<Encounter> encounters = (List<Encounter>)request.getAttribute("encounterList");
	%>
	<table>
		<tr>
			<td>ID</td>
			<td>Reason</td>
			<td>Date Time</td>
			<td>Created by</td>
		</tr>
		<%
			for(Encounter encounter : encounters) {
				
				%>
					<tr>
						<td><%=encounter.getId() %></td>
						<td><%=encounter.getReason() %></td>
						<td><%=encounter.getAdmitDateTime() %>
						<td><%=encounter.getCreatorName() %></td>
					</tr>
				
				<%
			}
		
		%>
	
	</table>
	
</body>
</html>