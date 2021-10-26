<link rel="stylesheet" href="<%=request.getContextPath() %>/css/updateMember.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <title>회원정보 수정 Page</title>
</head>
<body>
    <%@ include file="./Header.jsp" %>
    <section>
        <form action="update.do" method="POST" id="updatefrm">
            <div>
	            <h1 id="title">회원정보 수정</h1>
	            <label>새로운 비밀번호</label><br>
	            <input type="password" id="upPw" class="textBox" placeholder=" 8자이상 12자이하"><br><br>
	            <label>비밀번호 확인</label><br>
	            <input type="password" id="upPwCh" class="textBox" placeholder=" 알파벳과 특수문자가 각각 1개 이상 필요합니다."><br><br>
                <label>닉네임</label><br>
	            <input type="text" id="upNick" class="btnTextBox" placeholder=" 사용하실 닉네임을 입력해 주세요.">
                <input type="button" id="dupNick" class="btnCheck" value="확인"><br><br>
	            <label>전화번호</label><br>
	            <input type="text" id="upPhone" class="textBox" placeholder=" ' - '은 제외하고 작성해주세요."><br><br>
	            <label>이메일</label><br>
                <input type="email" id="upEmail" class="btnTextBox" placeholder=" 등록하실 이메일을 입력해 주세요.">
                <input type="button" id="sendEmail" class="btnCheck" value="인증"><br>
	            <input type="text" id="autBox" class="btnTextBox" placeholder=" 인증코드를 입력해 주세요.">
                <input type="button" id="checkAut" class="btnCheck" value="확인"><br><br>
	            <label>주소</label><br>
	            <input type="text" id="kakaoAddress" class="textBox" placeholder=" 주소 (클릭하면 검색창이 열립니다)"><br>
	            <input type="text" id="kakaoAddressDetail" class="textBox" placeholder=" 상세주소"><br><br>
	            <!-- 카카오맵 api -->
	            <input type="button" value="수정" id="upBrn">
	            <!-- 수정후 마이페이지 -->
	            <p id="note">*회원정보 수정이 완료되면 자동으로 로그아웃 됩니다.
            </div>
        </form>
    </section>
    <%@ include file="./Footer.jsp" %>
</body>
<script>
    window.onload = function(){
            document.getElementById("kakaoAddress").addEventListener("click", function(){ //주소입력칸을 클릭
            new daum.Postcode({
                oncomplete: function(data) {
                    document.getElementById("kakaoAddress").value = data.address;
                    //document.querySelector("kakaoAddressDetail").focus();
                    document.querySelector("input[id=kakaoAddressDetail]").focus();
                }
            }).open();
        });
    };
