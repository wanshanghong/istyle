package com.istyle.mapper;

import com.istyle.pojo.TbStyHouse;

import java.util.List;

public interface TbStyHouseMapper {
    Long selectStylistCountByUserId(Long userId);
    List<TbStyHouse> selectStyHouseByUserId(Long userId);
}
