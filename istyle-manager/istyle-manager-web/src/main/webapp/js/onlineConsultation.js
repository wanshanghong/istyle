function consultation() {
	//var formobj =  document.getElementById("form1");
	var form_data = new FormData(form1);
	 console.log(form_data.get('file1')); 
	/*form_data.append("advisoryStyle", document.getElementById('style').value);
	form_data.append("advisoryDescription", document.getElementById('question').value);*/
	
	let stylistId=sessionStorage.getItem('stylistId');
	form_data.append("stylistId", stylistId);
	form_data.append("stoken", getCookie('stoken'));
	
	let xhr=new XMLHttpRequest();
	let url="userBrowse/stylist/"+stylistId+"/summitAdvisory";
    xhr.open("post",url);
    xhr.send(form_data);
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                var info = JSON.parse(xhr.responseText);
                // var info = xhr.responseText;
                if (info.errCode === 0){
                    console.log("咨询成功"+xhr.status);
                    //locationConsultation();
                    alert("咨询成功");
                    window.history.back(-1);
                }else{
                    console.log("咨询失败");
                }
            }else{
                console.log("发生错误"+xhr.status);
            }
        }
    }
    
    console.log(form_data);
    
   /* let photo=document.getElementById('changeHead').value;
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
    let url="userBrowse/stylist/"+stylistId+"/summitAdvisory";
    xhr.open('post',url);
    //xhr.setRequestHeader("Content-Type","multipart/form-data");
    let obj={"stoken":getCookie('stoken'),"stylistId":stylistId,"advisoryPhoto":photo,"advisoryHeight":height,"advisoryWeight":weight,"advisoryStyle":style,"advisoryDescription":question};
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));*/
}