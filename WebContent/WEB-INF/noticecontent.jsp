<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
<table border="1">
		<tr>
			<td>글번호</td>
			<td> <%=  %> </td>
			<td> <%=  %>  </td>
		</tr>
		<tr>
			<td>제목</td>
			<td colspan="2"> <%=  %> </td>
		</tr>
		<tr>
			<td colspan="3"> <%=  %> </td>
		</tr>
	</table>
	<a href="boardwrite?bno=<%= %>">답글작성</a>
</body>
</html>