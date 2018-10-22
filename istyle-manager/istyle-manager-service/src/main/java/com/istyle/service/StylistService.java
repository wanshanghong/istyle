package com.istyle.service;

import com.istyle.pojo.TbStylist;

import java.util.List;

/**
 * 造型师接口
 * @author 黄文伟
 */
public interface StylistService {
    /**
     * 通过用户id查询造型师数量
     * @param userId
     * @return Long StylistCount
     */
    Long selectStylistCountByUserId(Long userId);

    /**
     * 通过用户id查询造型师
     * @param userId
     * @return List<TbStylist>
     */
    List<TbStylist> selectStylistByUserId(Long userId);

    /**
     * 造型师注册
     * @param tbStylist
     */
    void stylistRegister(TbStylist tbStylist);
}
