 <link rel="stylesheet" href="./css/header.css" />
    <link rel="stylesheet" href="./css/index.css"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>T.B.H</title>
   
    <script
    src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script>
      const all = (ele) => document.querySelectorAll(ele);
      const one = (ele) => document.querySelector(ele);
      const slide = function() {
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
   <%@ include file="./Header.jsp" %>
    
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
      <div class="slideBox">
        <h3 class="subTitle">오늘의 인기 Top10!</h3>
        <div id="hotSlideShow">
          <ul class="hotSlides">
           <li><img src="./img/flower.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/fox.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/lightning.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/moon.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/nature.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/space.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/flower.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/fox.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/lightning.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/moon.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            
          </ul>
        </div>
        <p class="hotcontroller">
          <span class="hotPrev">&lang;</span>
          <span class="hotNext">&rang;</span>
        </p>
      </div>
      <div class="slideBox">
        <h3 class="subTitle">모집 마감 임박!</h3>
        <div id="scSlideShow">
          <ul class="scSlides">
           <li><img src="./img/flower.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/fox.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/lightning.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/moon.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/nature.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/space.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/flower.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/fox.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/lightning.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/moon.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            
          </ul>
        </div>
        <p class="scController">
          <span class="scPrev">&lang;</span>
          <span class="scNext">&rang;</span>
        </p>
      </div>
      <div class="slideBox">
        <h3 class="subTitle">코로나 시대에 무슨 모임?</h3>
        <div id="thSlideShow">
          <ul class="thSlides">
           <li><img src="./img/flower.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/fox.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/lightning.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/moon.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/nature.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/space.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/flower.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/fox.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/lightning.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/moon.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
          </ul>
        </div>
        <p class="thController">
          <span class="thPrev">&lang;</span>
          <span class="thNext">&rang;</span>
        </p>
      </div>
      <div class="slideBox">
        <h3 class="subTitle">비대면 모임 Top10!</h3>
        <div id="foSlideShow">
          <ul class="foSlides">
        <li><img src="./img/flower.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/fox.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/lightning.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/moon.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/nature.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/space.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/flower.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/fox.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/lightning.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
            <li><img src="./img/moon.jpg" alt="img" /><p>모임:농구<br>위치:서울 강남</p></li>
          </ul>
        </div>
        <p class="foController">
          <span class="foPrev">&lang;</span>
          <span class="foNext">&rang;</span>
        </p>
      </div>
    </section>
	<%@ include file="./Footer.jsp" %>
    <script src="./js/indexSlides.js"></script>
    <script src="./js/header.js"></script>

  </body>
</html>