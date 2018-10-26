package com.istyle.mapper;

import com.istyle.pojo.TbStyHouse;

import java.util.List;

/**
 * @author 黄文伟
 */
public interface TbStyHouseMapper {
    /**
     * 根据id查询造型屋数量
     * @param userId
     * @return
     */
    Long selectStyHouseCountByUserId(Long userId);

    /**
     * 根据id查询造型屋
     * @param userId
     * @return
     */
    List<TbStyHouse> selectStyHouseByUserId(Long userId);

    /**
     * 造型屋注册
     * @param tbStyHouse
     */
    void addStyHouse(TbStyHouse tbStyHouse);

}
