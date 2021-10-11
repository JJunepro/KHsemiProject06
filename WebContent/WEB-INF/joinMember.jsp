<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/WebContent/css/joinMember.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
        <header>
            <div id="headers"></div>
        </header>
        <form action="join.do" method="POST" id="joinfrm">
            <div>
                <div id="title">
                    <h1>회원가입</h1>
                </div>
                <div>
                    <label>아이디</label><br>
                    <input type="text" class="textBox" id="joinId" placeholder="사용하실 아이디를 입력해 주세요."><br>
                    <label>비밀번호</label><br>
                    <input type="password" class="textBox" id="joinPw" placeholder="정규표현식 상의"><br>
                    <label>비밀번호 확인</label><br>
                    <input type="password" class="textBox" id="joinPwRe"><br>
                    <label>이름</label><br>
                    <input type="text" class="textBox" id="joinName"><br>
    
                        <div id="aa">
                            <div id="gender">
                                <label>성별</label><br>
                                <select id="selectGender">
                                <option value="">성별</option>
                                <option value="m" id="male">남성</option>
                                <option value="f" id="female">여성</option>
                                </select>
                            </div>
                            <div id="birth">
                                <label>생년월일</label><br>
                                <input type="date" id="dateBox">
                            </div>
                        </div>
                    <label>전화번호</label><br>
                    <input type="text" class="textBox">
                    <input type="button" value="인증"><br>
                    <input type="text" class="textBox">
                    <input type="button" value="확인"><br>
                    <label>이메일</label><br>
                    <input type="email" class="textBox"><br>
                    <input type="checkbox">예약/이벤트 메일을 수신하시겠습니까?<br>
                    <label>주소</label><br>
                    <input type="text" class="textBox" placeholder="주소" id="kakaoAddress"><br>
                    <input type="text" class="textBox" placeholder="상세주소"id="kakaoAddressDetail"><br><!-- 카카오맵 api -->
                </div>
                <!-- 
                <div>
                    <p>관심운동선택</p>
                    <input type="radio" value="aaa">
                    <input type="radio" value="aaa">
                    <input type="radio" value="aaa"><br>
                    <input type="radio" value="aaa">
                    <input type="radio" value="aaa">
                    <input type="radio" value="aaa"><br>
                    <input type="radio" value="aaa">
                    <input type="radio" value="aaa">
                    <input type="radio" value="aaa"><br>
                    <input type="radio" value="aaa">
                    <input type="radio" value="aaa">
                    <input type="radio" value="aaa">
                    <a>radio모양변경 및 버튼안에 내용추가</a><br>
                </div> -->
                <div>
                <!-- TODO 유효성 체크 후 그곳에서 submit() -->
                    <input type="submit" value="회원가입" id="btnSubmit">
                </div>
            </div>
        </form>
    </body>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        window.onload = function(){
            document.getElementById("kakaoAddress").addEventListener("click", function(){ //주소입력칸을 클릭
            new daum.Postcode({
                oncomplete: function(data) {
                    document.getElementById("kakaoAddress").value = data.address;
                    document.querySelector("input[id=kakaoAddressDetail]").focus();
                }
            }).open();
        });
    }
    </script>
    <!-- <script>
        $(function(){
            $("#btnSubmit").on("click", function(){
                $.ajax({
                    type: "post",
                    url: "join.do",
                    data: {
                        m_id: $("#")
                        m_pw: 
                        m
                    }

                });
            });
        });
    </script> -->
</html>