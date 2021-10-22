<link rel="stylesheet" href="css/marketAdd.css" />
<link rel="stylesheet" href="css/header.css" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

</head>
<body>
	<%@ include file="./Header.jsp" %>
	<section class="body">
		<div class="formBox">
			<form action="doAddMarket" method="post" enctype="multipart/form-data">
				<h3>중고 물품 등록</h3>
				<table>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title"></td>
					</tr>
					<tr>
						<th>사진</th>
						<td>
						<input id="input" class="input" type="file"name="uploadFile1">
						<input id="input" class="input" type="file"name="uploadFile2">
						<input id="input" class="input" type="file"name="uploadFile3">
						</td>
						<td><div class="divImg"></div></td>
					</tr>
					<tr>
						<th>가격</th>
						<td><input type="text" name="price"></td>
					</tr>
					<tr>
						<th>설명</th>
						<td><textarea name="content" id="explain" cols="50" rows="10"></textarea></td>
					</tr>
				</table>
				<div class="submitBox">
					<input id="submit" type="submit" class="formButton">
				</div>

			</form>
		</div>
	</section>
	<%@ include file="./Footer.jsp"%>
	
	<script>
		
	</script>
</body>
</html>
