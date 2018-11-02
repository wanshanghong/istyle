package com.istyle.pojo;

/**
 * @Author: 黄文伟
 * @description: 用户与造型师连接表
 * @Date:Created in 22:17 2018/11/1
 */
public class TbUserStylist {
    private long userId;
    private long stylistId;
    private int status;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getStylistId() {
        return stylistId;
    }

    public void setStylistId(long stylistId) {
        this.stylistId = stylistId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
