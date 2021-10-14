<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><%@ include file="./Header.jsp"%>
	<h1>모집 참가방 생성 Page</h1>
	<%
		// 메인 페이지로 이동했을 때 세션에 값이 담겨있는지 체크
	String userID = null;
	if (session.getAttribute("userID") != null) {
		userID = (String) session.getAttribute("userID");
	}
	%>
	<div class="container">
		<div class="container-body-warp">
			<section class="section-mobile"
				style="border-bottom: 20px solid rgb(238, 238, 238);"></section>


			<div class="match"></div>

			<nav>
				<ul>
					<li>진행 방식</li>
					<li>남은시간</li>
					<li>구장시설</li>
					<li>매치 내용</li>
				</ul>
			</nav>
			<section id="rcRule" class="section">
				<div class="section title">
					<h3>매치내용</h3>
				</div>
				<div class="match">
					<ul>
						<li>
							<!-- <img src="" alt="몇대몇 매치"> --> <span class="txt">몇대몇
								매치</span>
						</li>
						<li>성별</li>
						<li>필요장비</li>
						<li>총 인원</li>
					</ul>
				</div>
				<div class="matchInner">
					<ul class="matchrule">
						<li>실력과 상관없이 누구나 참여하실 수 있습니다.</li>
					</ul>
				</div>
			</section>
			<!-- TODO 남은시간 계산 code 넣기 -->
			<section id="rccontent" class="section">
				<div class="section title">
					<h3>남은 시간</h3>
				</div>
				<div class="matchTime">
					<h2>일 / 시 / 분 / 초 남음</h2>
				</div>
			</section>

			<section id="rcPlace" class="section">
				<div class="section title">
					<h3>운동 시설</h3>
				</div>
				<div class="place">
					<ul>
						<li><span class="txt">샤워장</span></li>
						<li>주차장</li>
						<li>장비 대여</li>
						<li>운동복 대여</li>
					</ul>
				</div>
				<div class="place-detail">
					<h3>Title</h3>
					<p>코로나19로 인해 샤워장을 개방하지 않고 있습니다</p>
				</div>
				<div class="matchInner">
					<ul class="matchUnique">
						<h3>시설 특이사항</h3>
						<pre class="txt">운동 특이사항 삽입</pre>
					</ul>
				</div>
			</section>
			<section class="section">
				<div class="cheifProfile">
					<div class="photoProfile"></div>
					<div class="profileID">
						<span>방장</span>
						<p>
							<!-- TODO 아이디 불러오는 코드 -->
						</p>
					</div>
				</div>
			</section>
			<section id="rccontent" class="section">
				<div class="section title">
					<h3>매치내용</h3>
				</div>
				<div class="match">
					<ul>
						<li><span class="txt">몇대몇 매치</span></li>
						<li>성별</li>
						<li>필요장비</li>
						<li>총 인원</li>
					</ul>
				</div>
				<div class="matchInner">
					<ul class="matchrule">
						<h4>일반</h4>
						<li>
							<!-- TODO 안내 내용 코드 -->
						</li>
					</ul>
				</div>
			</section>
			<div class="container-body-right-warp">
				<div class="section-pc">
					<div class="matchTime">
						<p>2021년 10월 16일 토요일 08:00</p>
					</div>
					<div class="matchPlace">
						<h1 class="txtH w700h">
							<a href="">위치 입력</a>
						</h1>
						<div class="wtgTool">
							<p class="txt1">경기도 구리시 토평동 518-4</p>
							<p id="copy-url" class="txt1 w400h">주소 복사</p>
							<p class="txt1 w400h" id="toggleMap" onclick="showmap()">지도
								보기</p>
						</div>
					</div>
					<div class="match-info__fee">
						<div class="matchFee">
							<span>참가비</span>
							<p>?원</p>
						</div>
					</div>
				</div>

				<div class="match-apply__wrap">
					<div class="btnWrap">
						<a href="" class="btn"
							style="background-color ': matchStatusBackgroundColor, 'color': matchStatusColor">
							<p>신청하기</p> <span>몇 자리남음</span>
						</a>
					</div>
					<div class="chat">
						
					</div>
				</div>
				<!-- 페이징 처리 영역 -->

				<!-- 만들기, 수정, 삭제  버튼 생성 -->
				<a href="RecruitMake.jsp" class="btn btn-primary pull-right">방
					만들기</a> <a href="RecruitModify.jsp" class="btn btn-primary pull-right">방수정</a>
				<a href="RecruitDelete.jsp" class="btn btn-primary pull-right">방
					삭제</a>
			</div>
		</div>
	</div>
</body>
<!-- 부트스트랩 참조 영역 -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.js"></script>

<%@ include file="./Footer.jsp"%>

</body>
</html>