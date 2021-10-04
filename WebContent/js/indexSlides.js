"use strict";
const slideWidth = 2500;
const slideMargin = 500;
let currentIdx = 0;

function slideAction(prev, next, slides, slideCount) {
  slides.style.width = (slideWidth + slideMargin) * slideCount + "px";
  function moveSlide(slides, num, slideCount) {
    slides.style.left = -num * 500 + "px";
    currentIdx = num;
  }

  prev.addEventListener("click", function () {
    if (currentIdx !== 0) {
      moveSlide(slides, currentIdx - 1, slideCount);
    }
  });

  next.addEventListener("click", function () {
    if (currentIdx !== slideCount * 0.3) {
      // 10의 자리 단위로 사진 개수를 나타내야 함
      moveSlide(slides, currentIdx + 1);
    }
  });
}

let hotSlides = document.querySelector(".hotSlides");
let hotSlideImg = document.querySelectorAll(".hotSlides li");

let hotSlideCount = hotSlideImg.length;
const hotPrev = document.querySelector(".hotPrev");
const hotNext = document.querySelector(".hotNext");

slideAction(hotPrev, hotNext, hotSlides, hotSlideCount);

let scSlides = document.querySelector(".scSlides");
let scSlideImg = document.querySelectorAll(".scSlides li");

let scSlideCount = scSlideImg.length;
const scPrev = document.querySelector(".scPrev");
const scNext = document.querySelector(".scNext");

slideAction(scPrev, scNext, scSlides, scSlideCount);

let thSlides = document.querySelector(".thSlides");
let thSlideImg = document.querySelectorAll(".thSlides li");

let thSlideCount = thSlideImg.length;
const thPrev = document.querySelector(".thPrev");
const thNext = document.querySelector(".thNext");

slideAction(thPrev, thNext, thSlides, thSlideCount);

let foSlides = document.querySelector(".foSlides");
let foSlideImg = document.querySelectorAll(".foSlides li");

let foSlideCount = foSlideImg.length;
const foPrev = document.querySelector(".foPrev");
const foNext = document.querySelector(".foNext");

slideAction(foPrev, foNext, foSlides, foSlideCount);