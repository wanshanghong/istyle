package com.istyle.pojo;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 22:14 2019/1/20
 */
public class TbStyHousePackage {
    private Long packageId;
    private Long styHouseId;
    private String packageName;
    private String packagePhoto;
    private String packagePrice;
    private String packageDescription;

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    @Override
	public String toString() {
		return "TbStyHousePackage [packageId=" + packageId + ", styHouseId=" + styHouseId + ", packageName="
				+ packageName + ", packagePhoto=" + packagePhoto + ", packagePrice=" + packagePrice
				+ ", packageDescription=" + packageDescription + "]";
	}

	public Long getStyHouseId() {
        return styHouseId;
    }

    public void setStyHouseId(Long styHouseId) {
        this.styHouseId = styHouseId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackagePhoto() {
        return packagePhoto;
    }

    public void setPackagePhoto(String packagePhoto) {
        this.packagePhoto = packagePhoto;
    }

    public String getPackagePrice() {
        return packagePrice;
    }

    public void setPackagePrice(String packagePrice) {
        this.packagePrice = packagePrice;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }
}
