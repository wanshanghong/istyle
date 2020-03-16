(function(){
    function tagName(tagName){
        return document.getElementsByTagName(tagName);
    }function addEvent(obj,type,func){
        if(obj.addEventListener){
            obj.addEventListener(type,func,false);
        }else if(obj.attachEvent){
            obj.attachEvent('on'+type,func);
        }
    }
    var v = {
        eleGroup:null,
        eleTop:null,
        eleHeight:null,
        screenHeight:null,
        limitHeight:null
    }
    function init(element){
        v.eleGroup = document.getElementsByTagName(element);
        v.screenHeight = document.documentElement.clientHeight;
        var len = v.eleGroup.length;
        for(var i = 0;i < len; i++){
            if(v.eleGroup[i].offsetTop<v.screenHeight&&v.eleGroup[i].getAttribute("asrc")){
                v.eleGroup[i].setAttribute("src",v.eleGroup[i].getAttribute("asrc"));
                v.eleGroup[i].removeAttribute("asrc");
            }
        }
    }
    function lazyload(){
        v.limitHeight = document.documentElement.scrollTop || document.body.scrollTop + document.documentElement.clientHeight;
        var len = v.eleGroup.length;
        for(var j = 0 ;j < len; j++){
            if(v.eleGroup[j].offsetTop <= v.limitHeight&&v.eleGroup[j].getAttribute("asrc")){
                v.eleGroup[j].setAttribute("src",v.eleGroup[j].getAttribute("asrc"));
                v.eleGroup[j].removeAttribute("asrc");
            }
        }
    }
    init("video");
    addEvent(window,"scroll",lazyload);
})()