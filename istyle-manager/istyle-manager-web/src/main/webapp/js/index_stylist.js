//基本信息start
//基本信息编辑隐藏弹出start
function editor1() {
    let hidden=document.getElementById('showInformation');
    hidden.style.display="none";

    //let obj=document.getElementById('form');
    //obj.style.display="block";

    //渲染造型屋信息
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0) {
                    let showInform = "";
                    //alert("成功渲染");
                    showInform +="<p><input type=\"button\" id=\"changeheadPortrait\" onclick=\"changeHead.click()\" value=\"上传照片\">"+
                    "<input type=\"file\" id=\"changeHead\" style=\"display: none\" onchange=\"input1.value=this.value\" name=\"file2\">"+
                    "<input type=\"text\" id=\"input1\" style=\"margin-right:-100px;border-radius: 5px; border: 1px solid #5bc0de; width: 250px; height: 30px;\">"+
                    "</p>"+
                    "<p><label for=\"salonName\">名字：</label><input type=\"text\" class=\"input1\" id=\"salonName\" name=\"stylistName\" value=\""+info.result.tbStylist.stylistName+"\" placeholder=\"请输入名称字\" /></p>"+
                    "<p><label for=\"meal\">简介：</label><textarea name=\"stylistIntroduction\" class=\"input3\" id=\"meal\" cols=\"30\" rows=\"10\" value=\""+info.result.tbStylist.stylistIntroduction+"\"placeholder=\"请输入简介(最多25字)\">"+info.result.tbStylist.stylistIntroduction+"</textarea></p>"+
                    "<p><label for=\"address\">所在造型屋ID：</label><textarea name=\"styHouseId\" class=\"input2\" id=\"address\" cols=\"30\" rows=\"10\" value=\""+info.result.tbStyHouse.styHouseId+"\"placeholder=\"请输入造型屋ID\">"+info.result.tbStyHouse.styHouseId+"</textarea></p>"+
                    "<p><label for=\"phone\">联系电话：</label><input type=\"text\" class=\"input5\" id=\"phone\" name=\"stylistPhone\" value=\""+info.result.tbStylist.stylistPhone+"\" placeholder=\"请输入联系电话\" /></p>"+
                 	"<p><input type=\"button\" onclick=\"information();success();showInformation()\" id=\"submit\" value=\"保存\"/></p>";
               		
                    
                        /*"<p><label for=\"stylistName\">名字：</label><input type=\"text\" class=\"input\" id=\"stylistName\" name=\"stylistName\" value=\""+info.result.tbStylist.stylistName+"\" /></p>"+
                        "<p><label for=\"meal\">简介：</label><input type=\"text\" class=\"input\" id=\"meal\" name=\"meal\" value=\""+info.result.tbStylist.stylistIntroduction+"\" /></p>"+
                        "<p><label for=\"address\">所在造型屋ID：</label><input type=\"text\" class=\"input\" id=\"address\" name=\"address\" value=\""+info.result.styHouseId+"\" /></p>"+
                        "<p><label for=\"phone\">联系电话：</label><input type=\"text\" class=\"input\" id=\"phone\" name=\"phone\" value=\""+info.result.tbStylist.stylistPhone+"\" /></p>"+
                        "<p><input type=\"button\" onclick=\"information();success();showInformation()\" id=\"submit\" value=\"保存\"/></p>";*/
                    document.getElementById('updateContent1').innerHTML = showInform;
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    let stylistId=sessionStorage.getItem('stylistId');
    /*let url="/styHouse/"+styHouseId+"/editMessage";*/
    xhr.open('post',"stylist/editMessage");
    xhr.setRequestHeader("Content-Type","application/json");
    let obj1={"stoken":getCookie('stoken'),"stylistId":stylistId};
    xhr.send(JSON.stringify(obj1));
}
function success(){
    let hidden=document.getElementById('form');
    hidden.style.display="none";
    showInformation();
    let obj=document.getElementById('showInformation');
    obj.style.display="block";
}
//基本信息编辑隐藏弹出end
//基本信息展示
function showInformation(){
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0) {
                    sessionStorage.setItem('stylistId',info.result.stylistId);
                    let showInform = "";
              
                    showInform += 
                    	"<p><img src='" + info.result.tbStylist.stylistPhoto + "'></p><div class=\"clear\"></div>" +
                        "<p><span class=\"salonName\">名字：" + info.result.tbStylist.stylistName + "</span></p><div class=\"clear\"></div>" +
                        "<p><span class=\"address\">所在造型屋地址：" + info.result.tbStyHouse.styHouseAddress + "</span></p><div class=\"clear\"></div>" +
                        "<p><span class=\"meal\">简介：" + info.result.tbStylist.stylistIntroduction + "</span></p><div class=\"clear\"></div>" +
                        "<p><span class=\"phone\">联系电话：" + info.result.tbStylist.stylistPhone + "</span></p><div class=\"clear\"></div>";
                    document.getElementsByClassName('addContent1')[0].innerHTML = showInform;
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    let stylistId=sessionStorage.getItem('stylistId');
    xhr.open('post','stylist/index');
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"stylistId":stylistId};
    xhr.send(JSON.stringify(obj));
}
//我的信息编辑
function information(){
	
	var form_data = new FormData(form2);
	console.log(form_data.get('file2')); 

	/*let stylistName=document.getElementById('salonName').value;
	let styHouseId=document.getElementById('address').value;
	let stylistIntroduction=document.getElementById('meal').value;
	let stylistPhone=document.getElementById('phone').value;
	form_data.append("stylistName", stylistName);
	form_data.append("styHouseId", styHouseId);
	form_data.append("stylistIntroduction", stylistIntroduction);
	form_data.append("stylistPhone", stylistPhone);*/
	form_data.append("stoken", getCookie('stoken'));
	console.log(form_data);
	
	let xhr=new XMLHttpRequest();
	let url="stylist/updateMessage";
    xhr.open("post",url);
    xhr.send(form_data);
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
        	if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                console.log("5");
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
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
}

