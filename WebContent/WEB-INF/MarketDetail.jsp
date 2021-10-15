<%@page import="tbh.articlesix.market.service.MarketService"%>
<%@page import="tbh.articlesix.market.vo.Market"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Market> mkList = (ArrayList<Market>) request.getAttribute("mkList");
	ArrayList<Market> searchList = (ArrayList<Market>) request.getAttribute("searchList");
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
<link rel="stylesheet" href="./css/marketDetail.css" />
</head>
<body>
	 <%@ include file="./Header.jsp" %>
		<section class="body">
			<div class="slideBox">
				<div id="slideShow">
					<ul class="slides">
					<%
			if (mkList != null) {
				for (Market mk : mkList) {
			%>
						<li><img src="<%=mk.getImgScr() %>" alt="test" /></li>
					  	<!--<li><img src="./img/fox.jpg" alt="" /></li>
						<li><img src="./img/lightning.jpg" alt="" /></li>
						<li><img src="./img/moon.jpg" alt="" /></li>
						<li><img src="./img/nature.jpg" alt="" /></li>
						<li><img src="./img/space.jpg" alt="" /></li>-->
						<%
			}
			}
		%>
					</ul>
					<p class="controller">
						<span class="prev">&lang;</span> <span class="next">&rang;</span>
					</p>
				</div>
			</div>
			<%
			if (mkList != null) {
				for (Market mk : mkList) {
			%>
			<div class="content">
				<div class="expContent">
					<h4><%=mk.getBmTitle() %></h4>
					<div>
						<p>작성자:<%=mk.getmId() %></p>
						<p>가격:<%=mk.getPrice() %></p>
						<p><%=mk.getBmContent() %></p>
					</div>
				</div>
				<div class="reserveContent">
					<button class="sendBtn">쪽지하기</button>
				</div>
			</div>
			<div class="btnBox">
			<a href="marketModify?no=<%=mk.getBmN()%>"><button>수정</button></a>
			<a href="marketDelete?no=<%=mk.getBmN()%>"><button>삭제</button></a>
			</div>
			<%
			}
			}
		%>
			
			<div class="relatedContent">
				<h4>관련 상품</h4>
				<div class="relatedSlideShow">
					<ul class="relatedSlides">
					<%
			if (searchList != null) {
				for (Market mk : searchList) {
			%><a href="marketDetail?no=<%=mk.getBmN()%>&title=<%=mk.getBmTitle()%>">
						<li>
							<img src="<%=mk.getImgScr() %>" alt="img" />
							<p><%=mk.getBmTitle() %></p>
						</li>
						</a>
						<%
			}
			}
		%>
					</ul>
				</div>
				<p class="relatedController">
					<span class="relatedPrev">&lang;</span> <span class="relatedNext">&rang;</span>
				</p>
			</div>
		</section>

		 <%@ include file="./Footer.jsp" %>

			<script src="./js/marketDetail.js"></script>
			<script src="./js/header.js"></script></body>
</html>
