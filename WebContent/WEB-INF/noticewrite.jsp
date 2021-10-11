<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String bn_n = request.getParameter("bn_n");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/index.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<style>
	.form label{
		width:100%; text-align:left;
	}
</style>
<title>공지사항 글 등록</title>
</head>
<body>
	<%@ include file="./header.jsp"%>
	<div class="container">
		<div class="row">
			<form method="post" action="noticewrite.do">
				<table class="table table-striped" style="text-align:center; border:1px solid #dddddd;">
					<thead>
						<tr>
							<th colspan="2" style="background-color : #eeeeee; text-align : center;">게시판 글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="글 제목" name="bn_title" maxlength="50"></td>
						</tr>
						<tr>
							<td><input type="text" class="form-control" placeholder="작성자" name="m_id" maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea cols="50" rows="10" name="bn_content" placeholder="글 내용" maxlength="2048"></textarea></td>
						</tr>
						
					</tbody>
				</table>
				<input type="submit" class="btn btn-primary pull-right" value="등록">
			</form>
			<!-- TODO : CK에디터 사용 할 것인지 -->
		</div>
	</div>
</body>
</html>