package com.istyle.mapper;

import java.util.List;

import com.istyle.pojo.TbAppointmentPackage;

public interface TbAppointmentPackageMapper {

	/* 添加套餐预约
	* @param 
	* @return int*/
	 public int InsertTbAppointmentPackage(TbAppointmentPackage tbAppointmentPackage );
		
	/* 查看造型屋的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentAllPackageBystyhouseId(Long styhouseId);
	
	
	/* 查看造型屋未处理的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentPackageBystyhouseIdNoDeal(Long styhouseId);
	
	
	/* 看造型屋已处理的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentPackageBystyhouseIdIsDeal(Long yhouseId);
	
	/* 删除套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public int deleteTbAppointmentPackage(Long appointmentId);

	/* 用户查看的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentAllPackageByUserId(Long UserId);

	/* 用户查看未处理套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentPackageByUserIdNoDeal(Long UserId);
	
	/* 用户查看已处理的套餐预约
	* @param 
	* @return List<TbAppointmentPackage>*/
	public List<TbAppointmentPackage> SelectTbAppointmentPackageByUserIdIsDeal(Long UserId);

	 
}
