<%@page import="com.dm.paradiso.CommentDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="user_table">
					
				<%
					ArrayList<CommentDTO> vlist = (ArrayList<CommentDTO>) session.getAttribute("cuList");
					for(int i=0; i<vlist.size(); i++) {
					CommentDTO regBean = vlist.get(i);
				%>
				<tr>
					<td><%= regBean.getId()%></td>
					<td><%= regBean.getRating()%></td>
					<td><%= regBean.getComment()%></td>
					<td><%= regBean.getMovie_code()%></td>
				</tr>
				<%
					}
				%>
	</table>
</body>
</html>