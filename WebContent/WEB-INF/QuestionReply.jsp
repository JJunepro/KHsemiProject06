<link rel="stylesheet" href="./css/header.css" />
<%@page import="tbh.articlesix.board.question.vo.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String bq_n = request.getParameter("no");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
	<!-- <script src="ckeditor/ckeditor.js"></script> -->
	<!-- <script src="https://cdn.ckeditor.com/4.16.2/standard/ckeditor.js"></script> -->
	<script src="https://cdn.ckeditor.com/ckeditor5/25.0.0/classic/ckeditor.js"></script>
	<script src="http://netdna.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.js"></script>
	<script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
<style>
	* {
		list-style : none;
		text-decoration : none;
		padding : 0;
		margin : 0;

	}
	.container {
		clear : both;
		width: 80%;
  		margin: 0 auto;
  		padding-top : 10px;
  		
	}
	.page-title h3 {
	  font-size: 28px;
	  color: #333333;
	  font-weight: 400;
	  text-align: center;
	}
	.title {
		height : 50px;
		font-size : 28px;
		color : #333333;
	}
	.table {
		width : 80%;
		margin : 0 auto;
		border-spacing : 5px;
	}
	.table_title {
		border : 1px solid #d1d1d1;
		background : #f8f8f8;
		font-size: 28px;
	}
	.table_content {
		border : 1px solid #d1d1d1;
		background : #f8f8f8;
		font-size: 28px;
		width : 90%;
	}
	
	.ck-editor__editable {
		min-height : 450px;
	}
	
	.centerBtn {
		text-align : center;
		
		margin-top : 10px;
	}
	.form-control {
		width : 100%;
		border : 1px solid #d1d1d1;
		font-size : 18px;
		padding : 8px;
	}
	.btn {
		font-size : 20px;
		background : #ccc;
	}
</style>
<title>QnA 답글 작성</title>
</head>
<body>
	<%@ include file="./Header.jsp"%>
	<div class="container">
		<div class="row">
			<form method="post" action=questionreply>
				<input type="hidden" name="no" value="<%= bq_n %>" readonly>
				<div class="page-title">
					<div class="container">
					</div>
				</div>
				<table class="table table-striped" style="text-align:center; border:1px solid #dddddd;">
					<thead class="title">
						<tr>
							<th colspan="4" style="background-color : #eeeeee; text-align : center;">QnA 글쓰기 양식</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="1" class="table_title"><span>제목</span></td>
							<td colspan="3" ><input type="text" class="form-control" placeholder="글 제목" name="bq_title" maxlength="50"></td>
						</tr>
						<tr>
							<td colspan="1" class="table_title"><span>작성자</span></td>
							<td colspan="3"><input type="text" class="form-control" placeholder="작성자" name="m_nick" maxlength="50"></td>
						</tr>
						<tr>
							<td colspan="4"><textarea cols="100" rows="10" name="bq_content" id="editor" placeholder="글 내용" maxlength="2048"></textarea></td>
							<!-- <script>CKEDITOR.replace('editor4',{filebrowserUploadUrl:'/img/imgUpload.do'});</script> -->
							<script>
								/* CKEDITOR.filebrowserUploadMethod = 'form';
								CKEDITOR.replace("text_content",{ height:"300" ,filebrowserImageUploadUrl: 'upload'
								,toolbar:
									[
										{ name: 'document', items : [ 'Source' ] },
										{ name: 'basicstyles', items : [ 'Bold','Italic','Underline','Strike','Subscript','Superscript' ] },
										{ name: 'paragraph', items : [ 'NumberedList','BulletedList','-','JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock' ] },
										{ name: 'links', items : [ 'Link','Unlink' ] },
										{ name: 'insert', items : [ 'Image','Table' ] },
										'/',
										{ name: 'styles', items : [ 'Font', 'FontSize' ] },
										{ name: 'colors', items : [ 'TextColor', 'BGColor' ] }
										]
								}); */
								/* CKEDITOR.replace("editor1", {
									filebrowserUploadUrl : "${pageContext.request.contextPath}/imageUpload.do"
								});
								window.parent.CKEDITOR.tools.callFunction(1, "${url}", "전송완료"); */
								ClassicEditor
								.create( document.querySelector( '#editor' ), {
									ckfinder : { uploadUrl : 'imageUpload2' }
								} )
								.then( editor => {
									window.editor = editor
								} )
								.catch( error => {
								        console.log(error);
								});
							</script>

						</tr>
					</tbody>
				</table>
				<div class="centerBtn">
					<button onclick="back()" class="btn">취소</button>
					<button type="submit" class="btn btn-primary pull-right">등록</button>
				</div>	
			</form>
		</div>
	</div>
</body>
</html>