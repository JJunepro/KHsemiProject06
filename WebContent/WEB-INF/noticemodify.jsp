<link rel="stylesheet" href="./css/header.css" />
<%@page import="tbh.articlesix.board.notice.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Notice bnn = (Notice)request.getAttribute("noticeno"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
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
					<thead class="title">
						<tr>
							<th colspan="4" style="background-color : #eeeeee; text-align : center;">글 수정</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td colspan="1" class="table_title">제목</td>
							<td colspan="3"><input type="text" class="form-control" placeholder="글 제목" name="bn_title" maxlength="50" value="<%= bnn.getBn_title()%>"></td>
						</tr>
						<tr>
							<td colspan="1" class="table_title">닉네임</td>
							<td colspan="3"><input type="text" class="form-control" placeholder="작성자" name="m_nick" maxlength="50" value="<%= bnn.getM_nick()%>"></td>
						</tr>
						<tr>
							<td colspan="4"><textarea cols="100" rows="10" name="bn_content" id="editor" placeholder="글 내용" maxlength="2048"><%= bnn.getBn_content()%></textarea></td>
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
									ckfinder : { uploadUrl : 'imageUpload' }
								} )
								.then( editor => {
									window.editor = editor
								} )
								.catch( error => {
								        console.log( "aaa" );
								});
							</script>
						</tr>
					</tbody>
				</table>
				<div class="centerBtn">
					<button onclick="back()">취소</button>
					<input type="submit" class="btn btn-primary pull-right" value="등록">
				</div>
			</form>


			<!-- TODO : CK에디터 사진 적용 해야함-->
		</div>
	</div>
</body>
</html>