<%@page import="com.dm.paradiso.RegisterDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>User Control Page</title>
</head>

<body>

	<!-- header -->
	<%@ include file="nav.jsp" %>
	
	<main>
		<div id="table_div">
			<form id="user_tb_form" action=admin_user3.do>
				<input type="text" name="id">
				<button id="search_btn" type="submit" >Search</button>
			</form>
		</div>
		<%
			ArrayList<RegisterDTO> vlist = (ArrayList<RegisterDTO>) session.getAttribute("vlist");
			for(int i=0; i<vlist.size(); i++) {
			RegisterDTO regBean = vlist.get(i);
		%>
		<div id="table_div">
			<form id="user_tb_form" action="modify.do">
				<table>
					<tr id="user_tb">
						<td>ID</td>
						<td><%= regBean.getId() %></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" name="pw" value="<%= regBean.getPassword() %>"></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><%=regBean.getName() %></td>
					</tr>
					<tr>
						<td>Date of Birth</td>
						<td><input type="text" name="pw" value="<%= regBean.getDate() %>"></td>
					</tr>
						
				</table>
				<button id="delete_btn" type="submit" >Delete</button>
			</form>
		</div>
		<%} %>
	</main>
	
	<!-- footer -->
	<%@ include file="footer.jsp" %>
</body>
</html>