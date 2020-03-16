/*第43行有个路径需要改*/

function selesctAddress2(){
    /* 地址三级联动的取值*/
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                let info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("成功"+xhr.status);
                    let salonBox="";
                    for (let i=0;i<info.result.styHouses.length;i++){
                        salonBox += "<div class='box1' onclick='locationDetail(this)' id='"+info.result.styHouses[i].styHouseId+"'>" +
                            "<img src='"+info.result.styHouses[i].styHousePhoto+"'/>"  +
                            "<div class='box1_1'>"   +
                            "<h5>"+info.result.styHouses[i].styHouseName+"</h5><br/>"  +
                            "<span class=\"address\">地址:"+info.result.styHouses[i].styHouseAddress+"</span><br/>"  +
                            "<span class=\"package\">"+info.result.styHouses[i].styHousePackage+"</span><br/>"+
                            "<a href=\"\">查看详情>></a><button style=\"float: right;color: #FF0000;border: 1px solid #000000;outline: none;background-color:#FFFFFF;padding: 2px;margin: 18px\">预约发型师</button>" +
                            "</div>"  +
                            "</div>";
                    }
                    let stylistBox="";
                    for(let i=0;i<info.result.stylists.length;i++){
                        stylistBox+="<div class=\"box2\" onclick='locationStylistDetail(this)' id='"+info.result.stylists[i].stylistId+"' style=\"width: 120px; height: 120px;background:url('img/stylistBackground.png') center;\">"+
                            "<img src='"+info.result.stylists[i].stylistPhoto+"'/>"  +
                            "<div class=\"box2_2\">"+
                            "<span><b>"+info.result.stylists[i].stylistName+"</b></span>"+
                            "<span>Lv20</span>"+
                            "</div>"+
                            "</div>";
                    }
                    document.getElementsByClassName('salonIndex')[0].innerHTML=salonBox;
                    document.getElementsByClassName('stylistAdd')[0].innerHTML=stylistBox;
                }else{
                    console.log("失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    xhr.open('post','userBrowse/styHouse');
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"styHousePosition":"上海市辖区黄浦区"};
    console.log("select2");
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}

function selesctAddress(){
        /* 地址三级联动的取值*/
        let pro = document.getElementById('cmbProvince'); //定位id
        let index1 = pro.selectedIndex; // 选中索引
        /*let text1 = pro.options[index1].text; // 选中文本*/
        let value1 = pro.options[index1].value; // 选中值

        let city = document.getElementById('cmbCity'); //定位id
        let index2 = city.selectedIndex; // 选中索引
        /*let text2 = city.options[index2].text; // 选中文本*/
        let value2 = city.options[index2].value; // 选中值

        let area = document.getElementById('cmbArea'); //定位id
        let index3 = area.selectedIndex; // 选中索引
        /*let text3 = area.options[index3].text; // 选中文本*/
        let value3 = area.options[index3].value; // 选中值

        let styHousePosition=value1+value2+value3;
        let xhr=new XMLHttpRequest();
        xhr.onreadystatechange=function(){
            if (xhr.readyState===4){
                if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                    let info = JSON.parse(xhr.responseText);
                    // var info = xhr.responseText;
                    if (info.errCode === 0){
                        console.log("成功"+xhr.status);
                        let salonBox="";
                        for (let i=0;i<info.result.styHouses.length;i++){
                            salonBox += "<div class='box1' onclick='locationDetail(this)' id='"+info.result.styHouses[i].styHouseId+"'>" +
                                "<img src='"+info.result.styHouses[i].styHousePhoto+"'/>"  +
                                "<div class='box1_1'>"   +
                                "<h5>"+info.result.styHouses[i].styHouseName+"</h5><br/>"  +
                                "<span class=\"address\">地址:"+info.result.styHouses[i].styHouseAddress+"</span><br/>"  +
                                "<span class=\"package\">"+info.result.styHouses[i].styHousePackage+"</span><br/>"+
                                "<a href=\"\">查看详情>></a><button style=\"float: right;color: #FF0000;border: 1px solid #000000;outline: none;background-color:#FFFFFF;padding: 2px;margin: 18px\">预约发型师</button>" +
                                "</div>"  +
                                "</div>";
                        }
                        let stylistBox="";
                        for(let i=0;i<info.result.stylists.length;i++){
                            stylistBox+="<div class=\"box2\" onclick='locationStylistDetail(this)' id='"+info.result.stylists[i].stylistId+"' style=\"width: 120px; height: 120px;background:url('../img/stylistBackground.png') center;\">"+
                                        "<img src='"+info.result.stylists[i].stylistPhoto+"'/>"  +
                                        "<div class=\"box2_2\">"+
                                        "<span><b>"+info.result.stylists[i].stylistName+"</b></span>"+
                                        "<span>Lv20</span>"+
                                        "</div>"+
                                        "</div>";
                        }
                        document.getElementsByClassName('salonIndex')[0].innerHTML=salonBox;
                        document.getElementsByClassName('stylistAdd')[0].innerHTML=stylistBox;
                    }else{
                        console.log("失败");
                    }
                }else{
                    console.log("发生错误"+xhr.status);
                }
            }
        }
        xhr.open('post','userBrowse/styHouse');
        xhr.setRequestHeader("Content-Type","application/json");
        let obj={"stoken":getCookie('stoken'),"styHousePosition":styHousePosition};
        console.log("select1");
        xhr.send(JSON.stringify(obj));
        console.log(JSON.stringify(obj));
}
/*造型屋详情页跳转*/
function locationDetail(objid){
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                let info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("成功"+xhr.status);
                    window.location.href = "salonDetail.html";
                }else{
                    console.log("跳转详情页失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let salonId=objid.getAttribute("id");
    sessionStorage.setItem('styhouseId',salonId);  /*后面可以加一个验证浏览器支不支持sessionStorage来优化*/
    let url='userBrowse/styHouse/'+salonId;
    console.log(url);
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"styHouseId":salonId};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}
/*造型师详情页跳转*/
function locationStylistDetail(objid){
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                let info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("成功"+xhr.status);
                    window.location.href = "stylistIndex.html";
                }else{
                    console.log("跳转详情页失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let stylistId=objid.getAttribute("id");
    sessionStorage.setItem('stylistId',stylistId);  /*后面可以加一个验证浏览器支不支持sessionStorage来优化*/
    let url='userBrowse/stylist/'+stylistId;
    console.log(url);
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"stylistId":stylistId};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}
window.onload=function () {
    console.log("salonIndex");
    selesctAddress2();
    /*getCookie('stoken');*/
};
