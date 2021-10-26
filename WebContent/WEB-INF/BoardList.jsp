<link rel="stylesheet" href="./css/header.css" />
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
		.boardtitle {
			width : 80%;
			margin : 0 auto;
			text-align : center;
			margin-bottom : 1em;
		}
        .container {
            width : 80%;
            margin : 0 auto;
            
        }
        .aside {
        	width : 10%;
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
		
		.aside ol {
			margin : 0 auto;
		}
		
		.aside h2 {
			margin-bottom : 1em;
		}
        
        .aside li, .aside a {
        	float:left;
			height:35px;
			line-height:35px;
			position:relative;
			font-size:15px;
			margin-bottom: 12px;
			font-family: 'Raleway', sans-serif;
			transition: background-color 1.5s ease;
			
		}
		
		.aside a {
			background:#ccc;
			color:#fff;
			text-decoration:none;
			-moz-border-radius-bottomright:4px;
			-webkit-border-bottom-right-radius:4px;
			border-bottom-right-radius:4px;
			-moz-border-radius-topright:4px;
			-webkit-border-top-right-radius:4px;
			border-top-right-radius:4px;
			width : 8em;
			text-align : center;
			margin-left : 1em;
		}
		
        .aside a:hover{
		background:#555;
		}
		
		.aside a:before{
			content:"";
			float:left;
			position:absolute;
			top:0;
			left:-12px;
			width:0;
			height:0;
			border-color:transparent #ddd transparent transparent;
			border-style:solid;
			border-width: 18px 12px 18px 0;
		}
		
		.aside a:after{
			content:"";
			position:absolute;
			top:15px;
			left:0;
			float:left;
			width:6px;
			height:6px;
			-moz-border-radius:2px;
			-webkit-border-radius:2px;
			border-radius:2px;
			background:#fff;
			-moz-box-shadow:-1px -1px 2px #004977;
			-webkit-box-shadow:-1px -1px 2px #004977;
			box-shadow:-1px -1px 2px #004977;
		}
		
		.aside a:hover:before {
			border-color:transparent #ddd transparent transparent;
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
            margin-bottom : 2em;
        }
        .list-search {
            width: 80%;
            height: 6em;
            display: inline-block;
            margin : 0 auto;
            text-align: center;
            margin-bottom : 1em;
        }

        .left-list {
            float : left;
            width : 49%;
            border : 1px solid #ccc;
            border-radius: 15% 3%;
            margin-top : 1em;
        }
        .right-list {
            float : right;
            width : 49%;
            border : 1px solid #ccc;
            border-radius: 3% 15%;
            margin-top : 1em;
        }
        .list-title {
            text-align : center;
            margin-top : 1em;
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
            width : 98%;
            border-top: 1px solid #ccc;
        }
         .list-table th {
            background : #F9F7F9;
            width : 33%;
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
    </style>
</head>
<body>
	<%@ include file="./Header.jsp"%>
	<div class="boardtitle">
		<h1>자유 게시판</h1>
	</div>
    <div class="container">
        <div class="content-box">
            <div class="aside">
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
                            <td><a href="boardcontent?no=<%=vo.getBf_n()%>"><%=vo.getBf_timestamp()%></a></td>
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
                            <td><a href="boardcontent?no=<%=vo2.getBf_n()%>"><%=vo2.getBf_timestamp()%></a></td>
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
	                            <td><a href="boardcontent?no=<%=vo3.getBf_n()%>"><%=vo3.getBf_timestamp()%></a></td>
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
                            <td><a href="boardcontent?no=<%=vo4.getBf_n()%>"><%=vo4.getBf_timestamp()%></a></td>
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
                            <td><a href="boardcontent?no=<%=vo5.getBf_n()%>"><%=vo5.getBf_timestamp()%></a></td>
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
                            <td><a href="boardcontent?no=<%=vo6.getBf_n()%>"><%=vo6.getBf_timestamp()%></a></td>
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