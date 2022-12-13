<%@page import="com.dm.crawling.MovieDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 1500px">
<head>
  <meta charset="UTF-8">
  <title>Cinema Paradiso</title>
  <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/bulma@0.9.3/css/bulma.min.css'>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
  <link rel="stylesheet" href="css/style.css">
</head>
<body>
	<!-- header  -->
	<%@ include file="nav.jsp" %>
	<!-- ---- -->
	
	<!-- Top -->
	<%
	ArrayList<MovieDTO> vlist = (ArrayList<MovieDTO>) session.getAttribute("vlist");
	ArrayList<String> url= new ArrayList<>();
	ArrayList<String> code= new ArrayList<>();
	for(int i=0; i<vlist.size(); i++) {
		MovieDTO regBean = vlist.get(i);
		url.add(regBean.getPoster());
		code.add(regBean.getMovie_code());
	}%>
	

	<main>
		<div class="container">
			<div class="columns is-multiline p-0 pt-6 last" style="margin-top: 0px; align-content: center; justify-content: center;">
				<div class="column is-full">
					<p id="title_m">| <span class="title_text">Top box office</span></p>
				</div>
				<div class="column is-one-quarter">
					<a href="infoSelect.do">
						<img src="<%= url.get(0)%>" alt="<%=code.get(0) %>">
					</a>
				</div>
				<div class="column is-one-quarter">
					<a href="infoSelect.do">
						<img src="<%= url.get(1)%>" alt="<%=code.get(1) %>">
					</a>
				</div>
				<div class="column is-one-quarter">
					<a href="infoSelect.do">
						<img src="<%= url.get(2)%>" alt="<%=code.get(2) %>">
					</a>
				</div>
				<div class="column is-one-quarter">
					<a href="infoSelect.do">
						<img src="<%= url.get(3)%>" alt="<%=code.get(3) %>">
					</a>
				</div>
				<div class="column is-one-quarter">
					<a href="infoSelect.do">
						<img src="<%= url.get(4)%>" alt="<%=code.get(4) %>">
					</a>
				</div>
				
			</div>
			<div class="columns last" style="justify-content: center;">
				<div class="column is-one-quarter">
					<a href="infoSelect.do">
						<img src="<%= url.get(5)%>" alt="<%=code.get(5) %>">
					</a>
				</div>
				<div class="column is-one-quarter">
					<a href="infoSelect.do">
						<img src="<%= url.get(6)%>" alt="<%=code.get(6) %>">
					</a>
				</div>
				<div class="column is-one-quarter">
					<a href="infoSelect.do">
						<img src="<%= url.get(7)%>" alt="<%=code.get(7) %>">
					</a>
				</div>
				<div class="column is-one-quarter">
					<a href="infoSelect.do">
						<img src="<%= url.get(8)%>" alt="<%=code.get(8) %>">
					</a>
				</div>
				<div class="column is-one-quarter">
					<a href="infoSelect.do">
						<img src="<%= url.get(9)%>" alt="<%=code.get(9) %>">
					</a>
				</div>
			</div>
		<!-- ---- -->
		
		<!-- forum -->
		<section>
		<div class="forum">
		<div class="ink_widget">

		<div class="w_title">
			<h3><a href="">|<span class="title_text"> Best</span></a></h3>
		</div>
		<div class="w_list wn">
			<ul>
				<li class="page1 active">
					<ul class="list_unit list_unit0">
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"> <span class="list_main">
								<a class="title_link">1. 영화 &lt;터미널&gt; 리뷰</a>
								<a class="cmt_num" href="">4</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">2. 마지막 국화 이야기 (1939) 참 희한한 영화. 스포일러 있음.</a>
								<a class="cmt_num" href="">2</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">3. 영화 &lt;데시벨&gt; 무대인사 직찍...</a>
								<a class="cmt_num updated" href="">13</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">4. 오린의 발라드 (1977) 이런 영화를 걸작이라 부르지 않으면 ...</a>
								<a class="cmt_num" href="">3</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">5. ※스포※ 생에 단 한 번 뿐일 축복, 혹은 저주 - &lt;헤어질 결심...</a>
								<a class="cmt_num" href="">7</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">6. 마블 페이즈4에 대한 작품별 간단 코멘트와 개인적인 생각(...</a>
								<a class="cmt_num" href="">17</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">7. [위플래쉬 인 콘서트]공연 관람 후기</a>
								<a class="cmt_num" href="">16</a></span><span class="list_info"></span>
							</div>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		</div>
		</div>
		<div class="forum">
		<div class="ink_widget">

		<div class="w_title">
			<h3><a href="">|<span class="title_text"> Reviews</span></a></h3>
		</div>
		<div class="w_list wn">
			<ul>
				<li class="page1 active">
					<ul class="list_unit list_unit0">
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"> <span class="list_main">
								<a class="title_link">1. 영화 &lt;터미널&gt; 리뷰</a>
								<a class="cmt_num" href="">4</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">2. 마지막 국화 이야기 (1939) 참 희한한 영화. 스포일러 있음.</a>
								<a class="cmt_num" href="">2</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">3. 영화 &lt;데시벨&gt; 무대인사 직찍...</a>
								<a class="cmt_num updated" href="">13</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">4. 오린의 발라드 (1977) 이런 영화를 걸작이라 부르지 않으면 ...</a>
								<a class="cmt_num" href="">3</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">5. ※스포※ 생에 단 한 번 뿐일 축복, 혹은 저주 - &lt;헤어질 결심...</a>
								<a class="cmt_num" href="">7</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">6. 마블 페이즈4에 대한 작품별 간단 코멘트와 개인적인 생각(...</a>
								<a class="cmt_num" href="">17</a></span><span class="list_info"></span>
							</div>
						</li>
						<li class="has_rankB">
							<div class="list_main_wrap clearfix"><span class="list_main">
								<a class="title_link">7. [위플래쉬 인 콘서트]공연 관람 후기</a>
								<a class="cmt_num" href="">16</a></span><span class="list_info"></span>
							</div>
						</li>
					</ul>
				</li>
			</ul>
		</div>
		</div>
		</div>
		</section>
		</div>
		<!-- ----- -->	
	</main>
	
	<!-- footer -->
	
	<%@ include file="footer.jsp" %>
</body>
</html>