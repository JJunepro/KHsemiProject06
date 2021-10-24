<%@page import="tbh.articlesix.board.recruit.model.vo.Recruit"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Recruit> rclist = (ArrayList<Recruit>) request.getAttribute("rclist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<!-- <link rel="stylesheet" href="css/RecruitShortList.css" /> -->
</head>
<body>
	<%@ include file="./Header.jsp"%>
	<section class="recruitShortLsit">
		<div class="page-title">
			<div class="container">
				<h3>모집방 단기</h3>
				<div id="board-search">
					<div class="container">

						<!-- TODO 검색기능 구현
						<div class="search-window">
							<form action="">
								<div class="search-wrap">
									<label for="search" class="blind">모집방 List 내용 검색</label> <input
										id="search" type="search" name="" placeholder="검색어를 입력해주세요."
										value="">
										// TODO 내용 검색

									<button type="submit" class="btn btn-dark">검색</button>
								</div>
							</form>
						</div>
						 -->
					</div>
				</div>
				<div id="recruit-list">
					<div class="container">
						<table class="recruit-table">
							<thead>
								<tr>
									<th>
										<!-- TODO 여러개 삭제 체크박스 기능 추가 
									<input type="checkbox" name="chk" value=""</th>
									-->
									<th id="adminlist" scope="col" class="b-num">번호</th>
									<th id="adminlist" scope="col" class="b-title">제목</th>
									<th id="adminlist" scope="col" class="b-category">카테고리</th>
									<th id="adminlist" scope="col" class="b-category">작성자</th>
									<th id="adminlist" scope="col" class="b-place">위치</th>
									<th id="adminlist" scope="col" class="b-date">날짜</th>
									<th id="adminlist" scope="col" class="b-total">총인원</th>
									<th id="adminlist" scope="col" class="b-timestamp">등록일</th>
									<th id="adminlist" scope="col" class="b-view">조회수</th>
								</tr>
							</thead>
							<%
								if (rclist != null) {
								for (Recruit rc : rclist) {
							%>
							<tbody>
								<tr>
									<td><a href="recruitroom?no=<%=rc.getB_n()%>"><%=rc.getB_n()%></a>
									</td>
									<td><a href="recruitroom?no=<%=rc.getB_n()%>"><%=rc.getB_title()%></a>
									</td>
									<td><a href="recruitroom?no=<%=rc.getB_n()%>"><%=rc.getCa_n()%></a>
									</td>
									<td><a href="recruitroom?no=<%=rc.getB_n()%>"><%=rc.getM_id()%></a>
									</td>
									<td><a href="recruitroom?no=<%=rc.getB_n()%>"><%=rc.getB_place()%></a>
									</td>
									<td><a href="recruitroom?no=<%=rc.getB_n()%>"><%=rc.getB_start()%></a>
										<a href="recruitroom?no=<%=rc.getB_n()%>"><%=rc.getB_end()%></a>
									</td>
									<td><a href="recruitroom?no=<%=rc.getB_n()%>"><%=rc.getB_total()%></a>
									</td>
									<td><a href="recruitroom?no=<%=rc.getB_n()%>"><%=rc.getB_timestamp()%></a>
									</td>
									<td><a href="recruitroom?no=<%=rc.getB_n()%>"><%=rc.getB_view()%></a>
									</td>
								</tr>
								<%
									}
								}
								%>
							</tbody>
						</table>
						<br>
					<!-- 만들기, 수정, 삭제  버튼 생성 -->
					<a href="RecruitMake.jsp" class="btn btn-primary pull-right">방 만들기</a>
					<a href="RecruitModify.jsp" class="btn btn-primary pull-right">방 수정</a>
					<a href="RecruitDelete.jsp" class="btn btn-primary pull-right">방 삭제</a>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>