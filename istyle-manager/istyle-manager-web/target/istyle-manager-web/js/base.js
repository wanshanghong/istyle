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

