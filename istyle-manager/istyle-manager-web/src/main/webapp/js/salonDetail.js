function locaDetail(){
	console.log("locaDetail()");
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
                            "<span style=\"color: orangered\">" +info.result.styHouse[0].commentCount+ "人评论</span>" +
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
                            "<button class='order' onclick='mealOrderShow(this)' id='"+info.result.discountPackage[i].packageId+"'>立即预约</button>"+
                            "</div>";
                    }
                    let stylistBox2="";
                    for(let i=0;i<info.result.tbStyHouseStylist.length;i++){
                    	stylistBox2+="<div class=\"clear\"></div>"+
                        	"<div class=\"mealContent\">"+
                            "<img src=\""+info.result.tbStyHouseStylist[i].stylistPhoto+"\"/>"+
                            "<p>"+
                                "<span>姓名："+info.result.tbStyHouseStylist[i].stylistName+"</span>  <span>最大预约人数："+info.result.tbStyHouseStylist[i].maxNumber+"</span> <br />"+
                                "<span >可预约时间："+info.result.tbStyHouseStylist[i].reservationTime+"</span>"+
                            "</p>"+
                            "<button class='order' onclick='locationStylistDetail(this)' id='"+info.result.tbStyHouseStylist[i].stylistId+"'>点击查看</button>"+
                            "<button class='order' onclick='stylistOrderShow(this)' id='"+info.result.tbStyHouseStylist[i].stylistId+"'>立即预约</button>"+
                        "</div>";
                    }
                    document.getElementsByClassName('salonIntroduce')[0].innerHTML=salonBox;
                    document.getElementById('showSalonMeal').innerHTML=stylistBox;
                    document.getElementById('showSalonStylist').innerHTML=stylistBox2;
                }else{
                    console.log("失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let salonId=sessionStorage.getItem('styhouseId');
    let url='userBrowse/styHouse/'+salonId;
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"styHouseId":salonId};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}
function mealOrderShow(obj) {
	let hidden=document.getElementById('showSalonMeal');
    hidden.style.display="none";
    let obj1=document.getElementById('updateSalonMeal');
    obj1.style.display="block";
    let packageId=obj.getAttribute("id");
    let showInform = "";
    showInform +=
               "<p><label for=\"test12\">日期选择：</label><input type=\"text\" class=\"demo-input\" placeholder=\"请选择日期\" id=\"test2\"></p>"+
               "<p><label for=\"test9\">时间选择：</label><input type=\"text\" class=\"demo-input\" placeholder=\"请选择时间\" id=\"test9\"></p>"+
               "<p><input type='button' onclick='updadeOrderMeal(this);locaDetail();' class='order' value='提交' id='"+packageId+"'/></p>";
    
    document.getElementById('updateSalonMeal').innerHTML = showInform;
    laydate.render({
        elem: '#test2'
    });
    laydate.render({
        elem: '#test9'
        ,type: 'time'
        ,range: true
    });
    /*let hidden=document.getElementById('showSalonMeal');
    hidden.style.display="none";
    let obj1=document.getElementById('updateSalonMeal');
    obj1.style.display="block";
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0) {
                    let showInform = "";
                    showInform +=
                        "<p><label for=\"test12\">日期选择：</label><input type=\"text\" class=\"demo-input\" placeholder=\"请选择日期\" id=\"test2\"></p>"+
                        "<p><label for=\"test9\">时间选择：</label><input type=\"text\" class=\"demo-input\" placeholder=\"请选择时间\" id=\"test9\"></p>"+
                        "<p><input type='button' onclick='updadeOrderMeal(this);locaDetail();' class='order' value='提交' id='"+info.result.packageId+"'/></p>";
                    document.getElementById('updateSalonMeal').innerHTML = showInform;
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    let styHouseId=sessionStorage.getItem('styHouseId');
    let url="/styHouse/"+styHouseId+"/editMessage";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let packageId=obj.getAttribute("id");
    let obj2={"stoken":getCookie('stoken'),"styHouseId":styHouseId,"packageId":packageId};
    xhr.send(JSON.stringify(obj2));*/
}
function updadeOrderMeal(obj) {
    let date=document.getElementById('test2').value;
    let hour=document.getElementById('test9').value;
    let reservationTime=date+hour;
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("提交成功"+xhr.status);
                    alert("预约成功");
                    window.location.href = "salonDetail.html";
                }else{
                    console.log("提交失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let styHouseId=sessionStorage.getItem('styhouseId');
    //let url="/styHouse/"+styHouseId+"/submitEditPackage";
    let url="InsertTbAppointmentPackage";
    let packageId=obj.getAttribute("id");
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj1={"stoken":getCookie('stoken'),"styhouseId":styHouseId,"packageId":packageId,"appointmentTime":reservationTime};
    xhr.send(JSON.stringify(obj1));
    console.log(JSON.stringify(obj1));
}
function stylistOrderShow(obj) {
	let hidden=document.getElementById('showSalonStylist');
    hidden.style.display="none";
    let obj1=document.getElementById('updateSalonStylist');
    obj1.style.display="block";
    let stylistId=obj.getAttribute("id");
    let showInform = "";
    showInform +=
        "<p><label for=\"test1\">日期选择：</label><input type=\"text\" class=\"demo-input\" placeholder=\"请选择日期\" id=\"test1\"></p>"+
        "<p><label for=\"test8\">时间选择：</label><input type=\"text\" class=\"demo-input\" placeholder=\"请选择时间\" id=\"test8\"></p>"+
        "<p><input type='button' onclick='updadeOrderStylist(this);locaDetail();' class='order' value='提交' id='"+stylistId+"'/></p>";
    document.getElementById('updateSalonStylist').innerHTML = showInform;
    laydate.render({
        elem: '#test1'
    });
    laydate.render({
        elem: '#test8'
        ,type: 'time'
        ,range: true
    });
    /*let hidden=document.getElementById('showSalonStylist');
    hidden.style.display="none";
    let obj1=document.getElementById('updateSalonStylist');
    obj1.style.display="block";
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0) {
                    let showInform = "";
                    showInform +=
                        "<p><label for=\"test1\">日期选择：</label><input type=\"text\" class=\"demo-input\" placeholder=\"请选择日期\" id=\"test1\"></p>"+
                        "<p><label for=\"test8\">时间选择：</label><input type=\"text\" class=\"demo-input\" placeholder=\"请选择时间\" id=\"test8\"></p>"+
                        "<p><input type='button' onclick='updadeOrderStylist(this);locaDetail();' class='order' value='提交' id='"+info.result.stylistId+"'/></p>";
                    document.getElementById('updateSalonStylist').innerHTML = showInform;
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    let styHouseId=sessionStorage.getItem('styHouseId');
    let url="/styHouse/"+styHouseId+"/editMessage";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let stylistId=obj.getAttribute("class");
    let obj2={"stoken":getCookie('stoken'),"styHouseId":styHouseId,"stylistId":stylistId};
    xhr.send(JSON.stringify(obj2));*/
}
function updadeOrderStylist(obj1) {
    let date=document.getElementById('test1').value;
    let hour=document.getElementById('test8').value;
    let reservationTime=date+hour;
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("提交成功"+xhr.status);
                    alert("预约成功");
                    window.location.href = "salonDetail.html";
                }else{
                    console.log("提交失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let styhouseId=sessionStorage.getItem('styhouseId');
    let url="insertAppointmentStylist";
    let stylistId=obj1.getAttribute("id");
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj2={"stoken":getCookie('stoken'),"styhouseId":styhouseId,"stylistId":stylistId,"appointmentStylistTime":reservationTime};
    xhr.send(JSON.stringify(obj2));
    console.log(JSON.stringify(obj2));
}
window.onload=function () {
	console.log("locaDetail()111111");
	locaDetail();
    /*getCookie('stoken');*/
};
