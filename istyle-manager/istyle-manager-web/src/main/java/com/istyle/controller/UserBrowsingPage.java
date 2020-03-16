package com.istyle.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
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

import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUser;
import com.istyle.pojo.TbUserStylistAdvisory;
import com.istyle.service.StylistService;
import com.istyle.service.UserBrowseService;
import com.istyle.service.UserService;
import com.util.JWT;
import com.util.Response;

/**
 * @Author: 黄文伟
 * @description: 用户浏览页面
 * @Date:Created in 15:34 2019/1/16
 */
@Controller
@RequestMapping("/userBrowse")
public class UserBrowsingPage {
    @Autowired
    private UserService userService;
    @Autowired
    private StylistService stylistService;
    @Autowired
    private UserBrowseService userBrowseService;

    /**
     * 用户浏览造型屋界面
     * @param request 造型屋地址
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/styHouse", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userBrowseStyHousePage(@RequestBody Map<String, String> request) {
        String position = request.get("styHousePosition");
        System.out.println(position);
        Map temp = userBrowseService.browseStyHouse(position);
        return Response.ok(temp);
    }

    /**
     * 用户详细查看造型屋界面
     * @param styHouseId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/styHouse/{styHouseId}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response showStyHousePage(@PathVariable("styHouseId") Long styHouseId) {
        System.out.println("zaoxingwu");
        Map param = userBrowseService.showStyHouse(styHouseId);
        System.out.println("param="+param);
        return Response.ok(param);
    }

    /**
     * 造型师主页展示
     * @param stylistId 身份认证
     * @return Response，造型师数据
     */
    @ResponseBody
    @RequestMapping(value = "/stylist/{stylistId}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistHomePage(@PathVariable("stylistId") Long stylistId, @RequestBody Map<String, String> request) {
        TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
        Long userId = tbUser.getUserId();

        Map param = userBrowseService.selectStylistById(userId, stylistId);
        return Response.ok(param);
    }

