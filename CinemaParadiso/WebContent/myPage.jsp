<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 1300px;">
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="css/style.css">
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
			  <label class="tab" id="two-tab" for="two"><i class="fa fa-film"></i>Reviews</label>
			  <label class="tab" id="three-tab" for="three"><i class="fa fa-list"></i>Lists</label>
			  <label class="tab" id="four-tab" for="four"><i class="fa fa-thumbs-up"></i>Likes</label>
			    </div>
			  <div class="panels">
			  <div class="panel" id="one-panel">
			    <div class="panel-title">Why Learn CSS?</div>
			    <p>Without CSS, every web page would be drab plain text and images that flowed straight down the page. With CSS, you can add color and background images and change the layout of your page — your web pages can feel like works of art!</p>
			  </div>
			  <div class="panel" id="two-panel">
			    <div class="panel-title">Take-Away Skills</div>
			    <p>You will learn many aspects of styling web pages! You’ll be able to set up the correct file structure, edit text and colors, and create attractive layouts. With these skills, you’ll be able to customize the appearance of your web pages to suit your every need!</p>
			  </div>
			  <div class="panel" id="three-panel">
			    <div class="panel-title">Note on Prerequisites</div>
			    <p>We recommend that you complete Learn HTML before learning CSS.</p>
			  </div>
			  <div class="panel" id="four-panel">
			    <div class="panel-title">Note on Prerequisites</div>
			    <p>We recommend that you complete Learn HTML before learning CSS.</p>
			  </div>
			  </div>
			</div>
		</body>
    </main>
    
    <!-- footer -->
	<%@ include file="footer.jsp" %>
</body>
</html>