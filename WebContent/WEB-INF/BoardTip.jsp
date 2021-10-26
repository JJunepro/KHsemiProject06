<%@page import="tbh.articlesix.board.board.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Board> volist = (ArrayList<Board>)request.getAttribute("boardvolist");
int startPage = (int) request.getAttribute("startPage");
int endPage = (int) request.getAttribute("endPage");
int pageCount = (int) request.getAttribute("pageCount");
int previous = startPage - 1;
int next = endPage + 1;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/index.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<title>TBH 자유게시판 전체</title>
<style>

* {
  list-style: none;
  text-decoration: none;
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.clearfix:after {
  content: '';
  display: block;
  clear: both;
}
.container {
  width: 80%;
  margin: 0 auto;
}

.nav {
  width: 80%;
  margin: 0 auto;
}

.nav ul li{
	float : left;
	border : 1px solid #ccc;
	text-align : center;
	padding : 0.5em;
	width : 5.5em;
}

.nav ul li:first-child {
	border-radius: 2em 0 0 2em;
}
.nav ul li:last-child {
	border-radius: 0 2em 2em 0;
}

.p1 {
	background : #ccc;
	font-weight : bold;
}

.p1 a {
	color : #4D4D4D;
}

.blind {
  position: absolute;
  overflow: hidden;
  clip: rect(0 0 0 0);
  margin: -1px;
  width: 1px;
  height: 1px;
}

table {
  border-collapse: collapse;
  border-spacing: 0;
}

section.notice {
  padding: 3em 0;
}

.page-title {
  margin-bottom: 2em;
}

.page-title h3 {
  font-size: 28px;
  color: #333333;
  font-weight: 400;
  text-align: center;
}

#board-search .search-window {
  padding: 15px 0;
  background-color: #f9f7f9;
}

#board-search .search-window .search-wrap {
  position: relative;
/*   padding-right: 124px; */
  margin: 0 auto;
  width: 80%;
  max-width: 564px;
}
#board-search .search-window .search-wrap input {
  height: 40px;
  width: 59%;
  font-size: 14px;
  padding: 7px 14px;
  border: 1px solid #ccc;
}
#board-search .search-window .search-wrap input:focus {
  border-color: #333;
  outline: 0;
  border-width: 1px;
}
#board-search .search-window .search-wrap .btn {
  position: absolute;
  right: 0;
  top: 0;
  bottom: 0;
  width: 108px;
  padding: 0;
  font-size: 16px;
}


.select { 
  height: 40px;
  width : 20%;
  text-align : center;
  border-color : #ccc;
}

.board-table {
	font-size: 13px;
	width: 100%;
	border-top: 1px solid #ccc;
	border-bottom: 1px solid #ccc;
}

.board-table a {
	color: #333;
	display: inline-block;
	line-height: 1.4;
	word-break: break-all;
	vertical-align: middle;
}
.board-table a:hover {
  text-decoration: underline;
}
.board-table th {
  text-align: center;
}
.board-table .th-num {
  width: 100px;
  text-align: center;
}

.board-table .th-date {
  width: 200px;
}

.board-table th, .board-table td {
  padding: 14px 0;
}

.board-table tbody td {
  border-top: 1px solid #e7e7e7;
  text-align: center;
}

.board-table tbody th {
  padding-left: 28px;
  padding-right: 14px;
  border-top: 1px solid #e7e7e7;
  text-align: left;
}

.board-table tbody th p{
  display: none;
}

.btn {
  display: inline-block;
  padding: 0 30px;
  font-size: 15px;
  font-weight: 400;
  background: transparent;
  text-align: center;
  white-space: nowrap;
  vertical-align: middle;
  -ms-touch-action: manipulation;
  touch-action: manipulation;
  cursor: pointer;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  border: 1px solid transparent;
  text-transform: uppercase;
  -webkit-border-radius: 0;
  -moz-border-radius: 0;
  border-radius: 0;
  -webkit-transition: all 0.3s;
  -moz-transition: all 0.3s;
  -ms-transition: all 0.3s;
  -o-transition: all 0.3s;
  transition: all 0.3s;
}

