<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="height: 1300px;">
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="preconnect" href="https://fonts.gstatic.com">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
<link rel="stylesheet" href="css/style.css">
<style media="screen">
*,
*:before,
*:after{
    padding: 0;
    margin: 0;
    box-sizing: border-box;
}
</style>
</head>
<body>
	<!-- header -->
	<%@ include file="nav.jsp" %>
	
	<main style="height: 1100px">
	    <div class="background">
	        <div class="shape"></div>
	        <div class="shape"></div>
	    </div>
	    <form id="login_f"action="login.do" method="post" accept-charset="UTF-8">
	        <h3>Log In</h3>
	        <label for="username">Username</label>
	        <input type="text" placeholder="Email" name="id">
	
	        <label for="password">Password</label>
	        <input type="password" placeholder="Password" name="password">
	
	        <button type="submit">Log In</button>
	        <p id="signup_l">New to Cinema Paradiso?<a href="signUpForm.jsp">Sign Up</a></p> 
	    </form>
    </main>
    <footer>
		<div>
			<a>
				<img id="logo_f" src="img/logo.png" width="130" height="90" alt="Logo">
			</a>
			<div id="text_f">Copyright© Cinema Paradiso All rights reserved.</div>
		</div>
	</footer>
</body>
</html>