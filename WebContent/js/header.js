$(".subReserve").hide();

const reserveBtn = $(".reserveBtn");
reserveBtn.hover(function(){
    $(".subReserve").show(500);
   
},function(){
    $(".subReserve").hide(500);
})

$(".subReserve").hover(function(){
    $(".subReserve").show();
},function(){
    $(".subReserve").hide();
})

