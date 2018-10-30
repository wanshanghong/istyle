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

	//多用户注册切换效果
    $('.fastRegister .tabBottom .tabBottomContent').first().show();

    $('.fastRegister .tabTop ul li').mousedown(function(){
        $(this).addClass('active');
        $('.fastRegister .tabTop ul li').not($(this)).removeClass('active');

        idx = $(this).index('.fastRegister .tabTop ul li');
        $('.fastRegister .tabBottom .tabBottomContent').eq(idx).show();
        $('.fastRegister .tabBottom .tabBottomContent').not($('.fastRegister .tabBottom .tabBottomContent').eq(idx)).hide();
    });





	
	
	
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
	if(!/^1(3|4|5|7|8)\d{9}$/.test(tel)){
		alert('电话输入有误，请输入11位正确的号码');
		return false;
	}
	
	return true;
}

    function check3(){
        var fakename=document.getElementById("loginAccount").value;
        if(/^1(3|4|5|7|8)\d{9}$/.test(loginAccount)){
            alert('登录账号输入有误');
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
        var password3=document.getElementById("password3").value;
        if(/^[\s\t\r\n]*$/.test(password1)){
            alert('密码不能为空');
            return false;
        }
        var password3=document.getElementById("password3").value;
        if(password1.length<6){
            alert('密码不能小于六个字符，请重新输入');
            return false;
        }
        var password4=document.getElementById("password4").value;
        if(password3!=password4){
            alert('两次密码输入不一致');
            return false;
        }
        var tel=document.getElementById("tel2").value;
        if(!/^1(3|4|5|7|8)\d{9}$/.test(tel)){
            alert('电话输入有误，请输入11位正确的号码');
            return false;
        }
        var idcard=document.getElementById("idcard").value;
        if(!/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[012])(0[1-9]|[12]\d|3[01])\d{3}(\d|[xX])$/.test(idcard)){
            alert('身份证输入有误');
            return false;
        }

        return true;
    }

    function check4(){
        var fakename=document.getElementById("fakename3").value;
        if(/^[\s\t\r\n]*$/.test(fakename)){
            alert('昵称不能为空');
            return false;
        }
        var realname=document.getElementById("realname3").value;
        if(/^[\s\t\r\n]*$/.test(realname)){
            alert('真实姓名不能为空');
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
        var password5=document.getElementById("password5").value;
        if(/^[\s\t\r\n]*$/.test(password5)){
            alert('密码不能为空');
            return false;
        }
        var password5=document.getElementById("password5").value;
        if(password5.length<6){
            alert('密码不能小于六个字符，请重新输入');
            return false;
        }
        var password6=document.getElementById("password6").value;
        if(password5!=password6){
            alert('两次密码输入不一致');
            return false;
        }
        var tel=document.getElementById("tel3").value;
        if(!/^1(3|4|5|7|8)\d{9}$/.test(tel)){
            alert('电话输入有误，请输入11位正确的号码');
            return false;
        }

        return true;
    }

//ajax


//登录
/*function login(){
	
	let username = document.getElementById("username");
	let password = document.getElementById("password");
	console.log(username);

	/!*兼容ie*!/
	let xhr = null;
	if(XMLHttpRequest){
		xhr = new XMLHttpRequest();
	} else {
		xhr = new ActiveXObject("Microsoft.XMLHttp");
	}




	let url = "/login";
	xhr.open("post",url,true);
	xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");

    xhr.onreadystatechange = function(){
        if(xhr.readyState===4){
            if(xhr.status >= 200 && xhr.status<300 || xhr.status===304){
				window.location.href="";  /!*登录成功后跳转*!/
				let userInfo=xhr.responseText;
                sessionStorage.setItem('user',JSON.stringify(userInfo));/!*存储时，将对象转换为json字符串*!/

				let users=sessionStorage.getItem('user');
				userInfo=JSON.parse(users);
				if(userInfo.userType===1){
					document.getElementsByClassName('beforeLogin')[0].style.display='none';
					document.getElementsByClassName('afterLogin')[0].innerHTML="欢迎"+userInfo.userName+"登录istyle";
				}else if(userInfo.userType===2){
                    document.getElementsByClassName('beforeLogin')[0].style.display='none';
                    document.getElementsByClassName('afterLogin')[0].innerHTML="欢迎"+userInfo.stylistName+"登录istyle";
				}else if(userInfo.userType===3){
                    document.getElementsByClassName('beforeLogin')[0].style.display='none';
                    document.getElementsByClassName('afterLogin')[0].innerHTML="欢迎"+userInfo.styHouseName+"登录istyle";
				}



                /!*var url = location.search.split("=")[1];
                location.href = url; //从地址栏获取返回地址，实现跳转  ,不行的话就改成index的url*!/


            } else {
                console.error;
            }
        }
    };

	let information = {"data":{"username" : username.value  , "password" : password.value}};
    xhr.send(information);
    console.log(information);
}
*/
function login(){
    let username = document.getElementById("username");
    let password = document.getElementById("password");
    let obj={"userPhone":username.value,"userPassword":password.value};
    $.ajax({
        type:"POST",
        url:"/userLogin",
        contentType:'application/json;charset=utf-8',
        data:JSON.stringify(obj),
        dataType:"json",
        success:function (data) {
            console.log("succ");
            console.log(data);
            window.location.href="";  /*登录成功后跳转*/
        },
        error:function (err) {
            console.error(err);
            console.log("发生错误");
            alert(err.responseText);
        }
    });
}



document.getElementById("loginbtn").onclick = function(){
	check1()?login():alert("请重新输入");
};




/*function register1(){
    let information = "";
    var inputs = document.getElementById("register").getElementsByTagName("input");
    var arr = ["fakename","password1","tel","sex","age"];

/!*    创建对象*!/
    var xhr = null;
    if(XMLHttpRequest) {
        xhr = new XMLHttpRequest();
    } else {
        xhr = new ActiveXObject("Microsoft.XMLHTTP");
    }

/!*    function success(data){
        console.log(information);
        alert("注册成功");
    }*!/
    function fail(code){
        console.log("发生错误"+code);
    }
    
    /!*连接服务器*!/
    var url = "/register";
	xhr.open("post",url,true);
	xhr.setRequestHeader("Content-Type","application/json");
    
    /!*请求完成,响应就绪*!/
	xhr.onreadystatechange = function(){
		if(xhr.readyState===4){
			if((xhr.status >= 200 && xhr.status < 300) || xhr.status === 304){
                alert("注册成功");
			} else {
                return fail(xhr.status);
			}

        }
	}

    for(var i=0; i<inputs.length-1; i++) {
        information += ( arr[i] + "=" + inputs[i].value +"&" );
    }
    xhr.send( information +"userType=1");

}*/

    function register1(){
        let fakename = document.getElementById("fakename");
        let password1 = document.getElementById("password1");
        let tel = document.getElementById("tel");
        let sex = document.getElementById("sex");
        let age = document.getElementById("age");
        $.ajax({
            type:"POST",
            url:"/register",
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(
                {
                    "userName":fakename.value,
                    "userPassword":password1.value,
                    "userPhone":tel.value,
                    "userSex":sex.value,
                    "userAge":age.value,
                    "userType":"1"
                }
            ),
            dataType:"json",
            success:function (data) {
                console.log("用户注册成功");
                console.log(data);
            },
            error:function (err) {
                console.error(err);
                console.log("发生错误");
                alert(err.responseText);
            }
        });
    }



document.getElementById("registerbtn").onclick = function(){
	check2()?register1():alert("请重新输入");
};


/*//造型屋注册
    function register2(){

        var information = "";
        /!*var inputs = document.getElementsByClassName("fastRegister")[0].getElementsByTagName("input");*!/
        var arr = ["styHouseName","styHouseAccount","styHousePassword","headName","headId","headPhone","styHousePosition"];
        let styHouseName=document.getElementById('shopname').value;
        let styHouseAccount=document.getElementById('loginAccount').value;
        let styHousePassword=document.getElementById('password3').value;
        let headName=document.getElementById('realname1').value;
        let headId=document.getElementById('idcard').value;
        let headPhone=document.getElementById('tel2').value;



       /!* 地址三级联动的取值*!/
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


        /!*    创建对象*!/
        var xhr = null;
        if(XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }

        /!*    function success(data){
                console.log(information);
                alert("注册成功");
            }*!/
        function fail(code){
            console.log("发生错误"+code);
        }

        /!*连接服务器*!/
        var url = "/register";
        xhr.open("post",url,true);
        xhr.setRequestHeader("Content-Type","application/json");

        /!*请求完成,响应就绪*!/
        xhr.onreadystatechange = function(){
            if(xhr.readyState===4){
                if((xhr.status >= 200 && xhr.status < 300) || xhr.status === 304){
                    alert("注册成功");
                } else {
                    return fail(xhr.status);
                }

            }
        };
        information += ( arr[0] + "=" + styHouseName +"&" +arr[1]+ "=" +styHouseAccount+ "&" +arr[2]+ "=" +styHousePassword  +"&" +arr[3]+ "=" +headName +"&" +arr[4]+ "=" +headId +"&" +arr[5]+ "=" +headPhone +"&" +arr[6]+ "=" +styHousePosition);
        xhr.send( information+"userType=3");

    }*/


    function register2(){

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


        let styHouseName=document.getElementById('shopname');
        let styHouseAccount=document.getElementById('loginAccount');
        let styHousePassword=document.getElementById('password3');
        let headName=document.getElementById('realname1');
        let headId=document.getElementById('idcard');
        let headPhone=document.getElementById('tel2');
        $.ajax({
            type:"POST",
            url:"/register",
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(
                {
                    "styHouseName":styHouseName.value,
                    "styAccount":styHouseAccount.value,
                    "styHousePassword":styHousePassword.value,
                    "headName":headName.value,
                    "headId":headId.value,
                    "headPhone":headPhone.value,
                    "styHousePosition":styHousePosition,
                    "userType":"3"
                }
            ),
            dataType:"json",
            success:function (data) {
                console.log("造型屋注册成功");
                console.log(data);
            },
            error:function (err) {
                console.error(err);
                console.log("发生错误");
                alert(err.responseText);
            }
        });
    }

    document.getElementById("registerbtn2").onclick = function(){
        check3()?register2():alert("请重新输入");
    };


    //造型师注册

/*    function register3(){
        var information = "";
        var inputs = document.getElementById("register3").getElementsByTagName("input");
        var arr = ["stylistName","realName","stylistPassword","stylistPhone","stylistSex","stylistAge"];

        /!*    创建对象*!/
        var xhr = null;
        if(XMLHttpRequest) {
            xhr = new XMLHttpRequest();
        } else {
            xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }

        /!*    function success(data){
                console.log(information);
                alert("注册成功");
            }*!/
        function fail(code){
            console.log("发生错误"+code);
        }

        /!*连接服务器*!/
        var url = "/register";
        xhr.open("post",url,true);
        xhr.setRequestHeader("Content-Type","application/json");

        /!*请求完成,响应就绪*!/
        xhr.onreadystatechange = function(){
            if(xhr.readyState===4){
                if((xhr.status >= 200 && xhr.status < 300) || xhr.status === 304){
                    alert("造型师注册成功");
                } else {
                    return fail(xhr.status);
                }

            }
        }

        for(var i=0; i<inputs.length-1; i++) {
            information += ( arr[i] + "=" + inputs[i].value +"&" );
        }
        xhr.send( information +"userType=2");

    }*/

    function register3(){
        let stylistName = document.getElementById("fakename3");
        let realName = document.getElementById("realname3");
        let stylistPassword = document.getElementById("password5");
        let stylistSex = document.getElementById("sex3");
        let stylistAge = document.getElementById("age3");
        let stylistPhone = document.getElementById("tel3");
        $.ajax({
            type:"POST",
            url:"/register",
            contentType:'application/json;charset=utf-8',
            data:JSON.stringify(
                {
                    "stylistName":stylistName.value,
                    "realName":realName.value,
                    "stylistPassword":stylistPassword.value,
                    "stylistSex":stylistSex.value,
                    "stylistAge":stylistAge.value,
                    "stylistPhone":stylistPhone.value,
                    "userType":"2"
                }
            ),
            dataType:"json",
            success:function (data) {
                console.log("造型师注册成功");
                console.log(data);
            },
            error:function (err) {
                console.error(err);
                console.log("发生错误");
                alert(err.responseText);
            }
        });
    }




    document.getElementById("registerbtn3").onclick = function(){
        check4()?register3():alert("请重新输入");
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


		