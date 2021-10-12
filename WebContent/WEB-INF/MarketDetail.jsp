<%@page import="tbh.articlesix.market.vo.Market"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Market> mkList = (ArrayList<Market>) request.getAttribute("mkList");
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
						<li><img src="./img/flower.jpg" alt="" /></li>
						<li><img src="./img/fox.jpg" alt="" /></li>
						<li><img src="./img/lightning.jpg" alt="" /></li>
						<li><img src="./img/moon.jpg" alt="" /></li>
						<li><img src="./img/nature.jpg" alt="" /></li>
						<li><img src="./img/space.jpg" alt="" /></li>
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
					<h4><%=mk.getBmContent() %></h4>
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
			<form action="marketModify" method="GET">
				<input type="submit" value="수정" name="mk"/>
			</form>
				
			</div>
			<%
			}
			}
		%>

			<div class="relatedContent">
				<h4>관련 상품</h4>
				<div class="relatedSlideShow">
					<ul class="relatedSlides">
						<li><img src="./img/flower.jpg" alt="" /></li>
						<li><img src="./img/fox.jpg" alt="" /></li>
						<li><img src="./img/lightning.jpg" alt="" /></li>
						<li><img src="./img/moon.jpg" alt="" /></li>
						<li><img src="./img/nature.jpg" alt="" /></li>
						<li><img src="./img/space.jpg" alt="" /></li>
						<li><img src="./img/flower.jpg" alt="" /></li>
						<li><img src="./img/fox.jpg" alt="" /></li>
						<li><img src="./img/lightning.jpg" alt="" /></li>
						<li><img src="./img/moon.jpg" alt="" /></li>
						<li><img src="./img/nature.jpg" alt="" /></li>
						<li><img src="./img/space.jpg" alt="" /></li>
						<li><img src="./img/flower.jpg" alt="" /></li>
						<li><img src="./img/fox.jpg" alt="" /></li>
						<li><img src="./img/lightning.jpg" alt="" /></li>
						<li><img src="./img/moon.jpg" alt="" /></li>
						<li><img src="./img/nature.jpg" alt="" /></li>
						<li><img src="./img/space.jpg" alt="" /></li>
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
