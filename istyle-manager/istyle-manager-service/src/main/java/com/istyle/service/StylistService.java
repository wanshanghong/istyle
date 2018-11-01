package com.istyle.service;

import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUser;

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
     * 查询造型师信息数据并返回
     * @param id id
     * @return stylist 造型师数据
     */
    TbStylist selectStylistById(long id);

    /**
     * 根据id查询粉丝数据
     * @param id id
     * @return result 造型师数据、粉丝数据、粉丝数
     */
    Map selectFansById(long id);

    /**
     * 关注造型师
     * @param user 用户id
     * @param stylistId 造型师id
     */
    void addAttention(TbUser user, long stylistId);
}
