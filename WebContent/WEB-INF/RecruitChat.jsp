<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅화면 구현</title>
</head>
<body>
	<div class="chat_screen">
		<div class="chat_timestamp"></div>
		<div class="chat_messages">
			<ul>
				<!-- 동적생성 -->
			</ul>
		</div>
		<div class="write">
			<textarea placehoder="Press Enter for message." rows="4" cols="20"></textarea>
		</div>

		<div class="chatformat">
			<ul>
				<li>
					<div class="sender">
						<span></span>
					</div>
					<div class="writer">
						<span></span>
					</div>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>