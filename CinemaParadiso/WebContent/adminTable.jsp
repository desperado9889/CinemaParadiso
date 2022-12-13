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
		<div id="table_div">
			<table id="user_table">
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
</body>
</html>