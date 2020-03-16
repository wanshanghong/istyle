$(document).ready(function() {
    /*tab切换*/
    $('.left .-bottom .select').first().show();
    $('.left .-bottom .select').not($('.left .-bottom .select').first()).hide();
    $('.left .-top ul li').click(function(){
        $(this).addClass('active');
        $('.left .-top ul li').not($(this)).removeClass('active');
        idx = $(this).index('.left .-top ul li');
        if(!idx){
            $('.left .-bottom .select').eq(idx).show();
            $('.left .-bottom .select').not($('.left .-bottom .select').eq(idx)).hide();
        }else{
            $('.left .-bottom .select').eq(idx).show();
            $('.left .-bottom .select').not($('.left .-bottom .select').eq(idx)).hide();
        }
    });
    $("#select1 dd").click(function() {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $("#selectA").remove();
        } else {
            var copyThisA = $(this).clone();
            if ($("#selectA").length > 0) {
                $("#selectA a").html($(this).text());
            } else {
                $(".select-result dl").append(copyThisA.attr("id", "selectA"));
            }
        }
    });
    $("#select2 dd").click(function() {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $("#selectB").remove();
        } else {
            var copyThisB = $(this).clone();
            if ($("#selectB").length > 0) {
                $("#selectB a").html($(this).text());
            } else {
                $(".select-result dl").append(copyThisB.attr("id", "selectB"));
            }
        }
    });
    $("#select3 dd").click(function() {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $("#selectC").remove();
        } else {
            var copyThisB = $(this).clone();
            if ($("#selectC").length > 0) {
                $("#selectC a").html($(this).text());
            } else {
                $(".select-result dl").append(copyThisB.attr("id", "selectC"));
            }
        }
    });
    $("#select4 dd").click(function() {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $("#selectD").remove();
        } else {
            var copyThisB = $(this).clone();
            if ($("#selectD").length > 0) {
                $("#selectD a").html($(this).text());
            } else {
                $(".select-result dl").append(copyThisB.attr("id", "selectD"));
            }
        }
    });
    $("#select5 dd").click(function() {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $("#selectE").remove();
        } else {
            var copyThisB = $(this).clone();
            if ($("#selectE").length > 0) {
                $("#selectE a").html($(this).text());
            } else {
                $(".select-result dl").append(copyThisB.attr("id", "selectE"));
            }
        }
    });
    $("#select6 dd").click(function() {
        $(this).addClass("selected").siblings().removeClass("selected");
        if ($(this).hasClass("select-all")) {
            $("#selectF").remove();
        } else {
            var copyThisB = $(this).clone();
            if ($("#selectF").length > 0) {
                $("#selectF a").html($(this).text());
            } else {
                $(".select-result dl").append(copyThisB.attr("id", "selectF"));
            }
        }
    });
    $("#selectA").on("click",
        function() {
            $(this).remove();
            $("#select1 .select-all").addClass("selected").siblings().removeClass("selected");
            console.log("on");
        });
    $("#selectB").on("click",
        function() {
            $(this).remove();
            $("#select2 .select-all").addClass("selected").siblings().removeClass("selected");
        });
    $("#selectC").on("click",
        function() {
            $(this).remove();
            $("#select3 .select-all").addClass("selected").siblings().removeClass("selected");
        });
    $("#selectD").on("click",
        function() {
            $(this).remove();
            $("#select4 .select-all").addClass("selected").siblings().removeClass("selected");
        });
    $("#selectE").on("click",
        function() {
            $(this).remove();
            $("#select5 .select-all").addClass("selected").siblings().removeClass("selected");
        });
    $("#selectF").on("click",
        function() {
            $(this).remove();
            $("#select6 .select-all").addClass("selected").siblings().removeClass("selected");
        });
    $(".select dd").on("click",
        function locationDesign3(obj1) {
            let hairSex=sessionStorage.getItem('hairSex');
            console.log(hairSex)
            let height1=document.getElementsByClassName('height1');
            let hairLenght1=null;
            for(let i=0;i<height1.length;i++){
                if(height1[i].className.indexOf('selected')>-1){
                    hairLenght1=i;
                    break;
                }
            }
            let curl1=document.getElementsByClassName('curl1');
            let hairCurl1=null;
            for(let i=0;i<curl1.length;i++){
                if(curl1[i].className.indexOf('selected')>-1){
                    hairCurl1=i;
                    break;
                }
            }
            let color1=document.getElementsByClassName('color1');
            let hairColor1=null;
            for(let i=0;i<color1.length;i++){
                if(color1[i].className.indexOf('selected')>-1){
                    hairColor1=i;
                    break;
                }
            }
            let height2=document.getElementsByClassName('height2');
            let hairLenght2=null;
            for(let i=0;i<height2.length;i++){
                if(height2[i].className.indexOf('selected')>-1){
                    hairLenght2=i;
                    break;
                }
            }
            let curl2=document.getElementsByClassName('curl2');
            let hairCurl2=null;
            for(let i=0;i<curl2.length;i++){
                if(curl2[i].className.indexOf('selected')>-1){
                    hairCurl2=i;
                    break;
                }
            }
            let color2=document.getElementsByClassName('color2');
            let hairColor2=null;
            for(let i=0;i<color2.length;i++){
                if(color2[i].className.indexOf('selected')>-1){
                    hairColor2=i;
                    break;
                }
            }
            let xhr=new XMLHttpRequest();
            xhr.onreadystatechange=function(){
                if (xhr.readyState===4){
                    if (xhr.status>=200 && xhr.status<300 || xhr.status===304){
                        var info = JSON.parse(xhr.responseText);
                        if (info.errCode === 0) {
                        	let list=info.result;
                        	let s = "";
                        	if(list==""){
                        		console.log("list:" +list);
                        	}else{
                        		console.log("list:" +list);
                                for (let i = 0; i < list.length; i++) {
                                    s += "<div class='content'>" +
                                        "<img src='" + list[i].hairPhoto + "' alt=''>" +
                                        "<span>适宜肤色:" + list[i].suitSkin + "</span>" +
                                        "<span>适宜脸型:" + list[i].suitFace + "</span>" +
                                        "</div>";
                                }
                        	}
                        	
                            document.getElementsByClassName('right')[0].innerHTML = s;
                        }else{
                            alert("用户没有登录");
                        }
                    }else{
                        console.log("发生错误"+xhr.status);
                    }
                }
            }
            xhr.open('post','SelectHairByhairClass');
            xhr.setRequestHeader("Content-Type","application/json");
            let obj={"hairSex":hairSex,"hairLenght1":hairLenght1,"hairCurl1":hairCurl1,"hairColor1":hairColor1,"hairLenght2":hairLenght2,"hairCurl2":hairCurl2,"hairColor2":hairColor2};
            xhr.send(JSON.stringify(obj));
            /*$(".select-no").hide();*/
            /*                console.log( $("#selectA a").text());
                            console.log( $("#selectB a").text());*/
/*            var a=$("#selectA a").text();
            var b=$("#selectB a").text();
            var c=$("#selectC a").text();
            var d=$("#selectD a").text();
            var e=$("#selectE a").text();
            var f=$("#selectF a").text();
            console.log("12");
            console.log(a+b+c+d+e+f);*/
            /*if ($(".select-result dd").length > 1) {
                $(".select-no").hide();
            } else {
                $(".select-no").show();
            }*/
/*            $.ajax({
                type: 'post',
                data: 1,
                url: 'https://easy-mock.com/mock/5cbdf17117aa3e7f8b8f2e0a/example/upload',
                contentType: 'application/json',
                success: function(data) {
                    console.log("成功");
                },
                error: function(e) {
                    console.error(e);
                }
            });*/
        });


});
