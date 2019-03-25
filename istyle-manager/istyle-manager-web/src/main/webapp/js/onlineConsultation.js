function consultation() {
    let photo=document.getElementById('changeHead').value;
    let height=document.getElementById('height').value;
    let weight=document.getElementById('weight').value;
    let style=document.getElementById('style').value;
    let question=document.getElementsByName('question');
    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("咨询成功"+xhr.status);
                    locationConsultation();
                }else{
                    console.log("咨询失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    let stylistId=sessionStorage.getItem('stylistId');
    let url="/userBrowse/stylist/"+stylistId+"/summitAdvisory";
    xhr.open('post',url);
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"stylistId":stylistId,"advisoryPhoto":photo,"advisoryHeight":height,"advisoryWeight":weight,"advisoryStyle":style,"advisoryDescription":question};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
}