package com.istyle.pojo;

public class TbAppointmentPackage {
	private Long appointmentId;	//预约Id
	private Long UserId;		//用户id
	private Long packageId;		//套餐id
	private Long styhouseId;	//造型屋id
	private String appointmentTime;	//预约时间
	private int appointmenState;	//预约状态
	private int appointmenPay;		//是否支付
	
	public TbStyHousePackage tbStyHousePackage;
	
	public Long getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(Long appointmentId) {
		this.appointmentId = appointmentId;
	}
	
	public Long getUserId() {
		return UserId;
	}
	public void setUserId(Long userId) {
		UserId = userId;
	}
	public Long getPackageId() {
		return packageId;
	}
	public void setPackageId(Long packageId) {
		this.packageId = packageId;
	}
	public Long getStyhouseId() {
		return styhouseId;
	}
	public void setStyhouseId(Long styhouseId) {
		this.styhouseId = styhouseId;
	}
	public String getAppointmentTime() {
		return appointmentTime;
	}
	public void setAppointmentTime(String appointmentTime) {
		this.appointmentTime = appointmentTime;
	}
	public int getAppointmenState() {
		return appointmenState;
	}
	public void setAppointmenState(int appointmenState) {
		this.appointmenState = appointmenState;
	}
	public int getAppointmenPay() {
		return appointmenPay;
	}
	public void setAppointmenPay(int appointmenPay) {
		this.appointmenPay = appointmenPay;
	}
	
	public TbStyHousePackage getTbStyHousePackage() {
		return tbStyHousePackage;
	}
	public void setTbStyHousePackage(TbStyHousePackage tbStyHousePackage) {
		this.tbStyHousePackage = tbStyHousePackage;
	}
	
	@Override
	public String toString() {
		return "TbAppointmentPackage [appointmentId=" + appointmentId + ", UserId=" + UserId + ", packageId="
				+ packageId + ", styhouseId=" + styhouseId + ", appointmentTime=" + appointmentTime
				+ ", appointmenState=" + appointmenState + ", appointmenPay=" + appointmenPay + ", tbStyHousePackage="
				+ tbStyHousePackage + "]";
	}
}
