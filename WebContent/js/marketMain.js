"use strict";

let hotSlides = document.querySelector(".hotSlides");
let hotSlideImg = document.querySelectorAll(".hotSlides li");

let currentIdx = 0;
let slideCount = hotSlideImg.length;
const prev = document.querySelector(".hotPrev");
const next = document.querySelector(".hotNext");

const slideWidth = 2500;
const slideMargin = 500;
hotSlides.style.width = (slideWidth + slideMargin) * slideCount + "px";

function moveSlide(slides, num) {
  slides.style.left = -num * 500 + "px";
  currentIdx = num;
}

prev.addEventListener("click", function () {
  if (currentIdx !== 0) {
    moveSlide(hotSlides, currentIdx - 1);
  }
});

next.addEventListener("click", function () {
  if (currentIdx !== slideCount*0.3) { // 10의 자리 단위로 사진 개수를 나타내야 함 
    moveSlide(hotSlides, currentIdx + 1);
  }
});
