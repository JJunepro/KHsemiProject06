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
<title>모집 참가방 생성 Page</title>
</head>
<body>
	<form action="RecruitMake" method="POST">
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
								<table>
									<tr>
										<td>방 제목 :</td>
										<td><input type="text"></td>
									</tr>
									<tr>
										<td>운동종류 :</td>
										<td><select name="b_type">
												<option value="none"></option>
												<option value="0">축구</option>
												<option value="1">농구</option>
												<option value="2">야구</option>
												<option value="3">족구</option>
												<option value="4">배드민턴</option>
												<option value="5">테니스</option>
												<option value="6">헬스</option>
												<option value="7">런닝</option>
												<option value="8">필라테스</option>
												<option value="9">요가</option>
										</select></td>
									</tr>
									<tr>
										<td>장소 :</td>
										<td><input type="text"></td>
									</tr>
									<tr>
										<td>상세 위치 :</td>
										<td><input type="text"></td>
									</tr>
									<tr>
										<td>참가비 :</td>
										<td><input type="text"></td>
									</tr>
								</table>
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
										<li><br>운동 매치여부<br> <br> <select
											name="b_match">
												<option value="0">매치형식 아님</option>
												<option value="1">매치임</option>
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
									<h3>매치 시간</h3>
								</div>
								<div class="match-levels">
									<div>
										<h2>운동 날짜</h2>
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
										<textarea rows="8" cols="100%"></textarea>
									</div>
									<!-- <span class="contentAnchor">더 자세한 정보는 <a href="/stadium/3/info/">송파 천마 풋살파크 C면의 시설 정보</a>에서 확인하세요</span> -->
								</div>
							</section>

							<section class="section" id="rcMatch">
								<div class="section-title">
									<h3>매치 안내</h3>
								</div>
								<div class="stadInner">
									<ul class="matchRule">
										<h4>일반</h4>
										<textarea rows="8" cols="100%"></textarea>
									</ul>
								</div>
							</section>

							<section class="section">
								<div class="mngProf">
									<div class="profID">
										<span class="txt2">방장</span>
										<p class="txt5">방장이름</p>
									</div>
								</div>
							</section>
						</div>

						<div class="content-right-body_wrap--sticky">
							<div class="section-pc">
								<table>
									<tr>
										<td>방 제목 :</td>
										<td><input type="text"></td>
									</tr>
									<tr>
										<td>운동종류 :</td>
										<td><select name="b_type">
												<option value="none"></option>
												<option value="0">축구</option>
												<option value="1">농구</option>
												<option value="2">야구</option>
												<option value="3">족구</option>
												<option value="4">배드민턴</option>
												<option value="5">테니스</option>
												<option value="6">헬스</option>
												<option value="7">런닝</option>
												<option value="8">필라테스</option>
												<option value="9">요가</option>
										</select></td>
									</tr>
									<tr>
										<td>장소 :</td>
										<td><input type="text"></td>
									</tr>
									<tr>
										<td>상세 위치 :</td>
										<td><input type="text"></td>
									</tr>
									<tr>
										<td>참가비 :</td>
										<td><input type="text"></td>
									</tr>
								</table>
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


</body>

<%@ include file="./Footer.jsp"%>
</html>