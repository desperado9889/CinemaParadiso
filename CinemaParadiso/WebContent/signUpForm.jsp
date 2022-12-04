<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 1500px;">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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

	<main>
	    <form id="signup_f" action="signup.do" method="post" accept-charset="UTF-8">
	        <h3>Sign Up</h3>
	        <label>Username</label>
	        <input type="text" placeholder="Email" name="id">
	        <label>Password</label>
	        <input type="password" placeholder="Password" name="password">
	        <label>Your name</label>
			<input type="text" placeholder="Name" name="name">
			<label>Date of birth</label>
			<input type="date" name="date">
	        <button type="submit">Create Account</button>
	    </form>
    </main>
    
   	<!-- footer -->
	<%@ include file="footer.jsp" %>
</body>
</html>