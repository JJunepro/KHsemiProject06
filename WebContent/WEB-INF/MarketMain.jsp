<%@page import="tbh.articlesix.market.service.MarketService"%>
<%@page import="tbh.articlesix.market.vo.Market"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	int imgNum = 0;
	ArrayList<Market> mkList = (ArrayList<Market>) request.getAttribute("mkList");
	ArrayList<Market> hotMkList = (ArrayList<Market>) request.getAttribute("hotMkList");
	ArrayList<Market> searchMkList = (ArrayList<Market>) request.getAttribute("searchMkList");
	ArrayList<Market> listOne = (ArrayList<Market>) request.getAttribute("listOne");
	int startPage = Integer.parseInt(request.getAttribute("startPage").toString());
	int endPage = Integer.parseInt(request.getAttribute("endPage").toString());
	int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Document</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/marketMain.css" />
</head>
<body>
	<%@ include file="./Header.jsp"%>

	<section class="body">
		<div class="searchBox">
			<form method="GET" action="searchMarket" id="frm1">
				<input type="text" id="search" name="searchTitle"
					placeholder="찾고 싶은 상품을 입력해주세요" /> <input type="submit"
					id="searchBtn" value="확인" />
			</form>
			<div>
				<a href="<%=request.getContextPath()%>/marketAdd"><button
						id="searchBtn">추가</button></a>
			</div>
		</div>



		<div class="slideBox">
			<h3 class="subTitle">오늘의 HOT 아이템!</h3>
			<div id="hotSlideShow">
				<ul class="hotSlides">
					<%
						if (hotMkList != null) {
							for (Market no : hotMkList) {
					%>
					<a
						href="marketDetail?no=<%=no.getBmN()%>&title=<%=no.getBmTitle()%>">
						<li><img
							src="<%=no.getImgScr()%>" alt="img" />
							<p>
								제목:<%=no.getBmTitle()%>
								<br />가격:<%=no.getPrice()%>
							</p></li>
					</a>
					<%
						}
						}
					%>
				</ul>
			</div>
			<p class="hotcontroller">
				<span class="hotPrev">&lang;</span> <span class="hotNext">&rang;</span>
			</p>
		</div>


		<%
			if (listOne != null) {
				for (Market no : listOne) {
		%>
		<div class="listBox">
			<ul class="listContent">
				<a
					href="marketDetail?no=<%=no.getBmN()%>&title=<%=no.getBmTitle()%>">
					<li><img
						src="<%=no.getImgScr()%>" alt="img" />
						<div>
							<p><%=no.getBmTitle()%></p>
							<p>가격</p>
						</div>
						<p><%=no.getBmContent()%></p></li>
				</a>
			</ul>
		</div>
		<%
			}
			}
		%>
		<div class="pageBox">
			<%
				int currentPage = 1;
				if (startPage > 1)
			%><a href="marketMain">이전</a>
			<%
				for (int i = startPage; i <= endPage; i++) {
			%>
			<a href="marketMain?pagenum=<%=i%>"><%=i%></a>
			<%
				currentPage = i;
					if (i != endPage) {
			%>
			<%
				}
				}

				if (endPage < pageCount)
			%><a href="marketMain">다음</a>
			<%
				
			%>
		</div>

	</section>

	<%@ include file="./Footer.jsp"%>


	<script src="js/marketMain.js"></script>
	<script src="js/header.js"></script>
</body>
</html>
