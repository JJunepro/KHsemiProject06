<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css" />
<%@page import="tbh.articlesix.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 Page</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
 <%@ include file="./Header.jsp" %>
 	<section>
    	<form action="login.do" method="POST" id="frm">
        	<div id="loginAll">
            	<fieldset id="loginBox">
                    	<h1 id="title">로그인</h1>
                	<div id="textBox">
                		<label>아이디</label><br>
                    	<input type="text" id="loginId" name="loginId" placeholder=" 아이디" class="loginField"><br><br>
                    	<label>비밀번호</label><br>
                    	<input type="password" id="loginPw" name="loginPw" placeholder=" 비밀번호" class="loginField"><br><br>
                    	<input type="button" id="loginBtn" value="로그인"><br>
	                </div>
    	        </fieldset>
        	        <div id="url">
            	        <a href="findId" class="alink">아이디 찾기</a>
                	    <a href="findPw" class="alink">비밀번호 찾기</a>
                    	<a href="join" class="alink">회원가입</a>
	                </div>
    	    </div>
    	</form>
    </section>
</body>
<script>
    window.addEventListener("load", pageLoadedHandler);
    function pageLoadedHandler(){
        document.getElementById("loginBtn").addEventListener("click", btnSubmt);
    }
    function btnSubmt(){
        var id = document.getElementById("loginId").value;
        var pw = document.getElementById("loginPw").value;

        var inputElements = document.getElementsByClassName("loginField");
        if(id == ""){
            swal("", "아이디를 입력하지 않았습니다.", "error")
            return false;
        }
        if(pw == ""){
            swal("", "비밀번호를 입력하지 않았습니다.", "error")
            return false;
        }
            callLogin(id, pw)
    }

    function callLogin(id, pw) {
        $.ajax({
            type: "POST",
            url: "login.do",
            data: {
                m_id: id,
                m_pw: pw
            },
            dataType : "json",
            success : function(data) {
                if(data.result == "ok"){
                    console.log(data.result);
                    swal("환영합니다!", "로그인성공", "success").then(function() {
                        	location.href="main";
                        });
                }else{
                    swal("", data.msg, "error");
                }
            },
            error : function(request, status, error){
                console.log(request)
                console.log(status)
                console.log(error)
                swal("err")
                swal("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                }
        });
        
    } 
</script>
</html>