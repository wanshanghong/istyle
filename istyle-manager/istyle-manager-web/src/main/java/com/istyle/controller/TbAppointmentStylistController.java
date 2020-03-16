package com.istyle.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
public class TbAppointmentStylistController {
	@Autowired
	private TbAppointmentPackageService tbAppointmentPackageService;
	@Autowired
	private TbAppointmentStylistService tbAppointmentStylistService;
	
	/* 添加造型师预约
	* @param 
	* @return int*/
	@ResponseBody
    @RequestMapping(value = "/insertAppointmentStylist", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	 public Response InsertAppointmentStylist(@RequestBody Map<String, String> request ){
		TbAppointmentStylist tbAppointmentStylist=new TbAppointmentStylist();
		tbAppointmentStylist.setStyhouseId(Long.parseLong(request.get("styhouseId")));
		tbAppointmentStylist.setStylistId(Long.parseLong(request.get("stylistId")));
		tbAppointmentStylist.setAppointmentStylistTime(request.get("appointmentStylistTime"));
		System.out.println("tbAppointmentStylist="+tbAppointmentStylist);
		TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
		tbAppointmentStylist.setUserId(tbUser.getUserId());
		System.out.println("tbAppointmentStylist="+tbAppointmentStylist);
		int i= tbAppointmentStylistService.InsertAppointmentStylist(tbAppointmentStylist);
		return Response.ok(i); 
	 }
	
	/* 取消套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	@ResponseBody
    @RequestMapping(value = "/quxiaoAppointmentStylistByappointmentStylistId", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	public Response quxiaoAppointmentPackageByappointmentStylistId(@RequestBody Map<String, String> request){
		Long appointmentStylistId=Long.parseLong(request.get("appointmentStylistId"));
		System.out.println("appointmentStylistId="+appointmentStylistId);
		int i= tbAppointmentStylistService.deleteAppointmentStylist(appointmentStylistId);
		return Response.ok(i);
	}
}
