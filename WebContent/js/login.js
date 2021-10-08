
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
        // location.href = "main.html";

        callLogin(id, pw)

    
    // console.log("id : " + id + " pw : " + pw)
    
}

function callLogin(id, pw) {
    $.ajax({
        type: "POST",
        url: "login",
        data: {
            m_id: id,
            m_pw: pw
        },
        dataType : "json",
        success : function(data) {
            if(data.result == "ok"){
                console.log(data.result)
                alert("로그인 성공.");
            }else{
                console.log(data.result)
                alert("아이디와 비밀번호를 확인해주세요.");
            }
        },
        error : function(request, status, error){
            console.log(request)
            console.log(status)
            console.log(error)
            alert("뿌앵")
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
            }
    })
    
} 
// $(function(){
//     $("#loginBtn").on("click", function(){
//         $.ajax({
//             type: "POST",
//             url: "login",
//             data: {
//                 m_id: $("#lojinId").val(),
//                 m_pw: $("#loginPw").val()
//             },
//             dataType : "json",
//             success : function(data) {
//                 if(data.result == "ok"){

//                 }else{
//                     console.log(data.result)
//                     alert("아이디와 비밀번호를 확인해주세요.");
//                 }
//             },
//             error : function(request, status, error){
//                 alert("뿌앵")
//             }
//         });

//     });
// });


