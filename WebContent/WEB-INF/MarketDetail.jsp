<link rel="stylesheet" href="css/marketDetail.css" />
<link rel="stylesheet" href="css/header.css" />

<%@page import="tbh.articlesix.market.service.MarketService"%>
<%@page import="tbh.articlesix.market.vo.Market"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Market> mkList = (ArrayList<Market>) request.getAttribute("mkList");
	ArrayList<Market> searchList = (ArrayList<Market>) request.getAttribute("searchList");
	ArrayList<Market> detailListOne = (ArrayList<Market>) request.getAttribute("detailListOne");
	ArrayList<Market> chatMarket = (ArrayList<Market>) request.getAttribute("chatMarket");
	String memberId = (String)request.getAttribute("memberId");
	int bmN = 0;
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

</head>
<body>
	<%@ include file="./Header.jsp"%>
	<section class="body">
		<div class="slideBox">
			<div id="slideShow">
				<ul class="slides">
					<%
						if (mkList != null) {
							for (Market mk : mkList) {
					%>
					<li><img src="<%=mk.getImgScr()%>" alt="test" /></li>
					<%
						}
						}
					%>
				</ul>
				<p class="controller">
					<span class="prev">&lang;</span> <span class="next">&rang;</span>
				</p>
			</div>
		</div>
		<%
			if (detailListOne != null) {
				for (Market mk : detailListOne) {
		%>
		<div class="content">
			<div class="expContent">
				<h4><%=mk.getBmTitle()%></h4>
				<div>
					<p>
						작성자:<%=mk.getmId()%></p>
					<p>
						가격:<%=mk.getPrice()%></p>
					<p><%=mk.getBmContent()%></p>
					<p>
						조회수:<%=mk.getBmView()%></p>
					<p>
						날짜:<%=mk.getBmTimeStamp()%></p>
				</div>
			</div>
			<button class="replyShowBtn">댓글보기</button>
		</div>
		<%
			if (chatMarket != null) {
						for (Market rp : chatMarket) {
		%>
		<div class="reserveContent">
			<div class="showReply">

				<div class="writerInfo">
					<div class="showContent"><%=rp.getmId()%></div>
					<div>
						<div class="writeTime"><%=rp.getcTimeStamp()%></div>
						<button class="rewrite">답글 달기</button>
					</div>
				</div>

				<p><%=rp.getcContent()%></p>


				<form class="replyInputBox" action="chatMarket" method="post">
					<input id="comment2" type="text" placeholder="댓글을 적어주세요" />
					<button onclick="clickMoveComment()">확인</button>
				</form>
			</div>

		</div>
		<%
			}
					}
		%>
		<div class="InputBox">
			<input name="cContent" id="comment" type="text" placeholder="댓글을 적어주세요" />
			<button class="replyBtn">확인</button>
		</div>
		<div class="btnBox">
			<a href="marketModify?no=<%=mk.getBmN()%>"><button>수정</button></a> <a
				href="marketDelete?no=<%=mk.getBmN()%>"><button>삭제</button></a>
		</div>
		<%
			}
			}
		%>

		<div class="relatedContent">
			<h4>관련 상품</h4>
			<div class="relatedSlideShow">
				<ul class="relatedSlides">
					<%
						if (searchList != null) {
							for (Market mk : searchList) {
					%><li>
					<div>
					<a class="front"
						href="marketDetail?no=<%=mk.getBmN()%>&title=<%=mk.getBmTitle()%>">
							<img src="<%=mk.getImgScr()%>" alt="img" />
					</a>
					<a class="back"
						href="marketDetail?no=<%=mk.getBmN()%>&title=<%=mk.getBmTitle()%>">
								<img src="<%=mk.getImgScr()%>" alt="img" />
								<div class="relatedInfo">
								<p>가격:<%=mk.getPrice() %></p>
								</div>
					</a>
					</div>
					</li>
					<%
						}
						}
					%>
				</ul>
			</div>
			<p class="relatedController">
				<span class="relatedPrev">&lang;</span> <span class="relatedNext">&rang;</span>
			</p>
		</div>
	</section>

	<%@ include file="./Footer.jsp"%>

	<script src="./js/marketDetail.js"></script>
	<script src="./js/header.js"></script>
	<script>
		$(".reserveContent").hide();
		$(".replyInputBox").hide();

		$(".replyShowBtn").click(function() {
			reserveContent.slideToggle();
		}, function() {
			$(".reserveContent").slideToggle();
		})

		$(".rewrite").click(function() {
			$(".replyInputBox").slideToggle();
		})
		
		$(".replyBtn").click(reply);
		<%
		if (detailListOne != null) {
			for (Market mk : detailListOne) {
				bmN = mk.getBmN();
	%>
		
		
		function reply(){
			
			let bre_level = 1;
			bre_level++;
			const bmN = <%=bmN%>
			const memberId ="<%=memberId%>"
			const cContent = $("#comment").val();
			const bref = 1;
			const breStep = 1;
			
			if(memberId==null){
				alert("로그인을 한 후 이용해주세요")
			}
			if(cContent==null){
				alert("댓글을 입력해주세요")
			}
			
			console.log("<%=memberId%>")
			
			$.ajax({
				url:'chatMarket',
				method:'post',
				data:{
					bmN : bmN,
					memberId : memberId,
					cContent : cContent,
					bref : bref,
					breStep : breStep,
					bre_level : bre_level,
				},
				success:function(resp){
					location.reload();
				}
			})
		
		<%
		}}%>
		}
		
	</script>
</body>
</html>