</script>
<script>
    $(function(){
        $("#dupNick").on("click", function(){
            var nickCheck = RegExp(/^[a-zA-Z0-9가-힣]{2,12}$/);
                if($("#upNick").val()==""){
                    swal("", "닉네임을 입력해 주세요.", "error");
                    $("#upNick").focus;
                    return false;
                }
                if(!nickCheck.test($("#upNick").val())){
                    swal("", "닉네임은 한글, 알파벳, 숫자만 입력 가능합니다. (최소 2자, 최대 12자)", "error")
                    $("#upNick").val(""); 
                    $("#upNick").focus(); 
                    return false;
                }
                callDupNick()
	    	    });
                function callDupNick(){
	    		$.ajax({
	    			type: "post",
	    			url: "dupNick",
	    			data: {
	    				m_nick: $("#upNick").val()
	    			},
	    			dataType: "json",
	    			success: function(data) {
	    				if(data.result == "ok"){
	    					swal("", "사용가능한 닉네임입니다.", "success");     
	    				}else{
	    					swal("", "이미 가입되어있는 닉네임입니다.", "error");
	    				}
	    			},
	    			error: function(request, status, error){
	                    console.log(request)
	                    console.log(status)
	                    console.log(error)
	                    swal("", "err", "error")
	    			}
	    		});    	
	    	};
        $("#sendEmail").on("click", function(){
            $.ajax({
	    		type: "post",
	    		url: "dupEmail",
	    		data: {
	    			m_email: $("#upEmail").val()
	    		},
	    		dataType: "json",
	    		success: function(data) {
	    			if(data.result == "ok"){    
	    				sendEmail()
	    			}else{
	    				swal("", "이미 가입되어있는 이메일입니다.", "error");
	    			}
	    		},
	    		error: function(request, status, error){
	                console.log(request)
	                console.log(status)
	                console.log(error)
	                swal("", "err", "error")
	    		}
            });
        });
        function sendEmail(){
            $.ajax({
	    		type: "post",
	    		url: "sendEmail",
	    		data: {
	    			m_email: $("#upEmail").val()
	    		},
	    		dataType: "json",
	    		success: function(data) {
	    			if(data.result == "ok"){   
	    				swal("", "인증메일이 발송되었습니다.", "success")
	    			}else{
	    				console.log(data.result);
	    			}
	    		},
	    		error: function(request, status, error){
	                console.log(request)
	                console.log(status)
	                console.log(error)
	                swal("", "err", "error")
	    		}
	    	});
        };
        $("#checkAut").on("click", function(){
                	if($("#autBox").val()==""){
                        swal("", "인증코드를 입력해주세요.", "error");
                        $("#autBox").focus;
                        return false;
                    }
                	checkAut();
                });
                function checkAut() {
                	$.ajax({
                		type: "post",
                		url: "checkEmail",
                		data: {
                			m_email: $("#upEmail").val(),
                			verCode: $("#autBox").val()
                		},
                		dataType: "json",
                		success: function(data) {
							if(data.result == "ok"){
								console.log(data.result);
								swal("", "이메일 인증이 완료되었습니다.", "success")
							}else{
								console.log(data.msg);
								swal("", "인증코드가 일치하지 않습니다.", "error")
								
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
        $("#upBrn").on("click", function(){
            $.ajax({
                type: "post",
                url: "update.do",
                data: {
                    //pw, nick, phone, email, address1, address2
                    m_pw: $("#upPw").val(),
                    m_nick: $("#upNick").val(),
                    m_phone: $("#upPhone").val(),
                    m_email: $("#upEmail").val(),
                    m_address: $("#kakaoAddress").val(),
                    m_address_detail: $("#kakaoAddressDetail").val()
                },
                dataType: "json",
                success: function(data){
                    if(data.result == "ok"){
                        swal("", "회원정보 수정이 완료되었습니다.", "success").then(function() {
                        location.href="main";
                        });
                    }else{
                        swal("", "오류", "error")
                    }
                },
                error: function(request, status, error){
                    console.log(request)
                    console.log(status)
                    console.log(error)
                }
            });
            $.ajax({
	    		type: "post",
	    		url: "dupPhone",
	    		data: {
	    			m_phone: $("#upPhone").val()
	    		},
	    		dataType: "json",
	    		success: function(data) {
	    			if(data.result == "ok"){     
	    			}else{
	    				swal("","이미 가입되어있는 전화번호입니다.", "error");
	    			}
	    		},
	    		error: function(request, status, error){
	                console.log(request)
	                console.log(status)
	                console.log(error)
	                swal("", "err", "error")
	    		}
	    	});
            $(function check(){
                var pwCheck = RegExp(/^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/);  //비밀번호

                if($("#upPw").val()==""){
                    swal("", "비밀번호를 입력해 주세요.", "error")
                    $("#upPw").focus;
                    return false;
                }
                if($("#upPwCh").val()==""){
                    swal("", "비밀번호 확인란을 입력해 주세요.", "error")
                    $("#upPwCh").focus;
                    return false;
                }
                if($("#upPw").val() != $("#upPwCh").val()){ 
                    swal("", "비밀번호가 같지않습니다.", "error");
                    $("#upPw").val("");
                    $("#upPwCh").val("");
                    $("#upPw").focus();
                    return false;
                }
                if(!pwCheck.test($("#upPw").val())){
                    swal("", "알파벳, 숫자, 특수문자를 각각 1자 이상 사용해야 합니다. (최소 8자, 최대 16자)", "error")
                    $("#upPw").val(""); 
                    $("#upPw").focus(); 
                    return false;
                }
                if($("#upPhone").val()==""){
                    swal("", "전화번호를 입력해 주세요.", "error")
                    $("#upPhone").focus;
                    return false;
                }
                if($("#upEmail").val()==""){
                    swal("", "이메일을 입력해 주세요.", "error")
                    $("#upEmail").focus;
                    return false;
                }//주소
                if($("#kakaoAddress").val()==""){
                    swal("", "주소를 입력해 주세요.", "error")
                    $("#kakaoAddress").focus;
                    return false;
                }
                if($("#kakaoAddressDetail").val()==""){
                    swal("", "상세주소를 입력해 주세요.", "error")
                    $("#kakaoAddressDetail").focus;
                    return false;
                }
            });   	
        });
    });
</script>
</html>