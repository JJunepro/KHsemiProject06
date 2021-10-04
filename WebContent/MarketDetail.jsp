<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/footer.css" />
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
			<div class="content">
				<div class="expContent">
					<h4>컨텐츠 제목</h4>
					<div>
						<p>작성자:홍길동</p>
						<p>가격:52000원</p>
						<p>설명을 적어놓는 칸입니다</p>
					</div>
				</div>
				<div class="reserveContent">
					<button class="sendBtn">쪽지하기</button>
				</div>
			</div>
			<div class="btnBox">
				<Button>
					<a href="http://127.0.0.1:5500/semi/src/market/detailModify.html">수정</a>
				</Button>
				<Button>삭제</Button>
			</div>

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
