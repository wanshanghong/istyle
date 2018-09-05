//用promise封装ajax
function ajax(method, url, data){
    let xhr;
    if(window.XMLHttpRequest){
        xhr=new XMLHttpRequest();
    }else{
        xhr=new ActiveXObject("Microsoft XMLHTTP");
    }

    return new Promise(function(resolve, reject){
        xhr.onreadystatechange=function(){
            if(xhr.readyState===4){
                if(xhr.status>=200 && xhr.status<300 || xhr.status===304){
                    resolve(xhr.responseText);
                }else{
                    reject(xhr.status);
                }
            }
        };
        //判断GET和POST方法
        if(method.toUpperCase()==="GET"){
            xhr.open("GET", url, true);
            xhr.send(null);
        }else if(method.toUpperCase()==="POST"){
            xhr.open("OPST", url, true);
            xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded;charset=utf-8');
            xhr.send(data);

        }
    });
}


//我的信息start
//我的信息编辑隐藏弹出start
function editor() {
    let hidden=document.getElementById('showInformation');
    hidden.style.display="none";

    let obj=document.getElementById('form');
    obj.style.display="block";
}
function success(){
    let hidden=document.getElementById('form');
    hidden.style.display="none";
    showInformation();
    let obj=document.getElementById('showInformation');
    obj.style.display="block";

}
//我的信息编辑隐藏弹出end
//我的信息展示
function showInformation(){
        let xhr=new XMLHttpRequest();

        xhr.onreadystatechange=function(){
            if (xhr.readyState===4){
                if (xhr.status>=200 && xhr.status<300 || xhr.status===304){

                    var info = JSON.parse(xhr.responseText);

                    if (info.isOpen === "1") {

                        let showInform = "";
                        /*alert("成功1");*/
                        showInform += "<p><img src='" + info.userPhoto + "'></p><div class=\"clear\"></div>" +
                            "<p><span class=\"nickname\">昵称：" + info.userName + "</span></p><div class=\"clear\"></div>" +
                            "<p><span class=\"personalizedSignature\">我的签名：" + info.userWord + "</span></p><div class=\"clear\"></div>" +
                            "<p><span class=\"sex\">性别:" + info.userSex + "</span></p><div class=\"clear\"></div>";
                        /*alert("成功2"+showInform);*/

                        document.getElementsByClassName('addContent')[0].innerHTML = showInform;
                        /*alert("成功");*/
                    }else{
                        alert("用户没有登录");
                    }
                }else {
                    alert("发生错误"+xhr.status);
                }
            }
        }
        xhr.open('get','/myHome/index');
        xhr.send(null);

}
//我的信息编辑
function information(){
/*    let fm=document.getElementById('form');

    let fd=new FormData(fm);*/
    console.log("1");
    let information1="";
    console.log("2");
    /*let inputs=document.getElementsByClassName("updateInfo")[0].getElementsByTagName("input");*/
    let username=document.getElementById('nickname').value;
    let userword=document.getElementById('personalizedSignature').value;
    let sex=document.getElementsByName('sex');
    let userSex=null;
    for(let i=0;i<sex.length;i++){
        if(sex[i].checked){
            userSex=sex[i].value;
            break;
        }
    }
    console.log("3");
    let arr = ["userName","userWord","userSex"];

    let xhr=new XMLHttpRequest();
    console.log("4");
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                console.log("5");
                 var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.isOpen === "1"){
                console.log("保存成功"+xhr.status);
                showInformation();
                }else{
                    console.log("保存失败");
                }
                /*eval("var info="+xhr.responseText);*/
                console.log("6")
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    console.log("7");
    xhr.open('post','/myHome/updateMessage');
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    console.log("8");
    /*for(var i=0; i<inputs.length-1; i++) {*/
        information1 += ( arr[0] + "=" + username +"&" +arr[1]+ "=" +userword+ "&" +arr[2]+ "=" +userSex );
    /*}*/
    xhr.send(information1);
    console.log("9");
    console.log(information1);
}

