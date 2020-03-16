package com.istyle.pojo;

public class TbAppointmentStylist {
	private Long appointmentStylistId;
	private Long userId;
	private Long stylistId;
	private Long styhouseId;
	private String appointmentStylistTime;
	private int appointmentStylistState;
	private TbStylist tbStylist;
	
	public Long getAppointmentStylistId() {
		return appointmentStylistId;
	}
	public void setAppointmentStylistId(Long appointmentStylistId) {
		this.appointmentStylistId = appointmentStylistId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getStylistId() {
		return stylistId;
	}
	public void setStylistId(Long stylistId) {
		this.stylistId = stylistId;
	}
	public Long getStyhouseId() {
		return styhouseId;
	}
	public void setStyhouseId(Long styhouseId) {
		this.styhouseId = styhouseId;
	}
	public String getAppointmentStylistTime() {
		return appointmentStylistTime;
	}
	public void setAppointmentStylistTime(String appointmentStylistTime) {
		this.appointmentStylistTime = appointmentStylistTime;
	}
	public int getAppointmentStylistState() {
		return appointmentStylistState;
	}
	public void setAppointmentStylistState(int appointmentStylistState) {
		this.appointmentStylistState = appointmentStylistState;
	}
	public TbStylist getTbStylist() {
		return tbStylist;
	}
	public void setTbStylist(TbStylist tbStylist) {
		this.tbStylist = tbStylist;
	}
	@Override
	public String toString() {
		return "TbAppointmentStylist [appointmentStylistId=" + appointmentStylistId + ", userId=" + userId
				+ ", stylistId=" + stylistId + ", styhouseId=" + styhouseId + ", appointmentStylistTime="
				+ appointmentStylistTime + ", appointmentStylistState=" + appointmentStylistState + ", tbStylist="
				+ tbStylist + "]";
	}
	
	
}
