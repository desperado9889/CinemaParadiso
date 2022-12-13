<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html style="height: 1300px;">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/star.css">
</head>
<body>
	<!-- header -->
	<%@ include file="nav.jsp" %>
	
	<main style="height: 1100px;">
		<body id="mypage_body">
			<div class="warpper">
			  <input class="radio" id="one" name="group" type="radio" checked>
			  <input class="radio" id="two" name="group" type="radio">
			  <input class="radio" id="three" name="group" type="radio">
			  <input class="radio" id="four" name="group" type="radio">
			  <div class="tabs" style="margin-bottom: 0px;">
			  <label class="tab" id="one-tab" for="one"><i class="fa fa-user"></i>Profile</label>
			  <label class="tab" id="two-tab" for="two"><i class="fa fa-list"></i>Modify</label>
			  <label class="tab" id="three-tab" for="three"><i class="fa fa-film"></i>Reviews</label>
			  <label class="tab" id="four-tab" for="four"><i class="fa fa-thumbs-up"></i>Likes</label>
			    </div>
			  <div class="panels">
			  <div class="panel" id="one-panel">
			    <div class="panel-title">Profile</div>
			    <table class="user_info_table">
			    <c:forEach items="${ulist}" var="userInfo">	
					<tr>
						<i class="fas fa-user" style="font-size:100px"></i>
						<td class="user_info_td">ID</td><td style="color: #878787">${userInfo.id}</td>
					</tr>
					<tr>
						<td class="user_info_td">Name</td><td style="color: #878787">${userInfo.name}</td>
					</tr>
					<tr>
						<td class="user_info_td">Date of Birth</td><td style="color: #878787">${userInfo.date}</td>
					</tr>
				</c:forEach>
				</table>
			  </div>
			  <div class="panel" id="two-panel">
			    <div class="panel-title">Modify Password</div>
			    <form action="pmodify.do">
			    	Old password<input type="text" class="modify_input" name="old">
			    	New password<input type="text" class="modify_input" name="new">
			    	<input id="modify_btn" type="submit" value="Modify">
			    </form>
			  </div>
			  <div class="panel" id="three-panel">
			    <div class="panel-title">Review</div>
			    <c:forEach items="${cuList}" var="commentInfo">	
			    <form id="comment_modify" action="reviewmod.do">
			    <table class="user_info_table">
					<tr>
						<td class="user_info_td">Title</td><td style="color: #878787">올빼미</td>
					</tr>
					<tr>	
						<td class="user_info_td">Rating</td><td style="color: #878787">${commentInfo.rating}</td>
					</tr>
					<tr>
						<td class="user_info_td">Comment</td><td style="color: #878787">${commentInfo.comment}</td>
					</tr>	
				</table>

				</form>
				</c:forEach>
			</div>
			  </div>
			  <div class="panel" id="four-panel">
			    <div class="panel-title"></div>
			    <p></p>
			  </div>
			  </div>
			</div>
		</body>
    </main>
    
    <!-- footer -->
	<%@ include file="footer.jsp" %>
</body>
</html>