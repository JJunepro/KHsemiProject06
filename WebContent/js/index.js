$(".subReserve").hide();

const reserveBtn = $(".reserveBtn");
reserveBtn.hover(function(){
    $(".subReserve").show();
},function(){
    $(".subReserve").hide();
})