//我的收藏start
function collect(){
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info=JSON.parse(xhr.responseText);
                /*var info=xhr.responseText;*/
                //造型师、造型屋、测评的收藏数
                /*console.log("1");*/
                let numDesigner="";
                numDesigner+="<span class='stylingDesignerSpan'>造型师（"+info.styCount+")</span>";
                /*console.log("2");
                console.log(info.styCount);
                console.log(info);*/

                let numSalon="";
                numSalon+="<span class='hairSalonSpan'>造型屋（"+info.styHouseCount+")</span>";
                /*console.log("3");*/
                let numEvaluate="";
                numEvaluate+="<span class='evaluationCollection'>测评（"+info.evalCount+")</span>";
                /*console.log(info.styHouseCount);
                console.log(info.evalCount);*/

                //造型师、造型屋、测评的添加内容
                /*console.log("4");
                console.log(info.stylist);*/
                let designerBox="";
                for (let i=0;i<info.stylist.length;i++){
                    designerBox += "<div class='box'><!--<a href='+/*info.stylist[i].designerUrl--><img src='"+info.stylist[i].stylistPhoto+"'/><span>"+info.stylist[i].stylistName+"造型师</span><!--</a>--></div>";
                }
                /*console.log("5");*/
                let salonBox="";
                for (let j=0;j<info.styHouse.length;j++){
                    salonBox += "<div class='box'><!--<a href='+info.styHouse[j].salonUrl+'>--><img src='"+info.styHouse[j].styHousePhoto+"'/><span>"+info.styHouse[j].styHouseName+"造型屋</span><!--</a>--></div>";
                }
               /* console.log("6");
                console.log(info.styHouse);*/
                let evaluateBox="";
                for (let i=0;i<info.evaluation.length;i++){
                    evaluateBox += "<div class='clear'></div>" +
                                       "<div class='box1'><!--<a href='+info.evaluation[i].evaluateUrl+'>-->"    +
                                           "<img src='"+info.evaluation[i].evalPhoto+"'/>"  +
                                           "<div class='box1_1'>"   +
                                               "<span>"+info.evaluation[i].evalName+"</span><br>"  +
                                               "<span>简介："+info.evaluation[i].evalWord+"</span><br>"  +
                                               "<i class='iconfont icon-fenxiang'></i><span class='icon-fenxiangSpan'>分享</span>" +
                                               "<i class='iconfont icon-shanchu'></i><span class='icon-shanchuSpan'>删除收藏</span>" +
                                           "</div>"  +
                                       "<!--</a>--></div>";
                }
            /*    console.log("7");
                console.log(info.evaluation);
                console.log(evaluateBox);*/

                document.getElementsByClassName('stylingDesignerSpan')[0].innerHTML=numDesigner;
                document.getElementsByClassName('hairSalonSpan')[0].innerHTML=numSalon;
                document.getElementsByClassName('evaluationCollection')[0].innerHTML=numEvaluate;
                /*console.log("8");*/
                document.getElementsByClassName('stylingDesignerIn')[0].innerHTML+=designerBox;
                document.getElementsByClassName('hairSalonIn')[0].innerHTML+=salonBox;
                document.getElementsByClassName('evaluation')[0].innerHTML+=evaluateBox;
                alert("收藏成功");
                /*console.log("succ");*/
            }else{
                alert("发生错误"+xhr.status);
                console.log("err"+xhr.status);
            }
        }
    }
    xhr.open('get','/myHome/userCollection');
    xhr.send(null);
}


