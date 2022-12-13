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
		<h1 id="admin_title">관리자 페이지</h1>
	</main>
</body>
</html>