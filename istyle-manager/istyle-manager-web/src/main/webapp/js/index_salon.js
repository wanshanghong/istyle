//基本信息start
//基本信息编辑隐藏弹出start
function editor2() {
    let hidden=document.getElementById('showInformation');
    hidden.style.display="none";

    let obj=document.getElementById('form');
    obj.style.display="block";

    //渲染造型屋信息
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0) {
                    let showInform = "";
                    //alert("成功渲染");
                    showInform +=
                    	"<p>"+
                    "<input type=\"button\" id=\"changeheadPortrait\" onclick=\"changeHead.click()\" value=\"上传图片\">"+
                    "<input type=\"file\" id=\"changeHead\" style=\"display: none\" onchange=\"input1.value=this.value\" name=\"file3\">"+
                    "<input type=\"text\" id=\"input1\" style=\"margin-right:-100px;border-radius: 5px; border: 1px solid #5bc0de; width: 250px; height: 30px;\">"+
                    "</p>"+
                        "<p><label for=\"salonName\">造型屋名：</label><input type=\"text\" class=\"input\" id=\"salonName\" name=\"styHouseName\" value=\""+info.result.styHouseName+"\" /></p>"+
                        "<p><label for=\"address\">具体地址：</label><input type=\"text\" class=\"input\" id=\"address\" name=\"styHouseAddress\" value=\""+info.result.styHouseAddress+"\" /></p>"+
                        "<p><label for=\"meal\">套餐简介：</label><input type=\"text\" class=\"input\" id=\"meal\" name=\"styHousePackage\" value=\""+info.result.styHousePackage+"\" /></p>"+
                        "<p><label for=\"time\">营业时间：</label><input type=\"text\" class=\"input\" id=\"time\" name=\"styHouseWorkTime\" value=\""+info.result.styHouseWorkTime+"\" /></p>"+
                        "<p><label for=\"phone\">联系电话：</label><input type=\"text\" class=\"input\" id=\"phone\" name=\"styHousePhone\" value=\""+info.result.styHousePhone+"\" /></p>";
                    document.getElementById('updateContent1').innerHTML = showInform;
                }else{
                    alert("用户没有登录");
                }
                
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    let styHouseId=sessionStorage.getItem('styHouseId');
    let url="styHouse/"+styHouseId+"/editMessage";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj1={"styHouseId":styHouseId};
    xhr.send(JSON.stringify(obj1));
}
function success1(){
    let hidden=document.getElementById('form');
    hidden.style.display="none";
    showInformation();
    let obj=document.getElementById('showInformation');
    obj.style.display="block";
}
//基本信息编辑隐藏弹出end
//基本信息展示
function showInformation2(){
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0) {
                    sessionStorage.setItem('styHouseId',info.result.styHouseId);
                    let showInform = "";
                    console.log("成功展示");
                    showInform += "<p><img src='" + info.result.styHousePhoto + "'></p><div class=\"clear\"></div>" +
                        "<p><span class=\"salonname\">造型屋名：" + info.result.styHouseName + "</span></p><div class=\"clear\"></div>" +
                        "<p><span class=\"address\">具体地址：" + info.result.styHouseAddress + "</span></p><div class=\"clear\"></div>" +
                        "<p><span class=\"meal\">套餐简介：" + info.result.styHousePackage + "</span></p><div class=\"clear\"></div>" +
                        "<p><span class=\"time\">营业时间：" + info.result.styHouseWorkTime + "</span></p><div class=\"clear\"></div>"+
                        "<p><span class=\"phone\">联系电话：" + info.result.styHousePhone + "</span></p><div class=\"clear\"></div>";
                    document.getElementsByClassName('addContent1')[0].innerHTML = showInform;
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    xhr.open('post','styHouse/index');
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken')};
    xhr.send(JSON.stringify(obj));
    console.log("55555555");
}
//我的信息编辑
function information1(){
	var form_data = new FormData(form);
	console.log(form_data.get('file3')); 
	form_data.append("stoken", getCookie('stoken'));
	
	let xhr=new XMLHttpRequest();
	let styHouseId=sessionStorage.getItem('styHouseId');
	let url="styHouse/"+styHouseId+"/updateMessage";
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
                    //showInformation();
                    window.location.href = "index_salon.html";
                    //alert("跳转成功");
                }else{
                    console.log("保存失败");
                }
                eval("var info="+xhr.responseText);
                console.log("6")
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    /*let salonName=document.getElementById('salonName').value;
    let address=document.getElementById('address').value;
    let meal=document.getElementById('meal').value;
    let time=document.getElementById('time').value;
    let phone=document.getElementById('phone').value;
    let xhr=new XMLHttpRequest();
    console.log("4");
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
                eval("var info="+xhr.responseText);
                console.log("6")
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let styHouseId=sessionStorage.getItem('styHouseId');
    let url="styHouse/"+styHouseId+"/updateMessage";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"styHouseId":styHouseId,"styHouseName":salonName,"styHouseAddress":address,"styHousePackage":meal,"styHouseWorkTime":time,"styHousePhone":phone};
    xhr.send(JSON.stringify(obj));
    console.log("9");
    console.log(JSON.stringify(obj));*/
}
/*套餐发布*/
function mealPublish(){
	var form_data = new FormData(form5);
	console.log(form_data.get('file5')); 
	
	let styHouseId=sessionStorage.getItem('styHouseId');
	
	let xhr=new XMLHttpRequest();
	let url="styHouse/"+styHouseId+"/submitPackage";
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
                    //showInformation();
                    alert("套餐发布成功");
                    window.location.href = "index_salon.html";
                    //alert("跳转成功");
                }else{
                    console.log("保存失败");
                }
                eval("var info="+xhr.responseText);
                console.log("6")
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    /*let mealName=document.getElementById('mealName').value;
    let price=document.getElementById('price').value;
    let description=document.getElementById('description').value;
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("提交成功"+xhr.status);
                    showInformation();
                }else{
                    console.log("提交失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let styHouseId=sessionStorage.getItem('styHouseId');
    let url="styHouse/"+styHouseId+"/submitPackage";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"styHouseId":styHouseId,"packageName":mealName,"packagePrice":price,"packageDescription":description};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));*/
}
/*套餐管理*/
/*套餐管理中修改和展示功能的切换实现*/
function mealEditorShow(obj1) {
    let hidden=document.getElementById('showMeal');
    hidden.style.display="none";

    let obj=document.getElementById('updateMeal');
    obj.style.display="block";

    //渲染套餐修改信息
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0) {
                    let showInform = "";
                    //alert("成功渲染");
                    showInform += "<form enctype=\"multipart/form-data\" id=\"form6\">" +
                    "<div class=\"updateContent1\" style=\"margin-top: 0px;\"><p>"+
                    "<p>"+
                    "<input type=\"button\" id=\"changeheadPortrait1\" onclick=\"changeHead2.click()\" value=\"上传图片\">"+
                    "<input type=\"file\" id=\"changeHead2\" style=\"display: none\" onchange=\"input4.value=this.value\" name=\"file5\">"+
                    "<input type=\"text\" id=\"input4\" style=\"margin-right:-100px;border-radius: 5px; border: 1px solid #5bc0de; width: 250px; height: 30px;\">"+
                    "</p>"+
                        "<p><label for='changemealName'>套餐名字：</label><input type='text' class='input1' id='changemealName' name='packageName' value='"+info.result.packageName+"' /></p>"+
                        "<p><label for='changeprice'>套餐价格：</label><input type='text' class='input1' id='changeprice' name='packagePrice' value='"+info.result.packagePrice+"' /></p>"+
                        "<p><label for='changedescription'>套餐介绍：</label><input type='text' class='input1' id='changedescription' name='packageDescription' value='"+info.result.packageDescription+"' /></p>"+
                        "</div>"+
                        "<p><input type='button' onclick='updadeMeal(this);successShow();showmeal();' class='submit3' value='提交' id='"+info.result.packageId+"'/></p>"+
                    "</form>";
                    document.getElementById('updateMeal').innerHTML = showInform;
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    let styHouseId=sessionStorage.getItem('styHouseId');
    let url="styHouse/"+styHouseId+"/editPackage";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let packageId=obj1.getAttribute("id");
    let obj2={"styHouseId":styHouseId,"packageId":packageId};
    xhr.send(JSON.stringify(obj2));
}
function successShow(){
    let hidden=document.getElementById('updateMeal');
    hidden.style.display="none";
    //showInformation();
    let obj=document.getElementById('showMeal');
    obj.style.display="block";
}
/*套餐管理中展示套餐*/
function showmeal() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status >= 200 && xhr.status < 300 || xhr.status === 304) {
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0) {
                    let mealNum="";
                    //<span class="mealNum">套餐数(8)</span>
                    mealNum+="套餐数（"+info.result.packageCount+")";

                    let s = "";
                    for (let i = 0; i < info.result.packages.length; i++) {
                        s += "<div class='clear'></div>" +
                            "<div class=\"mealContent\">" +
                            "<img src='" + info.result.packages[i].packagePhoto + "'/>" +
                            "<p>" +
                            "<span>" + info.result.packages[i].packageName + "</span><br />" +
                            "<span style=\"width: 280px;overflow: hidden;white-space:nowrap;text-overflow: ellipsis;\">"+info.result.packages[i].packageDescription+"</span>"+
                            "<span style=\"color: orange;\">" + info.result.packages[i].packagePrice + "</span>" +
                            "</p>" +
                            "<button class='order' onclick='mealEditorShow(this)' id="+info.result.packages[i].packageId+">修改套餐</button>"+
                            "<button id='order' onclick='delMeal(this)' class='"+info.result.packages[i].packageId+"'>删除套餐</button>" +
                            "</div>";
                    }
                    document.getElementsByClassName('mealNum')[0].innerHTML=mealNum;
                    document.getElementById('showMeal').innerHTML = s;
                    console.log("document.getElementById('showMeal').innerHTML="+document.getElementById('showMeal').innerHTML);
                } else {
                    console.log("套餐管理展示失败");
                }
            } else {
                console.log("发生错误" + xhr.status);
            }
        }
    }
    let styHouseId = sessionStorage.getItem('styHouseId');
    let url = "styHouse/" + styHouseId + "/packageManager";
    xhr.open('post', url);
    xhr.setRequestHeader("Content-Type", "application/json");
    let obj = {
        "styHouseId": styHouseId
    };
    xhr.send(JSON.stringify(obj));
}
/*套餐管理中提交修改*/
function updadeMeal(obj){
	var form_data = new FormData(form6);
	console.log(form_data.get('file5')); 
	let packageId=obj.getAttribute("id");
	form_data.append("packageId", packageId);
	let styHouseId=sessionStorage.getItem('styHouseId');
	
	let xhr=new XMLHttpRequest();
	let url="styHouse/"+styHouseId+"/submitEditPackage";
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
                    //showInformation();
                    alert("修改成功");
                    window.location.href = "index_salon.html";
                    //alert("跳转成功");
                }else{
                    console.log("保存失败");
                }
                eval("var info="+xhr.responseText);
                console.log("6")
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
	
	
    /*let mealName=document.getElementById('mealName').value;
    let price=document.getElementById('price').value;
    let description=document.getElementById('description').value;
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("提交成功"+xhr.status);
                    showInformation();
                }else{
                    console.log("提交失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let styHouseId=sessionStorage.getItem('styHouseId');
    let url="styHouse/"+styHouseId+"/submitEditPackage";
    let packageId=obj.getAttribute("id");
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj1={"styHouseId":styHouseId,"packageId":packageId,"packageName":mealName,"packagePrice":price,"packageDescription":description};
    xhr.send(JSON.stringify(obj1));
    console.log(JSON.stringify(obj1));*/
}
/*套餐管理里删除套餐*/
    function delMeal(obj){
        let xhr=new XMLHttpRequest();
        xhr.onreadystatechange=function(){
            if (xhr.readyState===4){
                if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                    var info1 = JSON.parse(xhr.responseText);
                    console.log(info1);
                    if (!info1.errCode){
                        console.log("删除套餐成功"+xhr.status);
                        alert("删除套餐成功");
                        window.location.href = "index_salon.html";
                    }else{
                        console.log("删除套餐失败");
                    }
                }else{
                    console.log("发生错误"+xhr.status);
                }
            }
        }
        let styHouseId=sessionStorage.getItem('styHouseId');
        let url="styHouse/"+styHouseId+"/deletePackage";
        xhr.open('post',url);
        xhr.setRequestHeader("Content-Type","application/json");
        let packageId=obj.getAttribute("class");
        let data={"packageId":packageId,"styHouseId":styHouseId};
        xhr.send(JSON.stringify(data));
    }
