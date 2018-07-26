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

    let obj=document.getElementById('showInformation');
    obj.style.display="block";
}
//我的信息编辑隐藏弹出end
function showInformation(){


        let xhr=new XMLHttpRequest();

        xhr.onreadystatechange=function() {
            if (xhr.readyState === 4) {
                if (xhr.status >= 200 && xhr.status < 300 || xhr.status === 304) {

                    var info = JSON.parse(xhr.responseText);

                    if (info.isOpen === "1") {

                        let showInform = "";
                        alert("成功1");
                        showInform += "<p><img src='" + info.userPhoto + "'></p><div class=\"clear\"></div>" +
                            "<p><span class=\"nickname\">昵称：" + info.userName + "</span></p><div class=\"clear\"></div>" +
                            "<p><span class=\"personalizedSignature\">我的签名：" + info.userWord + "</span></p><div class=\"clear\"></div>" +
                            "<p><span class=\"sex\">性别:" + info.userSex + "</span></p><div class=\"clear\"></div>";

                        alert("成功2" + showInform);

                        document.getElementsByClassName('addContent')[0].innerHTML = showInform;

                        alert("成功3");

                      } else {
                                        alert("用户没有登录" + info.isOpen);
                                    }
                                } else {
                                    alert("发生错误" + xhr.status);
                                }
                            }
                        }
                        xhr.open('get', '/myHome/index');
                        xhr.send(null);
                    }


function information(){
/*    let fm=document.getElementById('form');

    let fd=new FormData(fm);*/

    let information="";
    let inputs=document.getElementsByClassName("updateInfo")[0].getElementsByTagName("input");
    let arr = ["userPhoto","userName","userWord","userSex"];

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
            if (xmlhttp.status===200){
                var info = JSON.parse(xhr.responseText);

                if (info.isOpen === 1){
                    alert("保存成功"+xmlhttp.status);
                }else{
                    alert("保存失败");
                }

                /*eval("var info="+xmlhttp.responseText);*/
            }else{
                alert("发生错误"+xmlhttp.status);
            }
        }
    }
    xmlhttp.open('post','/myHome/updateMessage');
    xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
    for(var i=0; i<inputs.length-1; i++) {
        information += ( arr[i] + "=" + inputs[i].value +"&" );
    }
    xmlhttp.send(information);
}


