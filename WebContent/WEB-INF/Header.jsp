<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/header.css" />
<title>Insert title here</title>
</head>
<body>
    <header>
      <div class="header">
        <div class="headerLogo">
          <h1><a href="<%=request.getContextPath() %>/main">T.B.H</a></h1>
          <button class="loginButton" onclick="location.href='login'">로그인</button>
          <button class="JoinButton" onclick="location.href='join';">회원가입</button>
        </div>
        <div class="headerNav">
          <ul class="headerNavList">
            <li class="reserveBtn">
            <!-- TODO 경로 수정 -->
              <a href="#">예약페이지</a>
            </li>
            <li>
              <a href="<%=request.getContextPath() %>/marketMain">중고나라</a>
            </li>
            <li>
              <a href="<%=request.getContextPath() %>/noticelist">게시판</a>
            </li>
            <li>
              <a href="#">공지사항&QnA</a>
            </li>
          </ul>
        </div>
        <div class="subReserve">
          <span><a href="#">장기</a></span>
          <span><a href="#">단기</a></span>
        </div>
      </div>
    </header>
    <script src="js/header.js"></script>
    </body>
</html>
