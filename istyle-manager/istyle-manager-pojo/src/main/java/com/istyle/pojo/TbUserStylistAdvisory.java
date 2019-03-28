package com.istyle.pojo;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 20:47 2019/2/2
 */
public class TbUserStylistAdvisory {
    private String stoken;
    private long stylistId;
    private long userId;
    private MultipartFile advisoryPhoto;
    private String sqlPath;
    private String advisoryHeight;
    private String advisoryWeight;
    private String advisoryStyle;
    private String advisoryDescription;

    public String getStoken() {
        return stoken;
    }

    public void setStoken(String stoken) {
        this.stoken = stoken;
    }

    public long getStylistId() {
        return stylistId;
    }

    public void setStylistId(long stylistId) {
        this.stylistId = stylistId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public MultipartFile getAdvisoryPhoto() {
        return advisoryPhoto;
    }

    public void setAdvisoryPhoto(MultipartFile advisoryPhoto) {
        this.advisoryPhoto = advisoryPhoto;
    }

    public String getSqlPath() {
        return sqlPath;
    }

    public void setSqlPath(String sqlPath) {
        this.sqlPath = sqlPath;
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
}
