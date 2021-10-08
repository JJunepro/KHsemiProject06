<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <header>
      <div class="header">
        <div class="headerLogo">
          <h1><a href="<%=request.getContextPath() %>/main">T.B.H</a></h1>
          <button class="loginButton">로그인</button>
          <button class="JoinButton" onclick="location.href='join';">회원가입</button>
        </div>
        <div class="headerNav">
          <ul class="headerNavList">
            <li class="reserveBtn">
            <!-- TODO 경로 수정 -->
              <a href="http://localhost:8090/TBH/ReserveMain.jsp">예약페이지</a>
            </li>
            <li>
              <a href="http://localhost:8090/TBH/MarketMain.jsp">중고나라</a>
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
    <script src="./js/header.js"></script>
