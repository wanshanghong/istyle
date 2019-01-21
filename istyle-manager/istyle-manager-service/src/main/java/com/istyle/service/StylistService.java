package com.istyle.service;

import com.istyle.pojo.TbStylist;

import java.util.Map;

/**
 * 造型师接口
 * @author 黄文伟
 */
public interface StylistService {

    /**
     * 造型师注册
     * @param tbStylist 注册数据
     */
    void stylistRegister(TbStylist tbStylist);

    /**
     * 造型师登录
     * @param stylist 账号密码
     * @return Map， token
     */
    Map stylistLogin(TbStylist stylist);

    /**
     * 登录后跳转主页返回用户名
     * @param stylist id
     * @return stylistName
     */
    Map afterLoginGetName(TbStylist stylist);

    /**
     * 查询造型师信息数据并返回
     * @param stylistId id
     * @return stylist 造型师数据
     */
    TbStylist selectStylistById(Long stylistId);
}
