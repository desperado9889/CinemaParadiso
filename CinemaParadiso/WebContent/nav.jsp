<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String login_ch=(String)session.getAttribute("user_login");
%>
<html>
<head>
<meta charset="UTF-8">
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
	<header>
		<div class="logo">
			<a href="posterSelect.do">
				<img src="img/logo.png">
			</a>
		</div>
		<div class="nav">
			<ul style="margin-right: 0px">
				<li><a href="">Film</a></li>
				<li><a href="">Best</a></li>
				<li><a href="">Reviews</a></li>
				<li><a href="">Forum</a></li>
			</ul>
		</div>
		<div class="user">
			<i class="fas fa-bell"></i>
			<i class="fas fa-search"></i>
			<% if (login_ch==null){ %>
			<a href="loginForm.jsp" id="log_button">Login</a>
			<% } else {%>
			<a href="myPage.do" id="my_page"><i class="fas fa-user"></i></a>
			<a href="logout.do" id="log_button">Logout</a>
			<% }%>
		</div>
	</header>
</body>
</html>