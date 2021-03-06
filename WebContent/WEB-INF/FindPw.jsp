<link rel="stylesheet" href="<%=request.getContextPath() %>/css/findIdPw.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ID/PW찾기 Page</title>
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
    <body>
    <%@ include file="./Header.jsp" %>
    	<section>
        <form action="findPw.do" id="frm">
            <fieldset>
                <div id="title">
                    <h1>ID/PW찾기</h1>
                </div>
    
                <div id="selectBtn">
                    <input type="button" id="findIdBtn" class="selectBtn" value="아이디" onclick="location.href='findId'">
                    <input type="button" id="findPwBtn" class="selectBtn" value="비밀번호" style="background-color: #95c2b7; color: oldlace;"><br>
                </div>
    
                <div id="all">
                    <div id="nameBox">
                        <label>아이디</label><br>
                        <input type="text" id="uId" placeholder=" 아이디를 입력하세요."><br>
                    </div>
    
                    <div id="cellNumBox">
                        <label>이메일 인증</label><br>
                        <input type="email" id="uEmail" placeholder=" 회원가입시 이메일을 입력하세요.">
                        <input type="button" id="send" value="전송"><br>
                        <input type="text" id="authentication" placeholder=" 인증코드를 입력하세요.">
                    </div>
                </div>
                <div id="findBtn">
                    <input type="button" id="find" value="찾기">
                </div>
            </fieldset>
        </form>
        </section>
        <%@ include file="./Footer.jsp" %>
         </body>
        <script>
            $(function(){
                $("#send").on("click", function(){
                	if($("#uId").val()==""){
                        swal("", "아이디를 입력해 주세요.", "error");
                        $("#uId").focus;
                        return false;
                    }
                	if($("#uEmail").val()==""){
                        swal("","이메일을 입력해 주세요.", "error");
                        $("#uEmail").focus;
                        return false;
                    }
                	sendEmail();
                });
                function sendEmail() {
                    $.ajax({
                        type: "post",
                        url: "findPw.do",
                        data: {
                            m_id: $("#uId").val(),
                            m_email: $("#uEmail").val()
                        },
                        dataType: "json",
                        success: function(data) {
                            if(data.result == "ok"){
                                console.log(data.result);
                                swal("", "인증메일이 발송되었습니다.", "success")
                            }else{
                                console.log(data.result);
                                swal("", "회원정보가 맞지않습니다.", "error")
                            }
                        },
                        error : function(request, status, error){
                            console.log(request)
                            console.log(status)
                            console.log(error)
                            
                            }
                    });
                };
            });
            $(function(){
                $("#find").on("click", function(){
                	if($("#authentication").val()==""){
                        swal("", "인증코드를 입력해주세요.", "error");
                        $("#authentication").focus;
                        return false;
                    }
                	findPw();
                });
                function findPw() {
                	$.ajax({
                		type: "post",
                		url: "showPw",
                		data: {
                			m_id: $("#uId").val(),
                			m_email: $("#uEmail").val(),
                			verCode: $("#authentication").val()
                		},
                		dataType: "json",
                		success: function(data) {
							if(data.result == "ok"){
								console.log(data.result);
								swal("회원님의 비밀번호는", data.msg+" 입니다", "success").then(function(){
									location.href="login";
									});
							}else{
								console.log(data.msg);
								swal("", data.msg, "error");
								
							}
						},
						 error: function(request, status, error){
							 	console.log(request)
	                            console.log(status)
	                            console.log(error)
	                            swal("", "오류가 발생하였습니다.", "error");
	                            
						 }
                	});
                };
            });
        </script>
   
    </html>