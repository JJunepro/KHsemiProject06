<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/deleteMember.css" />
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
</head>
<body>
<%@ include file="./Header.jsp" %>
	 <section>
         <form action="delete.do" method="post">
            <h1>회원탈퇴</h1>
            <input type="password" id="mPw" placeholder=" 비밀번호 작성"><br>
            <input type="button" id="delBtn" value="탈퇴하기">
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
         
                //var result = confirm("정말 삭제하시겠습니까?")
                //if(result) {
                    //delMember();
                //}else{
                    //swal("취소하였습니다.")
                //}
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