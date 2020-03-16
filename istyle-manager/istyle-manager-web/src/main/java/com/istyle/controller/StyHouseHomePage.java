package com.istyle.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.istyle.pojo.TbStyHouse;
import com.istyle.pojo.TbStyHousePackage;
import com.istyle.pojo.TbStyHouseStylist;
import com.istyle.pojo.TbStylist;
import com.istyle.service.StyHouseService;
import com.util.JWT;
import com.util.Response;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 21:49 2019/3/26
 */
@Controller
@RequestMapping("/styHouse")
public class StyHouseHomePage {
    @Autowired
    private StyHouseService styHouseService;

    /**
     * 造型屋信息主页
     * @param request
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response styHouseIndex(@RequestBody Map<String, String> request) {
        TbStyHouse styHouse = JWT.unsign(request.get("stoken"), TbStyHouse.class);
        TbStyHouse param = styHouseService.showStyHouseIndex(styHouse);
        return Response.ok(param);
    }

    /**
     * 造型屋主页信息编辑页面
     * @param styHouseId
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/editMessage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response editMessage(@PathVariable(value = "styHouseId") Long styHouseId) {
        TbStyHouse param = styHouseService.showEditMessage(styHouseId);
        return Response.ok(param);
    }

    /**
     * 造型屋主页信息修改
     * @param styHouseId
     * @param styHouse
     * @return
     *//*
    @RequestMapping(value = "/{styHouseId}/updateMessage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response editMessage(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHouse styHouse, @CookieValue(value = "stoken") String stoken) {
        styHouseService.updateEditMessage(styHouse);
        return Response.ok();
    }*/
    
    /**
     * 造型屋主页信息修改
     * @param styHouseId
     * @param styHouse
     * @return
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping(value = "/{styHouseId}/updateMessage")
    @ResponseBody
    public Response editMessage(@PathVariable(value = "styHouseId") Long styHouseId, @RequestParam(value="file3",required=false )MultipartFile file3,
    		TbStyHouse styHouse,@RequestParam(value="stoken",required=false )String stoken,HttpServletRequest request) throws IllegalStateException, IOException {
        styHouse.setStyHouseId(styHouseId);
        System.out.println("styHouseId="+styHouseId);
        //上传图片
    	//获得物理路径webapp所在路径
    	String pathRoot = request.getSession().getServletContext().getRealPath("");
    	String path1="";
    	if(!file3.isEmpty()){
    		//生成uuid作为文件名称
    		String uuid = UUID.randomUUID().toString().replaceAll("","");
    		//获得文件类型（可以判断如果不是图片，禁止上传）			
    		String contentType=file3.getContentType();
    		//获得文件后缀名称
    		String imageName=contentType.substring(contentType.indexOf("/")+1);
    		path1="img/styhouse/"+uuid+"."+imageName;
    		file3.transferTo(new File(pathRoot+path1));
    	}
    	styHouse.setStyHousePhoto(path1);
    	System.out.println("styHouse="+styHouse.toString());
    	boolean upd=styHouseService.updateEditMessage(styHouse);
        return Response.ok(upd);
    }
    /**
     * 套餐管理展示
     * @param styHouseId
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/packageManager", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response packageManager(@PathVariable(value = "styHouseId") Long styHouseId) {
        Map param = styHouseService.showPackageManager(styHouseId);
        System.out.println("套餐管理展示param="+param);
        return Response.ok(param);
    }

 /*   *//**
     * 套餐发布
     * @param styHouseId
     * @param tbStyHousePackage
     * @return
     *//*
    @RequestMapping(value = "/{styHouseId}/submitPackage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response packageManager(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHousePackage tbStyHousePackage) {
        boolean flag = styHouseService.submitPackage(tbStyHousePackage);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("套餐发布失败，请重新发布");
        }
    }
*/
  /**
    * 套餐发布
    * @param styHouseId
    * @param tbStyHousePackage
    * @return
 * @throws IOException 
 * @throws IllegalStateException 
    */
   @RequestMapping(value = "/{styHouseId}/submitPackage")
   @ResponseBody
   public Response packageManager(@PathVariable(value = "styHouseId") Long styHouseId, @RequestParam(value="file5",required=false )MultipartFile file5,
		   TbStyHousePackage tbStyHousePackage,HttpServletRequest request) throws IllegalStateException, IOException {
	   tbStyHousePackage.setStyHouseId(styHouseId);
	   //上传图片
	   	//获得物理路径webapp所在路径
	   	String pathRoot = request.getSession().getServletContext().getRealPath("");
	   	String path1="";
	   	if(!file5.isEmpty()){
	   		//生成uuid作为文件名称
	   		String uuid = UUID.randomUUID().toString().replaceAll("","");
	   		//获得文件类型（可以判断如果不是图片，禁止上传）			
	   		String contentType=file5.getContentType();
	   		//获得文件后缀名称
	   		String imageName=contentType.substring(contentType.indexOf("/")+1);
	   		path1="img/styhousePackage/"+uuid+"."+imageName;
	   		file5.transferTo(new File(pathRoot+path1));
	   	}
	   tbStyHousePackage.setPackagePhoto(path1);
	   System.out.println("tbStyHousePackage="+tbStyHousePackage.toString());
       boolean flag = styHouseService.submitPackage(tbStyHousePackage);
       if (flag == true) {
           return Response.ok();
       } else {
           return Response.errAuth("套餐发布失败，请重新发布");
       }
   }
    
  
   
