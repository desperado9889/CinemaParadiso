<%@page import="com.dm.paradiso.RegisterDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Admin Page</title>
</head>

<body>

	<!-- header -->
	<%@ include file="nav.jsp" %>
	
	<main>
		<div id="table_div">
			<table>
				<tr id="user_tb">
					<th>num</th><th>Id</th><th>Password</th><th>Name</th><th>Date of birth</th>
				</tr>
				
			<%
				ArrayList<RegisterDTO> vlist = (ArrayList<RegisterDTO>) session.getAttribute("vlist");
				for(int i=0; i<vlist.size(); i++) {
				RegisterDTO regBean = vlist.get(i);
			%>
			<tr>
				<td><%= i%></td>
				<td><%= regBean.getId()%></td>
				<td><%= regBean.getPassword()%></td>
				<td><%= regBean.getName()%></td>
				<td><%= regBean.getDate()%></td>
			</tr>
			<%
				}
			%>
			</table>
		</div>
	</main>
	
	<!-- footer -->
	<%@ include file="footer.jsp" %>
</body>
</html>