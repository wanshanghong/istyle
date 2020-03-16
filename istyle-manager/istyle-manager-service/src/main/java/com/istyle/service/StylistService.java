package com.istyle.service;

import java.io.IOException;
import java.util.Map;

import com.istyle.pojo.TbStyHouseStylist;
import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUserStylistAdvisory;

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
     * 查询造型师的信息数据
     * @param TbStylist 用户数据，包括stylistId
     * @return TbStylist
     */
    public TbStylist selectTbStylistByStylistId(TbStylist tbStylist);
    
    /**
     * 查询造型师的信息数据包括造型屋
     * @param 包括stylistId
     * @return 
     */
    public Map<String, String> findStylistByStylistId(long stylistId);
    
    /**
     * 造型师回复咨询
     * @param TbUserStylistAdvisory
     * @return 
     */
    public boolean updateAdvisoryByadvisoryId(TbUserStylistAdvisory tbUserStylistAdvisory);
    
    /**
     * 联合查找造型屋和造型师
     * @param  stylistId
     * @return
     */
    public TbStyHouseStylist SelectTbStyHouseStylistBystylistId(long stylistId);
    

    /**
     * 更新造型师
     * @param 
     * @return Response
     */
    public boolean updateStylistMessage(TbStyHouseStylist tbStyHouseStylist);
}
