/*第43行有个路径需要改*/

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
                            salonBox += "<div class='box1' onclick='locationDetail(this);locaDetail(this)' id='"+info.result.styHouses[i].styHouseId+"'>" +
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
                            stylistBox+="<div class=\"box2\" style=\"width: 120px; height: 120px;background:url('/img/stylistBackground.png') center;\">"+
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
        xhr.open('post','/userBrowse/styHouse');
        xhr.setRequestHeader("Content-Type","application/json");
        let obj={"stoken":getCookie('stoken'),"styHousePosition":styHousePosition};
        xhr.send(JSON.stringify(obj));
        console.log(JSON.stringify(obj));
}
function locationDetail(objid){
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                let info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("成功"+xhr.status);
                    locaDetail(objid.getAttribute("id"));
                    window.location.href = "/html/salonDetail.html";
                }else{

                } console.log("跳转详情页失败");
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let salonId=objid.getAttribute("id");
    console.log(salonId);
    let url='/userBrowse/styHouse/'+salonId;
    console.log(url);
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"styHouseId":salonId};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}
function locaDetail(objid){

    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                let info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("成功"+xhr.status);
                    let salonBox="";
                    salonBox += "<div class=\"salonTopLeft\">" +
                        "<h4>"+info.result.styHouse.styHouseName+"</h4><br>"  +
                        "<span style=\"color: orangered\">" +info.result.styHouse.styHouseEvaluation+ "人评论</span>" +
                        "<div style='width:500px; border:1px solid #666;'></div>"  +
                        "<span>"+info.result.styHouse.styHouseAddress+"</span><br>"  +
                        "<span>"+info.result.styHouse.styHousePackage+"</span><br>"+
                        "<span>电话："+info.result.styHouse.styHousePhone+"</span><br>" +
                        "<span>营业时间:"+info.result.styHouse.styHouseWorkTime+"</span>" +
                        "<div style=\"width:983px; border:1px solid #666;\"></div>"+
                        "<span>提供wifi</span>&nbsp;&nbsp;"+
                        "<span>提供免费车位</span>"+
                        "</div>"+
                        "<div class=\"salonTopRight\">"+
                        "<img src='"+info.result.styHouse.styHousePhoto+"'>"+
                        "</div>"+
                        "<div class=\"clear\"></div>"+
                        "<div class=\"salonTopBottom\"></div>";

                    let stylistBox="";
                    for(let i=0;i<info.result.discountPackage.length;i++){
                        stylistBox+="<div class=\"clear\"></div>"+
                            "<div class='mealContent'>"  +
                            "<img src='"+info.result.discountPackage[i].packagePhoto+"'/>"+
                            "<p>"+
                            "<span>"+info.result.discountPackage[i].packageName+"</span><br/>"+
                            "<span style=\"color: orange;padding-top: 20px\">"+info.result.discountPackage[i].packagePrice+"</span>"+
                            "</p>"+
                            "<button class='order' onclick=''>立即预约</button>"+
                            "</div>";
                    }
                    document.getElementsByClassName('salonIntroduce')[0].innerHTML=salonBox;
                    document.getElementsByClassName('salonMeal')[0].innerHTML=stylistBox;
                }else{
                    console.log("失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let salonId=objid.getAttribute("id");
    let url='/userBrowse/styHouse/'+salonId;
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"styHouseId":salonId};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}
window.onload=function () {
    console.log("salonIndex");
    selesctAddress();
    /*getCookie('stoken');*/
};
