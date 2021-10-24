<link rel="stylesheet" href="css/RecruitMake.css" />
<link rel="stylesheet" href="css/header.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>모집 참가방 생성</title>
</head>
<body>
	<form action="RecruitMakeServlet" method="POST">
		<div class="container">
			<div class="content">
				<div class="content_wrap">
					<div class="content_head">
						<%@ include file="./Header.jsp"%>
					</div>
					<div class="content_body" id="matchDetailApp">
						<div class="content-body_wrap">
							<section class="section-mobile"
								style="border-bottom: 20px solid #eee;">
								<div class="matchTime">
									<p>2021년 10월 20일 수요일 10:00</p>
									<input type="text">
								</div>
								<div class="matchPlace">
									<h1 class="txtH w700h">
										<a href="/stadium/3/matches/">송파 천마 풋살파크 C면</a> <input
											type="text">
									</h1>
									<div class="wtgTool">
										<p class="txt1">서울 송파구 마천동 68-21</p>
										<input type="text">
									</div>
								</div>
								<div class="match-info_fee">
									<div class="matchFee">
										<span>참가비</span>
										<p>10,000원</p>
									</div>
								</div>
							</section>

							<nav class="navigation">
								<ul class="navigation-items">
									<li><a href="#rcRule" class="navigation-item">진행 방식</a></li>
									<li><a href="#rcTime" class="navigation-item">매치 시간</a></li>
									<li><a href="#rcPlace" class="navigation-item">운동 시설</a></li>
									<li><a href="#rcMatch" class="navigation-item">매치 안내</a></li>
								</ul>
							</nav>
							<section id="rcRule" class="section">
								<div class="section-title">
									<h3>진행방식</h3>
								</div>
								<div class="howto">
									<ul>
										<li><br>몇대몇 매치<br> <br> <select
											name="b_match">
												<option value="0">매치형식 아님</option>
												<option value="1">2:2</option>
												<option value="2">3:3</option>
												<option value="3">4:4</option>
												<option value="4">5:5</option>
										</select></li>
										<li><br>성별<br> <br> <select name="b_match">
												<option value="1">ALL</option>
												<option value="2">Man</option>
												<option value="3">Women</option>
										</select></li>
										<li><br>필요장비<br> <br> <select
											name="b_equip">
												<option value="none"></option>
												<option value="0">O</option>
												<option value="1">X</option>
										</select></li>
										<li><br>총 인원<br> <br> <input type="text"
											class="b_total" style="width: 80px"></li>
									</ul>
								</div>
								<div class="stadInner">
									<ul class="matchRule">
										<li>실력과 상관없이 누구나 참여하실 수 있습니다.</li>
									</ul>
								</div>
							</section>
							<section class="section" id="rcTime">
								<div class="section-title">
									<h3>매치</h3>
									<span class="card2__title-label--beta">BETA</span>
								</div>
								<div class="match-levels">
									<div class="match-levels__countdown">
										<h2>[[ countdown ]]</h2>
										<span>경기 시작 시간</span>
									</div>
								</div>
							</section>
							<section id="rcPlace" class="section">
								<div class="section-title">
									<h3>구장 시설</h3>
								</div>
								<div class="howto">
									<ul>
										<li class=""><br> <span class="txt2">샤워장</span><br>
											<br> <select name="b_equip">
												<option value="none"></option>
												<option value="0">O</option>
												<option value="1">X</option>
										</select></li>
										<li class=""><br> <span class="txt2">무료주차</span>
											<p style="font-size: 10px;">사전 등록자 무료 주차</p> <br> <select
											name="b_equip">
												<option value="none"></option>
												<option value="0">O</option>
												<option value="1">X</option>
										</select></li>
										<li class=""><br> <span class="txt2">풋살화 대여</span><br>
											<br> <select name="b_equip">
												<option value="none"></option>
												<option value="0">O</option>
												<option value="1">X</option>
										</select></li>
										<li class="noFeature"><br> <span class="txt2">운동복
												대여</span><br> <br> <select name="b_equip">
												<option value="none"></option>
												<option value="0">O</option>
												<option value="1">X</option>
										</select></li>
									</ul>
								</div>
								<div class="match-detail__notice corona19-shower">
									<h3>🚫샤워실 이용 중단</h3>
									<p>코로나19로 인해 샤워장을 개방하지 않고 있습니다</p>
								</div>
								<div class="stadInner" style="">
									<div class="matchRule">
										<h4>구장 특이사항</h4>
										<pre class="txt2">
											<input type="text">
										</pre>
									</div>
									<!-- <span class="contentAnchor">더 자세한 정보는 <a href="/stadium/3/info/">송파 천마 풋살파크 C면의 시설 정보</a>에서 확인하세요</span> -->
								</div>
							</section>
							<section class="section">
								<div class="mngProf">
									<div class="profPhoto">
										<img src="#">
									</div>
									<div class="profID">
										<span class="txt2">매니저</span>
										<p class="txt5">박윤산</p>
									</div>
								</div>
							</section>

							<section class="section" id="rcMatch">
								<div class="section-title">
									<h3>매치 안내</h3>
								</div>
								<div class="stadInner">
									<ul class="matchRule">
										<h4>일반</h4>
										<li><input type="text"></li>

									</ul>
									<ul class="matchRule">
										<h4>특수 (우천)</h4>
										<li><input type="text"></li>
									</ul>
								</div>
							</section>
						</div>

						<div class="content-right-body_wrap--sticky">
							<div class="section-pc">
								<div class="matchTime">
									<p>방 제목</p>
									<input type="text">
								</div>
								<div class="matchPlace">
									<h1 class="txtH w700h">
										<a href="/stadium/3/matches/">구장 이름</a> <input type="text">
									</h1>
									<div class="wtgTool">
										<p class="txt1">상세 위치</p>
										<input type="text">
									</div>
								</div>
								<div class="match-info__fee">
									<div class="matchFee">
										<span>참가비</span>
										<p>
											<input type="text">
										</p>
									</div>
								</div>

								<div class="match-apply_wrap">
									<div class="btnWrap">
										<a href="#" class="btn-application"
											style="color: rgb(255, 255, 255);">
											<p style="width: 310px; text-align: center;">방 생성하기</p>
										</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
<!-- 부트스트랩 참조 영역 -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

<%@ include file="./Footer.jsp"%>

</body>
</html>