<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/RecruitAdminList.css" />

<%@page import="tbh.articlesix.board.recruit.model.vo.Recruit"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Recruit> rclist = (ArrayList<Recruit>) request.getAttribute("rclist");
int startPage = (int) request.getAttribute("startPage");
int endPage = (int) request.getAttribute("endPage");
int pageCount = (int) request.getAttribute("pageCount");

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
	<section class="RecruitAdminList">
		<div class="page-title">
			<div class="container">
				<h3>모집방 (관리자) List page</h3>
				<br>
			</div>
			<div id="recruit-list">
				<div class="container">
					<table class="recruit-table">
						<thead>
							<tr>
								<th scope="col" class="b-num" style="background-color: #eeeeee; text-align: center; height: 30px;">번호</th>
								<th scope="col" class="b-title" style="background-color: #eeeeee; text-align: center;">제목</th>
								<th scope="col" class="b-category" style="background-color: #eeeeee; text-align: center;">카테고리</th>
								<th scope="col" class="b-writer" style="background-color: #eeeeee; text-align: center;">작성자</th>
								<th scope="col" class="b-place" style="background-color: #eeeeee; text-align: center;">위치</th>
								<th scope="col" class="b-date" style="background-color: #eeeeee; text-align: center;">시작일</th>
								<th scope="col" class="b-date" style="background-color: #eeeeee; text-align: center;">종료일</th>
								<th scope="col" class="b-total" style="background-color: #eeeeee; text-align: center;">총인원</th>
								<th scope="col" class="b-timestamp" style="background-color: #eeeeee; text-align: center;">등록일</th>
								<th scope="col" class="b-view" style="background-color: #eeeeee; text-align: center;">조회수</th>
							</tr>
						</thead>
						<%
							if (rclist != null) {
							for (Recruit rc : rclist) {
						%>
						<tbody>
							<tr>
								<td><a href="./RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_n()%></a>
								</td>
								<td><a href="./RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_title()%></a>
								</td>
								<td><a href="./RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getCa_n()%></a>
								</td>
								<td><a href="./RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getM_id()%></a></td>
								<td><a href="./RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_place()%></a></td>
								<td><a href="./RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_start()%></a></td>
								<td><a href="./RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_end()%></a></td>
								<td><a href="./RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_total()%></a></td>
								<td><a href="./RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_timestamp()%></a></td>
								<td><a href="./RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_view()%></a></td>
							</tr>
							<%
								}
							}
							%>
						</tbody>
					</table>
				<div class="pageBox">
					<%
						if (startPage > 1) {
					%><a href="./RecruitAdminList?pagenum=" <%=startPage%>>이전</a>
					<%
						}
					for (int i = startPage; i <= endPage; i++) {
					%>
					<a href="./RecruitAdminList?pagenum=<%=i%>"><%=i%></a>
					<%
						if (i != endPage) {
					%>
					<%
						}
					}
					if (endPage < pageCount) {
					%><a href="./RecruitAdminList?pagenum=" <%=endPage%>>다음</a>
					<%
						}
					%>
					<br>
					<button class="btn towrite">
						<a href="RecruitMake">방 만들기</a>
					</button>
				</div>
			</div>
		</div>
	</section>
</body>
</html>