.btn-dark {
  background: #555;
  color: #fff;
}

.btn-dark:hover, .btn-dark:focus {
  background: #373737;
  border-color: #373737;
  color: #fff;
}

.towrite {
	margin-top : 0.5 em;
	float : right;
	font-size : 15px;
	font-weight : 400;
 	color: #fff;
 	border : 1px solid #ccc;
 	padding : 10px;
 	
}

.towrite:hover, .towrite:focus {
	background : #eeffdd;
	background-color : #eeffdd;
	color : #fff;
	border : 1px solid #cceed4;
}

.pageController {
	margin : 0 auto;
	padding-top : 1.5em;
	text-align : center;
}

.pageController a {
	display : block;
	display : inline-block;
	margin : 0 3px;
	border : 1px solid #ccc;
	width : 28px;
	height : 28px;
	line-height : 28px;
	background-color : #fff;
	font-size : 13px;
	color : #999999;
}

.pageController a:hover {
	text-weight : bold;
	background-color : #ccc;
	color : #555555;
}

.pageController a:active {
	text-weight : bold;
	color : #aaa;
}
</style>
</head>
<body>
	<%@ include file="./Header.jsp"%>
	<section class="notice">
		<div class="page-title">
			<div class="container">
				<h3>자유게시판 / 운동팁</h3>
			</div>
		</div>
		<div id="board-search">
			<div class="container">
				<div class="search-window">
					<form action="boardlist.do" method="get">
						<div class="search-wrap">
							<select name="search" class="select">
								<option value="0">제목</option>
								<option value="1">내용</option>
							</select>
							<label for="search" class="blind">자유게시판 내용 검색</label>
							<input id="search" type="text" name="item" placeholder="검색어를 입력해주세요." value="">
							<%//TODO %>
							<button type="submit" class="btn btn-dark">검색</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="board-list">
			<div class="container">
				<table class="board-table">
					<thead>
						<tr>
							<th scope="col" class="th-num">번호</th>
							<th scope="col" class="th-title">제목</th>
							<th scope="col"  class="th-writer">작성자</th>
							<th scope="col" class="th-date">등록일</th>
							<th scope="col" class="th-view">조회수</th>
						</tr>
				</thead>
					<%
                		if (volist != null) {
                			for (Board vo : volist) {
                	%>
				<tbody>
					<tr>
						<td><a href="boardcontent?no=<%=vo.getBf_n()%>"><%=vo.getBf_n()%></a>
						</td>
						<td><a href="boardcontent?no=<%=vo.getBf_n()%>"><%=vo.getBf_title()%></a>
						</td>
						<td><a href="boardcontent?no=<%=vo.getBf_n()%>">&#9977;<%=vo.getM_nick()%></a>
						</td>
						<td><a href="boardcontent?no=<%=vo.getBf_n()%>"><%=vo.getBf_timestamp()%></a>
						</td>
						<td><a href="boardcontent?no=<%=vo.getBf_n()%>"><%=vo.getBf_view()%></a>
						</td>
					</tr>
					<%
               				}
               			}
                    %>
				</tbody>
				</table>
				<div class="pageController">
				<%
					if (startPage > 1){
				%>
				<a href="./boardTip?pagenum=<%=previous%>">이전</a>
				<%
					}
						for (int i = startPage; i <= endPage; i++) {
				%>
				<a href="./boardTip?pagenum=<%=i%>"><%=i%></a>
				<%
					if (i != endPage) {
				%>
				<%
					}
				}
				if (endPage < pageCount) {
				%>
					<a href="./boardTip?pagenum=<%=next%>">다음</a>
				<%
				}
				%>
				</div>
				<button class="btn towrite">
				<a href='boardwrite.do'>글쓰기</a>
				</button>
			</div>
		</div>
	</section>
</body>
</html>