/*造型师发布*/
function stylistPublish(){
	
	var form_data = new FormData(form7);
	console.log(form_data.get('file5')); 
	let styHouseId=sessionStorage.getItem('styHouseId');
	let xhr=new XMLHttpRequest();
    let url="styHouse/"+styHouseId+"/submitStylist";
    xhr.open('post',url);
    xhr.send(form_data);
    xhr.onreadystatechange=function(){
    	if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
            console.log("5");
            var info = JSON.parse(xhr.responseText);
            // var info = xhr.responseText;
            if (info.errCode === 0){
                console.log("提交成功"+xhr.status);
                //showInformation();
                alert("造型师发布成功");
                window.location.href = "index_salon.html";
                
            }else{
                console.log("提交失败");
            }
            eval("var info="+xhr.responseText);
            console.log("6")
        }else{
            console.log("发生错误"+xhr.status);
        }
    }
    /*let stylistName=document.getElementById('stylistName').value;
    let maxNumber=document.getElementById('ordertime').value;
    let stylistDescription=document.getElementById('changestyscription2').value;
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
                    showInformation();
                }else{
                    console.log("提交失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let styHouseId=sessionStorage.getItem('styHouseId');
    let url="styHouse/"+styHouseId+"/submitStylist";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"styHouseId":styHouseId,"stylistName":stylistName,"maxNumber":maxNumber,"stylistDescription":stylistDescription,"reservationTime":reservationTime};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));*/
}
/*造型师管理*/
/*造型师管理中修改和展示功能的切换实现*/
function stylistEditorShow(obj1) {
    let hidden=document.getElementById('showstylist');
    hidden.style.display="none";
    
    let obj=document.getElementById('updatestylist');
    obj.style.display="block";

    //渲染造型师修改信息
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0) {
                    let showInform = "";
                    showInform +="<div class=\"updateContent1\">"+
                    	"<form enctype=\"multipart/form-data\" id=\"form8\">"+
	                    "<p>"+
	                    "<input type=\"button\" style=\"width: 100px\" id=\"changeheadPortrait2\" onclick=\"changeHead2.click()\" value=\"上传图片\">"+
	                    "&nbsp;&nbsp;<input type=\"file\" id=\"changeHead2\" style=\"display: none\" onchange=\"input2.value=this.value\" name=\"file5\">"+
	                    "<input type=\"text\" id=\"input2\" style=\"margin-right:-100px;border-radius: 5px; border: 1px solid #5bc0de; width: 250px; height: 30px;\">"+
	                    "</p>"+
                    	"<p><label for=\"changestylistName\">造型师ID：&nbsp;&nbsp;"+info.result.stylistId+"</p>"+
                        "<p><label for=\"changestylistName\">造型师名字：</label><input type=\"text\" class=\"input1\" id=\"changestylistName\" name=\"stylistName\" value=\""+info.result.stylistName+"\" /></p>"+
                        "<p><label for=\"changeordertime\">最大可预约人数：</label><input type=\"text\" class=\"input1\" id=\"changeordertime\" name=\"maxNumber\" value=\""+info.result.maxNumber+"\" /></p>"+
                        "<p><label for=\"changestyscription\">造型师介绍：</label><input type=\"text\" class=\"input1\" id=\"changestyscription\" name=\"stylistIntroduction\" value=\""+info.result.stylistIntroduction+"\" /></p>"+
                        /*"<p><label for=\"test2\">日期选择：</label><input type=\"text\" class=\"demo-input\" placeholder=\"请选择日期\" id=\"test2\"></p>"+*/
                        "<p><label for=\"test11\">时间选择：</label><input type=\"text\" class=\"demo-input\" placeholder=\"请选择时间\" id=\"test11\" name=\"reservationTime\" /></p>"+
                        "</div>"+
                        "<p><input type='button' onclick='updadeStylist(this);successShowstylist();showstylist();' class='submit4' value='提交' id='"+info.result.stylistId+"'/></p>"+
                        "</form>"+"<script>$(\"#test8\").remove();laydate.render({"+
                        "elem: '#test9'"+
                        ",type: 'time'"+
                        ",range: true"+
                		"});	"+
                        "</script>";
                    document.getElementById('updatestylist').innerHTML = showInform;
                    
                    
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    let styHouseId=sessionStorage.getItem('styHouseId');
    let url="styHouse/"+styHouseId+"/editStylist";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let stylistId=obj1.getAttribute("id");
    let obj2={"styHouseId":styHouseId,"stylistId":stylistId};
    xhr.send(JSON.stringify(obj2));
}
function successShowstylist(){
    let hidden=document.getElementById('updatestylist');
    hidden.style.display="none";
    showInformation();
    let obj=document.getElementById('showstylist');
    obj.style.display="block";
}
/*造型师管理中展示造型师*/
function showstylist() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status >= 200 && xhr.status < 300 || xhr.status === 304) {
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0) {
                    let styNum="";
                    //<span class="styNum">造型师数(6)</span>
                    styNum+="造型师数（"+info.result.stylistCount+")";

                    let s = "";
                    for (let i = 0; i < info.result.stylistCount; i++) {
                        s += "<div class='clear'></div>" +
                            "<div class=\"mealContent\">" +
                            "<img src='" + info.result.stylists[i].stylistPhoto + "'/>" +
                            "<p>" +
                            "<span class=\"stylistName\">姓名：" + info.result.stylists[i].stylistName + "</span> <span class=\"orderNum\">最大可预约人数：" +info.result.stylists[i].maxNumber+"</span><br />"+
                            "<span class=\"orderTime\">可预约时间："+info.result.stylists[i].reservationTime+"</span>"+
                            "<span style=\"width: 270px;overflow: hidden;white-space:nowrap;text-overflow: ellipsis;\">" + info.result.stylists[i].stylistIntroduction + "</span>" +
                            "</p>" +
                            "<button class='order' onclick='stylistEditorShow(this)' id="+info.result.stylists[i].stylistId+">修改造型师</button>"+
                            "<button id='order' onclick='delStylist(this)' class='"+info.result.stylists[i].stylistId+"'>删除造型师</button>" +
                            "</div>";
                    }
                    document.getElementsByClassName('styNum')[0].innerHTML=styNum;
                    document.getElementById('showstylist').innerHTML = s;
                } else {
                    console.log("造型师管理展示失败");
                }
            } else {
                console.log("发生错误" + xhr.status);
            }
        }
    }
    let styHouseId = sessionStorage.getItem('styHouseId');
    let url = "styHouse/" + styHouseId + "/stylistManager";
    xhr.open('post', url);
    xhr.setRequestHeader("Content-Type", "application/json");
    let obj = {
        "styHouseId": styHouseId
    };
    xhr.send(JSON.stringify(obj));
}
/*造型师管理中提交修改*/
function updadeStylist(obj){
	
	var form_data = new FormData(form8);
	console.log(form_data.get('file5')); 
	let stylistId=obj.getAttribute("id");
	let styHouseId=sessionStorage.getItem('styHouseId');
	form_data.append("stylistId", stylistId);
    let url="styHouse/"+styHouseId+"/submitEditStylist";
    xhr.open('post',url);
    xhr.send(form_data);
    xhr.onreadystatechange=function(){
    	if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
            console.log("5");
            var info = JSON.parse(xhr.responseText);
            // var info = xhr.responseText;
            if (info.errCode === 0){
                console.log("提交成功"+xhr.status);
                //showInformation();
                alert("修改成功");
                window.location.href = "index_salon.html";
                //alert("跳转成功");
            }else{
                console.log("提交失败");
            }
            eval("var info="+xhr.responseText);
            console.log("6")
        }else{
            console.log("发生错误"+xhr.status);
        }
    }
	
    /*let stylistName=document.getElementById('changestylistName').value;
    let maxNumber=document.getElementById('changeordertime').value;
    let stylistDescription=document.getElementById('changestyscription').value;
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
                    showInformation();
                }else{
                    console.log("提交失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let styHouseId=sessionStorage.getItem('styHouseId');
    let url="styHouse/"+styHouseId+"/submitEditStylist";
    let stylistId=obj.getAttribute("id");
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj1={"styHouseId":styHouseId,"stylistId":stylistId,"stylistName":stylistName,"maxNumber":maxNumber,"reservationTime":reservationTime,"stylistDescription":stylistDescription};
    xhr.send(JSON.stringify(obj1));
    console.log(JSON.stringify(obj1));*/
}
/*造型师管理里删除造型师*/
    function delStylist(obj){
        let xhr=new XMLHttpRequest();
        xhr.onreadystatechange=function(){
            if (xhr.readyState===4){
                if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                    var info1 = JSON.parse(xhr.responseText);
                    console.log(info1);
                    if (!info1.errCode){
                        console.log("删除造型师成功"+xhr.status);
                        //subscribe();
                        alert("删除成功");
                        window.location.href = "index_salon.html";
                        
                    }else{
                        console.log("删除造型师失败");
                    }
                }else{
                    console.log("发生错误"+xhr.status);
                }
            }
        }
        let styHouseId=sessionStorage.getItem('styHouseId');
        let url="styHouse/"+styHouseId+"/deleteStylist";
        let stylistId=obj.getAttribute("class");
        xhr.open('post',url);
        xhr.setRequestHeader("Content-Type","application/json");
        let data={"styHouseId":styHouseId,"stylistId":stylistId};
        xhr.send(JSON.stringify(data));
    }
    
window.onload=function(){
    showInformation2();
    console.log("5555555555555555");
    /* let collectBtn=document.getElementById('collectBtn');
     collectBtn.addEventListener('click',collect,false);*/
//collectBtn.removeEventListener('click',collect,false); 这个false是阻止冒泡的意思
}