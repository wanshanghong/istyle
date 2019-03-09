function locaDetail(){
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
                            "<h4>"+info.result.styHouse[0].styHouseName+"</h4><br>"  +
                            "<span style=\"color: orangered\">" +info.result.styHouse[0].styHouseEvaluation+ "人评论</span>" +
                            "<div style='width:500px; border:1px solid #666;'></div>"  +
                            "<span>"+info.result.styHouse[0].styHouseAddress+"</span><br>"  +
                            "<span>"+info.result.styHouse[0].styHousePackage+"</span><br>"+
                            "<span>电话："+info.result.styHouse[0].styHousePhone+"</span><br>" +
                            "<span>营业时间:"+info.result.styHouse[0].styHouseWorkTime+"</span>" +
                            "<div style=\"width:983px; border:1px solid #666;\"></div>"+
                            "<span>提供wifi</span>&nbsp;&nbsp;"+
                            "<span>提供免费车位</span>"+
                            "</div>"+
                            "<div class=\"salonTopRight\">"+
                            "<img src='"+info.result.styHouse[0].styHousePhoto+"'>"+
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
    let salonId=sessionStorage.getItem('styhouseId');
    sessionStorage.clear();
    let url='/userBrowse/styHouse/'+salonId;
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"styHouseId":salonId};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}
window.onload=function () {
    locaDetail();
    /*getCookie('stoken');*/
};
