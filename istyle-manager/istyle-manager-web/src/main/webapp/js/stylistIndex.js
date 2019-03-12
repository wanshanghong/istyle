$(function () {
    /*tab切换*/
    $('.bottomContent .-bottom .-bottomCon').first().show();
    $('.bottomContent .-bottom .-bottomCon').not($('.bottomContent .-bottom .-bottomCon').first()).hide();
    stylistIndex();
    $('.bottomContent .-top ul li').click(function(){
        $(this).addClass('active');
        $('.bottomContent .-top ul li').not($(this)).removeClass('active');

/*        idx = $(this).index('.bottomContent .-top ul li');
        $('.bottomContent .-bottom .-bottomCon').eq(idx).show();
        $('.bottomContent .-bottom .-bottomCon').not($('.bottomContent .-bottom .-bottomCon').eq(idx)).hide();*/
        idx = $(this).index('.bottomContent .-top ul li');
        if(!idx){
            $('.bottomContent .-bottom .-bottomCon').eq(idx).show();
            stylistIndex();
            $('.bottomContent .-bottom .-bottomCon').not($('.bottomContent .-bottom .-bottomCon').eq(idx)).hide();
        }else{
            $('.bottomContent .-bottom .-bottomCon').eq(idx).show();
            stylistFan();
            $('.bottomContent .-bottom .-bottomCon').not($('.bottomContent .-bottom .-bottomCon').eq(idx)).hide();
        }
    });
});