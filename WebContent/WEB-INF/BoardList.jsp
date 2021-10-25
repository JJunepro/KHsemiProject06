<%@page import="tbh.articlesix.board.board.vo.Board"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Board> volist = (ArrayList<Board>) request.getAttribute("boardvolist");
ArrayList<Board> volist2 = (ArrayList<Board>) request.getAttribute("boardvolist2");
ArrayList<Board> volist3 = (ArrayList<Board>) request.getAttribute("boardvolist3");
ArrayList<Board> volist4 = (ArrayList<Board>) request.getAttribute("boardvolist4");
ArrayList<Board> volist5 = (ArrayList<Board>) request.getAttribute("boardvolist5");
ArrayList<Board> volist6 = (ArrayList<Board>) request.getAttribute("boardvolist6");
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
<title>T.B.H 자유게시판</title>
<style>
        * {
            list-style: none;
            text-decoration: none;
            padding: 0;
            margin: 0;
            box-sizing: border-box;
        }

        .container {
            width : 80%;
            margin : 0 auto;
            
        }
        .aside {
        	width : 15%;
            float : left;
            height : 960px;
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
		  width: 44%;
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
		  width: 88px;
		  padding: 0;
		  font-size: 16px;
		}
		
		.select {
		  height: 40px;
		  width : 20%;
		  text-align : center;
		  border-color : #ccc;
		}
		
		.aside h3 {
			border : 1px solid #ccc;
		}
		
		.aside ol {
			counter-reset: li;
			list-style: none;
			*list-style: decimal;
			font-size: 12px;
			padding: 0;
			margin-bottom: 10em;
			text-align : center;
		}
		
        .aside ol li {
        	margin: 0 0 0 2em;
        	margin-bottom : 10em;
        }
        
        .aside a {
        	position: relative;
			display: block;
			padding: .4em .4em .4em 2em;
			*padding: .4em;
			margin: .5em 0;
			background: #93C775;
			color: #000;
			text-decoration: none;
			-moz-border-radius: .3em;
			-webkit-border-radius: .3em;
			border-radius: 10em;
			transition: all .2s ease-in-out;
		}	
        .aside a:hover{
		background: #d6d4d4;
		text-decoration:none;
		transform: scale(1.1);
		}
		
		.aside a:before{
		content: counter(li);
		counter-increment: li;
		position: absolute;
		left: -1.3em;
		top: 50%;
		margin-top: -1.3em;
		background:#93C775;
		height: 2em;
		width: 2em;
		line-height: 2em;
		border: .3em solid #fff;
		text-align: center;
		font-weight: bold;
		-moz-border-radius: 2em;
		-webkit-border-radius: 2em;
		border-radius: 2em;
		color:#FFF;
		}
        .content-box {
            width: 100%;
            height: 800px;
            text-align: center;
        }

        .list-wrap {
            width: 80%;
            height: 15em;
            display: inline-block;
            margin : 0 auto;
            text-align: center;
            margin-top : 1em;
        }
        .list-search {
            width: 80%;
            height: 6em;
            display: inline-block;
            margin : 0 auto;
            text-align: center;
        	margin-top : 3em;
            margin-bottom : 1em;
        }

        .left-list {
            float : left;
            width : 49%;

        }
        .right-list {
            float : right;
            width : 49%;
        }
        .list-title {
            text-align : center;
        }
        .more {
            float : right;
        }
        .blind {
		  position: absolute;
		  overflow: hidden;
		  clip: rect(0 0 0 0);
		  margin: -1px;
		  width: 1px;
		  height: 1px;
		}
        .list-table {
            clear : both;
            margin : 0 auto;
            width : 100%;
            border-top: 1px solid #ccc;

        }
        .list-table a {
			color: #333;
			display: inline-block;
			line-height: 1.4;
			word-break: break-all;
			vertical-align: middle;
		}
		
		.list-table a:hover {
		  text-decoration: underline;
		}
		
		.list-table th {
		  text-align: center;
		}
		.list-table .th-num {
		  width: 100px;
		  text-align: center;
		}
		
		.list-table .th-date {
		  width: 200px;
		}
		
		.list-table th, .list-table td {
		  padding: 3px 0;
		}
		
		.list-table tbody td {
		  border-top: 1px solid #e7e7e7;
		  text-align: center;
		}
		
		.list-table tbody th {
		  padding-left: 28px;
		  padding-right: 14px;
		  border-top: 1px solid #e7e7e7;
		  text-align: left;
		}
		
		.list-table tbody th p{
		  display: none;
		}
    </style>
