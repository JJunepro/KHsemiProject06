<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/header.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<title>Header</title>
</head>
<body>
	<header>
		<div class="header">
			<div class="headerLogo">
				<h1>
					<a href="<%=request.getContextPath()%>/main"><img
						src="img/logo.png"></a>
				</h1>
				<div class="loginButtonBox">
					<button class="loginButton" onclick="location.href='login'">로그인</button>
					<button class="JoinButton" onclick="location.href='agree'">회원가입</button>
				</div>
				<div class="logoutButtonBox">
					<button class="logoutButton" onclick="location.href='logout'">로그아웃</button>
					<button class="mypageButton" onclick="location.href='profile'">마이페이지</button>
				</div>
			</div>
			<div class="headerNav">
				<ul class="headerNavList">
					<li class="reserveBtn"><a
						href="<%=request.getContextPath()%>/recruitadminlist">예약페이지</a></li>
					<li><a href="<%=request.getContextPath()%>/marketMain">중고나라</a>
					</li>
					<li><a href="<%=request.getContextPath()%>/boardlist">게시판</a>
					</li>
					<li><a href="<%=request.getContextPath()%>/noticelist">공지사항&QnA</a></li>
				</ul>
			</div>
			<div class="subReserve">
				<span><a
					href="<%=request.getContextPath()%>/recruitmainshort">단기</a></span>
				 <span><a
					href="<%=request.getContextPath()%>/recruitmainlong">장기</a></span>

			</div>
		</div>
	</header>
	<script src="js/header.js"></script>
	<script>
		let mId = null;
		$.ajax({
			url : "header",
			method : "post",
			data : null,
			success : function(data) {
				mId = data.memberId
				console.log(mId)
				if (mId !== null) {
					$(".loginButtonBox").hide();
				} else if (mId === null) {
					$(".logoutButtonBox").hide();
				}
			}
		})
	</script>
</body>
</html>
