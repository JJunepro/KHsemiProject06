
<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/index.css" />

<%@page import="tbh.articlesix.board.board.vo.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Board bfn = (Board) request.getAttribute("boardvo");
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
<title>공지사항 게시글 보기</title>
<style>
* {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

.article {
	border-collapse: collapse;
	margin: 5px;
}

.articleTitle {
	width: 80%;
	position: relative;
	margin: 0 auto;
	border-top: 1em solid #9DB6C2;
	background: #f9f7f9;
	padding: 1em 1em;
}

.articleContent {
	width: 80%;
	position: relative;
	margin: 0 auto;
	padding: 1em;
	border-top: thick double #A7ABC2;
	border-bottom: 0.5em solid #9DB6C2;
	height: 560px;
}

.btncol {
	position: relative;
	margin: 0 auto;
	width: 80%;
	padding-top: 1em;
	text-align: right;
}

.btn {
	font-size: 20px;
	font-weight: 400;
	background: transparent;
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
	background: #94C2B7;
	color: #fff;
}

.btn-dark:hover, .btn-dark:focus {
	background: #004B5E;
	border-color: #373737;
	color: #fff;
}

.btn-dark a {
	background: #94C2B7;
	color: #fff;
	text-decoration: none;
}

.btn-dark a:hover, .btn-dark a:focus {
	background: #004B5E;
	border-color: #373737;
	color: #fff;
}
}
</style>

</head>
<body>
	<%@ include file="./Header.jsp"%>
	<%
		
	%>
	<div class="article">
		<div class="articleTitle">
			<form method="get" action="" id="modify" name="form">
				<input type="hidden" name="no" value="<%=bfn.getBf_n()%>">
				<h1><%=bfn.getBf_title()%></h1>
				<pre>
				
<span>닉네임 : <%=bfn.getM_nick()%></span>
<span>조회수 : <%=bfn.getBf_view() + 1%></span>
<span>등록일 : <%=bfn.getBf_timestamp()%></span>
				</pre>
		</div>
		<div class="articleContent">
			<%=bfn.getBf_content()%>
		</div>
		</form>

		<!-- TODO : 수정 필요함 -->
		<div class="btncol">
			<button id="modifybtn" class="btn btn-dark">
				<a href="boardmodify?no=<%=bfn.getBf_n()%>">수정</a>
			</button>


			<button id="deletebtn" class="btn btn-dark">
				<a href="boarddelete?no=<%=bfn.getBf_n()%>">삭제</a>
			</button>

			<button onclick="location.href='boardlist'" class="btn btn-dark">목록</button>
		</div>
	</div>
	<div></div>
	<script>
		$("#modifybtn").click(function() {
			if (confirm("수정하시겠습니까?")) {
				$("#modify").submit();
			} else {
				return false;
			}
		});

		$("#deletebtn").click(function() {
			if (confirm("이 글을 삭제하시겠습니까?")) {
				$("#modify").submit();

			} else {
				return false;
			}
		});
	</script>
	<%@ include file="./Footer.jsp"%>
</body>
</html>