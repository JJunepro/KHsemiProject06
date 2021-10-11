<%@page import="tbh.articlesix.board.notice.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ArrayList<Notice> nolist = (ArrayList<Notice>) request.getAttribute("noticenolist");
int startPage = (int) request.getAttribute("startPage");
int endPage = (int) request.getAttribute("endPage");
int pageCount = (int) request.getAttribute("pageCount");
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
<title>Insert title here</title>
</head>
<body>
	<%@ include file="./Header.jsp"%>
	<hr>
	<article>
		<nav>
			<ul>
				<li>공지사항</li>
				<li>Q&A</li>
			</ul>
		</nav>
		<div class="dataTbl1">
			<table>
				<caption>공지사항</caption>

				<colgroup>
					<col width="10%" />
					<col width="*" />
					<col width="14%" />
				</colgroup>

				<thead>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>등록일</th>
				</thead>
				<%
                		if (nolist != null) {
                			for (Notice no : nolist) {
                	%>
				<tbody>
					<tr>
						<td>
						<a href="noticecontent?no=<%=no.getBn_n()%>"> <%=no.getBn_n()%></a>
						</td>
						<td>
							<%
                        		for (int i=0; i<5; i++) {
                        	%> Re : <%
								}
							%> <%=no.getBn_title()%>
						</td>
						<td><%=no.getM_id()%></td>
						<td><%=no.getBn_timestamp()%></td>
					</tr>
					<%
                			}
                		}
                    	%>
				
			</table>
			<%
			  	if (startPage > 1){
			%>
			이전
			<%
				}
				for (int i = startPage; i <= endPage; i++) {
			%>
			<a href="./noticelist?pagenum=<%=i%>"> <%=i%>
			</a>
			<%
				if (i != endPage) {
			%>
			,
			<%
				}
			}
			if (endPage < pageCount) {
			%>
			다음
			<%
			}
			%>
			<button location.href='noticewrite.jsp';>글쓰기</button>
		</div>
	</article>


</body>
</html>