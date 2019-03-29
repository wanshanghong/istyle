package com.istyle.service;

import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUserStylistAdvisory;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 22:42 2019/1/20
 */
public interface UserBrowseService {
    /**
     * 用户浏览造型屋
     * @param styHousePosition
     * @return
     */
    Map browseStyHouse(String styHousePosition);

    /**
     * 展示造型屋详情页面
     * @param styHouseId
     * @return
     */
    Map showStyHouse(Long styHouseId);

    /**
     * 造型师展示
     * @param userId 用户id
     * @param stylistId 造型师id
     * @return stylist 造型师数据
     */
    Map selectStylistById(Long userId, Long stylistId);

    /**
     * 展示造型师粉丝
     * @param stylistId
     * @return
     */
    Map showStylistFans(Long stylistId);

    /**
     * 用户关注造型师
     * @param userId
     * @param stylistId
     */
    void addAttention(Long userId, Long stylistId);

    /**
     * 用户提交咨询信息
     * @param userStylistAdvisory
     */
    void summitAdvisory(MultipartFile userStylistAdvisory);
}
