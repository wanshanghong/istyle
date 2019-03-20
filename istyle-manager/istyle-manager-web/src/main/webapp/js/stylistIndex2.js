/*造型师主页展示*/
function stylistIndex() {
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0){
                    console.log("造型屋首页展示成功"+xhr.status);
                    let y="";
                    y+= "<img src='"+info.result.tbStylist[0].stylistPhoto+"'>"+
                        "<h5>"+info.result.tbStylist[0].stylistName+"</h5>"+
                        "<span>"+info.result.tbStylist[0].stylistWord+"</span>"+
                        "<div class=\"clear\"></div>"+
                        "<div class=\"stylistBtn2\"></div>"+
                        "<button onclick=\"locationConsultation()\"class=\"stylistBtn2\">咨询</button>";
                    let s="";
                    if(!info.result.isAttention){  //0是已关注，1是未关注
                        s+="<button onclick=\"decstylistSub()\" class=\"stylistBtn1\">已关注</button>";
                    }else{
                        s+="<button onclick=\"stylistSub()\" class=\"stylistBtn1\">关注</button>";
                    }
                    let z="";
                    z+="<span>已接受咨询人数："+info.result.tbStylist[0].stylistAdvisory+"</span>"+
                        "<div class=\"clear\"></div>"+
                        "<div style=\"width:1000px; border:1px solid #666;\"></div>"+
                        "<p>个人简介></p>"+
                        "<div class=\"clear\"></div>"+
                        "<span class=\"introduce\">"+info.result.tbStylist[0].stylistIntroduction+"</span>";
                    document.getElementsByClassName('topContent')[0].innerHTML=y;
                    document.getElementsByClassName('stylistBtn2')[0].innerHTML=s;
                    document.getElementsByClassName('stylistindex')[0].innerHTML=z;
                }else{
                    console.log("造型师首页展示失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let stylistId=sessionStorage.getItem('stylistId');
    let url="/userBrowse/stylist/"+stylistId;
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"stylistId":stylistId};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}

/*造型师粉丝页面展示*/
function stylistFan() {
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0){
                    console.log("造型屋粉丝展示成功"+xhr.status);
                    let s="";
                    s+="<span class=\"fannum\">粉丝数 "+info.result.fanCount+" </span>";
                    let y="";
                    for (let i=0;i<info.result.fanCount.length;i++){
                        y+="<div class=\"subscribeContent1\">"+
                            "<img src='"+info.result.fans[i].userPhoto+"'/>"+
                            "<p>"+
                            "<span>"+info.result.fans[i].userName+"</span><br/>"+
                            "<span>"+info.result.fans[i].userWord+"</span>"+
                            "</p>"+
                            "<button class='privateChat'><a href=''>私信</a></button>"+
                            "<button class='subscribeOrNot' onclick='' id='"+info.result.fans[i].userId+"'>取消关注</button>"+
                            "</div>"+
                            "<div class=\"clear\"></div>";
                    }
                    document.getElementsByClassName('fannum')[0].innerHTML=s;
                    document.getElementsByClassName('fanCon')[0].innerHTML=y;
                }else{
                    console.log("造型师首页展示失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let stylistId=sessionStorage.getItem('stylistId');
    let url="/userBrowse/stylist/"+stylistId+"/showStylistFan";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"stylistId":stylistId};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}

/*用户关注造型师*/
function stylistSub() {
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info1 = JSON.parse(xhr.responseText);
                if (!info1.errCode){
                    console.log("关注成功"+xhr.status);
                    stylistIndex();
                }else{
                    console.log("关注失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let stylistId=sessionStorage.getItem('stylistId');
    let url="/userBrowse/stylist/"+stylistId+"/addAttention";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"stylistId":stylistId};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}

/*用户取消关注造型师*/
function decstylistSub() {
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info1 = JSON.parse(xhr.responseText);
                if (!info1.errCode){
                    console.log("取消关注成功"+xhr.status);
                    stylistIndex();
                }else{
                    console.log("取消关注失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let stylistId=sessionStorage.getItem('stylistId');
    let url="/userBrowse/stylist/"+stylistId+"/addAttention";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"stylistId":stylistId};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}

/*用户打开造型师咨询界面*/
function locationConsultation() {
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0){
                    console.log("咨询跳转成功"+xhr.status);
                }else{
                    console.log("咨询跳转失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let stylistId=sessionStorage.getItem('stylistId');
    let url="/userBrowse/stylist/"+stylistId+"/ShowAdvisory";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"stylistId":stylistId};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}
