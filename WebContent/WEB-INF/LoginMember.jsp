<link rel="stylesheet" href="<%=request.getContextPath() %>/css/login.css" />
<%@page import="tbh.articlesix.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Member m = (Member) session.getAttribute("member");
%>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
 <%@ include file="./Header.jsp" %>
 	<section>
    	<form action="login.do" method="POST" id="frm">
        	<div id="loginAll">
            	<fieldset id="loginBox">
                	<div id="title">
                    	<h1 id="qwe">로그인</h1>
                </div>	
                	<div id="textBox">
                    	<input type="text" id="loginId" name="loginId" placeholder=" 아이디" class="loginField"><br><br>
                    	<input type="password" id="loginPw" name="loginPw" placeholder=" 비밀번호" class="loginField"><br><br>
                    	<input type="button" id="loginBtn" value="로그인"><br>
	                </div>
    	        </fieldset>
        	        <div id="url">
            	        <a href="findId">아이디 찾기</a>
                	    <a href="findPw">비밀번호 찾기</a>
                    	<a href="join">회원가입</a>
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
            alert("아이디를 입력하지 않았습니다.")
            return false;
        }
        if(pw == ""){
            alert("비밀번호를 입력하지 않았습니다.")
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
                    alert("로그인 성공.");
                    location.href="main";
                }else{
                    console.log(data.result)
                    alert("아이디와 비밀번호를 확인해주세요.");
                }
            },
            error : function(request, status, error){
                console.log(request)
                console.log(status)
                console.log(error)
                alert("err")
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
                }
        });
        
    } 
</script>
</html>