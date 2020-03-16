function showUserConsultation(){
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                if (info.errCode === 0) {
                    sessionStorage.setItem('stylistId',info.result.stylistId);
                    let showInform = "";
                    showInform += "<p><label class=\"myphoto\">咨询照片</label><img src=\"" + info.result.advisoryPhoto + "\"/></p><div class=\"clear\"></div>" +
                        "<p><span class=\"salonname\">我的基本信息:&nbsp;" + info.result.advisoryHeight +"cm&nbsp;&nbsp;"+ info.result.advisoryWeight+"kg</span></p><div class=\"clear\"></div>" +
                        "<p><span class=\"address\">我的穿衣风格描述:" + info.result.advisoryStyle + "</span></p><div class=\"clear\"></div>" +
                        "<p><span class=\"meal\">本次咨询问题描述：" + info.result.advisoryDescription+ "</span></p><div class=\"clear\"></div>";
                    document.getElementById('myConsul').innerHTML = showInform;
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    let advisoryId=sessionStorage.getItem('advisoryId');
    xhr.open('post','stylist/editAdvisory');
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"advisoryId":advisoryId};
    xhr.send(JSON.stringify(obj));
}
function answerConsul() {
	
	var form_data = new FormData(form_answer);
	console.log(form_data.get('file1')); 
	let advisoryId=sessionStorage.getItem('advisoryId');
	form_data.append("advisoryId", advisoryId);
	form_data.append("stoken", getCookie('stoken'));
	
	let xhr=new XMLHttpRequest();
	let url="stylist/replyAdvisory";
    xhr.open("post",url);
    xhr.send(form_data);
    
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("保存成功"+xhr.status);
                    /*showInformation();*/
                    alert("回复咨询成功");
                    window.history.back(-1);
                }else{
                    console.log("保存失败");
                }
                eval("var info="+xhr.responseText);
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    
	 
    /*let replyMessage=document.getElementById('question').value;
    let styHouseURL=document.getElementById('height').value;
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("保存成功"+xhr.status);
                    showInformation();
                }else{
                    console.log("保存失败");
                }
                eval("var info="+xhr.responseText);
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let stylistId=sessionStorage.getItem('stylistId');
    let url="/styHouse/"+styHouseId+"/updateMessage";
    xhr.open('post',"stylist/replyAdvisory");
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"stylistId":stylistId,"replyMessage":replyMessage,"styHouseURL":styHouseURL};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));*/
}
window.onload=function(){
    console.log("answerConsultation.html");
    showUserConsultation();
};