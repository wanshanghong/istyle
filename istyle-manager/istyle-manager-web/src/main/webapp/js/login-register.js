$(function(){



	var $form_modal = $('.cd-user-modal'),
		$form_login = $form_modal.find('#cd-login'),
		$form_signup = $form_modal.find('#cd-signup'),
		$form_modal_tab = $('.cd-switcher'),
		$tab_login = $form_modal_tab.children('li').eq(0).children('a'),
		$tab_signup = $form_modal_tab.children('li').eq(1).children('a'),
		$main_nav = $('.main-nav');

	//弹出窗口
	$main_nav.on('click', function(event){

		if( $(event.target).is($main_nav) ) {
			// on mobile open the submenu
			$(this).children('ul').toggleClass('is-visible');
		} else {
			// on mobile close submenu
			$main_nav.children('ul').removeClass('is-visible');
			//show modal layer
			$form_modal.addClass('is-visible');	
			//show the selected form
			( $(event.target).is('.cd-signup') ) ? signup_selected() : login_selected();
		}

	});

	//关闭弹出窗口
	$('.cd-user-modal').on('click', function(event){
		if( $(event.target).is($form_modal) || $(event.target).is('.cd-close-form') ) {
			$form_modal.removeClass('is-visible');
		}	
	});
	//使用Esc键关闭弹出窗口
	$(document).keyup(function(event){
    	if(event.which=='27'){
    		$form_modal.removeClass('is-visible');
	    }
    });

	//切换表单
	$form_modal_tab.on('click', function(event) {
		event.preventDefault();
		( $(event.target).is( $tab_login ) ) ? login_selected() : signup_selected();
	});


	function login_selected(){
		$form_login.addClass('is-selected');
		$form_signup.removeClass('is-selected');
		$tab_login.addClass('selected');
		$tab_signup.removeClass('selected');
	}

	function signup_selected(){
		$form_login.removeClass('is-selected');
		$form_signup.addClass('is-selected');
		$tab_login.removeClass('selected');
		$tab_signup.addClass('selected');
	}







	
	
	
//tab栏切换
/*window.onload=function(){
	var btns=document.getElementById("btns").getElementsByTagName("button");
	var divs=document.getElementById("divs").getElementsByTagName("div");

	for(var i=0;i<btns.length;i++){
		btns[i].index=i;  //自定义属性，用于关联下面的大盒子
		btns[i].onclick=function(){
		
		for(var j=0;j<btns.length;j++){
		//把所有的button清空类名
		btns[j].className="";
		}
		//点击的那个盒子添加指定类名
		this.className="change";
		
		for(var i=0;i<divs.length;i++){
			//先让底下的div全部隐藏
			divs[i].style.display="none";
		}
		//然后给当前所点击按钮相关联的盒子添加指定属性
		divs[this.index].style.display="block";
	    
		}
	}
}*/




	//登录表单验证
function check1(){
	var username=document.getElementById("username").value;
	if(!/^[0-9]+$/.test(username)){
		alert('账号输入有误');
		return false;
	}
	var password=document.getElementById("password").value;
	if(/^[\s\t\r\n]*$/.test(password)){
		alert('密码不能为空');
		return false;
	}
	var password=document.getElementById("password").value;
	if(password.length<6){
		alert('密码不能小于六个字符，请重新输入');
		return false;
	}
	return true;
}
//注册表单验证
function check2(){
	var fakename=document.getElementById("fakename").value;
	if(/^[\s\t\r\n]*$/.test(fakename)){
		alert('用户名不能为空');
		return false;
	}
	/*var realname=document.getElementById("realname").value;
	{if(/^[\s\t\r\n]*$/.test(realname)){
		alert('姓名不能为空');
		return false;
	}
	if(/^[0-9]*$/.test(realname)){
		alert('姓名输入有误');
		return false;
	}}*/
	var password1=document.getElementById("password1").value;
	if(/^[\s\t\r\n]*$/.test(password1)){
		alert('密码不能为空');
		return false;
	}
	var password1=document.getElementById("password1").value;
	if(password1.length<6){
		alert('密码不能小于六个字符，请重新输入');
		return false;
	}
	var password2=document.getElementById("password2").value;
	if(password1!=password2){
		alert('两次密码输入不一致');
		return false;
	}
	var tel=document.getElementById("tel").value;
	if(!/^[0-9]+$/.test(tel)){
		alert('电话输入有误');
		return false;
	}
	
	return true;
}

//ajax


//登录
function login(){
	
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	
	/*兼容ie*/
	var xhr = null;
	if(XMLHttpRequest){
		xhr = new XMLHttpRequest();
	} else {
		xhr = new ActiveXObject("Microsoft.XMLHttp");
	}
	
/*	function success(data){
		console.log(information);
		if(data.msg==2){
            alert("登录成功");
		} else {
			alert("登录失败");
		}

	}*/
	function fail(code){
		console.log("发生错误"+code);
	}


	var url = "/login";
	xhr.open("post",url,true);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

    xhr.onreadystatechange = function(){
        if(xhr.readyState===4){
            if(xhr.status === 200){
                /*return success(xhr.responseText)*/
                alert(xhr.responseText);
            } else {
                return fail(xhr.status);
            }
        }
    };

	var information = "action=userLogin&"+"username=" + username.value + "&" + "password=" + password.value;
    xhr.send(information);
}

document.getElementById("loginbtn").onclick = function(){
	check1()?login():alert("请重新输入");
}


function register(){
    var information = "";
    var inputs = document.getElementsByClassName("fastRegister")[0].getElementsByTagName("input");
    var arr = ["fakename","password1","password2","tel","sex","age"];

/*    创建对象*/
    var xhr = null;
    if(XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }

    function success(data){
        console.log(information);
        alert("注册成功");
    }
    function fail(code){
        console.log("发生错误"+code);
    }
    
    /*连接服务器*/
    var url = "/register";
	xhr.open("post",url,true);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    
    /*请求完成,响应就绪*/
	xhr.onreadystatechange = function(){
		if(xhr.readyState==4){
			if((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304){
                return success(xhr.resonseText)
			} else {
                return fail(xhr.status);
			}

        }
	}

    for(var i=0; i<inputs.length-1; i++) {
        information += ( arr[i] + "=" + inputs[i].value +"&" );
    }

    xhr.send( information );

}
	
	

document.getElementById("registerbtn").onclick = function(){
	check2()?register():alert("请重新输入");
}




});


//credits http://css-tricks.com/snippets/jquery/move-cursor-to-end-of-textarea-or-input/
    jQuery.fn.putCursorAtEnd = function() {
        return this.each(function() {
            // If this function exists...
            if (this.setSelectionRange) {
                // ... then use it (Doesn't work in IE)
                // Double the length because Opera is inconsistent about whether a carriage return is one character or two. Sigh.
                var len = $(this).val().length * 2;
                this.setSelectionRange(len, len);
            } else {
                // ... otherwise replace the contents with itself
                // (Doesn't work in Google Chrome)
                $(this).val($(this).val());
            }
        });
    };


		