<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <script
      type="text/javascript"
      src="https://code.jquery.com/jquery-3.6.0.min.js"
    ></script>
    <link rel="stylesheet" href="./css/boardDetail.css" />
    <link rel="stylesheet" href="./css/header.css" />
    <link rel="stylesheet" href="./css/footer.css" />
    <title>Document</title>
  </head>
  <body>
    <%@ include file="./Header.jsp" %>

    <section>
      <div class="body">
        <table>
          <thead>
            <tr>
              <th>
                <span>홍길동</span>
                <span>2021-10-05</span>
                <span>1 <br /></span>
                <strong>자바스크립트</strong>
              </th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td class="text">
                <textarea readonly name="textVal" id="textVal" cols="30" rows="10">
                    종로문화다양성연극제 참가단체 모집

(WITH 종로구 우수연극전)



2021 종로문화다양성연극제는 문화다양성의 가치를 공유하는 문화다양성 연극작품을 공모합니다.



더불어 공연 예술의 중심지인 대학로에서 작품성을 인정 받은 연극 공연을 선정하는

종로구 우수연극전 작품을 함께 모집하오니

극단 관계자 여러분들의 많은 관심과 참여 부탁드립니다.

 

■ 공모기간

9월27일(월) ~ 10월11일(월)



■ 접수방법

종로문화재단 홈페이지 및 블로그에서

[양식]2021 종로문화다양성연극제 공모안내를

다운받아 작성 후 이메일(hjisun96@jfac.or.kr) 접수



■ 서류심사 발표

10월18일(월)

선정단체 종로문화재단 홈페이지(공지사항) 및 블로그 공지



■ 인터뷰 심사

10월21일(목) ~10월22일(금)



■ 최종합격 발표

10월25일(월) 예정

※ 최종합격 발표는 일정에 따라 변경될 수 있으며, 변경 시 추후 안내


상세 안내 및 공모 양식은  종로문화재단 홈페이지 및 블로그를 확인하시기 바랍니다.
                </textarea>
              </td>
            </tr>
          </tbody>
        </table>
      </div>

      <div class="textBox">
        <textarea name="reply" id="reply" cols="50" rows="10"></textarea>
        <button class="update">등록</button>
      </div>
      <div class="replyBox">
        <ul>
          <li>
            <span>홍길동</span>
            <span>2021-10-05 <br /></span>
            <span>댓글입니다 여기부분이</span>
            <button>답글</button>
          </li>
          <li>
            <span>홍길동</span>
            <span>2021-10-05 <br /></span>
            <span>댓글입니다 여기부분이</span>
            <button>답글</button>
          </li>
          <li>
            <span>홍길동</span>
            <span>2021-10-05 <br /></span>
            <span>댓글입니다 여기부분이</span>
            <button>답글</button>
          </li>
          <li>
            <span>홍길동</span>
            <span>2021-10-05 <br /></span>
            <span>댓글입니다 여기부분이</span>
            <button>답글</button>
          </li>
          <li>
            <span>홍길동</span>
            <span>2021-10-05 <br /></span>
            <span>댓글입니다 여기부분이</span>
            <button>답글</button>
          </li>
        </ul>
      </div>
      <div class="replyNum">
        <ul>
          <li>1</li>
          <li>2</li>
          <li>3</li>
          <li>4</li>
          <li>5</li>
        </ul>
      </div>
    </section>

     <%@ include file="./Footer.jsp" %>
    <script src="./js/header.js"></script>
    <script>
      function replyBtn() {
        let str = document.querySelector("#reply").value;
        str = str.replace(/(?:\r\n|\r|\n)/g, '<br />');
        console.log(str);
        document.querySelector("#textVal").innerHTML = str;
      }
    </script>
  </body>
</html>
