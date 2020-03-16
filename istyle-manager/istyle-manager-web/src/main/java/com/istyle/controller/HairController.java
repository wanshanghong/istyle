package com.istyle.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.istyle.pojo.TbHair;
import com.istyle.service.HairService;
import com.util.Response;

/**
 * @Author: 万上鸿
 * @description: 发型的接口
 * @Date:Created in 19:52 2019/9/30
 */
@Controller
public class HairController {

	@Autowired
	private HairService hairService;
	/**
     * 造型师未处理咨询
     * @param request 造型屋地址
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/SelectAllHair", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	public Response SelectAllHair(){
		List<TbHair> list=hairService.SelectAllHair();
        System.out.println("list:"+list);
        return Response.ok(list);
    }
    
    
    /**
     * 筛选发型
     * @param 
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/SelectHairByhairClass", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	public Response SelectHairByHairClass(@RequestBody Map<String, String> request){
    	int hairLenght1=Integer.parseInt(request.get("hairLenght1"));
    	int hairCurl1=Integer.parseInt(request.get("hairCurl1"));
    	int hairColor1=Integer.parseInt(request.get("hairColor1"));
    	int hairLenght2=Integer.parseInt(request.get("hairLenght2"));
    	int hairCurl2=Integer.parseInt(request.get("hairCurl2"));
    	int hairColor2=Integer.parseInt(request.get("hairColor2"));
    	int hairSex=Integer.parseInt(request.get("hairSex"));
    	System.out.println("hairLenght1="+hairLenght1+"  hairCurl1="+hairCurl1+"  hairColor1="+hairColor1+
    			"  hairLenght2="+hairLenght2+"  hairCurl2="+hairCurl2+"  hairColor2="+hairColor2+"  hairSex="+hairSex);
    	TbHair tbHair=new TbHair();
    	if(hairSex==1){
    		tbHair.setHairColor(hairColor1);
    		tbHair.setHairCurl(hairCurl1);
    		tbHair.setHairLenght(hairLenght1);
    	}else{
    		tbHair.setHairColor(hairColor2);
    		tbHair.setHairCurl(hairCurl2);
    		tbHair.setHairLenght(hairLenght2);
    	}
    	tbHair.setHairSex(hairSex);
    	System.out.println("tbHair="+tbHair.toString());
		List<TbHair> list=hairService.SelectHairByHairClass(tbHair);
        System.out.println("list:"+list);
        return Response.ok(list);
    }
}
