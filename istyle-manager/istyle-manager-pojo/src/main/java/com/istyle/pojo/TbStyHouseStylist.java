package com.istyle.pojo;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 16:06 2019/5/30
 */
public class TbStyHouseStylist {
    private long id;
    private long stylistId;
    private long styHouseId;
    private String stylistPhoto;
    private String stylistName;
    private int maxNumber;
    private String reservationTime;
    private int status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getStylistId() {
        return stylistId;
    }

    public void setStylistId(long stylistId) {
        this.stylistId = stylistId;
    }

    public long getStyHouseId() {
        return styHouseId;
    }

    public void setStyHouseId(long styHouseId) {
        this.styHouseId = styHouseId;
    }

    public String getStylistPhoto() {
        return stylistPhoto;
    }

    public void setStylistPhoto(String stylistPhoto) {
        this.stylistPhoto = stylistPhoto;
    }

    public String getStylistName() {
        return stylistName;
    }

    public void setStylistName(String stylistName) {
        this.stylistName = stylistName;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public String getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(String reservationTime) {
        this.reservationTime = reservationTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
