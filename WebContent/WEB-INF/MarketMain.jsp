<%@page import="tbh.articlesix.market.vo.Market"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Market> mkList = (ArrayList<Market>)request.getAttribute("mkList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/marketMain.css" />
</head>
<body>
	 <%@ include file="./Header.jsp" %>

		<section class="body">
			<div class="searchBox">
				<div>
					<input type="text" id="search" placeholder="찾고 싶은 상품을 입력해주세요" />
					<input type="button" id="searchBtn" value="확인" />
				</div>
				<div>
					<a href="#"><button
							id="searchBtn">추가</button></a>
				</div>
			</div>
			
			<%
				if(mkList != null){
					for(Market no: mkList){
					
			%>
			<div class="slideBox">
				<h3 class="subTitle">오늘의 HOT 아이템!</h3>
				<div id="hotSlideShow">
					<ul class="hotSlides">
						<li><img src="WebContent/WEB-INF/img/flower.jpg" alt="img" />
							<p>
								제목:꽃<br />가격:5600
							</p></li>
						<li><img src="img/fox.jpg" alt="img" />
							<p>
								제목:여우<br />가격:5600
							</p></li>
						<li><img src="img/lightning.jpg" alt="img" />
							<p>
								제목:전구<br />가격:5600
							</p></li>
						<li><img src="img/moon.jpg" alt="img" />
							<p>
								제목:달<br />가격:5600
							</p></li>
						<li><img src="img/nature.jpg" alt="img" />
							<p>
								제목:자연<br />가격:5600
							</p></li>
						<li><img src="img/space.jpg" alt="img" />
							<p>
								제목:우주<br />가격:5600
							</p></li>
						<li><img src="img/flower.jpg" alt="img" />
							<p>
								제목:꽃<br />가격:5600
							</p></li>
						<li><img src="img/fox.jpg" alt="img" />
							<p>
								제목:꽃<br />가격:5600
							</p></li>
						<li><img src="img/lightning.jpg" alt="img" />
							<p>
								제목:꽃<br />가격:5600
							</p></li>
						<li><img src="img/moon.jpg" alt="img" />
							<p>
								제목:꽃<br />가격:5600
							</p></li>
					</ul>
				</div>
				<p class="hotcontroller">
					<span class="hotPrev">&lang;</span> <span class="hotNext">&rang;</span>
				</p>
			</div>
			
			<%
			}
			}%>


			<%
				if(mkList != null){
					for(Market no: mkList){
					
			%>
			<div class="listBox">
				<ul class="listContent">
					<li>
						<a href="#"><img src="img/flower.jpg" alt="img" /></a>
						<h5><%=no.getBmTitle() %></h5>
						<p><%=no.getBmContent() %></p>
					</li>
				</ul>
			</div>
			<%
			}
			}%>
		</section>
 <%@ include file="./Footer.jsp" %>
		

			<script src="js/marketMain.js"></script>
			<script src="js/header.js"></script></body>
</html>
