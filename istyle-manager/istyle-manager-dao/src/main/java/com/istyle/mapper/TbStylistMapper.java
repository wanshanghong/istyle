package com.istyle.mapper;

import com.istyle.pojo.TbStylist;

import java.util.List;

/**
 * @author 黄文伟
 */
public interface TbStylistMapper {
    /**
     * 根据id查询造型师数量
     * @param userId
     * @return
     */
    Long selectStylistCountByUserId(Long userId);

    /**
     * 根据id查询造型师
     * @param userId
     * @return
     */
    List<TbStylist> selectStylistByUserId(Long userId);

    /**
     * 造型师注册
     * @param tbStylist
     */
    void addStylist(TbStylist tbStylist);
}
