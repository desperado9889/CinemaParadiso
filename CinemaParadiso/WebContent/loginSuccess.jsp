<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnLogout").click(function(){
			location.href=
				"<%=request.getContextPath()%>/ch02_servlet/logout.do";
		});
	});
</script>
</head>
<body>
	
	<h1>접속 중인 아이디<%=session.getAttribute("userid") %></h1>
	<h2><%=session.getAttribute("message") %></h2>
	<button type="button" id="btnLogout">로그아웃</button>
</body>
</html>