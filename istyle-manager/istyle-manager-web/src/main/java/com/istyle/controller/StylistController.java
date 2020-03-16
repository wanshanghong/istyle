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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.istyle.pojo.TbStyHouseStylist;
import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUserStylistAdvisory;
import com.istyle.service.StylistService;
import com.istyle.service.UserBrowseService;
import com.util.JWT;
import com.util.Response;

/**
 * @Author: 万上鸿
 * @description: 造型师的接口
 * @Date:Created in 19:52 2019/9/30
 */
@Controller
@RequestMapping("/stylist")
public class StylistController {
	@Autowired
	private StylistService stylistService;
	
	@Autowired
    private UserBrowseService userBrowseService;
    /**
     * 造型师主页信息
     * @param request 造型屋地址
     * @return Response
     
    @ResponseBody
    @RequestMapping(value = "/styHouse", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userBrowseStyHousePage(@RequestBody Map<String, String> request) {
    	long stylistId = JWT.unsign(request.get("stylistId"), Long.class);
        
        System.out.println("stylistId="+stylistId);
        TbStylist tbStylist=stylistService.selectTbStylistByStylistId(stylistId);
        
        return Response.ok(temp);
    }
	*/
	/**
     * 造型师未处理咨询
     * @param request 造型屋地址
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/advisorying", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userBrowseStyHousePage(@RequestBody Map<String, String> request) {
    	TbStylist tbStylist = JWT.unsign(request.get("stoken"), TbStylist.class);
    	System.out.println("tbStylist:"+tbStylist.toString());
        List<TbUserStylistAdvisory> list=userBrowseService.findUserAdvisoryByStylistIdNoReturn(tbStylist.getStylistId());
        System.out.println("list:"+list);
        return Response.ok(list);
    }
    /**
     * 造型师通过咨询
     * @param request 造型屋地址
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/editAdvisory", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response editAdvisory(@RequestBody Map<String, String> request) {
    	Long advisoryId=Long.parseLong(request.get("advisoryId"));
    	System.out.println("advisoryId:"+advisoryId);
        TbUserStylistAdvisory tbUserStylistAdvisory=userBrowseService.findUserAdvisoryById(advisoryId);
        System.out.println("tbUserStylistAdvisory:"+tbUserStylistAdvisory.toString());
        return Response.ok(tbUserStylistAdvisory);
    }
    
    
    /**
     * 造型师回复咨询
     * @param request 造型屋地址
     * @return Response
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @ResponseBody
    @RequestMapping(value = "/replyAdvisory")
    public Response replyAdvisory(@RequestParam(value="file1",required=false )MultipartFile file1,HttpServletRequest request,
    		@RequestParam(value="stoken",required=false )String stoken,TbUserStylistAdvisory tbUserStylistAdvisory) throws IllegalStateException, IOException {
    	
    	System.out.println("tbUserStylistAdvisory:"+tbUserStylistAdvisory.toString());
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
    		path1="img/reply/"+uuid+"."+imageName;
    		file1.transferTo(new File(pathRoot+path1));
    	}
    	tbUserStylistAdvisory.setReplyPhoto(path1);
    	tbUserStylistAdvisory.setReplyTime(new Date());
        boolean update=stylistService.updateAdvisoryByadvisoryId(tbUserStylistAdvisory);
        System.out.println("update:"+update);
        return Response.ok(tbUserStylistAdvisory);
    }
    
    
    /**
     * 造型师主页渲染
     */
    @ResponseBody
    @RequestMapping(value = "/index")
    public Response TbStylistIndex(@RequestBody Map<String, String> request) {
    	TbStylist tbStylist = JWT.unsign(request.get("stoken"), TbStylist.class);
    	System.out.println("StylistId:"+tbStylist.getStylistId());
    	System.out.println("tbStylist:"+tbStylist.toString());
    	
    	TbStyHouseStylist tbStyHouseStylist=stylistService.SelectTbStyHouseStylistBystylistId(tbStylist.getStylistId());
    	System.out.println("tbStyHouseStylist:"+tbStyHouseStylist.toString());
        return Response.ok(tbStyHouseStylist);
    }
    
    
    /**
     * 造型师信息编辑
     */
    @ResponseBody
    @RequestMapping(value = "/editMessage")
    public Response TbStylisteditMessage(@RequestBody Map<String, String> request) {
    	TbStylist tbStylist = JWT.unsign(request.get("stoken"), TbStylist.class);
    	System.out.println("StylistId:"+tbStylist.getStylistId());
    	System.out.println("tbStylist:"+tbStylist.toString());
    	
    	TbStyHouseStylist tbStyHouseStylist=stylistService.SelectTbStyHouseStylistBystylistId(tbStylist.getStylistId());
    	System.out.println("tbStyHouseStylist:"+tbStyHouseStylist.toString());
        return Response.ok(tbStyHouseStylist);
    }
    
    
    /**
     * 更新造型师
     * @param 
     * @return Response
     * @throws IOException 
     * @throws IllegalStateException 
     */
    @ResponseBody
    @RequestMapping(value = "/updateMessage")
    public Response updateStylistMessage(@RequestParam(value="file2",required=false )MultipartFile file2,HttpServletRequest request,
    		@RequestParam(value="stoken",required=false )String stoken,@RequestParam(value="styHouseId",required=false )Long styHouseId,
    		TbStylist tbStylist) throws IllegalStateException, IOException {
    	TbStyHouseStylist tbStyHouseStylist=new TbStyHouseStylist();
    	
    	tbStyHouseStylist.setStyHouseId(styHouseId);
    	//上传图片
    	//获得物理路径webapp所在路径
    	String pathRoot = request.getSession().getServletContext().getRealPath("");
    	String path1="";
    	if(!file2.isEmpty()){
    		//生成uuid作为文件名称
    		String uuid = UUID.randomUUID().toString().replaceAll("","");
    		//获得文件类型（可以判断如果不是图片，禁止上传）			
    		String contentType=file2.getContentType();
    		//获得文件后缀名称
    		String imageName=contentType.substring(contentType.indexOf("/")+1);
    		path1="img/reply/"+uuid+"."+imageName;
    		file2.transferTo(new File(pathRoot+path1));
    	}
    	tbStylist.setStylistPhoto(path1);
    	TbStylist tbStylist1 = JWT.unsign(stoken, TbStylist.class);
    	tbStylist.setStylistId(tbStylist1.getStylistId());
    	tbStyHouseStylist.setTbStylist(tbStylist);
    	tbStyHouseStylist.setStylistId(tbStyHouseStylist.getTbStylist().getStylistId());
    	System.out.println("tbStyHouseStylist:"+tbStyHouseStylist.toString());
        boolean update=stylistService.updateStylistMessage(tbStyHouseStylist);
        System.out.println("update:"+update);
        return Response.ok(update);
    }
}
