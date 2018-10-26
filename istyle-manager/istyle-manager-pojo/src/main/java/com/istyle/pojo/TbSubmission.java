package com.istyle.pojo;

/**
 * @author 黄文伟
 */
public class TbSubmission {
    private Long subId;
    private Long userId;
    private String subPhoto;
    private String subName;
    private String subTime;
    private int subPageView;
    private int subComment;
    private int subCollection;
    private String subContent;
    private int subStatus;

    public Long getSubId() {
        return subId;
    }

    public void setSubId(Long subId) {
        this.subId = subId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSubPhoto() {
        return subPhoto;
    }

    public void setSubPhoto(String subPhoto) {
        this.subPhoto = subPhoto;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubTime() {
        return subTime;
    }

    public void setSubTime(String subTime) {
        this.subTime = subTime;
    }

    public int getSubPageView() {
        return subPageView;
    }

    public void setSubPageView(int subPageView) {
        this.subPageView = subPageView;
    }

    public int getSubComment() {
        return subComment;
    }

    public void setSubComment(int subComment) {
        this.subComment = subComment;
    }

    public int getSubCollection() {
        return subCollection;
    }

    public void setSubCollection(int subCollection) {
        this.subCollection = subCollection;
    }

    public String getSubContent() {
        return subContent;
    }

    public void setSubContent(String subContent) {
        this.subContent = subContent;
    }

    public int getSubStatus() {
        return subStatus;
    }

    public void setSubStatus(int subStatus) {
        this.subStatus = subStatus;
    }
}
