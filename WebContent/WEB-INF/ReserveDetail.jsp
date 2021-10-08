<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="./css/reservationDetail.css" />
    <title>Document</title>
  </head>
  <body>
     <%@ include file="./Header.jsp" %>
    <section class="body">
      <div class="reserve">
        <div class="intro">
          <h1>제목</h1>
          <div class="imageBox"><img src="https://plab-football.s3.amazonaws.com/media/dgys_half.jpeg" alt="이미지" width="200px" height="120px"></div>
          <div class="exTable">
            <ul>
              <li class="info">
                <h5>진행 방식(인원수, 날짜, 준비물)</h5>
                <ul>
                  <li>
                    <img src="https://plab-football.s3.amazonaws.com/static/img/ic_turf.svg" alt="img" width="90" height="70">
                    <p>인원수: 50명</p> 
                  </li>
                  <li>
                    <img src="https://plab-football.s3.amazonaws.com/static/img/ic_turf.svg" alt="img" width="90" height="70">
                    <p>날짜: 매주 수요일</p>
                  </li>
                  <li>
                    <img src="https://plab-football.s3.amazonaws.com/static/img/ic_turf.svg" alt="img" width="90" height="70">
                    <p>준비물: 풋살화</p>
                  </li>
                </ul>
              </li>
              <li class="space">
                <h5>장소</h5>
                <p>서울시 남산공원</p>
                <div id="space"></div>
              </li>
              <li class="rule">
                <h5>기본 사항</h5>
                <textarea name="rule" id="rule" cols="100" rows="10" readonly></textarea>
              </li>
              <li class="admin">
                <h5>관리자 정보</h5>
                <textarea name="admin" id="admin" cols="100" rows="10" readonly></textarea>
              </li>
            </ul>
          </div>
        </div>

        <div class="reserveCheck">
          <input type="button" class="reserveButton" value="예약하기" >
        </div>
      </div>
     
    </section>
      <%@ include file="./Footer.jsp" %>
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyADwT_OchIS3GFVF2oEGPSjhgYcH6Rz1jo&callback=initMap&region=kr"></script>
    <script src="./js/map.js"></script>
    <script src="./js/header.js"></script>
  </body>
</html>