    /**
     * 关注造型师
     * @param stylistId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stylist/{stylistId}/addAttention", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistAddAttention(@PathVariable("stylistId") Long stylistId, @RequestBody Map<String, String> request) {
        TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
        Long userId = tbUser.getUserId();

        userBrowseService.addAttention(userId, stylistId);
        return Response.ok();
    }

    /**
     * 用户打开造型师咨询界面
     * @param stylistId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stylist/{stylistId}/ShowAdvisory", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response showAdvisory(@PathVariable("stylistId") Long stylistId) {
        return Response.ok();
    }

    /**
     * 造型师咨询提交
     * @param stylistId
     * @param userStylistAdvisory
     * @return
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @ResponseBody
    @RequestMapping(value = "/stylist/{stylistId}/summitAdvisory")
    public Response summitAdvisory(@RequestParam(value="file1",required=false )MultipartFile file1
    		,TbUserStylistAdvisory tbUserStylistAdvisory,HttpServletRequest request ,TbStylist tbStylist,
    		@RequestParam(value="stoken",required=false )String stoken) throws IllegalStateException, IOException {
    	//上传图片
    	//获得物理路径webapp所在路径
    	String pathRoot = request.getSession().getServletContext().getRealPath("");
    	String path1="";
    	if(!file1.isEmpty()){
    		//生成uuid作为文件名称
    		String uuid = UUID.randomUUID().toString().replaceAll("","");
    		//获得文件类型（可以判断如果不是图片，禁止上传）			
    		String contentType=file1.getContentType();
    		//获得文件后缀名称
    		String imageName=contentType.substring(contentType.indexOf("/")+1);
    		path1="img/zixun/"+uuid+"."+imageName;
    		file1.transferTo(new File(pathRoot+path1));
    	}
    	tbUserStylistAdvisory.setAdvisoryPhoto(path1);
    	
    	TbUser tbUser = JWT.unsign(stoken, TbUser.class);
    	
    	tbUserStylistAdvisory.setTbUser(tbUser);
    	tbUserStylistAdvisory.setTbStylist(tbStylist);
    	tbUserStylistAdvisory.setIsReply(0);
    	tbUserStylistAdvisory.setPutTime(new Date());
    	System.out.println(tbUserStylistAdvisory.toString());
    	boolean i=userBrowseService.summitAdvisory(tbUserStylistAdvisory);
    	return Response.ok(1);
    }
    
    
    
    /**
     * 查找所有的用户咨询
     * @param s 
     * @param  findAdvisory
     * @return 
     */
    @ResponseBody
    @RequestMapping(value = "/findUserAdvisory")
    public Response findUserAdvisory(@RequestBody Map<String, String> request){
    	TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
        Long userId = tbUser.getUserId();
        System.out.println("userId:"+userId);
        List<TbUserStylistAdvisory> list=userBrowseService.findUserAdvisoryByUserId(userId);
        System.out.println("list:"+list);
    	return Response.ok(list);
    }
    /*@ResponseBody
    @RequestMapping(value = "/stylist/{stylistId}/summitAdvisory")
    public Response summitAdvisory(@PathVariable("stylistId") Long stylistId,@RequestParam(value="file1",required=false )MultipartFile file1
    		,TbUserStylistAdvisory tbUserStylistAdvisory HttpServletRequest request) {
    	//获取一个文件请求的MultipartHttpServletRequest对象
    	MultipartHttpServletRequest params=((MultipartHttpServletRequest) request);  
    	//通过MultipartHttpServletRequest对象获取文件
    	MultipartFile uploadFile = ((MultipartHttpServletRequest) request).getFile("file1");
    			
        System.out.println(4);
        System.out.println("tbUserStylistAdvisory="+tbUserStylistAdvisory.toString());
        System.out.println("stylistId="+stylistId);
    	 System.out.println("stylistId="+stylistId);
    	 System.out.println("advisoryHeight="+params.getParameter("advisoryHeight"));
    	 System.out.println("advisoryWeight="+params.getParameter("advisoryWeight"));
    	System.out.println("tbUserStylistAdvisory="+tbUserStylistAdvisory.toString());
        System.out.println("stylistId="+stylistId);
        if(file1!=null){
        	System.out.println("file 不是空");
        }else{
        	System.out.println("file wei空");
        }
        
        TbUser user = JWT.unsign(userStylistAdvisory.getStoken(), TbUser.class);
        //userBrowseService.summitAdvisory(userStylistAdvisory);
//        userStylistAdvisory.setUserId(1);

        return Response.ok();
    }*/
    /**
     * 造型师粉丝的展示界面
     * @param stylistId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stylist/{stylistId}/showStylistFan", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistFanShow(@PathVariable("stylistId") Long stylistId) {
        Map param = userBrowseService.showStylistFans(stylistId);
        return Response.ok(param);
    }
    
    
    /**
     * 用户查询已回复咨询
     * @param userId
     */
    @ResponseBody
    @RequestMapping(value = "/findUserAdvisoryByUserIdIsReturn")
    public Response findUserAdvisoryByUserIdIsReturn(@RequestBody Map<String, String> request){
    	TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
        Long userId = tbUser.getUserId();
        List<TbUserStylistAdvisory> list=userBrowseService.findUserAdvisoryByUserIdIsReturn(userId);
        System.out.println("list:"+list);
        return Response.ok(list);
    }
    
	/**
	 * 用户查询未回复咨询
	 * @param userId
	 */
    @ResponseBody
    @RequestMapping(value = "/findUserAdvisoryByUserIdNoReturn")
    public Response findUserAdvisoryByUserIdNoReturn(@RequestBody Map<String, String> request){
    	TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
        Long userId = tbUser.getUserId();
        List<TbUserStylistAdvisory> list=userBrowseService.findUserAdvisoryByUserIdNoReturn(userId);
        System.out.println("list:"+list);
        return Response.ok(list);
    }
    
	/**
     * 造型师查询所有咨询
     * @param stylistId
     */
    @ResponseBody
    @RequestMapping(value = "/findUserAdvisoryByStylistId")
    public Response findUserAdvisoryByStylistId(@RequestBody Map<String, String> request){
    	TbStylist tbStylist = JWT.unsign(request.get("stoken"), TbStylist.class);
        Long stylistId = tbStylist.getStylistId();
        List<TbUserStylistAdvisory> list=userBrowseService.findUserAdvisoryByStylistId(stylistId);
        System.out.println("list:"+list);
        return Response.ok(list);
    }
	/**
     * 造型师查询已回复咨询
     * @param userId
     */
    @ResponseBody
    @RequestMapping(value = "/findUserAdvisoryByStylistIdIsReturn")
    public Response findUserAdvisoryByStylistIdIsReturn(@RequestBody Map<String, String> request){
    	TbStylist tbStylist = JWT.unsign(request.get("stoken"), TbStylist.class);
        Long stylistId = tbStylist.getStylistId();
        List<TbUserStylistAdvisory> list=userBrowseService.findUserAdvisoryByStylistIdIsReturn(stylistId);
        System.out.println("list:"+list);
        return Response.ok(list);
    }
    /**
     * 造型师查询未回复咨询
     * @param userId
     */
    @ResponseBody
    @RequestMapping(value = "/findUserAdvisoryByStylistIdNoReturn")
    public Response findUserAdvisoryByStylistIdNoReturn(@RequestBody Map<String, String> request){
    	TbStylist tbStylist = JWT.unsign(request.get("stoken"), TbStylist.class);
        Long stylistId = tbStylist.getStylistId();
        List<TbUserStylistAdvisory> list=userBrowseService.findUserAdvisoryByStylistIdNoReturn(stylistId);
        System.out.println("list:"+list);
        return Response.ok(list);
    }
		
