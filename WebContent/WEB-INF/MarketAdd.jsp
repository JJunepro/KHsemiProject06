<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="css/marketAdd.css?after" />
  </head>
  <body>
     <%@ include file="./Header.jsp" %>
	<!--<c:if test=""></c:if>-->
    <section class="body">
      <div class="formBox">
         <form action="doAddMarket" method="GET">
          <h3>중고 물품 등록</h3>
         <table>
           <tr>
             <th>제목</th>
             <td><input type="text" name="title"></td>
           </tr>
           <tr>
             <th>사진</th>
             <td><input class="input" type="file" name="img"></td>
             <td><button onclick="onClick()">check</button></td>
            <td><div class="divImg"></div></td>
            </tr>
           <tr>
             <th>가격</th>
             <td><input type="text" name="price"></td>
           </tr>
           <tr>
             <th>설명</th>
             <td><textarea name="content" id="explain" cols="50" rows="10" ></textarea></td>
           </tr>
         </table>
         <div class="submitBox">
          <input type="submit" class="formButton" >
         </div>
       
         </form> 
      </div>
    </section>
    <%@ include file="./Footer.jsp" %>

  </body>
</html>
