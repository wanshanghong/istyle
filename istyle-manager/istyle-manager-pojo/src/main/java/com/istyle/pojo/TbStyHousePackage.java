package com.istyle.pojo;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 22:14 2019/1/20
 */
public class TbStyHousePackage {
    private Long packageId;
    private Long styHoseId;
    private String packageName;
    private String packagePhoto;
    private String packagePrice;

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public Long getStyHoseId() {
        return styHoseId;
    }

    public void setStyHoseId(Long styHoseId) {
        this.styHoseId = styHoseId;
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
}