/*待处理咨询*/
function showConsul() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status >= 200 && xhr.status < 300 || xhr.status === 304) {
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0) {
                   /* let styNum="";
                    //<span class="styNum">造型师数(6)</span>
                    styNum+="造型师数（"+info.result.stylistCount+")";*/
                    let s = "";
                    let list=info.result;
                    
                	
                    for (let i = 0; i < list.length; i++) {
                    	var date = new Date(list[i].putTime);
                    	console.log("date[i]="+date)
                    	var putTime = date.getFullYear() + '-' + (date.getMonth() + 1) + '-' 
                    				+ date.getDate() + ' ' + date.getHours()+ ':' + date.getMinutes() + ':' + date.getSeconds();
                    	console.log("putTime="+putTime);
                       
                    	s += "<div class='clear'></div>" +
                            "<div class=\"mealContent\">" +
                            "<img src='" + list[i].tbUser.userPhoto + "'/>" +
                            "<p>" +
                            "<span class=\"stylistName\">" + list[i].tbUser.userName + "</span><br />"+
                            "<span class=\"orderTime\">发起咨询时间："+putTime+"</span>"+
                            "</p>" +
                            "<button class='order' onclick='locationAnswer(this)' id="+list[i].advisoryId+">查看咨询并回复</button>"+
                            "</div>";
                    }
                    /*document.getElementsByClassName('styNum')[0].innerHTML=styNum;*/
                    document.getElementById('showstylist').innerHTML = s;
                } else {
                    console.log("造型师管理展示失败");
                }
            } else {
                console.log("发生错误" + xhr.status);
            }
        }
    }
    let stylistId=sessionStorage.getItem('stylistId');
    /*let url = "/styHouse/" + styHouseId + "/stylistManager";*/
    xhr.open('post',"stylist/advisorying");
    xhr.setRequestHeader("Content-Type", "application/json");
    let obj = {
        "stoken":getCookie('stoken'),
        "stylistId": stylistId
    };
    xhr.send(JSON.stringify(obj));
}
/*待处理咨询end*/
function locationAnswer(obj1){
    /*let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0) {
                    window.location.href = "answerConsultation.html";
                    alert("跳转成功");
                    let hidden=document.getElementById('beforeLogin');
                    hidden.style.display="none";
                    let userName=getCookie('username');
                    let appear=document.getElementsByClassName('afterLogin')[0];
                    appear.innerHTML="欢迎"+userName+"登录istyle";
                }else{
                    alert("跳转失败，该用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
                console.error(xhr.responseText);
            }
        }
    }
    let stylistId=sessionStorage.getItem('stylistId');
    xhr.open('post','stylist/editAdvisory');
    xhr.setRequestHeader("Content-Type","application/json");
    let data=getCookie('stoken');
    let userId=obj1.getAttribute("id");
    sessionStorage.setItem('userId',userId);
    let obj={"stoken":data,"stylistId":stylistId,"userId":userId};
    xhr.send(JSON.stringify(obj));*/
	 let advisoryId=obj1.getAttribute("id");
	 sessionStorage.setItem('advisoryId',advisoryId);
	 window.location.href = "answerConsultation.html";
     //alert("跳转成功");
     let hidden=document.getElementById('beforeLogin');
     hidden.style.display="none";
     let userName=getCookie('username');
     let appear=document.getElementsByClassName('afterLogin')[0];
     appear.innerHTML="欢迎"+userName+"登录istyle";
}


window.onload=function(){
    showInformation();
    /* let collectBtn=document.getElementById('collectBtn');
     collectBtn.addEventListener('click',collect,false);*/
//collectBtn.removeEventListener('click',collect,false); 这个false是阻止冒泡的意思
}