<%@page import="tbh.articlesix.market.vo.Market"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<Market> mkList = (ArrayList<Market>) request.getAttribute("mkList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<title>Document</title>
<link rel="stylesheet" href="./css/marketModify.css" />
</head>
<body>
	<%@ include file="./Header.jsp"%>

	<%
		if (mkList != null) {
			for (Market mk : mkList) {
	%>


	<section class="body">
		<div class="formBox">
			<form action="doMarketModify" method="post">
				<h3>중고 물품 수정</h3>
				<table>
					<tr>
						<th>물품 넘버</th>
						<td><input type="text" readonly name="no"
							value="<%=mk.getBmN()%>"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"
							value="<%=mk.getBmTitle()%>"></td>
					</tr>
					<tr>
						<th>사진</th>
						<td><input class="input" type="file" name="img"></td>
						<td><button onclick="onClick()">check</button></td>
						<td><div class="divImg"></div></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input name="price" type="text"
							value="<%=mk.getPrice()%>"></td>
					</tr>
					<tr>
						<th>설명</th>
						<td><textarea name="content" id="explain" cols="50" rows="10"><%=mk.getBmContent()%></textarea></td>
					</tr>
				</table>
				<div class="submitBox">
					<input type="submit" class="formButton" value="수정">
					<input type="reset" value="초기화">
				</div>
				<%
					}
					}
				%>
			</form>
		</div>
	</section>

	<%@ include file="./Footer.jsp"%>

	<script src="./js/header.js"></script>
</body>
</html>