//我的收藏start
                    function collect() {
                        let xhr = new XMLHttpRequest();
                        xhr.onreadystatechange = function () {
                            if (xhr.readyState === 4) {
                                if (xhr.status === 200) {
                                    var info = xhr.responseText;

                                    //造型师、造型屋、测评的收藏数
                                    let numDesigner = "";
                                    //<span class="stylingDesignerSpan">造型师（收藏数）</span>
                                    numDesigner += "<span class='stylingDesignerSpan'>造型师（" + info.designerNum + ")</span>";

                                    let numSalon = "";
                                    //<span class="hairSalonSpan">造型屋（收藏数）</span>
                                    numSalon += "<span class='hairSalonSpan'>造型屋（" + info.salonNum + ")</span>";

                                    let numEvaluate = "";
                                    //<span class="evaluationCollection">测评（收藏数）</span>
                                    numEvaluate += "<span class='evaluationCollection'>测评（" + info.evaluateNum + ")</span>";

                                    //造型师、造型屋、测评的添加内容
                                    let designerBox = "";
                                    for (let i = 0; i < info.length; i++) {
                                        //<div class="box"><img src="../img/designerphoto2.jpg"/><span>XX造型师</span></div>
                                        designerBox += "<div class='box'><a href='" + info[i].designerUrl + "'><img src='" + info[i].designerPic + "'/><span>" + info[i].designer + "造型师</span></a></div>";
                                    }

                                    let salonBox = "";
                                    for (let i = 0; i < info.length; i++) {
                                        //<div class="box"><img src="../img/salaonpho1.jpg"/><span>XX造型屋</span></div>
                                        salonBox += "<div class='box'><a href='" + info[i].salonUrl + "'><img src='" + info[i].salonPic + "'/><span>" + info[i].salon + "造型屋</span></a></div>";
                                    }

                                    let evaluateBox = "";
                                    for (let i = 0; i < info.length; i++) {
                                        //<div class="clear"></div>
                                        //<div class="box1">
                                        //       <img src="../img/投稿/evaluation.jpeg"/>
                                        //        <div class="box1_1">
                                        //        <span>名字</span><br />
                                        //        <span>简介：xxxxxxxxxxxxxxxxxxxxx</span><br />
                                        //    <i class="iconfont icon-fenxiang"> </i><span class="icon-fenxiangSpan">分享</span>
                                        //    <i class="iconfont icon-shanchu"></i><span class="icon-shanchuSpan">删除收藏</span>
                                        //        </div>
                                        //</div>
                                        evaluateBox += "<div class='clear'></div>" +
                                            "<div class='box1'><a href='" + info[i].evaluateUrl + "'>" +
                                            "<img src='" + info[i].evaluatePic + "'/>" +
                                            "<div class='box1_1'>" +
                                            "<span>" + info[i].evaluateName + "</span><br/>" +
                                            "<span>简介：" + info[i].evaluateSummary + "</span><br/>" +
                                            "<i class='iconfont icon-fenxiang'></i><span class='icon-fenxiangSpan'>分享</span>" +
                                            "<i class=\"iconfont icon-shanchu\"></i><span class=\"icon-shanchuSpan\">删除收藏</span>" +
                                            "</div>" +
                                            "</a></div>";
                                    }

                                    document.getElementsByClassName('stylingDesignerSpan').innerHTML = numDesigner;
                                    document.getElementsByClassName('hairSalonSpan').innerHTML = numSalon;
                                    document.getElementsByClassName('evaluationCollection').innerHTML = numEvaluate;

                                    document.getElementsByClassName('stylingDesigner').innerHTML += designerBox;
                                    document.getElementsByClassName('hairSalon').innerHTML += salonBox;
                                    document.getElementsByClassName('evaluation').innerHTML += evaluateBox;
                                    alert("收藏成功");
                                } else {
                                    alert("发生错误" + xhr.status);
                                }
                            }
                        }
                        xhr.open('get', '');
                        xhr.send(null);
                    }

//我的收藏end

//我的关注start
                    function subscribe() {
                        let xmlhttp;
                        if (window.XMLHttpRequest) {
                            xmlhttp = new XMLHttpRequest();
                        } else {
                            xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
                        }

                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4) {
                                if (xmlhttp.status === 200) {
                                    var info = xmlhttp.responseText;

                                    let numsubscribe = "";
                                    //<span class="subscribeNum">关注(关注数)</span>
                                    numsubscribe += "<span class='subscribeNum'>关注（" + info.subscribeNum + ")</span>";

                                    let s = "";
                                    for (let i = 0; i < info.length; i++) {

                                        s += "<div class='subscribeContent1'>" +
                                            "<img src='" + info[i].subscribePic + "'/>" +
                                            "<p>" +
                                            "<span>" + info[i].subscribeNickname + "</span><br/>" +
                                            "<span>" + info[i].subscribeSignature + "</span>" +
                                            "</p>" +
                                            "<button class='privateChat'><a href=''>私信</a></button>" +
                                            "<form action='' method='post'>" +
                                            "<select class='subscribeOrNot' name='subscribeOrNot'>" +
                                            "<option value=''>取消关注</option>" +
                                            "<option value=''>关注</option>" +
                                            "</select>" +
                                            "</form>" +
                                            "</div>";
                                    }

                                    document.getElementsByClassName('subscribeNum').innerHTML = numsubscribe;
                                    document.getElementsByClassName('rightBottomSubscribe').innerHTML += s;
                                    alert("关注连接成功");
                                } else {
                                    alert("发生错误" + xmlhttp.status);
                                }
                            }
                        }
                        xmlhttp.open('get', '');
                        xmlhttp.send(null);
                    }

//我的关注end

