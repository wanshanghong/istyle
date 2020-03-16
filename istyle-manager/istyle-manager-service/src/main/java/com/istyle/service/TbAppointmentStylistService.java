package com.istyle.service;

import java.util.List;

import com.istyle.pojo.TbAppointmentStylist;

public interface TbAppointmentStylistService {
	/* 添加造型师预约
	* @param 
	* @return Response*/
	public int InsertAppointmentStylist(TbAppointmentStylist tbAppointmentStylist);
	 
	/* 造型屋查询造型师预约
	* @param 
	* @return Response*/
	public List<TbAppointmentStylist> SelectAllAppointmentStylistBystyhouseId(Long styhouseId);
	 
	/* 查看造型屋未处理的造型师预约
	* @param 
	* @return Response*/
	public List<TbAppointmentStylist> SelectAllAppointmentStylistBystyhouseIdNoDeal(Long styhouseId);
	
	/* 查看造型屋已处理的造型师预约
	* @param 
	* @return Response*/
	public List<TbAppointmentStylist> SelectAllAppointmentStylistBystyhouseIdIsDeal(Long styhouseId);
	
	/* 查看造型屋已删除的造型师预约
	* @param 
	* @return Response*/  
	public List<TbAppointmentStylist> SelectAllAppointmentStylistBystyhouseIdIsdelete(Long styhouseId);
	
	/* 用户查询造型师预约
	* @param 
	* @return Response*/
	public List<TbAppointmentStylist> SelectAllAppointmentStylistByuserId(Long userId);
	 
	/* 用户查询造型师未处理预约
	* @param 
	* @return Response*/
	public List<TbAppointmentStylist> SelectAllAppointmentStylistByuserIdnoDeal(Long userId);
	
	/* 删除造型师预约
	* @param 
	* @return Response*/
	public int deleteAppointmentStylist(Long appointmentStylistId);

	/* 处理造型师预约
	* @param 
	* @return Response*/
	 public int  dealAppointmentStylist(Long appointmentStylistId);
}
