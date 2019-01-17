
$(function(){





/*下拉框效果*/
$('.top .myhome').mouseenter(function(){
	$(this).find('.myhome').css({'background':'#fff'});
	$(this).find('.mydropdown').show();
});

$('.top .myhome').mouseleave(function(){
	$(this).find('.myhome').css({'background':'#F2F2F2'});
	$(this).find('.mydropdown').hide();
});



/*隐藏部分的tab切换效果*/
$('.hide-right .tabBottom .tabBottomContent').first().show();

    $('.hide-right .tabTop ul li').mouseenter(function(){
        $(this).addClass('active');
        $('.hide-right .tabTop ul li').not($(this)).removeClass('active');

        idx = $(this).index('.hide-right .tabTop ul li');
        $('.hide-right .tabBottom .tabBottomContent').eq(idx).show();
        $('.hide-right .tabBottom .tabBottomContent').not($('.hide-right .tabBottom .tabBottomContent').eq(idx)).hide();
    });


/*//首页下面的轮播图实现

(function(){    //闭包函数
//第一步
$(".slidepic .paging").show();
$("..slidepic .paging a:first").addClass("active");


var imageWidth = $(".slidepic .window").width();           //求幻灯片的宽度  console.log(imageWidth);
var imageSum = $(".slidepic .image_reel img").size();     //求幻灯片的张数 console.log(imageSum);
var imageReelWidth = imageWidth * imageSum;

//Adjust the image reel to its new size
$(".slidepic .image_reel").css({'width':imageReelWidth});

//第二步
//Paging and Slider Function分页和滑动功能
var rotate = function(end){
	if(end){
		var triggerId = imageSum - 1;    //确定需要滑动的次数
		var image_reelPosition = triggerId * imageWidth;  //确定图像卷轴需要滑动的距离
		
		$(".slidepic .paging a").removeClass('active');     //Remove allactive class
		$active2.addClass('active');     //Add active class(the $active is declared in the rotateSwitch funtion)
		
		//滑动动画
		$(".slidepic .image_reel").animate({
			left:-image_reelPosition
		},500,function(){
			$(this).css({'left':'0px'});
		});
	}else{
		var triggerId = $active.attr("rel") - 1;    //得到幻灯片的次数
		var image_reelPosition = triggerId * imageWidth;  //确定图像需要滑动的距离
		
		$(".slidepic .paging a").removeClass('active');     //Remove all active class
		$active.addClass('active');     //Add active class(the $active is declared in the rotateSwitch funtion)
		
		//Slider Animation滑动动画
		$(".slidepic .image_reel").animate({
			left:-image_reelPosition
		},500);
	}
	
	
};

//Rotation and Timing Event循环和定时事件
var rotateSwitch = function(){
	play = setInterval(function(){  //规定时间
		$active = $('.slidepic .paging a.active').next();      //移动到下一个分页
		var rel = $('.slidepic .paging a.active').attr('rel');
		//document.title = rel;
		if( rel==2 ){    //If paging reaches the end...
			$active = $('.slidepic .paging a:first');  //go back to first
			var end = true;
		}else{
			var end = false;
		}
		rotate(end);    //触发滑动和分页函数		
	},3000);    //计时器以毫秒为单位
};

rotateSwitch();    //在启动运行函数

//第三步
//On Hover
$(".slidepic .image_reel a").hover(function(){
	clearInterval(play);   //停止循环
},function(){
	rotateSwitch();     //resume(重新开始,继续,恢复) rotation timer
});

//On Click
$(".slidepic .paging a").click(function(){
    $active = $(this);     //激活点击分页
	//Reset Timer
	clearInterval(play);   //停止循环
	rotate(false);         //Trigger（触发） rotation immediately
	rotateSwitch();        //resume rotation timer
	return false;          //防止浏览器跳转到链接锚
});

})();      //闭包函数

*/

var slideBox = $(".slideBox");
     var ul = slideBox.find("ul");
     var oneWidth = slideBox.find("ul li").eq(0).width();
     var number = slideBox.find(".spanBox span");            //注意分号 和逗号的用法
     var timer = null;
     var sw = 0;                    
     //每个span绑定click事件，完成切换颜色和动画，以及读取参数值
     number.on("click",function (){
     $(this).addClass("active").siblings("span").removeClass("active");
     sw=$(this).index();
     ul.animate({
            "right":oneWidth*sw,    //ul标签的动画为向左移动；
               });
     });
     //左右按钮的控制效果
/*     $(".next").stop(true,true).click(function (){
         sw++;
         if(sw==number.length){sw=0};
         number.eq(sw).trigger("click");
         });
    $(".prev").stop(true,true).click(function (){
        sw--;
        if(sw==number.length){sw=0};
        number.eq(sw).trigger("click");
        });*/
    //定时器的使用，自动开始
    timer = setInterval(function (){
        sw++;
        if(sw==number.length){sw=0};
        number.eq(sw).trigger("click");
        },2000);
    //hover事件完成悬停和，左右图标的动画效果
    slideBox.hover(function(){
        $(".next,.prev").animate({
            "opacity":1,
            },200);
        clearInterval(timer);
        },function(){
            $(".next,.prev").animate({
                "opacity":0.5,
                },500);
        timer = setInterval(function (){
        sw++;
        if(sw==number.length){sw=0};
        number.eq(sw).trigger("click");
        },2000);
           });


});

//跳转用户主页
function locationInformation(){
    let xhr=new XMLHttpRequest();

    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){

                let info = JSON.parse(xhr.responseText);

                if (info.errCode === 0) {

                    window.location.href = "/html/userIndex.html";
                    alert("跳转成功");
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    xhr.open('post','/userHome/index');
    xhr.setRequestHeader("Content-Type","application/json");
    let data=getCookie('stoken');
    console.log(data);
    let obj={"stoken":data};
    xhr.send(JSON.stringify(obj));
}
//跳转造型屋
function locationSalon(){
    let xhr=new XMLHttpRequest();

    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                /* 地址三级联动的取值*/
                let pro = document.getElementById('cmbProvince'); //定位id
                let index1 = pro.selectedIndex; // 选中索引
                let text1 = pro.options[index1].text; // 选中文本
                let value1 = pro.options[index1].value; // 选中值

                let city = document.getElementById('cmbCity'); //定位id
                let index2 = city.selectedIndex; // 选中索引
                let text2 = city.options[index2].text; // 选中文本
                let value2 = city.options[index2].value; // 选中值

                let area = document.getElementById('cmbArea'); //定位id
                let index3 = area.selectedIndex; // 选中索引
                let text3 = area.options[index3].text; // 选中文本
                let value3 = area.options[index3].value; // 选中值

                let styHousePosition=value1+value2+value3;
                let info = JSON.parse(xhr.responseText);
                if (info.error_code === 0) {
                    window.location.href = "/html/salonIndex.html";
                    alert("跳转成功");
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    xhr.open('post','/userBrowse/styHouseIndex');
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"styHousePosition":styHousePosition};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}
window.onload=function(){
  lodingUsername();
};
