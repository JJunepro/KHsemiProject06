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
    padding: 0;
    margin: 0;
    box-sizing: border-box;
  }
  .article {
  	border-collapse : collapse;
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
          	</form>
        </div>
        <!-- TODO : 수정 필요함 -->
	        <button onclick="location.href='noticelist'" class="btn">목록</button> 
	        <button id="modifybtn" class="btn">
	        <a href="noticemodify?no=<%=bnn.getBn_n()%>">수정
	        </button>
	        
	        <button id="deletebtn">
	        <a href="noticelist">삭제
	        </button>
    </div>
    
    <script>
    	$("#modifybtn").click(function(){
    		if(confirm("수정하시겠습니까?")) {
    			$("#modify").submit();
    		} else {
    			return false;
    		}
    	});
    	
    	$("#deletebtn").click(function(){
    		if(confirm("이 글을 삭제하시겠습니까?")) {
    			alert("삭제 되었습니다.");
    			window.location.href = "noticelist";
    		} else {
    			return false;
    		}
    	});
    </script>
    
</body>
</html>