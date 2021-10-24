<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/RecruitAdminList.css" />

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
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>T.B.H 모집방 (관리자) page</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="./Header.jsp"%>
	<section class="recruitAdminList">
		<div class="page-title">
			<div class="container">
				<h3>모집방 (관리자) List page</h3>
				<div id="board-search">
					<div class="container">

						<!-- TODO 검색기능 구현-->
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
						<button class="btn towrite">
							<a href="#">방 만들기</a>
						</button>
						
					</div>
				</div>
			</div>
		</div>
		<div class="pageBox">
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
		</div>
	</section>
	<br>
	<!-- 페이징 처리 영역 -->
	<script src="./js/header.js"></script>


</body>
</html>