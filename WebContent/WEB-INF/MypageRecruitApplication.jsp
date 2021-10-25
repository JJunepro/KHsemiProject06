<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<RecruitApplication> rcapplist = (ArrayList<RecruitApplication>) request.getAttribute("rcapplist");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
					if (rcapplist != null) {
					for (RecruitApplication ra : rcapplist) {
				%>
				<tbody>
					<tr>
						<td><a href="RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_n()%></a>
						</td>
						<td><a href="RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_title()%></a>
						</td>
						<td><a href="RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getCa_n()%></a>
						</td>
						<td><a href="RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getM_id()%></a>
						</td>
						<td><a href="RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_place()%></a>
						</td>
						<td><a href="RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_start()%></a>
							<a href="RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_end()%></a>
						</td>
						<td><a href="RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_total()%></a>
						</td>
						<td><a href="RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_timestamp()%></a>
						</td>
						<td><a href="RecruitRoom?no=<%=rc.getB_n()%>"><%=rc.getB_view()%></a>
						</td>
					</tr>
					<%
						}
					}
					%>
				</tbody>
			</table>
</body>
</html>