<link rel="stylesheet" href="<%=request.getContextPath() %>/css/congratulations.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <title>환영합니다~!!</title>
</head>
<body>
	<section>
        <div id="img">
        	<img src="./img/cong.jpg">
        </div>
    	<div id="asd">
    		<p id="fstCon">환영합니다!</p><br><br>
    		<p id="secCon">TBH의 멤버가 되신것을</p>
    		<p id="secCon">축하드립니다.</p><br><br>
    		<hr>
    		<input type="button" value="로그인" id="loginBtn" onclick="location.href='login'">
    		<input type="button" value="메인페이지" id="loginBtn" onclick="location.href='main'">
    		<p id="tbh">Together Be Healthy</p>
    		<p id="copy">copyright by <span id="hg">HealthGramer</span></p>
    	</div>
    </section>
<%@ include file="./Footer.jsp" %>
</body>
</html>