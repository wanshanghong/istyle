package com.istyle.service;

import com.istyle.pojo.TbStyHouse;

import java.util.List;

/**
 * 造型屋相关
 * @author 黄文伟
 */
public interface StyHouseService {
    /**
     * 通过用户id查询造型屋数量
     * @param userId
     * @return Long styHouseCount
     */
    Long selectStyHouseCountByUserId(Long userId);

    /**
     * 通过用户id查询造型屋
     * @param userId
     * @return List<TbStyHouse>
     */
    List<TbStyHouse> selectStyHouseByUserId(Long userId);

    /**
     * 造型屋注册
     * @param tbStyHouse
     */
    void styHouseRegister(TbStyHouse tbStyHouse);
}
