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
        location.href = "main.html";

    
    // console.log("id : " + id + " pw : " + pw)
}
