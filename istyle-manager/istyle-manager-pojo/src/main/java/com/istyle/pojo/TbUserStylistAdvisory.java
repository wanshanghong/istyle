package com.istyle.pojo;

import java.util.Date;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 20:47 2019/2/2
 */
public class TbUserStylistAdvisory {
	private long advisoryId;
    private String advisoryPhoto;
    private String advisoryHeight;
    private String advisoryWeight;
    private String advisoryStyle;
    private String advisoryDescription;
    private Date putTime;
    private int isReply;
    private String replyMessage;
    private Date replyTime;
    private String replyPhoto;
    private String styHouseURL;
    
    private TbStylist tbStylist;
	private TbUser tbUser;
	@Override
	public String toString() {
		return "TbUserStylistAdvisory [advisoryId=" + advisoryId + ", advisoryPhoto=" + advisoryPhoto
				+ ", advisoryHeight=" + advisoryHeight + ", advisoryWeight=" + advisoryWeight + ", advisoryStyle="
				+ advisoryStyle + ", advisoryDescription=" + advisoryDescription + ", putTime=" + putTime + ", isReply="
				+ isReply + ", replyMessage=" + replyMessage + ", replyTime=" + replyTime + ", replyPhoto=" + replyPhoto
				+ ", styHouseURL=" + styHouseURL + ", tbStylist=" + tbStylist + ", tbUser=" + tbUser + "]";
	}
	public long getAdvisoryId() {
		return advisoryId;
	}
	public void setAdvisoryId(long advisoryId) {
		this.advisoryId = advisoryId;
	}
	public String getAdvisoryPhoto() {
		return advisoryPhoto;
	}
	public void setAdvisoryPhoto(String advisoryPhoto) {
		this.advisoryPhoto = advisoryPhoto;
	}
	public String getAdvisoryHeight() {
		return advisoryHeight;
	}
	public void setAdvisoryHeight(String advisoryHeight) {
		this.advisoryHeight = advisoryHeight;
	}
	public String getAdvisoryWeight() {
		return advisoryWeight;
	}
	public void setAdvisoryWeight(String advisoryWeight) {
		this.advisoryWeight = advisoryWeight;
	}
	public String getAdvisoryStyle() {
		return advisoryStyle;
	}
	public void setAdvisoryStyle(String advisoryStyle) {
		this.advisoryStyle = advisoryStyle;
	}
	public String getAdvisoryDescription() {
		return advisoryDescription;
	}
	public void setAdvisoryDescription(String advisoryDescription) {
		this.advisoryDescription = advisoryDescription;
	}
	public Date getPutTime() {
		return putTime;
	}
	public void setPutTime(Date putTime) {
		this.putTime = putTime;
	}
	public int getIsReply() {
		return isReply;
	}
	public void setIsReply(int isReply) {
		this.isReply = isReply;
	}
	public String getReplyMessage() {
		return replyMessage;
	}
	public void setReplyMessage(String replyMessage) {
		this.replyMessage = replyMessage;
	}
	public Date getReplyTime() {
		return replyTime;
	}
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}
	public String getReplyPhoto() {
		return replyPhoto;
	}
	public void setReplyPhoto(String replyPhoto) {
		this.replyPhoto = replyPhoto;
	}
	public String getStyHouseURL() {
		return styHouseURL;
	}
	public void setStyHouseURL(String styHouseURL) {
		this.styHouseURL = styHouseURL;
	}
	public TbStylist getTbStylist() {
		return tbStylist;
	}
	public void setTbStylist(TbStylist tbStylist) {
		this.tbStylist = tbStylist;
	}
	public TbUser getTbUser() {
		return tbUser;
	}
	public void setTbUser(TbUser tbUser) {
		this.tbUser = tbUser;
	}
}
