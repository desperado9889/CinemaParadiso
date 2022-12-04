<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, com.dm.paradiso.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>회원 목록</h1>
<%
	ArrayList<RegisterDTO> vlist = (ArrayList<RegisterDTO>) session.getAttribute("vlist");
	for(int i=0; i<vlist.size(); i++) {
		RegisterDTO regBean = vlist.get(i);
		out.println(regBean.getId() + ",");
		out.println(regBean.getPassword()+ ",");
		out.println(regBean.getName()+ ",");
		out.println(regBean.getDate()+ "<br>");
	}
%>
</body>
</html>