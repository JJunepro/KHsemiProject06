<link rel="stylesheet" href="css/RecruitMake.css" />
<link rel="stylesheet" href="css/header.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/index.css" />
<title>모임참가방 Page</title>
</head>
<body>
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
							</div>
							<div class="matchPlace">
								<h1 class="txtH w700h">
									<a href="/stadium/3/matches/">송파 천마 풋살파크 C면</a>
								</h1>
								<div class="wtgTool">
									<p class="txt1">서울 송파구 마천동 68-21</p>
									<p id="copy-url1" class="txt1 w400h">
										주소 복사</span>
									<p class="txt1 w400h" id="toggleMap" onclick="showmap()">
										지도 보기</span>
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
									<li>
										<!-- <img src="" alt="몇대몇 매치"> --> <span class="txt">몇대몇
											매치</span>
									</li>
									<li>성별</li>
									<li>필요장비</li>
									<li>총 인원</li>
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
									<li class="noFeature"><img src="#" alt="샤워장"> <span
										class="txt2">샤워장</span></li>
									<li class=""><img src="#" alt="무료주차"> <span
										class="txt2">무료주차</span>
										<p style="font-size: 11px;">사전 등록자 무료 주차</p></li>
									<li class=""><img src="#" alt="풋살화 대여"> <span
										class="txt2">풋살화 대여</span></li>
									<li class="noFeature"><img src="#" alt="운동복 대여"> <span
										class="txt2">운동복 대여</span></li>
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
◈플랩 모든 매치는 현재 매치 중, 이동 시 마스크 필수 착용입니다◈
■풋살장 가는 길: GS25 마천우방점 옆 골목 250미터 직진
■주차 : 주차 사전 미 신청자는 주차가 불가능하며 퇴장 조치 될 수 있습니다. 
■흡연: 흡연구역 외 절대 금연
(흡연구역 외에서 흡연 적발 시 이후 서비스 이용에 제재가 있을 수 있습니다.) 
■풋살화 대여: O (245mm~, 3천 원)</pre>
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
									<li>매치 시작 1시간 30분 전까지 최소 인원(10명) 미달 시 매치가 취소 됩니다. 취소 시
										카카오톡을 통해 안내드리며 캐시는 전액 환급됩니다.</li>
								</ul>
								<ul class="matchRule">
									<h4>특수 (우천)</h4>
									<li>전날 기준 기상청 날씨누리 기준 해당 지역 1mm 이상의 예보가 있는 경우 매치 당일 00시 부터
										환급 기준이 변경 됩니다.</li>
									<li>인원이 모집되는 경우 우천 시에도 진행됩니다.</li>
									<li>진행이 확정되었지만 매치 진행에 변동이 있을 경우 매치 시작 1시간 전까지 안내드립니다.</li>
									<li>매치 시작 1시간 30분 전까지 취소하지 않고 불참하면 페어플레이 포인트가 차감되어 향후 이용에
										제한이 있습니다.</li>
									<li>매치 중 플레이가 어려울 정도로 비가 오는 경우에는 현장에서 매니저 판단하에 종료 될 수 있으며,
										진행되지 않은 시간만큼 부분 환급 처리됩니다.</li>
									<!--<li><strong>기상청 예보 없는 게릴라성 호우로 인한 취소 희망시 카카오톡 채널 '플랩풋볼'을 통해 문의 바랍니다.</strong></li>-->
								</ul>
							</div>
						</section>
					</div>

					<div class="content-right-body_wrap--sticky">
						<div class="section-pc">
							<div class="matchTime">
								<p>2021년 10월 20일 수요일 10:00</p>
							</div>
							<div class="matchPlace">
								<h1 class="txtH w700h">
									<a href="/stadium/3/matches/">송파 천마 풋살파크 C면</a>
								</h1>
								<div class="wtgTool">
									<p class="txt1">서울 송파구 마천동 68-21</p>
									<p id="copy-url2" class="txt1 w400h">
										주소 복사</span>
									<p class="txt1 w400h" id="toggleMap" onclick="showmap()">
										지도 보기</span>
								</div>
							</div>
							<div class="match-info__fee">
								<div class="matchFee">
									<span>참가비</span>
									<p>10,000원</p>
								</div>
							</div>
							

							<div class="match-apply_wrap">
								<div class="btnWrap">
									<a href="#" class="btn-application"
										style="background-color: rgb(53, 52, 165); color: rgb(255, 255, 255);">
										<p>신청하기</p>
									</a>
								</div>
							</div>
							
							<div class="member-list">
								<div class="member">
														
								</div>
							</div>
							
							<div class="chat-area">
								<div class="chat">
														
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<!-- 부트스트랩 참조 영역 -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>

</body>
</html>