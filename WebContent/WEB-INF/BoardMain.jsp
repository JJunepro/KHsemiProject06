<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardMain.css" />
    <title>Document</title>
  </head>
  <body>
   <%@ include file="./Header.jsp" %>

    <section>
        <div class="board">
           <table>
               <tr>
                   <th>게시판 번호</th>
                   <th class="thTitle">제목</th>
                   <th>작성자</th>
                   <th>등록일</th>
                   <th>조회순</th>
               </tr>
               <tr>
                   <td>1</td>
                   <td><a href="http://localhost:8090/TBH/BoardDetail.jsp">자바스크립트</a></td>
                   <td>홍길동</td>
                   <td>2021-10-05</td>
                   <td>1</td>
               </tr>
               <tr>
                <td>1</td>
                <td>자바스크립트</td>
                <td>홍길동</td>
                <td>2021-10-05</td>
                <td>1</td>
            </tr>
            <tr>
                <td>1</td>
                <td>자바스크립트</td>
                <td>홍길동</td>
                <td>2021-10-05</td>
                <td>1</td>
            </tr>
            <tr>
                <td>1</td>
                <td>자바스크립트</td>
                <td>홍길동</td>
                <td>2021-10-05</td>
                <td>1</td>
            </tr>
            <tr>
                <td>1</td>
                <td>자바스크립트</td>
                <td>홍길동</td>
                <td>2021-10-05</td>
                <td>1</td>
            </tr>
            <tr>
                <td>1</td>
                <td>자바스크립트</td>
                <td>홍길동</td>
                <td>2021-10-05</td>
                <td>1</td>
            </tr>
            <tr>
                <td>1</td>
                <td>자바스크립트</td>
                <td>홍길동</td>
                <td>2021-10-05</td>
                <td>1</td>
            </tr>
           </table>
        </div>
        <ul>
            <li>1</li>
            <li>2</li>
            <li>3</li>
            <li>4</li>
            <li>5</li>
        </ul>
    </section>
    
    
 <%@ include file="./Footer.jsp" %>
    <script src="./js/header.js"></script>
  </body>
</html>