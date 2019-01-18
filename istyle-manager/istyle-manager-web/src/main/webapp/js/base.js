//setCookie和getCookie封装
function setCookie(name, value){
        document.cookie=name +"="+value;
}
function getCookie(name) {
        //将document.cookie保存在变量cookie中
        let cookie=document.cookie;
        //在cookie中查找cookieName的位置保存在i中
        let i=cookie.indexOf(name);
        //如果i等于-1,就返回null
        if(i==-1){
            let username=getCookie('username');
            document.getElementsByClassName('beforeLogin')[0].style.display='none';
            document.getElementsByClassName('afterLogin')[0].innerHTML="欢迎"+username+"登录istyle";
        }
        else{//否则
            //i+name的长度+1,保存在变量starti中
            let starti=i+name.length+1;
            //从starti开始查找cookie中下一个;的位置endi
            let endi=cookie.indexOf(";",starti);
            if(endi==-1){//如果endi是-1
                //截取cookie中starti到结尾的剩余内容,返回
                return cookie.slice(starti);
            }else{//否则
                //截取cookie中starti到endi的内容，返回
                return cookie.slice(starti,endi);
            }
        }
}

//登录后刷新用户信息
/*function lodingUsername() {
    if(getCookie('stoken')){
        console.log("用户还没登录");
    }else{

    }
}*/

//我的主页跳转
function home(){

    let xmlhttp;
    if(window.XMLHttpRequest){
        //code for IE7+,Firefox,Chrome,Opera,Safari
        xmlhttp=new XMLHttpRequest();
    }
    else{
        //code for IE6+,IE5+
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange=function(){
        if (xmlhttp.readyState===4){
            alert("连接成功");

        }
    }
    xmlhttp.open('get','');
    xmlhttp.send(null);

}