    /**
     * 套餐管理编辑展示
     * @param styHouseId
     * @param tbStyHousePackage
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/editPackage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response editPackage(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHousePackage tbStyHousePackage) {
    	tbStyHousePackage.setStyHouseId(styHouseId);
    	System.out.println("tbStyHousePackage="+tbStyHousePackage.toString());
        TbStyHousePackage param = styHouseService.showeditPackage(tbStyHousePackage);
        System.out.println("param="+param.toString());
        return Response.ok(param);
    }

    /**
     * 套餐管理信息修改
     * @param styHouseId
     * @param tbStyHousePackage
     * @return
     *//*
    @RequestMapping(value = "/{styHouseId}/submitEditPackage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response submitEditPackage(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHousePackage tbStyHousePackage) {
        boolean flag = styHouseService.submitEditPackage(tbStyHousePackage);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("套餐修改失败");
        }
    }*/

    
    /**
     * 套餐管理信息修改
     * @param styHouseId
     * @param tbStyHousePackage
     * @return
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping(value = "/{styHouseId}/submitEditPackage")
    @ResponseBody
    public Response submitEditPackage(@PathVariable(value = "styHouseId") Long styHouseId,  @RequestParam(value="file5",required=false )MultipartFile file5,
 		   TbStyHousePackage tbStyHousePackage,HttpServletRequest request) throws IllegalStateException, IOException {
    	tbStyHousePackage.setStyHouseId(styHouseId);
 	   //上传图片
 	   	//获得物理路径webapp所在路径
 	   	String pathRoot = request.getSession().getServletContext().getRealPath("");
 	   	String path1="";
 	   	if(!file5.isEmpty()){
 	   		//生成uuid作为文件名称
 	   		String uuid = UUID.randomUUID().toString().replaceAll("","");
 	   		//获得文件类型（可以判断如果不是图片，禁止上传）			
 	   		String contentType=file5.getContentType();
 	   		//获得文件后缀名称
 	   		String imageName=contentType.substring(contentType.indexOf("/")+1);
 	   		path1="img/styhousePackage/"+uuid+"."+imageName;
 	   		file5.transferTo(new File(pathRoot+path1));
 	   	}
 	   tbStyHousePackage.setPackagePhoto(path1);
 	   System.out.println("tbStyHousePackage="+tbStyHousePackage.toString());
    	boolean flag = styHouseService.submitEditPackage(tbStyHousePackage);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("套餐修改失败");
        }
    }
    
    
    /**
     * 套餐删除
     * @param styHouseId
     * @param tbStyHousePackage
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/deletePackage", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response deletePackage(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHousePackage tbStyHousePackage) {
        boolean flag = styHouseService.deletePackage(tbStyHousePackage);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("套餐删除失败");
        }
    }

    /**
     * 造型师管理展示
     * @param styHouseId
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/stylistManager", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response stylistManager(@PathVariable(value = "styHouseId") Long styHouseId) {
        Map param = styHouseService.selectStylistManager(styHouseId);
        return Response.ok(param);
    }

    /**
     * 造型师编辑界面展示
     * @param styHouseId
     * @param tbStyHouseStylist
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/editStylist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response editStylist(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHouseStylist tbStyHouseStylist) {
        TbStyHouseStylist param = styHouseService.selectStylist(tbStyHouseStylist);
        return Response.ok(param);
    }

    /**
     * 造型师信息修改
     * @param styHouseId
     * @param tbStyHouseStylist
     * @return
     *//*
    @RequestMapping(value = "/{styHouseId}/submitEditStylist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response submitEditStylist(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHouseStylist tbStyHouseStylist) {
        boolean flag = styHouseService.submitEditStylist(tbStyHouseStylist);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("造型师信息修改失败");
        }
    }*/
    
    
    /**
     * 造型师信息修改
     * @param styHouseId
     * @param tbStyHouseStylist
     * @return
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping(value = "/{styHouseId}/submitEditStylist")
    @ResponseBody
    public Response submitEditStylist(@PathVariable(value = "styHouseId") Long styHouseId, TbStyHouseStylist tbStyHouseStylist,
    		@RequestParam(value="file5",required=false )MultipartFile file5,HttpServletRequest request) throws IllegalStateException, IOException {
    	//上传图片
 	   	//获得物理路径webapp所在路径
 	   	String pathRoot = request.getSession().getServletContext().getRealPath("");
 	   	String path1="";
 	   	if(!file5.isEmpty()){
 	   		//生成uuid作为文件名称
 	   		String uuid = UUID.randomUUID().toString().replaceAll("","");
 	   		//获得文件类型（可以判断如果不是图片，禁止上传）			
 	   		String contentType=file5.getContentType();
 	   		//获得文件后缀名称
 	   		String imageName=contentType.substring(contentType.indexOf("/")+1);
 	   		path1="img/styhouseStylist/"+uuid+"."+imageName;
 	   		file5.transferTo(new File(pathRoot+path1));
 	   	}
 	   tbStyHouseStylist.setStylistPhoto(path1);
 	   tbStyHouseStylist.setStyHouseId(styHouseId);
 	   System.out.println("tbStyHouseStylist="+tbStyHouseStylist.toString());
       boolean flag = styHouseService.submitEditStylist(tbStyHouseStylist);
       if (flag == true) {
           return Response.ok();
       } else {
            return Response.errAuth("造型师信息修改失败");
        }
    }

    /*//TODO 需用户填写造型师id进行造型师绑定
    *//**
     * 造型师发布
     * @param styHouseId
     * @param tbStyHouseStylist
     * @return
     *//*
    @RequestMapping(value = "/{styHouseId}/submitStylist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response submitStylist(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHouseStylist tbStyHouseStylist) {
        boolean flag = styHouseService.submitStylist(tbStyHouseStylist);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("造型师发布失败");
        }
    }
