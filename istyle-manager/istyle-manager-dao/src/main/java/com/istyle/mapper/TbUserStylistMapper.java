package com.istyle.mapper;

import com.istyle.pojo.TbUser;
import com.istyle.pojo.TbUserStylist;

import java.util.List;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 22:18 2018/11/1
 */
public interface TbUserStylistMapper {
    /**
     * 根据id查询造型师粉丝
     * @param stylistId id
     * @return user 粉丝数据
     */
    List<TbUser> selectStylistFanById(long stylistId);

    /**
     * 根据id查询粉丝数
     * @param stylistId id
     * @return fanCount 粉丝数
     */
    long selectFanCountById(long stylistId);

    /**
     * 根据用户id和造型师id查询是否关注，并返回数据
     * @param userStylist
     * @return
     */
    Integer selectStatusByUserIdAndStylistId(TbUserStylist userStylist);

    /**
     * 根据用户id和造型师id修改为关注状态
     * @param userStylist
     */
    void updateStatusTo0ByUserIdAndStylistId(TbUserStylist userStylist);

    /**
     * 根据用户id和造型师id增加关注状态
     * @param userStylist
     */
    void insertStatusByUserIdAndStylistId(TbUserStylist userStylist);
}
