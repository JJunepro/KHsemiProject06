<%@page import="tbh.articlesix.board.notice.vo.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Notice no = (Notice)request.getAttribute("noticeno"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 보기</title>
</head>
<body>
	<%
		//일단 1차적으로는 로그인한 사람이라면 userID라는 변수에 해당 아이디가 담기고 그렇지 않으면 null처리
		//TODO 수정 필요 (관리자 번호를 비교)
		String userID = null;
		if (session.getAttribute("userID")!= null) {
			userID = (String) session.getAttribute("userID");
			
		}
		
		int pageNumber = 1;
		
		if (request.getParameter("P_NUMBER")!=null) {
			
		}
	%>
	<div class="article">
        <div class="articleTitle">
            <h1>Lorem Ipsum</h1>
            <p>
            	<span>작성자</span>
            	<span>조회수</span>
            	<span>등록일</span>
            </p>
        </div>
        
        <div class="articleContent">
        <hr>
            <p>
                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
            </p>
        <hr>
        </div>
        <button onclick="">목록</button>
        <button onclick="">수정</button> 
        <button onclick="">삭제</button>
    </div>
</body>
</html>