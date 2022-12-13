<%@page import="com.dm.paradiso.CommentDTO"%>
<%@page import="com.dm.crawling.MovieDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 1790px">
<head>
  <meta charset="UTF-8">
  <title>Cinema Paradiso</title>
  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="css/style.scss">
  <link rel="stylesheet" href="css/star.css">
</head>
<body style="background-color: black;">
<%
	ArrayList<MovieDTO> miList = (ArrayList<MovieDTO>) session.getAttribute("miList");
	MovieDTO movieInfo = miList.get(0);
	String avg=(String)session.getAttribute("average");
%>
<!-- header  -->
	<%@ include file="nav.jsp" %>
	<!-- ---- -->
	
	<!-- Top -->
	<div class="movie-card">
  		<div class="container">
			<img src="<%=movieInfo.getPoster()%>" alt="cover" class="cover" style="height: 300px" />
        
    		<div class="hero">
    			
    		</div> <!-- end hero -->
    		<div class="info">
	    		<div class="title" style="color: white;"><%=movieInfo.getTitle()%>
	    			<span class="rating">⭐ <%= avg %></span> <br>
		    		<span class="pg"><%= movieInfo.getPg()%>세 이상</span>
		    		<span class="gen"><%= movieInfo.getGenre()%></span>
		    		<p class="info">감독: <%= movieInfo.getDirector()%></p> <br>
		    		<p class="info">출연진: <%= movieInfo.getCast()%></p><br>
		    		<p class="info">러닝 타임: <%= movieInfo.getRunning_time()%>분</p>
		    		<p class="info">개봉일: <%= movieInfo.getDate() %> &nbsp;/&nbsp;</p>
	    		</div>
    		</div>
		    <div class="description">
	      		<div class="column2">
	      			<p class="aud"><%= movieInfo.getAudience()%></p>
	        		<p class="synop"><%= movieInfo.getSynopsis()%></p>
	        
		      	</div> <!-- end column2 -->
	    	</div> <!-- end description -->
	    	
	    	<!-- rating -->
	    	<div class="form" style="margin-top: 30px">
				<form name="myform" id="myform" method="post" action="Rating.do">
				    <fieldset>
				        <legend>감상평</legend>
				        <input type="radio" name="rating" value="5" id="rate1"><label for="rate1">⭐</label>
				        <input type="radio" name="rating" value="4" id="rate2"><label for="rate2">⭐</label>
				        <input type="radio" name="rating" value="3" id="rate3"><label for="rate3">⭐</label>
				        <input type="radio" name="rating" value="2" id="rate4"><label for="rate4">⭐</label>
				        <input type="radio" name="rating" value="1" id="rate5"><label for="rate5">⭐</label>
				    </fieldset><br>
				    <div class="input_box">
				    <%if(login_ch==null){%> 
						<input type="text" name="comment" id="mycomment" placeholder="로그인 후 감상평을 등록해주세요"><input class="submit" type="submit" value="등록"/> 
						<%}else{%>
						<input type="text" name="comment" id="mycomment" placeholder="별점과 감상평을 등록해주세요"><input class="submit" type="submit" value="등록"/> 	
						<%}%>
					</div>
				</form>
					<%
						ArrayList<CommentDTO> cList = (ArrayList<CommentDTO>) session.getAttribute("cList");
						for(int i=0; i<cList.size(); i++) {
						CommentDTO comment = cList.get(i);
					%>
					<ul class="comment">
						<li class="comment">⭐<%= comment.getRating()%><br>
						<span class="comment"><%= comment.getId()%></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<%= comment.getComment()%><br></li>
					</ul>	
						<%
							}
						%>
			</div> <!-- end rating -->
  		</div> <!-- end container -->
  		
	</div> <!-- end movie-card -->	
	<!-- footer -->
	
	<%@ include file="footer.jsp" %>
</body>
</html>