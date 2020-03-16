package com.istyle.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.istyle.pojo.TbAppointmentPackage;
import com.istyle.pojo.TbAppointmentStylist;
import com.istyle.pojo.TbUser;
import com.istyle.service.TbAppointmentPackageService;
import com.istyle.service.TbAppointmentStylistService;
import com.util.JWT;
import com.util.Response;

/**
 * @Author: 万上鸿
 * @description: 套餐预约的接口
 * @Date:Created in 19:52 2019/9/30
 */
@Controller
public class TbAppointmentPackageController {
	@Autowired
	private TbAppointmentPackageService tbAppointmentPackageService;
	@Autowired
	private TbAppointmentStylistService tbAppointmentStylistService;
	
	/* 添加套餐预约
	* @param 
	* @return int*/
	@ResponseBody
    @RequestMapping(value = "/InsertTbAppointmentPackage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	 public Response InsertTbAppointmentPackage(@RequestBody Map<String, String> request ){
		TbAppointmentPackage tbAppointmentPackage=new TbAppointmentPackage();
		tbAppointmentPackage.setStyhouseId(Long.parseLong(request.get("styhouseId")));
		tbAppointmentPackage.setPackageId(Long.parseLong(request.get("packageId")));
		tbAppointmentPackage.setAppointmentTime(request.get("appointmentTime"));
		System.out.println("tbAppointmentPackage="+tbAppointmentPackage);
		TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
		tbAppointmentPackage.setUserId(tbUser.getUserId());
		System.out.println("tbAppointmentPackage="+tbAppointmentPackage);
		int i= tbAppointmentPackageService.InsertTbAppointmentPackage(tbAppointmentPackage);
		 return Response.ok(i); 
	 }
		
	/* 查看造型屋的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	@ResponseBody
    @RequestMapping(value = "/SelectTbAppointmentAllPackageBystyhouseId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	public Response SelectTbAppointmentAllPackageBystyhouseId(Long styhouseId){
		List<TbAppointmentPackage> list= tbAppointmentPackageService.SelectTbAppointmentAllPackageBystyhouseId(styhouseId);
		return Response.ok(list); 
	}
	
	
	/* 查看造型屋未处理的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	@ResponseBody
    @RequestMapping(value = "/SelectTbAppointmentPackageBystyhouseIdNoDeal", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	public Response SelectTbAppointmentPackageBystyhouseIdNoDeal(Long styhouseId){
		List<TbAppointmentPackage> list=  tbAppointmentPackageService.SelectTbAppointmentPackageBystyhouseIdNoDeal(styhouseId);
		return Response.ok(list);
	}
	
	
	/* 看造型屋已处理的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	@ResponseBody
    @RequestMapping(value = "/SelectTbAppointmentPackageBystyhouseIdIsDeal", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	public Response SelectTbAppointmentPackageBystyhouseIdIsDeal(Long yhouseId){
		List<TbAppointmentPackage> list= tbAppointmentPackageService.SelectTbAppointmentPackageBystyhouseIdIsDeal(yhouseId);
		return Response.ok(list);
	}
	
	/* 查看预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	@ResponseBody
    @RequestMapping(value = "/SelectTbAppointmentByUserId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	public Response SelectTbAppointmentByUserId(@RequestBody Map<String, String> request){
		TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
		Long UserId=tbUser.getUserId();
		
		System.out.println("UserId="+UserId);
		List<TbAppointmentPackage> list1= tbAppointmentPackageService.SelectTbAppointmentPackageByUserIdNoDeal(UserId);
		System.out.println("list1="+list1);
		
		List<TbAppointmentStylist> list2= tbAppointmentStylistService.SelectAllAppointmentStylistByuserIdnoDeal(UserId);
		System.out.println("list2="+list2);
		Map<String, List> map = new HashMap<String, List>();
		map.put("list1", list1);
		map.put("list2", list2);
		return Response.ok(map);
	}
	
	/* 取消套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	@ResponseBody
    @RequestMapping(value = "/quxiaoAppointmentPackageByappointmentId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	public Response quxiaoAppointmentPackageByappointmentId(@RequestBody Map<String, String> request){
		Long appointmentId=Long.parseLong(request.get("appointmentId"));
		System.out.println("appointmentId="+appointmentId);
		int i= tbAppointmentPackageService.deleteTbAppointmentPackage(appointmentId);
		return Response.ok(i);
	}
}
