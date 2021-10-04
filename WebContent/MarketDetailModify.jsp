<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="./css/header.css" />
    <link rel="stylesheet" href="./css/footer.css" />
    <link rel="stylesheet" href="./css/marketModify.css" />
  </head>
  <body>
    <jsp:include page="./Header.jsp">

    <section class="body">
      <div class="formBox">
        <!-- <form action="#" method="POST"> -->
          <h3>중고 물품 수정</h3>
         <table>
           <tr>
             <th>제목</th>
             <td><input type="text"></td>
           </tr>
           <tr>
             <th>사진</th>
             <td><input class="input" type="file"></td>
             <td><button onclick="onClick()">check</button></td>
            <td><div class="divImg"></div></td>
            </tr>
           <tr>
             <th>가격</th>
             <td><input type="text"></td>
           </tr>
           <tr>
             <th>설명</th>
             <td><textarea name="explain" id="explain" cols="50" rows="10"></textarea></td>
           </tr>
         </table>
         <div class="submitBox">
          <input type="submit" class="formButton" value="수정">
          <input type="submit" value="삭제">
          <input type="reset" value="초기화">
         </div>
       
        <!-- </form> -->
      </div>
    </section>

     <jsp:include page="./Footer.jsp">

    <script>
      const input = document.querySelectorAll(".body .formBox table tr td input");
        const title = input[0]
        const img = input[1]
        const price = input[2]
        title.value = "꽃"
        price.value = "5200원"
    </script>
    <script src="./js/header.js"></script>
  </body>
</html>
