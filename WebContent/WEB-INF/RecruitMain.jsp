<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="css/reservationMain.css" />

<%@page import="tbh.articlesix.board.recruit.model.vo.Recruit"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Recruit> rclist = (ArrayList<Recruit>) request.getAttribute("rclist");

int startPage = Integer.parseInt(request.getAttribute("startPage").toString());
int endPage = Integer.parseInt(request.getAttribute("endPage").toString());
int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>모집방 Main Page</title>
</head>
<body>
	<%@ include file="./Header.jsp"%>

	<section class="body">
		<div class="imageTool">
			<div class="imageRoom">
				<ul>
					<a href="http://www.naver.com"><li></li></a>
					<a href="http://www.naver.com"><li></li></a>
					<a href="http://www.naver.com"><li></li></a>
					<a href="http://www.naver.com"><li></li></a>
				</ul>
			</div>
		</div>
		<div class="dateBox">
			<ul class="date">
				<li>월</li>
				<li>화</li>
				<li>수</li>
				<li>목</li>
				<li>금</li>
				<li>토</li>
				<li>일</li>
			</ul>
		</div>
		<div class="areaBox">
			<ul class="area">
				<li>서울</li>
				<li>경기</li>
				<li>인천</li>
				<li>강원</li>
				<li>충북</li>
				<li>충남</li>
			</ul>
		</div>
		<div class="exerBox">
			<ul class="exer">
				<li>헬스</li>
				<li>필라테스</li>
				<li>크로스핏</li>
				<li>mma</li>
				<li>축구</li>
				<li>농구</li>
			</ul>
		</div>
	</section>
	<form action="post">
		<section class="recruitMain">
			<%
				if (rclist != null) {
				for (Recruit rc : rclist) {
			%>
			<a href="<%=rc.getB_n()%>"> <!-- 클릭 시 링크 설정 -->
				<div class="card">
					<!-- 카드 헤더 -->
					<!-- 이미지 넣고 크기 조절하기 -->
					<div class="card-header">
						<div class="card-header-is_closed">
							<div class="card-header-text">모집중</div>
							<div class="card-header-number">2 / 5</div>
						</div>
					</div>
					<!--  카드 바디 -->
					<div class="card-body">
						<!--  카드 바디 헤더 -->
						<div class="card-body-header">
							<h1>
								4월 15일 순천만 동행구해요!<%=rc.getB_title()%></h1>
							<p class="card-body-hashtag">
								#여수 #순천 #광양<%=rc.getCa_n()%></p>
							<p class="card-body-nickname">
								작성자:
								<%=rc.getM_id()%></p>
						</div>
						<p class="card-body-description">안녕하세요! 4월 15일 순천만 동행구합니다!</p>
						<!--  카드 바디 본문 -->
						<!--  카드 바디 푸터 -->
						<div class="card-body-footer">
							<hr
								style="margin-bottom: 8px; opacity: 0.5; border-color: #EF5A31">
							<i class="icon icon-view_count"></i>조회 38회<%=rc.getB_view()%>
							<i class="icon icon-comments_count"></i>댓글 4개 <i class="reg_date">
								2018/04/12 <%=rc.getB_timestamp()%></i>
						</div>
					</div>
				</div> <%
 	}
 }
 %>
		</section>
		<div class="pageBox"></div>
		<%
			int currentPage = 1;
		if (startPage > 1)
		%><a href="marketMain">이전</a>
		<%
			for (int i = startPage; i <= endPage; i++) {
		%>
		<a href="marketMain?pagenum=<%=i%>"><%=i%></a>
		<%
			currentPage = i;
		if (i != endPage) {
		%>
		<%
			}
		}

		if (endPage < pageCount)
		%><a href="marketMain">다음</a>
		<%
			
		%>
	</form>
	<%@ include file="./Footer.jsp"%>
	<script src="js/header.js"></script>
</body>
</html>
