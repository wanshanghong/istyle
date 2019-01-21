package com.istyle.mapper;

import com.istyle.pojo.TbStyHousePackage;

import java.util.List;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 22:16 2019/1/20
 */
public interface TbStyHousePackageMapper {
    /**
     * 根据造型屋id查询优惠套餐详情
     * @param styHouseId
     * @return
     */
    List<TbStyHousePackage> selectAllPackageByStyHouseId(Long styHouseId);
}
