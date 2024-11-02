<%@page import="com.ssw.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Student Login Successful</h2>
	<%
		User use = (User) request.getAttribute("data");
		// Student list = (Student) request.getAttribute("data");
	%>
	<div align="center">
		<form name="myForm">
			<table border="5px" cellspacing="50px">
				<thead>
					<tr>

						<th>UserID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>UserName</th>
						<th>Password</th>
						
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=use.getUid()%></td>
						<td><%=use.getName()%></td>
						<td><%=use.getEmail()%></td>
						<td><%=use.getMobile()%></td>
						<td><%=use.getUsername()%></td>
						<td><%=use.getPassword()%></td>
					</tr>
					<%
						
					%>
				</tbody>
			</table>
			
	</div>
</body>
</html>