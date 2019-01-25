package com.istyle.pojo;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 21:46 2019/1/21
 */
public class TbUserStylist {
    private Long userId;
    private Long stylistId;
    private int status;

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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
