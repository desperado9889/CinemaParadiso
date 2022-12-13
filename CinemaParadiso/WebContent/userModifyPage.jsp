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
	<header>
		<div class="logo">
			<a href="adminPage.jsp">
				<img src="img/logo.png">
			</a>
		</div>
		<div class="nav">
			<ul>
				<li><a href="admin_user.do">Admin</a></li>
				<li><a href="admin_user3.do">User Modify</a></li>
				<li><a href="admin_user2.do">User Delete</a></li>
				<li><a href="">Best</a></li>
				<li><a href="">Reviews</a></li>
				<li><a href="">Forum</a></li>
			</ul>
		</div>
		<div class="user">
			<i class="fas fa-bell"></i>
			<i class="fas fa-search"></i>
			<a href="myPage.jsp"><i class="fas fa-user"></i></a>
			<a href="logout.do" id="log_button">Logout</a>
		</div>
	</header>
	<main>
		<div id="user_search_form">
			<form id="user_tb_form" action=admin_user3.do>
				<input id="search_input"type="text" name="id">
				<button id="search_btn" type="submit" >Search</button>
			</form>
		</div>
		<%
			ArrayList<RegisterDTO> ulist = (ArrayList<RegisterDTO>) session.getAttribute("ulist");
			for(int i=0; i<ulist.size(); i++) {
			RegisterDTO regBean = ulist.get(i);
		%>
		<div id="user_modify_form">
			<form id="user_tb_form" action="modify.do">
				<table id="user_modify_tb">
					<tr id="user_tb">
						<td>ID</td>
						<td><input type="text" name="id" value="<%= regBean.getId()%>"></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="text" name="pw" value="<%= regBean.getPassword() %>"></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" value="<%= regBean.getName() %>"></td>
					</tr>
					<tr>
						<td>Date of Birth</td>
						<td><input type="text" name="date" value="<%= regBean.getDate() %>"></td>
					</tr>
						
				</table>
				<button id="delete_btn" type="submit" >Modify</button>
			</form>
		</div>
		<%} %>
	</main>
</body>
</html>