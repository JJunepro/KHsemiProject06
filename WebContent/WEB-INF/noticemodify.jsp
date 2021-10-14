<%@page import="tbh.articlesix.board.notice.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Notice bnn = (Notice)request.getAttribute("noticeno"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/index.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
	<script src="https://cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script>
<style>
	.container {
	position : relative;
	}
	
</style>
<title>공지사항 글 수정</title>
</head>
<body>
	<%@ include file="./Header.jsp"%>
	<div class="container">
		<div class="row">
			<form method="post" action="noticemodify">
				<input type="hidden" name="no" value="<%=bnn.getBn_n() %>">
				<table class="table table-striped" style="text-align:center; border:1px solid #dddddd;">
					<thead>
						<tr>
							<th colspan="2" style="background-color : #eeeeee; text-align : center;">글 수정</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>제목</td>
							<td><input type="text" class="form-control" placeholder="글 제목" name="bn_title" maxlength="50" value="<%= bnn.getBn_title()%>"></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input type="text" class="form-control" placeholder="작성자" name="m_id" maxlength="50" value="<%= bnn.getM_id()%>"></td>
						</tr>
						<tr>
							<td colspan="3"><textarea cols="50" rows="10" name="bn_content" id="editor4" placeholder="글 내용" maxlength="2048"><%= bnn.getBn_content()%></textarea></td>
							<script>CKEDITOR.replace('editor4');</script>
						</tr>
					</tbody>
				</table>
				<button onclick="back()">취소</button>
				<input type="submit" class="btn btn-primary pull-right" value="등록">
			</form>


			<!-- TODO : CK에디터 사용 할 것인지 -->
		</div>
	</div>
</body>
</html>