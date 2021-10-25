<link rel="stylesheet" href="css/marketMain.css" />
<link rel="stylesheet" href="css/header.css" />
<%@page import="tbh.articlesix.market.service.MarketService"%>
<%@page import="tbh.articlesix.market.vo.Market"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Market> searchMkList = (ArrayList<Market>) request.getAttribute("searchMkList");
int startPage = Integer.parseInt(request.getAttribute("startPage").toString());
int endPage = Integer.parseInt(request.getAttribute("endPage").toString());
int pageCount = Integer.parseInt(request.getAttribute("pageCount").toString());
String memberId = (String)request.getAttribute("memberId");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Market Search</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>

</head>
<body>
	<%@ include file="./Header.jsp"%>

	<section class="body">
		<div class="searchBox">
			<form method="GET" action="searchMarket" id=frm1>
				<input type="text" id="search" name="searchTitle" placeholder="찾고 싶은 상품을 입력해주세요" />
				 <input type="submit" id="searchBtn" value="확인" />
			</form>
			<div class="addbtn">
				<a href="<%=request.getContextPath()%>/marketAdd"><button
						id="searchBtn">추가</button></a>
			</div>
		</div>
		<%
			if (searchMkList != null) {
				for (Market mk : searchMkList) {
		%>
		<div class="listBox">
			<ul class="listContent">
				<a href="marketDetail?no=<%=mk.getBmN()%>&title=<%=mk.getBmTitle()%>">
					<li>
					<div class="detailImg">
					<img src="<%=mk.getImgScr()%>" alt="img" />
					</div>
						<div class="listTitle">
							<p><%=mk.getBmTitle()%></p>
							<p>가격</p>
						</div class="listContent">
						<p><%=mk.getBmContent()%></p></li>
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
			<a class="orderNum" href="marketMain?pagenum=<%=i%>"><%=i%></a>
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
	<script>
	$(".addbtn").hide();
	console.log(<%=memberId%>)
		if("<%=memberId%>" !== "null"){
			$(".addBtn").show();
		}else if("<%=memberId%>" === "null"){
			$(".addBtn").hide();
		}
	</script>
</body>
</html>
