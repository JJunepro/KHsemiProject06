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
<title>게시글 보기</title>
<style>
* {
  list-style: none;
  text-decoration: none;
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}

.article {
	clear : both;
	box-sizing : border-box;
}

.wrap {
	display : inline-block;
}
</style>
</head>
<body>
	<%@ include file="./header.jsp"%>
	<%
	%>
	<div class="article">
        <div class="articleTitle">
            <h1><%= bnn.getBn_title()%></h1>
			<pre>
			<span>작성자 : <%= bnn.getM_id()%></span>
			<span>조회수 : <%= bnn.getBn_view()%></span>
			<span>등록일 : <%= bnn.getBn_timestamp()%></span>
			</pre>
        </div>
        <div class="articleContent">
        <hr>
            <p>
            	<%= bnn.getBn_content()%>
            </p>
        <hr>
        </div>
	        <button onclick="location.href='noticelist'">목록</button>
	        <button onclick="">수정</button> 
	        <button onclick="">삭제</button>
    </div>
</body>
</html>