*/
    
  //TODO 需用户填写造型师id进行造型师绑定
    /**
     * 造型师发布
     * @param styHouseId
     * @param tbStyHouseStylist
     * @return
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @RequestMapping(value = "/{styHouseId}/submitStylist")
    @ResponseBody
    public Response submitStylist(@PathVariable(value = "styHouseId") Long styHouseId,  TbStyHouseStylist tbStyHouseStylist,
    		@RequestParam(value="file5",required=false )MultipartFile file5,HttpServletRequest request) throws IllegalStateException, IOException {
    	//上传图片
 	   	//获得物理路径webapp所在路径
 	   	String pathRoot = request.getSession().getServletContext().getRealPath("");
 	   	String path1="";
 	   	if(!file5.isEmpty()){
 	   		//生成uuid作为文件名称
 	   		String uuid = UUID.randomUUID().toString().replaceAll("","");
 	   		//获得文件类型（可以判断如果不是图片，禁止上传）			
 	   		String contentType=file5.getContentType();
 	   		//获得文件后缀名称
 	   		String imageName=contentType.substring(contentType.indexOf("/")+1);
 	   		path1="img/styhouseStylist/"+uuid+"."+imageName;
 	   		file5.transferTo(new File(pathRoot+path1));
 	   	}
 	   tbStyHouseStylist.setStylistPhoto(path1);
 	   tbStyHouseStylist.setStyHouseId(styHouseId);
 	   System.out.println("tbStyHouseStylist="+tbStyHouseStylist.toString());
        boolean flag = styHouseService.submitStylist(tbStyHouseStylist);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("造型师发布失败");
        }
    }

    /**
     * 造型师删除
     * @param styHouseId
     * @param tbStyHouseStylist
     * @return
     */
    @RequestMapping(value = "/{styHouseId}/deleteStylist", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response deleteStylist(@PathVariable(value = "styHouseId") Long styHouseId, @RequestBody TbStyHouseStylist tbStyHouseStylist) {
        boolean flag = styHouseService.deleteStylist(tbStyHouseStylist);
        if (flag == true) {
            return Response.ok();
        } else {
            return Response.errAuth("造型师删除失败");
        }
    }
}
