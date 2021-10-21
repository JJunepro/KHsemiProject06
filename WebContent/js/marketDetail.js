const slides = document.querySelector(".slides");
const slideImg = document.querySelectorAll(".slides li");
let currentIdx = 0;
const slideCount = slideImg.length;
const prev = document.querySelector(".prev");
const next = document.querySelector(".next");

const relatedSlides = document.querySelector(".relatedSlides");
const relatedSlidesImg = document.querySelectorAll(".relatedSlides li");
const relatedSlidesCount = relatedSlidesImg.length;
let relatedCurrentIdx = 0;
const relatedPrev = document.querySelector(".relatedPrev");
const relatedNext = document.querySelector(".relatedNext");

const slideWidth = 2500;
const slideMargin = 500;
slides.style.width = (slideWidth + slideMargin) * slideCount + "px";
relatedSlides.style.width = (slideWidth + slideMargin) * relatedSlidesCount
		+ "px";

function moveSlide(slide, num) {
	slide.style.left = -num * 400 + "px";
	currentIdx = num;
}

prev.addEventListener("click", function() {
	if (currentIdx !== 0) {
		moveSlide(slides, currentIdx - 1);
	}
});

next.addEventListener("click", function() {
	if (currentIdx !== slideCount - 1) {
		moveSlide(slides, currentIdx + 1);
	}
});

relatedPrev.addEventListener("click", function() {
	if (relatedCurrentIdx !== 0) {
		moveSlide(relatedSlides, relatedCurrentIdx - 1);
		relatedCurrentIdx--
	} else if (relatedCurrentIdx < 0) {
		relatedCurrentIdx == 0
	}
})

relatedNext.addEventListener("click", function() {
	if (relatedCurrentIdx !== (parseInt(relatedSlidesCount / 4) + 1)) {
		moveSlide(relatedSlides, relatedCurrentIdx + 1);
		relatedCurrentIdx++
	}
})

