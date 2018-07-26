$(function(){


/*左侧导航栏start*/
$('.verticalNav .right').first().show();

$('.verticalNav .box2>ul>li').click(function(){
	$(this).addClass('active');
	$('.verticalNav .box2>ul>li').not($(this)).removeClass('active');
	
	idx = $(this).index('.verticalNav .box2>ul>li');
	$('.verticalNav .right').eq(idx).show();
	$('.verticalNav .right').not($('.verticalNav .right').eq(idx)).hide();
	
});

/*我的主页投稿里面的tab切换*/
$('.contributeBottom .contributeBottomContent').first().show();

$('.contributeTop ul li').click(function(){
	$(this).addClass('active');
	$('.contributeTop ul li').not($(this)).removeClass('active');
	
	idx = $(this).index('.contributeTop ul li');
	$('.contributeBottom .contributeBottomContent').eq(idx).show();
	$('.contributeBottom .contributeBottomContent').not($('.contributeBottom .contributeBottomContent').eq(idx)).hide();
});



});
