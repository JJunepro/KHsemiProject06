<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <link href="/WebContent/css/findIdPw.css" rel="stylesheet" type="text/css">
</head>
<body>
    <form action="#" id="frm">
        <fieldset>
            <div id="title">
                <h1>ID/PW찾기</h1>
            </div>

            <div id="selectBtn">
                <input type="button" id="findIdBtn" class="selectBtn" value="아이디" style="background-color: navy; color: oldlace;">
                <input type="button" id="findPwBtn" class="selectBtn" value="비밀번호" onclick="location.href='findPw.html'"><br>
            </div>

            <div id="all">
                <div id="nameBox">
                    <label>이름</label><br>
                    <input type="text" id="uName" placeholder=" 이름을 입력하세요."><br>
                </div>

                <div id="cellNumBox">
                    <label>휴대폰 인증</label><br>
                    <input type="email" id="uEmail" placeholder=" 회원가입시 번호를 입력하세요.">
                    <input type="button" id="send" value="전송"><br>
                    <input type="text" id="authentication" placeholder=" 인증코드를 입력하세요.">
                    <input type="button" id="check" value="확인"><br>
                </div>
            </div>
            <div id="findBtn">
                <input type="button" id="find" value="찾기">
            </div>
            
        </fieldset>
    </form>
</body>
</html>