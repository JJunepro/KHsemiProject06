<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>모집방 수정</title>
</head>
<body>
	<%@ include file="./Header.jsp"%>
	<h1>모집방 수정 Page</h1>
	
	<form action="KHsemiProject06/RecruitMakeServlet" method="POST">
		<div class="container">
			<div class="container-body-warp">
				<section class="section-mobile"
					style="border-bottom: 20px solid rgb(238, 238, 238);"></section>
				<div class="recruit-match"></div>
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
					<div class="rcMatch">
						<ul>
							<li>
								<!-- <img src="" alt="몇대몇 매치"> --> 
								<span class="txt">몇 대 몇 매치</span> <input type="text" name="b_match">
							</li>
							<li>성별<input type="text" name="b_gender"></li>
							<li>필요장비<input type="text" name="b_equip"></li>
							<li>총 인원<input type="text" name="b_total"></li>
						</ul>
					</div>
					<div class="matchInner">
						<ul class="matchrule">
							<li></li>
						</ul>
					</div>
				</section>
				<!-- TODO 남은시간 계산 code 넣기 -->
				<section id="rcTime" class="section">
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
							<li><span class="txt">샤워장</span><input type="text" name="b_shower"></li>
							<li>주차장<input type="text" name="b_parking"></li>
							<li>장비 대여<input type="text" name="b_rental"></li>
							<li>운동복 대여<input type="text" name="b_cloth"></li>
						</ul>
					</div>
					<div class="place-detail">
						<h3>Title</h3>
						<p>코로나19로 인해 샤워장을 개방하지 않고 있습니다</p>
					</div>
					<div class="matchInner">
						<ul class="matchUnique">
							<h3>시설 특이사항</h3>
							<pre class="txt">운동 특이사항 삽입
							<input type="text" name="b_facility">
							</pre>
						</ul>
					</div>
				</section>
				<section id="rcContent" class="section">
					<div class="section title">
						<h3>매치내용</h3>
					</div>
					<div class="match">
						<ul>
							<li><input type="text" name="b_content"></li>
						</ul>
					</div>
					<div class="matchInner">
						<ul class="matchcontent">
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
							<p><input type="text" name="b_start"><br>
							<input type="text" name="b_end"></p>
						</div>
						<div class="matchPlace">
							<h1 class="txtH w700h">
								<input type="text" name="b_type">
								<input type="text" name="b_title">
							</h1>
							<div class="wtgTool">
								<p class="txt1">
									<input type="text" name="b_place">
								</p>
								<p id="copy-url" class="txt1 w400h">주소 복사</p>
								<p class="txt1 w400h" id="toggleMap" onclick="showmap()">지도
									보기</p>
							</div>
						</div>
						<div class="match-info__fee">
							<div class="matchFee">
								<span>참가비</span>
								<p><input type="text" name="b_fee">원</p>
							</div>
						</div>
					</div>

					<div class="match-apply__wrap">
						<div class="btnWrap">
							<a href="#" class="btn" style="background-color ': matchStatusBackgroundColor, 'color': matchStatusColor">
								<!-- TODO 몇 명 남았는지 코드 입력 -->
								<p>신청하기</p> <span>몇 자리남음</span>
							</a>
						</div>
					</div>
					<!-- 페이징 처리 영역 -->

					<!-- 만들기, 수정, 삭제  버튼 생성 -->
					<a href="RecruitMake.jsp" class="btn btn-primary pull-right">방 만들기</a>
					<a href="RecruitModify.jsp" class="btn btn-primary pull-right">방 수정</a>
					<a href="RecruitDelete.jsp" class="btn btn-primary pull-right">방 삭제</a>
				</div>
			</div>
		</div>
	</form>

</body>
<%@ include file="./Footer.jsp"%>
</body>
</html>