	/**
     * 用户查询指定的造型师回复咨询 或 造型师查询指定的用户回复咨询
     * @param userId stylistId
     */
    @ResponseBody
    @RequestMapping(value = "/findUserAdvisoryByUserIdAndStylistId")
    public Response findUserAdvisoryByUserIdAndStylistId(@RequestBody Map<String, String> request){
    	long userId,stylistId;
    	TbStylist tbStylist = JWT.unsign(request.get("stoken"), TbStylist.class);
    	if(tbStylist!=null){
    		stylistId = tbStylist.getStylistId();
    		userId=Long.parseLong(request.get("userId"));
    	}else{
    		TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
    		userId = tbUser.getUserId();
    		stylistId=Long.parseLong(request.get("stylistId"));
    	}
        List<TbUserStylistAdvisory> list=userBrowseService.findUserAdvisoryByUserIdAndStylistId(userId,stylistId);
        System.out.println("list:"+list);
        return Response.ok(list);
    }
	
	 
	/**
     * 用户查询指定的造型师未回复咨询 或 造型师查询指定的用户未回复咨询
     * @param userId stylistId
     */
    @ResponseBody
    @RequestMapping(value = "/findUserAdvisoryUserIdAndStylistIdIsReturn")
    public Response findUserAdvisoryUserIdAndStylistIdIsReturn(@RequestBody Map<String, String> request){
    	long userId,stylistId;
    	TbStylist tbStylist = JWT.unsign(request.get("stoken"), TbStylist.class);
    	if(tbStylist!=null){
    		stylistId = tbStylist.getStylistId();
    		userId=Long.parseLong(request.get("userId"));
    	}else{
    		TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
    		userId = tbUser.getUserId();
    		stylistId=Long.parseLong(request.get("stylistId"));
    	}
        List<TbUserStylistAdvisory> list=userBrowseService.findUserAdvisoryUserIdAndStylistIdIsReturn(userId,stylistId);
        System.out.println("list:"+list);
        return Response.ok(list);
    }
	
    
	/**
     * 用户查询指定的造型师已回复咨询 或 造型师查询指定的用户已回复咨询
     * @param userId stylistId
     */
    @ResponseBody
    @RequestMapping(value = "/findUserAdvisoryByUserIdAndStylistIdNoReturn")
    public Response findUserAdvisoryByUserIdAndStylistIdNoReturn(@RequestBody Map<String, String> request){
    	long userId,stylistId;
    	TbStylist tbStylist = JWT.unsign(request.get("stoken"), TbStylist.class);
    	if(tbStylist!=null){
    		stylistId = tbStylist.getStylistId();
    		userId=Long.parseLong(request.get("userId"));
    	}else{
    		TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
    		userId = tbUser.getUserId();
    		stylistId=Long.parseLong(request.get("stylistId"));
    	}
        List<TbUserStylistAdvisory> list=userBrowseService.findUserAdvisoryByUserIdAndStylistIdNoReturn(userId,stylistId);
        System.out.println("list:"+list);
        return Response.ok(list);
    }
    
    /**
     * 通过ID查询咨询
     * @param id
     */
    @ResponseBody
    @RequestMapping(value = "/{advisoryId}/findUserAdvisoryById")
    public Response findUserAdvisoryById(@RequestBody Map<String, String> request,@PathVariable("advisoryId") Long advisoryId){
    	System.out.println("advisoryId:"+advisoryId);
    	TbUserStylistAdvisory  tbUserStylistAdvisory =userBrowseService.findUserAdvisoryById(advisoryId);
    	System.out.println("TbUserStylistAdvisory :"+tbUserStylistAdvisory.toString() );
        return Response.ok(tbUserStylistAdvisory);
    }
}