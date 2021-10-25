<%@page import="tbh.articlesix.board.question.vo.Question"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Question bqn = (Question)request.getAttribute("questionno"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/index.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<title>QnA 게시글 보기</title>
<style>
* {
    padding: 0;
    margin: 0;
    box-sizing: border-box;
  }
  .article {
  	border-collapse : collapse;
  	margin : 5px;
  }
  .articleTitle {
  	width : 80%;
  	position : relative;
  	margin : 0 auto;
  	border-top : 1em solid #9DB6C2;
  	background : #f9f7f9;
  	padding : 1em 1em;
  }
  .articleContent {
  	width : 80%;
  	position : relative;
  	margin : 0 auto;
  	padding : 1em;
  	border-top : thick double #A7ABC2;
  	border-bottom : 0.5em solid #9DB6C2;
  	height : 560px;
  	background : #fff;
	}
 .btncol {
 	position : relative;
 	margin : 0 auto;
 	width : 80%;
 	padding-top : 1em;
 	text-align : right;
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
	background : #94C2B7;
	color : #fff;
	text-decoration : none;
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
        	<input type="hidden" name="no" value="<%=bqn.getBq_n() %>">
        		<h1><%= bqn.getBq_title()%></h1>
				<pre>
				
<span>작성자 : <%= bqn.getM_nick()%></span>
<span>등록일 : <%= bqn.getBq_timestamp()%></span>
				</pre>
        </div>
        <div class="articleContent">
            	<%= bqn.getBq_content()%>
        </div>
          	</form>
        
        <!-- TODO : 수정 필요함 -->
        <div class="btncol">
        	<button id="replybtn" class="btn btn-dark">
	        	<a href="questionreply?no=<%=bqn.getBq_n()%>">답글 작성</a>
	        </button>
	        
	        <button id="modifybtn" class="btn btn-dark">
	        	<a href="questionmodify?no=<%=bqn.getBq_n()%>">수정</a>
	        </button>

	        <button id="deletebtn" class="btn btn-dark">
	        	<a href="questiondelete?no=<%=bqn.getBq_n()%>">삭제</a>
	        </button>
	        
	        <button onclick="location.href='questionlist'" class="btn btn-dark">목록</button> 
	    </div>
    </div>
    
    <script>
	    $("#replybtn").click(function(){
			if(confirm("답글 작성하시겠습니까?")) {
				$("#modify").submit();
			} else {
				return false;
			}
		});	
    
    	$("#modifybtn").click(function(){
    		if(confirm("수정하시겠습니까?")) {
    			$("#modify").submit();
    		} else {
    			return false;
    		}
    	});
    	
    	$("#deletebtn").click(function(){
    		if(confirm("이 글을 삭제하시겠습니까?")) {
    			$("#modify").submit();
    			/* alert("삭제 되었습니다.");
    			window.location.href = "noticelist"; */
    		} else {
    			return false;
    		}
    	});
    </script>
    <%@ include file="./Footer.jsp"%>
</body>
</html>