//我的粉丝start
                    function fans() {
                        let xmlhttp;
                        if (window.XMLHttpRequest) {
                            xmlhttp = new XMLHttpRequest();
                        } else {
                            xmlhttp = new ActiveXObject("Microsoft XMLHTTP");
                        }
                        xmlhttp.onreadystatechange = function () {
                            if (xmlhttp.readyState === 4) {
                                if (xmlhttp.status === 200) {
                                    var info = xmlhttp.responseText;

                                    let numfans = "";
                                    //<span class="fansNum">粉丝(粉丝数)</span>
                                    numfans += "<span class='fansNum'>粉丝（" + info.fansNum + ")</span>";

                                    let s = "";
                                    for (let i = 0; i < info.length; i++) {

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

                                        s += "<div class=\"myfanContent1\">" +
                                            "<img src='" + info[i].fansPic + "'/>" +
                                            "<p>" +
                                            "<span>" + info[i].fansNickname + "</span><br/>" +
                                            "<span>" + info[i].fansSignature + "</span><br/>" +
                                            "</p>" +
                                            "<button class='privateChat'><a href=''>私信</a></button>" +
                                            "<form action='' method='post'>" +
                                            "<select class='subscribeOrNot' name='subscribeOrNot'>" +
                                            "<option value=''>加关注</option>" +
                                            "<option value=''>取消关注</option>" +
                                            "</select>" +
                                            "</form>" +
                                            "</div>";

                                    }

                                    document.getElementsByClassName('fansNum').innerHTML = numfans;
                                    document.getElementsByClassName('rightBottomMyfan').innerHTML += s;
                                    alert("粉丝连接成功");
                                } else {
                                    alert("发生错误" + xmlhttp.status);
                                }
                            }
                        }
                        xmlhttp.open('get', '');
                        xmlhttp.send(null);
                    }

//我的粉丝end


//我的预约start
                    function myOrder() {
                        let xhr = new XMLHttpRequest();
                        xhr.onreadystatechange = function () {
                            if (xhr.readyState === 4) {
                                if (xhr.status === 200) {
                                    var info = xhr.responseText;


                                    let myOrder = "";
                                    for (let i = 0; i < info.length; i++) {
                                        //<div class="box"><img src="../img/designerphoto2.jpg"/><span>XX造型师</span></div>
                                        myOrder += "<div class='box'><a href='" + info[i].myorderUrl + "'><img src='" + info[i].myorderPic + "'/><span>" + info[i].designer + "</span></a></div>";
                                    }

                                    let historyOrderDesigner = "";
                                    for (let i = 0; i < info.length; i++) {
                                        //<div class="box"><img src="../img/designerphoto2.jpg"/><span>XX造型师</span></div>
                                        historyOrderDesigner += "<div class='box'><a href='" + info[i].historyDesignerUrl + "'><img src='" + info[i].designerPic + "'/><span>" + info[i].designer + "</span></a></div>";
                                    }


                                    document.getElementsByClassName('myOrder').innerHTML += myOrder;
                                    document.getElementsByClassName('stylingDesigner').innerHTML += historyOrderDesigner;
                                    alert("预约连接成功");
                                } else {
                                    alert("发生错误" + xhr.status);
                                }
                            }

                        }
                        xhr.open('get', '');
                        xhr.send(null);
                    }

//我的预约end


//事件绑定start

/*onclick绑定
let collectBtn=document.getElementById('collectBtn');
collectBtn.onclick=collect;
//解绑：collectBtn.onclick=null;*/

//事件绑定end








                    window.onload = function () {
                        showInformation();
                        let collectBtn = document.getElementById('collectBtn');
                        console.log(collectBtn);
                        collectBtn.addEventListener('click', collect, false);
                        //collectBtn.removeEventListener('click',collect,false);
                        console.log(1);


                        let subscribeBtn = document.getElementById('subscribeBtn');
                        subscribeBtn.addEventListener('click', subscribe, false);

                        let fansBtn = document.getElementById('fansBtn');
                        fansBtn.addEventListener('click', fans, false);

                        let myOrderBtn = document.getElementById('myOrderBtn');
                        myOrderBtn.addEventListener('click', myOrder, false);

                    }

