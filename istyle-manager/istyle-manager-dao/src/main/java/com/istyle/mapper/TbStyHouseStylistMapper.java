package com.istyle.mapper;

import java.util.List;

/**
 * @Author: 黄文伟
 * @description: 造型屋与造型师的连接表
 * @Date:Created in 15:59 2019/1/16
 */
public interface TbStyHouseStylistMapper {
    /**
     * 根据造型屋ID查询造型师ID
     * @param styHouseId
     * @return stylistId
     */
    List<Long> selectStylistIdByStyHouseId(Long styHouseId);

    /**
     * 根据造型屋ID查询造型师数量
     * @param styHouseId
     * @return count
     */
    Long selectStylistCountByStyHouseId(Long styHouseId);
}
