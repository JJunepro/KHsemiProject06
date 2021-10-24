<link rel="stylesheet" href="<%=request.getContextPath() %>/css/joinMember.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 Page</title>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
    <%@ include file="./Header.jsp" %>
       
       <section>
        <form action="join.do" method="POST" id="joinfrm">
            <div>
                <div>
                    <h1 id="title">회원가입</h1>
                </div>
            <div>
                <label>아이디</label><br>
                <input type="text" class="textBox" id="joinId" name="joinId" placeholder=" 사용하실 아이디를 입력해 주세요.">
                <input type="button" id="dupId" class="checkBtn" value="중복확인"><br><br>
                <label>비밀번호</label><br>
                <input type="password" class="textBox" id="joinPw" name="joinPw" placeholder=" 8자이상  12이하"><br><br>
                <label>비밀번호 확인</label><br>
                <input type="password" class="textBox" id="joinPwRe" placeholder=" 알파벳과 특수문자가 각각 1개 이상 필요합니다."><br><br>
                <label>닉네임</label><br>
                <input type="text" class="textBox" id="joinNick" name="joinNick" placeholder=" 사용하실 닉네임을 입력해 주세요.">
                <input type="button" id="dupNick" class="checkBtn" value="중복확인"><br><br>
                <label>이름</label><br>
                <input type="text" class="textBox" id="joinName" name="joinName" placeholder=" 주민등록상 이름을 입력해주세요."><br><br>
                
                    <div id="genderDate">
                        <div id="joinGender">
                            <label>성별</label><br>
                            <select id="selGender" class="selGender" name="selGender">
                            	<option value="">성별</option>
                            	<option value='m' id="male">남성</option>
                            	<option value='f' id="female">여성</option>
                            </select>
                        </div>
                        <div id="joinBirth">
                            <label>생년월일</label><br>
                            <input type="date" id="dateBox" name="dateBox"><br><br>
                        </div>
                    </div>
                    
                    <label>전화번호</label><br>
                    <input type="text" class="textBox" id="joinPhone" name="joinPhone" placeholder=" ' - '은 제외하고 입력해주세요."><br><br>
                    <label>이메일</label><br>
                    <input type="email" class="textBox" id="joinEmail" name="joinEmail" placeholder=" 등록하실 이메일을 입력해 주세요.">
                    <input type="button" id="sendEmail" class="emailBtn" value="인증"><br>
                    <input type="text" id="autBox" class="textBox" placeholder=" 인증코드를 입력해 주세요.">
                    <input type="button" id="checkAut" class="emailBtn"  value="확인"><br><br>
                    
                    <label>주소</label><br>
                    <input type="text" class="textBox" placeholder=" 주소 (클릭하면 검색창이 열립니다)" id="kakaoAddress"><br>
                    <input type="text" class="textBox" placeholder=" 상세주소"id="kakaoAddressDetail"><br><br><!-- 카카오맵 api -->
             </div>
                  <input type="button" value="회원가입" class="checkBtn" id="joinMemberBtn">
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
    }
    </script>
    <script>
	    $(function(){
	    	// 아이디 
	    	// 유효성
	    	$("#dupId").on("click", function(){
                 var idCheck = RegExp(/^[a-zA-Z0-9]{4,12}$/);
                 if($("#joinId").val()==""){
                     swal("", "아이디를 입력해 주세요.", "error");
                     $("#joinId").focus;
                     return false;
                 }
                 if(!idCheck.test($("#joinId").val())){
                     swal("", "아이디는 알파벳과 숫자만 입력 가능합니다. (최소 4자, 최대 12자)", "error");
                     $("#joinId").val(""); 
                     $("#joinId").focus(); 
                     return false;
                 }
                 callDupId()
	    		});
	    	// 중복체크
	    		function callDupId(){
	    		$.ajax({
	    			type: "post",
	    			url: "dupId",
	    			data: {
	    				m_id: $("#joinId").val()
	    			},
	    			dataType: "json",
	    			success: function(data) {
	    				if(data.result == "ok"){
	    					swal("", "사용가능한 아이디입니다.", "success");     
	    				}else{
	    					swal("", "이미 가입되어있는 아이디입니다.", "error");
	    				}
	    			},
	    			error: function(request, status, error){
	                    console.log(request)
	                    console.log(status)
	                    console.log(error)
	                    swal("err")
	    			}
	    		});    	
	    	};
	    	
	    	//닉네임
	    	//유효성
	    	$("#dupNick").on("click", function(){
                var nickCheck = RegExp(/^[a-zA-Z0-9가-힣]{2,12}$/);
                if($("#joinNick").val()==""){
                    swal("", "닉네임을 입력해 주세요.", "error");
                    $("#joinNick").focus;
                    return false;
                }
                if(!nickCheck.test($("#joinNick").val())){
                    swal("", "닉네임은 한글, 알파벳, 숫자만 입력 가능합니다. (최소 2자, 최대 12자)", "error")
                    $("#joinNick").val(""); 
                    $("#joinNick").focus(); 
                    return false;
                }
                callDupNick()
	    		});
	    	//중복체크
	    	function callDupNick(){
	    		$.ajax({
	    			type: "post",
	    			url: "dupNick",
	    			data: {
	    				m_nick: $("#joinNick").val()
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
	                    swal("err")
	    			}
	    		});    	
	    	};
	    	//이메일
	    	//function callDupEmail(){
	    		$("#sendEmail").on("click", function(){
	    			$.ajax({
	    				type: "post",
	    				url: "dupEmail",
	    				data: {
	    					m_email: $("#joinEmail").val()
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
	                    	swal("err")
	    				}
	    			});
	    			
	    		});
	    		function sendEmail(){
	    			$.ajax({
	    				type: "post",
	    				url: "sendEmail",
	    				data: {
	    					m_email: $("#joinEmail").val()
	    				},
	    				dataType: "json",
	    				success: function(data) {
	    					if(data.result == "ok"){   
	    						swal("", "인증메일이 발송되었습니다.", "success")
	    					}else{
	    						console.log(data.result);
	    						swal("", data.msg, "error")
	    					}
	    				},
	    				error: function(request, status, error){
	                    	console.log(request)
	                    	console.log(status)
	                    	console.log(error)
	                    	swal("err")
	    				}
	    			});
	    		};
	    		//인증코드 확인
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
                			<!--m_email: $("#uEmail").val(),-->
                			m_email: $("#joinEmail").val(),
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
	    });
    </script>
    <script>
        $(function(){
        	$("#joinMemberBtn").on("click", function(){
                $.ajax({ 
                    type: "post",
                    url: "join.do",
                    data: {
                        m_id: $("#joinId").val(),
                        m_pw: $("#joinPw").val(),
                        m_nick: $("#joinNick").val(),
                        m_name: $("#joinName").val(),
                        m_birth: $("#dateBox").val(),
                        m_gender: $("#selGender option:selected").val(),
                        m_phone: $("#joinPhone").val(),
                        m_email: $("#joinEmail").val(),
                        m_address: $("#kakaoAddress").val(),
                        m_address_detail: $("#kakaoAddressDetail").val()
                    },
                    dataType: "json",
                    success: function(data) {
                        if(data.result == "ok"){
                        	swal("", "회원가입이 완료되었습니다.", "success").then(function() {
                                location.href="congratulations";
                            });
                        }else{
                            swal("", "회원가입실패!", "error");
                        }
                    },
                    error: function(request, status, error){
                        console.log(request)
                        console.log(status)
                        console.log(error)
                    }
                });
                
                $(function check(){
                	//숫자, 영문, 특수문자 각 1자리 이상이면서 8자에서 16자 사이 통과
                    var pwCheck = RegExp(/^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{8,16}$/);  //비밀번호
                    var nameCheck = RegExp(/^[가-힣]{2,8}$/);
                   
                    if($("#joinId").val()==""){
                        swal("", "아이디를 입력해 주세요.", "error");
                        $("#joinId").focus;
                        return false;
                    }

                    //비밀번호
                    if($("#joinPw").val()==""){
                        swal("", "비밀번호를 입력해 주세요.", "error")
                        $("#joinPw").focus;
                        return false;
                    }
                    if($("#joinPwRe").val()==""){
                        swal("", "비밀번호 확인란을 입력해 주세요.", "error")
                        $("#joinPwRe").focus;
                        return false;
                    }
                    if($("#joinPw").val() != $("#joinPwRe").val()){ 
                        swal("", "비밀번호가 같지않습니다.", "error");
                        $("#joinPw").val("");
                        $("#joinPwRe").val("");
                        $("#joinPw").focus();
                        return false;
                        }
                        if(!pwCheck.test($("#joinPw").val())){
                        swal("", "알파벳, 숫자, 특수문자를 각각 1자 이상 사용해야 합니다. (최소 8자, 최대 16자)", "error")
                        $("#joinPw").val(""); 
                        $("#joinPw").focus(); 
                        return false;
                    }
                    
                    //이름
                    if($("#joinName").val()==""){
                        swal("", "이름을 입력해 주세요.", "error")
                        $("#joinName").focus;
                        return false;
                    }
                    //성별
                    if($("#selGender").val()==""){
                        swal("", "성별을 선택해 주세요.", "error")
                        $("#selGender").focus;
                        return false;
                    }
                    //생년월일
                    if($("#dateBox").val()==""){
                        swal("", "생년월일을 선택해 주세요.", "error")
                        $("#dateBox").focus;
                        return false;
                    }
                    //전화번호
                    if($("#joinPhone").val()==""){
                        swal("", "전화번호를 입력해 주세요.", "error")
                        $("#joinPhone").focus;
                        return false;
                    }
                    //이메일
                    if($("#joinEmail").val()==""){
                        swal("", "이메일을 입력해 주세요.", "error")
                        $("#joinEmail").focus;
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
                callDupPhone()
            });
        	function callDupPhone(){
	    		$.ajax({
	    			type: "post",
	    			url: "dupPhone",
	    			data: {
	    				m_phone: $("#joinPhone").val()
	    			},
	    			dataType: "json",
	    			success: function(data) {
	    				if(data.result == "ok"){     
	    				}else{
	    					swal("", "이미 가입되어있는 전화번호입니다.", "error");
	    				}
	    			},
	    			error: function(request, status, error){
	                    console.log(request)
	                    console.log(status)
	                    console.log(error)
	                    swal("err")
	    			}
	    		});    	
	    	};
	    	
        });
    </script>
    </html>