/*
function collect() {
    ajax('get', '').then(function(data){
       /!* let info=JSON.parse(data);*!/
       let info=data;
        //造型师、造型屋、测评的收藏数
        let numDesigner="";
        numDesigner+="<span class='stylingDesignerSpan'>造型师（"+info.designerNum+")</span>";
        let numSalon="";
        numSalon+="<span class='hairSalonSpan'>造型屋（"+info.salonNum+")</span>";
        let numEvaluate="";
        numEvaluate+="<span class='evaluationCollection'>测评（"+info.evaluateNum+")</span>";
        //造型师、造型屋、测评的添加内容
        let designerBox="";
        for (let i=0;i<info.length;i++){
            //<div class="box"><img src="../img/designerphoto2.jpg"/><span>XX造型师</span></div>
            designerBox += "<div class='box'><a href='"+info[i].designerUrl+"'><img src='"+info[i].designerPic+"'/><span>"+info[i].designer+"造型师</span></a></div>";
        }
        let salonBox="";
        for (let i=0;i<info.length;i++){
            //<div class="box"><img src="../img/salaonpho1.jpg"/><span>XX造型屋</span></div>
            salonBox += "<div class='box'><a href='"+info[i].salonUrl+"'><img src='"+info[i].salonPic+"'/><span>"+info[i].salon+"造型屋</span></a></div>";
        }
        let evaluateBox="";
        for (let i=0;i<info.length;i++){
            evaluateBox += "<div class='clear'></div>" +
                "<div class='box1'><a href='"+info[i].evaluateUrl+"'>"    +
                "<img src='"+info[i].evaluatePic+"'/>"  +
                "<div class='box1_1'>"   +
                "<span>"+info[i].evaluateName+"</span><br/>"  +
                "<span>简介："+info[i].evaluateSummary+"</span><br/>"  +
                "<i class='iconfont icon-fenxiang'></i><span class='icon-fenxiangSpan'>分享</span>" +
                "<i class=\"iconfont icon-shanchu\"></i><span class=\"icon-shanchuSpan\">删除收藏</span>" +
                "</div>"  +
                "</a></div>";
        }

        document.getElementsByClassName('stylingDesignerSpan')[0].innerHTML=numDesigner;
        document.getElementsByClassName('hairSalonSpan')[0].innerHTML=numSalon;
        document.getElementsByClassName('evaluationCollection')[0].innerHTML=numEvaluate;

        document.getElementsByClassName('stylingDesigner')[0].innerHTML+=designerBox;
        document.getElementsByClassName('hairSalon')[0].innerHTML+=salonBox;
        document.getElementsByClassName('evaluation')[0].innerHTML+=evaluateBox;
        alert("收藏成功");
    }).catch(function (err) {
        console.error(err);
    });
}
*/



//我的收藏end

//我的关注start
function subscribe(){
    let xmlhttp;
    if(window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }else{
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }

    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState===4){
            if (xmlhttp.status>=200 && xmlhttp.status<300 || xmlhttp.status===304 ){
                var info=JSON.parse(xmlhttp.responseText);

                let numsubscribe="";
                //<span class="subscribeNum">关注(关注数)</span>
                numsubscribe+="关注（"+info.follerCount+")";

                /*console.log(info.follerCount);*/
                let s="";
                for(let i=0;i<info.follerCount;i++){

                    s+= "<div class='clear'></div>"+
                        "<div class='subscribeContent1'>"+
                            "<img src='"+info.follers[i].userPhoto+"'/>"+
                            "<p>"+
                            "<span>"+info.follers[i].userName+"</span><br/>"+
                            "<span>"+info.follers[i].userWord+"</span>"+
                            "</p>"+
                            "<button class='privateChat'><a href=''>私信</a></button>"+
                            /*"<form action='' method='post'>"+
                                "<select class='subscribeOrNot' name='subscribeOrNot'>"+
                                "<option value=''>取消关注</option>"+
                                "<option value=''>关注</option>"+
                                "</select>"+
                            "</form>"+*/
                            "<button class='subscribeOrNot' onclick='delSubsc()'>取消关注</button>"+
                        "</div>"+
                        "<div class='clear'></div>";
                }

             console.log(info.follers);
            document.getElementsByClassName('subscribeNum')[0].innerHTML=numsubscribe;
            document.getElementsByClassName('rightBottomSubscribe')[0].innerHTML+=s;
            /*alert("关注连接成功");*/
            console.log("成功");
            }else{
                alert("发生错误"+xmlhttp.status);
                console.log("'发生错误'+xmlhttp.status");
            }
        }
    }
    xmlhttp.open('get','/myHome/userFoller');
    xmlhttp.send(null);
}
//我的关注end

//取消关注start
function delSubsc(){
    /*    let fm=document.getElementById('form');

        let fd=new FormData(fm);*/
    console.log("1");
    let information1="";
    console.log("2");

    let xhr=new XMLHttpRequest();
    console.log("4");
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                console.log("5");
                var info1 = JSON.parse(xhr.responseText);
                console.log(info1);
                // var info = xhr.responseText;
                if (!info1){
                    console.log("取消关注成功"+xhr.status);

                }else{
                    console.log("取消关注失败");
                }
                console.log("6");
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    console.log("7");
    xhr.open('post','unFollor');
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    console.log("8");
    information1 += ( userid + "=" + info.follers[i].userId );
    xhr.send(information1);
    console.log("9");
    console.log(information1);
}


