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
}
