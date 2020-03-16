package com.istyle.pojo;

/**
 * @author 黄文伟
 */
public class TbStyHouse {
    private Long styHouseId;
    private String styHouseName;
    private String styHouseWord;
    private String styHousePhoto;
    private String styHousePosition;
    private String styHouseAccount;
    private String styHousePassword;
    private String headName;
    private String headId;
    private String headPhone;
    private String styHouseStatus;
    private String styHouseAddress;
    private String styHousePackage;
    private String styHousePhone;
    private String styHouseWorkTime;
    // 暂时添加
    private long commentCount;

    public Long getStyHouseId() {
        return styHouseId;
    }

    public void setStyHouseId(Long styHouseId) {
        this.styHouseId = styHouseId;
    }

    public String getStyHouseName() {
        return styHouseName;
    }

    public void setStyHouseName(String styHouseName) {
        this.styHouseName = styHouseName;
    }

    public String getStyHouseWord() {
        return styHouseWord;
    }

    public void setStyHouseWord(String styHouseWord) {
        this.styHouseWord = styHouseWord;
    }

    public String getStyHousePhoto() {
        return styHousePhoto;
    }

    public void setStyHousePhoto(String styHousePhoto) {
        this.styHousePhoto = styHousePhoto;
    }

    public String getStyHousePosition() {
        return styHousePosition;
    }

    public void setStyHousePosition(String styHousePosition) {
        this.styHousePosition = styHousePosition;
    }

    public String getStyHouseAccount() {
        return styHouseAccount;
    }

    public void setStyHouseAccount(String styHouseAccount) {
        this.styHouseAccount = styHouseAccount;
    }

    public String getStyHousePassword() {
        return styHousePassword;
    }

    public void setStyHousePassword(String styHousePassword) {
        this.styHousePassword = styHousePassword;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getHeadId() {
        return headId;
    }

    public void setHeadId(String headId) {
        this.headId = headId;
    }

    public String getHeadPhone() {
        return headPhone;
    }

    public void setHeadPhone(String headPhone) {
        this.headPhone = headPhone;
    }

    public String getStyHouseStatus() {
        return styHouseStatus;
    }

    public void setStyHouseStatus(String styHouseStatus) {
        this.styHouseStatus = styHouseStatus;
    }

    public String getStyHouseAddress() {
        return styHouseAddress;
    }

    public void setStyHouseAddress(String styHouseAddress) {
        this.styHouseAddress = styHouseAddress;
    }

    public String getStyHousePackage() {
        return styHousePackage;
    }

    public void setStyHousePackage(String styHousePackage) {
        this.styHousePackage = styHousePackage;
    }

    public String getStyHousePhone() {
        return styHousePhone;
    }

    public void setStyHousePhone(String styHousePhone) {
        this.styHousePhone = styHousePhone;
    }

    public String getStyHouseWorkTime() {
        return styHouseWorkTime;
    }

    public void setStyHouseWorkTime(String styHouseWorkTime) {
        this.styHouseWorkTime = styHouseWorkTime;
    }

    public long getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(long commentCount) {
        this.commentCount = commentCount;
    }

	@Override
	public String toString() {
		return "TbStyHouse [styHouseId=" + styHouseId + ", styHouseName=" + styHouseName + ", styHouseWord="
				+ styHouseWord + ", styHousePhoto=" + styHousePhoto + ", styHousePosition=" + styHousePosition
				+ ", styHouseAccount=" + styHouseAccount + ", styHousePassword=" + styHousePassword + ", headName="
				+ headName + ", headId=" + headId + ", headPhone=" + headPhone + ", styHouseStatus=" + styHouseStatus
				+ ", styHouseAddress=" + styHouseAddress + ", styHousePackage=" + styHousePackage + ", styHousePhone="
				+ styHousePhone + ", styHouseWorkTime=" + styHouseWorkTime + ", commentCount=" + commentCount + "]";
	}
}
