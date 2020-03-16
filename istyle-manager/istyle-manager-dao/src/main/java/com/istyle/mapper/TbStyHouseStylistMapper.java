package com.istyle.mapper;

import com.istyle.pojo.TbStyHouseStylist;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 查询所有造型师
     * @param styHouseId
     * @return
     */
    List<TbStyHouseStylist> selectStylistList(long styHouseId);

    /**
     * 查询造型师数量
     * @param styHouseId
     * @return
     */
    long selectStylistCount(long styHouseId);

    /**
     * 根据id查询造型屋关联的造型师
     * @param styHouseId
     * @param stylistId
     * @return
     */
    TbStyHouseStylist selectStylist(@Param("styHouseId")long styHouseId, @Param("stylistId")long stylistId);

    /**
     * 修改造型屋关联的造型师的数据
     * @param tbStyHouseStylist
     * @return
     */
    int updateStylist(TbStyHouseStylist tbStyHouseStylist);

    /**
     * 添加造型屋关联的造型师
     * @param tbStyHouseStylist
     * @return
     */
    int insertStylist(TbStyHouseStylist tbStyHouseStylist);

    /**
     * 删除造型师
     * @param styHouseId
     * @param stylistId
     * @return
     */
    int deleteStylist(@Param("styHouseId")long styHouseId, @Param("stylistId")long stylistId);
    
    
}
