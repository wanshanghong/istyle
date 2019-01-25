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
            console.log("用户还没登录");
        }
        else{//否则
            //i+name的长度+1,保存在变量starti中
            let username=getCookie2('username');
            let hidden=document.getElementsByClassName('beforeLogin')[0];
            hidden.style.display="none";
            document.getElementsByClassName('afterLogin')[0].innerHTML="欢迎"+username+"登录istyle";
            let show=document.getElementsByClassName('afterLogin')[0];
            show.style="float: right; width: 200px; height: 19px;";
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
function getCookie2(name) {
    //将document.cookie保存在变量cookie中
    let cookie=document.cookie;
    //在cookie中查找cookieName的位置保存在i中
    let i=cookie.indexOf(name);
    //如果i等于-1,就返回null
    if(i==-1){
        console.log("用户还没登录");
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






