<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script>
		alert('로그인을 실패하였습니다. ID/PW를 재 확인해 주세요');
		location.replace('index.jsp');
	</script>
<span style="color: red;">${param.message}</span>
</body>
</html>