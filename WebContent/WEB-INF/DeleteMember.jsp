<link rel="stylesheet" href="<%=request.getContextPath() %>/css/deleteMember.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴 Page</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
    <%@ include file="./Header.jsp" %>
         <section>
             <form action="delete.do" method="post">
                <h1>회원탈퇴</h1><br>
                <p>그동안 TBH를 이용해 주셔서 감사합니다.</p>
                <p>회원님의 소중한 의견을 받아 더 좋은 TBH가 되도록 노력하겠습니다.<br><br>
                    <hr><br>
                    <div class="checkbox">
                        <table>
                            <tr>
                                <td><input type="checkbox" class="checkbox1"> 사이트 사용 빈도 낮음</td>
                                <td><input type="checkbox" class="checkbox1"> 사이트내의 잦은 오류<br></td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" class="checkbox1"> 컨텐츠 오류로 인한 불만족ㅤㅤㅤㅤㅤㅤ</td>
                                <td><input type="checkbox" class="checkbox1"> 원하는 컨텐츠 부족<br></td>
                            </tr>
                            <tr>
                                <td><input type="checkbox" class="checkbox1"> 개인정보 유출 우려</td>
                                <td><input type="checkbox" class="checkbox1"> 컨텐츠 내용 불만<br></td>
                            </tr>
                            <tr>
                                <td colspan="2"><input type="checkbox" class="checkbox1"> <input type="text" placeholder="직접입력"  id="reasonBox"><br></td>
                                <td></td>
                            </tr>
                        </table><br>
                    </div>
                    <hr><br>
                <input type="password" id="mPw" placeholder=" 비밀번호"><br>
                <input type="button" id="delBtn" value="탈퇴하기"><br><br>
                <p class="endP">*탈퇴 처리된 ID는 다시 생성할 수 없습니다.</p>
                <p class="endP">*탈퇴 처리되면 즉시 계정정보가 삭제됩니다.</p>
             </form>
         </section>
    <%@ include file="./Footer.jsp" %>
    </body>
<script>
    $(function(){
        $("#delBtn").on("click", function(){
            $(function checkRe(){
            	swal({
          			title: "정말 탈퇴하시겠습니까?",
          		  	text: "승인하시면 회원 정보 복구가 블가합니다.",
          		  	icon: "warning",
          		  	buttons: true,
          		  	dangerMode: true,
          			}).then(function(e){
          			if(e){
          				delMember();
          		  	} else {
          		    swal("취소하였습니다.");
          		  	}
          		});
			});
		});
    });
            function delMember(){
                $.ajax({
                    type: "post",
                    url: "delete.do",
                    data: {
                        m_pw: $("#mPw").val()
                    },
                    dataType: "json",
                    success: function(data){
                        if(data.result == "ok"){
                        	swal("", "탈퇴처리 되었습니다.", "success");
                        	location.href="GoodBye";
                        }else{
                            swal("", "패스워드가 맞지않습니다.", "error");
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
    	
</script>
</html>