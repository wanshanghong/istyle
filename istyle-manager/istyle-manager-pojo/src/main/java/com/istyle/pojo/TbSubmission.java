package com.istyle.pojo;

public class TbSubmission {
    private Long subId; //投稿
    private Long userId; //用户id
    private String subPhoto;
    private String subName; //标题
    private String subTime; //创造日期
    private int subPageView; //浏览人数
    private int subComment; //评论数
    private int subCollection; //收藏数
    private String subContent; //内容
    private int subStatus; //状态

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
