package com.istyle.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.istyle.mapper.TbAppointmentPackageMapper;
import com.istyle.pojo.TbAppointmentPackage;
import com.istyle.service.TbAppointmentPackageService;

@Service 
public class TbAppointmentPackageServiceImpl implements TbAppointmentPackageService {
	@Autowired
	private TbAppointmentPackageMapper tbAppointmentPackageMapper;
	/* 添加套餐预约
	* @param 
	* @return int*/
	 public int InsertTbAppointmentPackage(TbAppointmentPackage tbAppointmentPackage ){
		 return tbAppointmentPackageMapper.InsertTbAppointmentPackage(tbAppointmentPackage);
	 }
		
	/* 查看造型屋的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentAllPackageBystyhouseId(Long styhouseId){
		return tbAppointmentPackageMapper.SelectTbAppointmentAllPackageBystyhouseId(styhouseId);
	}
	
	
	/* 查看造型屋未处理的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentPackageBystyhouseIdNoDeal(Long styhouseId){
		return tbAppointmentPackageMapper.SelectTbAppointmentPackageBystyhouseIdNoDeal(styhouseId);
	}
	
	
	/* 看造型屋已处理的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentPackageBystyhouseIdIsDeal(Long yhouseId){
		return tbAppointmentPackageMapper.SelectTbAppointmentPackageBystyhouseIdIsDeal(yhouseId);
	}
	
	/* 删除套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public int deleteTbAppointmentPackage(Long appointmentId){
		return tbAppointmentPackageMapper.deleteTbAppointmentPackage(appointmentId);
	}

	/* 用户查看的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentAllPackageByUserId(Long UserId){
		return tbAppointmentPackageMapper.SelectTbAppointmentAllPackageByUserId(UserId);
	}

	/* 用户查看未处理套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentPackageByUserIdNoDeal(Long UserId){
		return tbAppointmentPackageMapper.SelectTbAppointmentPackageByUserIdNoDeal(UserId);
	}
	
	/* 用户查看已处理的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentPackageByUserIdIsDeal(Long UserId){
		return tbAppointmentPackageMapper.SelectTbAppointmentPackageByUserIdIsDeal(UserId);
	}
}
