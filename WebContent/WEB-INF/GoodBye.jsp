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
	<meta charset="UTF-8">
	<title>GoodBye~</title>
</head>
<body>
	<section>
        <div id="img">
        	<img src="./img/cong.jpg">
        </div>
    	<div id="asd">
    		<p id="fstCon">그동안 감사했습니다.</p><br><br>
    		<p id="secCon">TBH는 더욱더 나은 서비스를 위해</p>
    		<p id="secCon">노력하겠습니다!</p>
    		<input type="button" value="메인페이지" id="loginBtn" onclick="location.href='main'">
    		<p id="tbh">Together Be Healthy</p>
    		<p id="copy">copyright by <span id="hg">HealthGramer</span></p>
    	</div>
    </section>
    <%@ include file="./Footer.jsp" %>
</body>
</html>