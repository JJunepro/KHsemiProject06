<link rel="stylesheet" href="<%=request.getContextPath() %>/css/profile.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>profile</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<%
String id = (String)session.getAttribute("memberId");
String nick = (String)session.getAttribute("nickName");
String name = (String)session.getAttribute("mName");
String birth = (String)session.getAttribute("mBirth");
String phone = (String)session.getAttribute("mPhone");
String email = (String)session.getAttribute("mEmail");
String address = (String)session.getAttribute("mAddress");
String addressDetail = (String)session.getAttribute("mAddressDetail");
String createDate = (String)session.getAttribute("createDate");
%>
</head>
<body>
<%@ include file="./Header.jsp" %>
	<section>
        <form action="login.do" method="post">
            <div>
            <h1 id="title">TBH</h1><br><br>
                <table>
                	<tr>
                        <td id="acountInf" colspan="1">계정 정보</td>
                        <td>TBH계정에 등록된 계정정보 입니다.</td>
                    </tr>
                    <tr>
                        <td>아이디</td>
                        <td><%=id %></td>
                    </tr>
                    <tr>
                        <td>닉네임</td>
                        <td><%=nick %></td>
                    </tr>
                    <tr>
                        <td>이름</td>
                        <td><%=name %></td>
                    </tr>
                    <tr>
                        <td>생년월일</td>
                        <td><%=birth %></td>
                    </tr>
                    <tr>
                        <td>전화번호</td>
                        <td><%=phone %></td>
                    </tr>
                    <tr>
                        <td>이메일</td>
                        <td><%=email %></td>
                    </tr>
                    <tr>
                        <td>주소</td>
                        <td><%=address %><%=addressDetail %></td>
                        <!--  <td style="float: right;"></td>-->
                    </tr>
                    <tr>
                        <td>가입일</td>
                        <td><%=createDate %></td>
                    </tr>
                </table>
                <div id="btn">
                	<input type="button" value="회원정보 수정" id="updateBtn" class="subBtn" onclick="location.href='update'">
                	<input type="button" value="회원탈퇴" class="subBtn" onclick="location.href='delete'">
                </div>
            </div>
        </form>
    </section>
<%@ include file="./Footer.jsp" %>
</body>
</html>