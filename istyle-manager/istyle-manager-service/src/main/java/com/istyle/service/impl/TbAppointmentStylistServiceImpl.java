package com.istyle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istyle.mapper.TbAppointmentStylistMapper;
import com.istyle.pojo.TbAppointmentStylist;
import com.istyle.service.TbAppointmentStylistService;

@Service
public class TbAppointmentStylistServiceImpl implements TbAppointmentStylistService {
	
	@Autowired
	private  TbAppointmentStylistMapper tbAppointmentStylistMapper;
	
	/* 添加造型师预约
	* @param 
	* @return int*/
	public int InsertAppointmentStylist(TbAppointmentStylist tbAppointmentStylist){
		return tbAppointmentStylistMapper.InsertAppointmentStylist(tbAppointmentStylist);
	}
	 
	/* 造型屋查询造型师预约
	* @param 
	* @return Response*/
	public List<TbAppointmentStylist> SelectAllAppointmentStylistBystyhouseId(Long styhouseId){
		return tbAppointmentStylistMapper.SelectAllAppointmentStylistBystyhouseId(styhouseId);
	}
	 
	/* 查看造型屋未处理的造型师预约
	* @param 
	* @return Response*/
	public List<TbAppointmentStylist> SelectAllAppointmentStylistBystyhouseIdNoDeal(Long styhouseId){
		return tbAppointmentStylistMapper.SelectAllAppointmentStylistBystyhouseIdNoDeal(styhouseId);
	}
	
	/* 查看造型屋已处理的造型师预约
	* @param 
	* @return Response*/
	public List<TbAppointmentStylist> SelectAllAppointmentStylistBystyhouseIdIsDeal(Long styhouseId){
		return tbAppointmentStylistMapper.SelectAllAppointmentStylistBystyhouseIdIsDeal(styhouseId);
	}
	
	/* 查看造型屋已删除的造型师预约
	* @param 
	* @return Response*/  
	public List<TbAppointmentStylist> SelectAllAppointmentStylistBystyhouseIdIsdelete(Long styhouseId){
		return tbAppointmentStylistMapper.SelectAllAppointmentStylistBystyhouseIdIsdelete(styhouseId);
	}
	
	/* 用户查询造型师预约
	* @param 
	* @return Response*/
	public List<TbAppointmentStylist> SelectAllAppointmentStylistByuserId(Long userId){
		return tbAppointmentStylistMapper.SelectAllAppointmentStylistByuserId(userId);
	}
	 
	/* 用户查询造型师未处理预约
	* @param 
	* @return Response*/
	public List<TbAppointmentStylist> SelectAllAppointmentStylistByuserIdnoDeal(Long userId){
		return tbAppointmentStylistMapper.SelectAllAppointmentStylistByuserIdnoDeal(userId);
	}
	
	/* 删除造型师预约
	* @param 
	* @return Response*/
	public int deleteAppointmentStylist(Long appointmentStylistId){
		return tbAppointmentStylistMapper.deleteAppointmentStylist(appointmentStylistId);
	}

	/* 处理造型师预约
	* @param 
	* @return Response*/
	 public int  dealAppointmentStylist(Long appointmentStylistId){
		 return tbAppointmentStylistMapper.dealAppointmentStylist(appointmentStylistId);
	 }
}
