package com.istyle.pojo;

public class TbHair {
	private Long hairId;		//头发id
	private int hairSex;		//头发性别
	private int  hairLenght; 	//头发长度
	private int hairCurl;       //头发弯曲程度
	private int hairColor;		//头发颜色
	private String hairPhoto;	//头发图片
	private String suitSkin;	//合适皮肤
	private String suitFace;    //合适面孔
	public Long getHairId() {
		return hairId;
	}
	public void setHairId(Long hairId) {
		this.hairId = hairId;
	}
	public int getHairSex() {
		return hairSex;
	}
	public void setHairSex(int hairSex) {
		this.hairSex = hairSex;
	}
	public int getHairLenght() {
		return hairLenght;
	}
	public void setHairLenght(int hairLenght) {
		this.hairLenght = hairLenght;
	}
	public int getHairCurl() {
		return hairCurl;
	}
	public void setHairCurl(int hairCurl) {
		this.hairCurl = hairCurl;
	}
	public int getHairColor() {
		return hairColor;
	}
	public void setHairColor(int hairColor) {
		this.hairColor = hairColor;
	}
	public String getHairPhoto() {
		return hairPhoto;
	}
	public void setHairPhoto(String hairPhoto) {
		this.hairPhoto = hairPhoto;
	}
	public String getSuitSkin() {
		return suitSkin;
	}
	public void setSuitSkin(String suitSkin) {
		this.suitSkin = suitSkin;
	}
	public String getSuitFace() {
		return suitFace;
	}
	public void setSuitFace(String suitFace) {
		this.suitFace = suitFace;
	}
	@Override
	public String toString() {
		return "TbHair [hairId=" + hairId + ", hairSex=" + hairSex + ", hairLenght=" + hairLenght + ", hairCurl="
				+ hairCurl + ", hairColor=" + hairColor + ", hairPhoto=" + hairPhoto + ", suitSkin=" + suitSkin
				+ ", suitFace=" + suitFace + "]";
	}
	
}
