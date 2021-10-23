

$(document).ready(function() {

    $('.a').click(function () {
        var productName = $(this).parent().prev().prev().text()

        $.ajax({
            type: "GET",
            url: "/cart/addToCart/" + productName,

        })

    });
});



$(document).ready(function() {

    $('.linkProduct').mouseover(function () {
       var productName = $(this).next().next().children(".products-name").text()
        $(".linkProduct").attr("href","product?productName="+productName+"")

    })

});

$('.chat-logo').click(function () {
    $('.chat').show();
    $('.carousel-control-next-icon').css({
        "z-index": "-1",
        

    })
    $('.chat').css({
        "z-index": "1",
        

    })
});



$('.close-chat').click(function () {
    $('.chat').hide();
    $('.carousel-control-prev').css({
        "z-index": "none"

    })
    
   
});


// -------------------------------------------------------------------------

$('.plus').click(function () {
    const input = $(this).closest(".counter").find("input");
    input.val(+input.val() + 1);
});

$('.minus').click(function () {
    const input = $(this).closest(".counter").find("input");
    if (input.val() == 0) {
        input.val(0);
    } else {
        input.val(+input.val() - 1);
    }
});




// -----------------------------------------------------------------------


var allSite = $('.allSite');

$('.products-digit').click(function () {
    $('.allSite').css({
        "opacity": "0.2",
        "z-index": "-1",

    })


    $('.card-product-list').fadeIn(700);
    $('.card-product-list').animate({right: '0rem'});
});

$('.product-close').click(function () {

    $('.card-product-list').animate({right: '38rem'});
    $('.card-product-list').fadeOut("fast");

    $('.allSite').css({
        "opacity": "1",
        "z-index": "none",

    })

});




// -----------------------------------------------------------




$('.second-element-responsive').click(function () {
    $( '.second-element' ).toggle()

});