//我的粉丝start
function fans(){
    let xmlhttp;
    if(window.XMLHttpRequest){
        xmlhttp=new XMLHttpRequest();
    }else{
        xmlhttp=new ActiveXObject("Microsoft XMLHTTP");
    }
    xmlhttp.onreadystatechange=function(){
        if(xmlhttp.readyState===4){
            if(xmlhttp.status===200){
                var info=xmlhttp.responseText;

                let numfans="";
                //<span class="fansNum">粉丝(粉丝数)</span>
                numfans+="<span class='fansNum'>粉丝（"+info.fansNum+")</span>";

                let s="";
                for(let i=0;i<info.length;i++){

                //<div class="myfanContent1">
                 //       <img src="../img/headphoto.png"/>
                //        <p>
                //        <span>昵称</span><br />
                //        <span>我的签名</span>
                //        </p>
                //        <button class="privateChat"><a href="">私信</a></button>
                //    <form action="" method="post">
                //        <select class="subscribeOrNot" name="subscribeOrNot">
                //        <option value="">加关注</option>
                //        <option value="">取消关注</option>
                //        </select>
                //        </form>
                //        </div>

                    s+="<div class=\"myfanContent1\">"+
                            "<img src='"+info[i].fansPic+"'/>"+
                            "<p>"+
                            "<span>"+info[i].fansNickname+"</span><br/>"+
                            "<span>"+info[i].fansSignature+"</span><br/>"+
                            "</p>"+
                            "<button class='privateChat'><a href=''>私信</a></button>"+
                            "<form action='' method='post'>"+
                                "<select class='subscribeOrNot' name='subscribeOrNot'>"+
                                "<option value=''>加关注</option>"+
                                "<option value=''>取消关注</option>"+
                                "</select>"+
                            "</form>"+
                         "</div>";

                }

                document.getElementsByClassName('fansNum').innerHTML=numfans;
                document.getElementsByClassName('rightBottomMyfan').innerHTML+=s;
                alert("粉丝连接成功");
            }else{
                alert("发生错误"+xmlhttp.status);
            }
        }
    }
    xmlhttp.open('get','');
    xmlhttp.send(null);
}
//我的粉丝end


//我的预约start
function myOrder(){
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status===200){
                var info=xhr.responseText;


                let myOrder="";
                for (let i=0;i<info.length;i++){
                    //<div class="box"><img src="../img/designerphoto2.jpg"/><span>XX造型师</span></div>
                    myOrder += "<div class='box'><a href='"+info[i].myorderUrl+"'><img src='"+info[i].myorderPic+"'/><span>"+info[i].designer+"</span></a></div>";
                }

                let historyOrderDesigner="";
                for (let i=0;i<info.length;i++){
                    //<div class="box"><img src="../img/designerphoto2.jpg"/><span>XX造型师</span></div>
                    historyOrderDesigner += "<div class='box'><a href='"+info[i].historyDesignerUrl+"'><img src='"+info[i].designerPic+"'/><span>"+info[i].designer+"</span></a></div>";
                }


                document.getElementsByClassName('myOrder').innerHTML+=myOrder;
                document.getElementsByClassName('stylingDesigner').innerHTML+=historyOrderDesigner;
                alert("预约连接成功");
            }else {
                alert("发生错误"+xhr.status);
            }
        }

    }
    xhr.open('get','');
    xhr.send(null);
}
//我的预约end



//事件绑定start
/*onclick绑定
let collectBtn=document.getElementById('collectBtn');
collectBtn.onclick=collect;
//解绑：collectBtn.onclick=null;*/


//事件绑定end
/*
let subscribeBtn=document.getElementById('subscribeBtn');
subscribeBtn.addEventListener('click',subscribe,false);

let fansBtn=document.getElementById('fansBtn');
fansBtn.addEventListener('click',fans,false);

let myOrderBtn=document.getElementById('myOrderBtn');
myOrderBtn.addEventListener('click',myOrder,false);
console.log(collectBtn);*/


window.onload=function(){
    showInformation();
    collect();
    subscribe();
   /* let collectBtn=document.getElementById('collectBtn');
    collectBtn.addEventListener('click',collect,false);*/
//collectBtn.removeEventListener('click',collect,false); 这个false是阻止冒泡的意思



};