</head>
<body>
	<%@ include file="./Header.jsp"%>
    <div class="container">
        <div class="content-box">
            <div class="aside">
            	<h2>게시판리스트</h2>
                <ol>
                    <li><a href="<%=request.getContextPath() %>/boardAll">전체보기</a></li>
                    <li><a href="<%=request.getContextPath() %>/boardHello">가입인사</a></li>
                    <li><a href="<%=request.getContextPath() %>/boardEvent">이벤트</a></li>
                    <li><a href="<%=request.getContextPath() %>/boardChat">수다</a></li>
                    <li><a href="<%=request.getContextPath() %>/boardTip">운동팁</a></li>
                    <li><a href="<%=request.getContextPath() %>/boardMeet">동네 소개/홍보</a></li>
                </ol>
            </div>
            <section class="list-search">
            <div id="board-search">
            	<div class="search-window">
					<form action="boardlist.do" method="get">
						<div class="search-wrap">
							<select name="type" class="select">
								<option value="제목">제목</option>
								<option value="내용">내용</option>
								<option value="제목+내용">제목+내용</option>
							</select>
							<label for="search" class="blind">자유게시판 내용 검색</label>
							<input id="search" type="search" name="search" placeholder="검색어를 입력해주세요." value="">
							<%//TODO %>
							<button type="submit" class="btn btn-dark">검색</button>
						</div>
					</form>
				</div>
				<h2>각 게시판 기준 조회수가 높은 5개의 글이 보여집니다.</h2>
			</div>
            </section>
            <section class="list-wrap">
                <article class="left-list">
                    <h3 class="list-title">전체</h3>
                    <a href="<%=request.getContextPath() %>/boardAll" class="more">더보기+</a>
                    <table class="list-table">
                        <thead>
                            <th>제목</th>
                            <th>날짜</th>
                            <th>조회수</th>
                        </thead>
                        <%
                		if (volist != null) {
                			for (Board vo : volist) {
                		%>
                        <tr>
                            <td><a href="boardcontent?no=<%=vo.getBf_n()%>"><%=vo.getBf_title()%></a></td>
                            <td><a href="boardcontent?no=<%=vo.getBf_n()%>"><%=vo.getBf_content()%></a></td>
                            <td><a href="boardcontent?no=<%=vo.getBf_n()%>"><%=vo.getBf_view()%></a></td>
                           </tr>
                            <%
               				}
               			}
                    	%>
                    </table>
                </article>
                <article class="right-list">
                    <h3 class="list-title">가입인사</h3>
                    <a href="<%=request.getContextPath() %>/boardHello" class="more">더보기+</a>
                    <table class="list-table">
                        <thead>
                            <th>제목</th>
                            <th>날짜</th>
                            <th>조회수</th>
                        </thead>
                        <%
                		if (volist2 != null) {
                			for (Board vo2 : volist2) {
                		%>
                        <tr>
                            <td><a href="boardcontent?no=<%=vo2.getBf_n()%>"><%=vo2.getBf_title()%></a></td>
                            <td><a href="boardcontent?no=<%=vo2.getBf_n()%>"><%=vo2.getBf_content()%></a></td>
                            <td><a href="boardcontent?no=<%=vo2.getBf_n()%>"><%=vo2.getBf_view()%></a></td>
                        </tr>
                        <%
               				}
               			}
                    	%>
                    </table>
                </article>
            </section>
            <section class="list-wrap">
                <article class="left-list">
                    <h3 class="list-title">이벤트</h3>
                    <a href="<%=request.getContextPath() %>/boardEvent" class="more">더보기+</a>
                    <table class="list-table">
                        <thead>
	                        <tr>
	                            <th>제목</th>
	                            <th>날짜</th>
	                            <th>조회수</th>
                            </tr>
                        </thead>
                        <%
                		if (volist3 != null) {
                			for (Board vo3 : volist3) {
                		%>
                        <tbody>
	                        <tr>
	                            <td><a href="boardcontent?no=<%=vo3.getBf_n()%>"><%=vo3.getBf_title()%></a></td>
	                            <td><a href="boardcontent?no=<%=vo3.getBf_n()%>"><%=vo3.getBf_content()%></a></td>
	                            <td><a href="boardcontent?no=<%=vo3.getBf_n()%>"><%=vo3.getBf_view()%></a></td>
	                        </tr>
	                        <%
               				}
               			}
                    	%>
                        </tbody>
                        
                    </table>
                </article>
                <article class="right-list">
                    <h3 class="list-title">수다</h3>
                    <a href="<%=request.getContextPath() %>/boardChat" class="more">더보기+</a>
                    <table class="list-table">
                        <thead>
                            <th>제목</th>
                            <th>날짜</th>
                            <th>조회수</th>
                        </thead>
                        <%
                		if (volist4 != null) {
                			for (Board vo4 : volist4) {
                		%>
                        <tr>
                            <td><a href="boardcontent?no=<%=vo4.getBf_n()%>"><%=vo4.getBf_title()%></a></td>
                            <td><a href="boardcontent?no=<%=vo4.getBf_n()%>"><%=vo4.getBf_content()%></a></td>
                            <td><a href="boardcontent?no=<%=vo4.getBf_n()%>"><%=vo4.getBf_view()%></a></td>
                        </tr>
                     	<%
               				}
               			}
                    	%>
                        
                    </table>
                </article>
            </section>
            <section class="list-wrap">
                <article class="left-list">
                    <h3 class="list-title">운동팁</h3>
                    <a href="<%=request.getContextPath() %>/boardTip" class="more">더보기+</a>
                    <table class="list-table">
                        <thead>
                            <th>제목</th>
                            <th>날짜</th>
                            <th>조회수</th>
                        </thead>
                        <%
                		if (volist5 != null) {
                			for (Board vo5 : volist5) {
                		%>
                        <tr>
                            <td><a href="boardcontent?no=<%=vo5.getBf_n()%>"><%=vo5.getBf_title()%></a></td>
                            <td><a href="boardcontent?no=<%=vo5.getBf_n()%>"><%=vo5.getBf_content()%></a></td>
                            <td><a href="boardcontent?no=<%=vo5.getBf_n()%>"><%=vo5.getBf_view()%></a></td>
                        </tr>
                        <%
               				}
               			}
                    	%>
                    </table>
                </article>
                <article class="right-list">
                    <h3 class="list-title">동네 소개/홍보</h3>
                    <a href="<%=request.getContextPath() %>/boardMeet" class="more">더보기+</a>
                    <table class="list-table">
                        <thead>
                            <th>제목</th>
                            <th>날짜</th>
                            <th>조회수</th>
                        </thead>
                        <%
                		if (volist6 != null) {
                			for (Board vo6 : volist6) {
                		%>
                        <tr>
                            <td><a href="boardcontent?no=<%=vo6.getBf_n()%>"><%=vo6.getBf_title()%></a></td>
                            <td><a href="boardcontent?no=<%=vo6.getBf_n()%>"><%=vo6.getBf_content()%></a></td>
                            <td><a href="boardcontent?no=<%=vo6.getBf_n()%>"><%=vo6.getBf_view()%></a></td>
                        </tr>
                        <%
               				}
               			}
                    	%>
                    </table>
                </article>
            </section>
        </div>
    </div>

</body>

</html>