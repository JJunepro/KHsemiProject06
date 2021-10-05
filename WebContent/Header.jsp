<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <script
      src="https://code.jquery.com/jquery-3.6.0.js"
      integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
      crossorigin="anonymous"
    ></script>
    <title>Insert title here</title>
    <link rel="stylesheet" href="./css/header.css" />
  </head>
  <body>
    <header>
      <div class="header">
        <div class="headerLogo">
          <h1><a href="http://localhost:8090/TBH/MainPage.jsp">T.B.H</a></h1>
          <button class="loginButton">로그인</button>
        </div>
        <div class="headerNav">
          <ul class="headerNavList">
            <li class="reserveBtn">
              <a href="http://localhost:8090/TBH/ReserveMain.jsp">예약페이지</a>
            </li>
            <li>
              <a href="http://localhost:8090/TBH/MarketMain.jsp">중고나라</a>
            </li>
            <li>
              <a href="http://localhost:8090/TBH/BoardMain.jsp">게시판</a>
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
  </body>
</html>
