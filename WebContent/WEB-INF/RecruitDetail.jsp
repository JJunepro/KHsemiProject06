<link rel="stylesheet" href="./css/header.css" />
<link rel="stylesheet" href="./css/index.css" />

<%@page import="tbh.articlesix.board.recruit.model.vo.Recruit"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />

<%
	Recruit bn = (Recruit) request.getAttribute("recruitdetail");
%>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="./css/reservationDetail.css" />
<title>모임참가방 Page</title>
</head>
<body>
	<form method="get" name="form">
		<input type="hidden" name="no" value="<%=bn.getB_n()%>">
		<h1><%=bn.getB_title()%></h1>
		<pre>
				
<span>작성자 : <%=bn.getM_id()%></span>
<span>조회수 : <%=bn.getB_view() + 1%></span>
<span>등록일 : <%=bn.getB_timestamp()%></span>
				</pre>
		</div>
		<div class="articleContent">
			<%=bn.getB_content()%>
		</div>
	</form>


	<div class="btncol">
		<button id="modifybtn" class="btn btn-dark">
			<a href="recruitmodify?no=<%=bn.getB_n()%>">수정</a>
		</button>


		<button id="deletebtn" class="btn btn-dark">
			<a href="recruitdelete?no=<%=bn.getB_n()%>">삭제</a>
		</button>

		<button onclick="location.href='recruitadminlist'" class="btn btn-dark">목록</button>
	</div>

	<script>
		$("#modifybtn").click(function() {
			if (confirm("수정하시겠습니까?")) {
				$("#modify").submit();
			} else {
				return false;
			}
		});

		$("#deletebtn").click(function() {
			if (confirm("이 글을 삭제하시겠습니까?")) {
				$("#modify").submit();
				/* alert("삭제 되었습니다.");
				window.location.href = "noticelist"; */
			} else {
				return false;
			}
		});
	</script>
	<%@ include file="./Footer.jsp"%>

</body>
</html>
</section>
<%@ include file="./Footer.jsp"%>
<script async defer
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyADwT_OchIS3GFVF2oEGPSjhgYcH6Rz1jo&callback=initMap&region=kr"></script>
<script src="./js/map.js"></script>
<script src="./js/header.js"></script>
</body>
</html>