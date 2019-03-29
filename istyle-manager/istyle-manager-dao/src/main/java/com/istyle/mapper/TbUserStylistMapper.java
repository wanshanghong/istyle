package com.istyle.mapper;

import com.istyle.pojo.TbUserStylist;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 21:48 2019/1/21
 */
public interface TbUserStylistMapper {
    /**
     *根据用户id和造型师id查询是否关注造型
     * @param tbUserStylist
     * @return
     */
    Integer selectStatusByUserIdAndStylistId(TbUserStylist tbUserStylist);

    /**
     * 修改关注状态
     * @param tbUserStylist
     */
    void updateStatusByUserIdAndStylistId(TbUserStylist tbUserStylist);

    /**
     * 插入关注状态
     * @param tbUserStylist
     */
    void insertStatusByUserIdAndStylistId(TbUserStylist tbUserStylist);

    /**
     * 根据造型师id和status查询关注造型师数
     * @param stylistId
     * @return
     */
    long selectCountById(long stylistId);
}
