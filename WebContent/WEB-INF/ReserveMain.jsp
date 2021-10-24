<link rel="stylesheet" href="css/RecruitMain.css" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>모집 메인</title>
<script>
      const all = (ele) => document.querySelectorAll(ele);
      const one = (ele) => document.querySelector(ele);
      const slide = (_) => {
        const wrap = one(".imageRoom");
        const target = wrap.children[0];
        const len = target.children.length;
        const liStyle = `
                position:absolute;
                left:0;right:0;top:0;bottom:0;transition:1s;opacity:0
            `;
        target.style.cssText = `position:relative;`;
        Array.from(target.children).forEach(
          (ele) => (ele.style.cssText = liStyle)
        );
        target.children[0].style.opacity = 1;
        let pos = 0;
        setInterval((_) => {
          target.children[pos].style.opacity = 0;
          pos = (pos + 1) % len;
          target.children[pos].style.opacity = 1;
        }, 2000);
      };
      window.onload = function () {
        slide();
      };
    </script>
</head>
<body>
	<%@ include file="./Header.jsp"%>

	<section class="body">
		<div class="imageTool">
			<div class="imageRoom">
				<ul>
					<a href="http://www.naver.com"><li></li></a>
					<a href="http://www.naver.com"><li></li></a>
					<a href="http://www.naver.com"><li></li></a>
					<a href="http://www.naver.com"><li></li></a>
				</ul>
			</div>
		</div>
		<div class="dateBox">
			<ul class="date">
				<li>월</li>
				<li>화</li>
				<li>수</li>
				<li>목</li>
				<li>금</li>
				<li>토</li>
				<li>일</li>
			</ul>
		</div>
		<div class="areaBox">
			<ul class="area">
				<li>서울</li>
				<li>경기</li>
				<li>인천</li>
				<li>강원</li>
				<li>충북</li>
				<li>충남</li>
			</ul>
		</div>
		<div class="exerBox">
			<ul class="exer">
				<li>헬스</li>
				<li>필라테스</li>
				<li>크로스핏</li>
				<li>mma</li>
				<li>축구</li>
				<li>농구</li>
			</ul>
		</div>
		<div class="contentBox">
			<ul class="content">
				<li><a href="http://localhost:8090/TBH/ReserveDetail.jsp">content1</a>
				</li>
				<li>content2</li>
				<li>content3</li>
				<li>content4</li>
				<li>content5</li>
				<li>content6</li>
				<li>content7</li>
				<li>content8</li>
				<li>content9</li>
				<li>content10</li>
			</ul>
		</div>
		
	</section>
	<section>
	<div class="card-wrapper">
			<div class="card">
				<p>dldldl1</p>
			</div>
			<div class="card">
				<p>dldldl2</p>
			</div>
			<div class="card">
				<p>dldldl3</p>
			</div>
			<div class="card">
				<p>dldld4</p>
			</div>
			<div class="card">
				<p>dldld5</p>
			</div>
			<div class="card">
				<p>dldldl6</p>
			</div>
			<div class="card">
				<p>dldldl7</p>
			</div>
			<div class="card">
				<p>dldldl8</p>
			</div>
			<div class="card">
				<p>dldld9</p>
			</div>
			<div class="card">
				<p>dldld10!</p>
			</div>
		</div>
	</section>
	<%@ include file="./Footer.jsp"%>
	<script src="./js/header.js"></script>
</body>
</html>
