


//跳转用户主页
function locationInformation(){
    let xhr=new XMLHttpRequest();

    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){

                let info = JSON.parse(xhr.responseText);

                if (info.errCode === 0) {
                    window.location.href = "/html/userIndex.html";
                    alert("跳转成功");
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status);
            }
        }
    }
    xhr.open('post','/userHome/index');
    xhr.setRequestHeader("Content-Type","application/json");
    let data=getCookie('stoken');
    console.log(data);
    let obj={"stoken":data};
    xhr.send(JSON.stringify(obj));
}
//跳转造型屋
function locationSalon(){
    /* 地址三级联动的取值*/
 /*   let pro = document.getElementById('cmbProvince'); //定位id
    let index1 = pro.selectedIndex; // 选中索引
    let value1 = pro.options[index1].value; // 选中值

    let city = document.getElementById('cmbCity'); //定位id
    let index2 = city.selectedIndex; // 选中索引
    let value2 = city.options[index2].value; // 选中值

    let area = document.getElementById('cmbArea'); //定位id
    let index3 = area.selectedIndex; // 选中索引
    let value3 = area.options[index3].value; // 选中值

    let styHousePosition=value1+value2+value3;*/

    let xhr=new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        if (xhr.readyState===4){
            if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                let info = JSON.parse(xhr.responseText);
                if (info.errCode === 0) {
                    window.location.href = "/html/salonIndex.html";
                    alert("跳转成功");
                }else{
                    alert("用户没有登录");
                }
            }else {
                alert("发生错误"+xhr.status+xhr.responseText);
            }
        }
    }
    xhr.open('post','/userBrowse/styHouse');
    xhr.setRequestHeader("Content-Type","application/json");
    let obj={"stoken":getCookie('stoken'),"styHousePosition":"上海市辖区黄浦区"};
    console.log("先");
    xhr.send(JSON.stringify(obj));
    console.log(JSON.stringify(obj));
    console.log("后");
}
console.log("what");