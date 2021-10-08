<%@page import="tbh.articlesix.board.notice.vo.Notice"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 이곳은 자바 문법에 따름
ArrayList<Notice> volist = (ArrayList<Notice>) request.getAttribute("boardvolist");
int startPage = (int) request.getAttribute("startPage");
int endPage = (int) request.getAttribute("endPage");
int pageCount = (int) request.getAttribute("pageCount");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 리스트</title>
</head>
<body>
	<h1>게 시 판 리스트</h1>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>날짜</td>
		</tr>
			<%
				if (volist != null) {
				for (Notice vo : volist) {
					// tr 이 volist 갯수 만큼 생기게 됨.
					// <%= 은 화면에 출력을 위한 표현식을 작성하는 태그, ;없어야 함.
			%>	
		<tr>
			<td><a href="boardcontent?no=<%=vo.getBn_n() %>"> <%=vo.getBn_n()%></a></td>
			<td><%=vo.getBn_title() %></td>
			<td><%=vo.getM_id() %></td>
			<td><%=vo.getBn_content() %></td>
		</tr>
			<%
				}
			}
			%>
	</table>

	<% if (startPage > 1) { %>
	이전
	<%	} for (int i = startPage; i <= endPage; i++) {	%>
	<a href="./boardlist?pagenum=<%=i%>"> <%=i%></a>
	<%	if (i != endPage) {	%>
	,
	<%	}
	} if (endPage < pageCount) {%>
	다음
	<%	} %>
	<br>
	<a href="boardwrite">글쓰기</a>
</body>
</html>