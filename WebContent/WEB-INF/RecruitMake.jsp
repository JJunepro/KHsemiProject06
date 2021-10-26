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
	<form action="RecruitMake.jsp" method="POST" id="frm">
		<div class="container">
			<div class="content">
				<div class="content_wrap">
					<div class="content_head">
						<%@ include file="./Header.jsp"%>
					</div>
					<div class="content_body" id="matchDetailApp">
						<div class="content-body_wrap">
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
											name="b_match" id="b_match">
												<option value="Y">O</option>
												<option value="N">X</option>
										</select></li>
										<li><br>성별<br> <br> <select id="b_gender"
											name="b_gender">
												<option value="A">ALL</option>
												<option value="M">Man</option>
												<option value="W">Women</option>
										</select></li>
										<li><br>필요장비<br> <br> <select
											name="b_equip" id="b_equip">
												<option value="Y">O</option>
												<option value="N">X</option>
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
												<option value="Y">O</option>
												<option value="N">X</option>
										</select></li>
										<li class=""><br> <span class="txt2">무료주차</span>
											<p style="font-size: 10px;">사전 등록자 무료 주차</p> <br> <select
											name="b_equip">
												<option value="Y">O</option>
												<option value="N">X</option>
										</select></li>
										<li class=""><br> <span class="txt2">풋살화 대여</span><br>
											<br> <select name="b_equip">
												<option value="Y">O</option>
												<option value="N">X</option>
										</select></li>
										<li class=""><br> <span class="txt2">운동복 대여</span><br>
											<br> <select name="b_equip">
												<option value="none"></option>
												<option value="0">O</option>
												<option value="1">X</option>
										</select></li>
									</ul>
								</div>
								<div class="match-detail__notice corona19-shower">
									<h3>🚫샤워실 이용 자제</h3>
									<p>코로나19로 인해 샤워장 이용을 삼가하여주시기 바랍니다.</p>
								</div>
								<div class="stadInner" style="">
									<div class="matchRule">
										<h4>구장 특이사항</h4>
										<textarea name="b_facility" rows="8" cols="100%"></textarea>
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
										<textarea name="b_content" rows="8" cols="100%"></textarea>
									</ul>
								</div>
							</section>

							<section class="section">
								<div class="mngProf">
									<div class="profID">
										<span class="txt2">방장</span>
										<p class="txt5"></p>
									</div>
								</div>
							</section>
						</div>

						<div class="content-right-body_wrap--sticky">
							<div class="section-pc">
								<table>
									<tr>
										<td>방 제목 :</td>
										<td><input type="text" class="textBox" id="b_title"
											name="b_title"></td>
									</tr>
									<tr>
										<td>모집현황 :</td>
										<td><select name="b_type">
												<option value="none"></option>
												<option value="1">모집중</option>
												<option value="2">모집 대기중</option>
										</select></td>
									</tr>
									<tr>
										<td>운동종류 :</td>
										<td><select name="ca_n">
												<option value="none"></option>
												<option value="1">축구</option>
												<option value="2">농구</option>
												<option value="3">야구</option>
												<option value="4">족구</option>
												<option value="5">배드민턴</option>
												<option value="6">테니스</option>
												<option value="7">헬스</option>
												<option value="8">런닝</option>
												<option value="9">필라테스</option>
												<option value="10">요가</option>
										</select></td>
									</tr>
									<tr>
										<td>장소 :</td>
										<td><input type="text" id="b_place"></td>
									</tr>
									<tr>
										<td>참가비 :</td>
										<td><input type="text" id="b_fee"></td>
									</tr>
								</table>
							</div>

							<div class="match-apply_wrap">
								<div class="btnWrap">

									<input id="submit" type="submit" class="btn-application"
										value="방 생성하기"
										style="background-color: #00ff0000 color: rgb(255, 255, 255background-color : #00ff0000 color : rgb(255, 255, 255)); width: 310px; text-align: center;">

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>

<%@ include file="./Footer.jsp"%>
</html>