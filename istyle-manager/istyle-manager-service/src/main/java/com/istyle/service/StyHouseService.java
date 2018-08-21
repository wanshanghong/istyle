package com.istyle.service;

import com.istyle.pojo.TbStyHouse;

import java.util.List;

public interface StyHouseService {
    //    查询造型师数量
    Long selectStyHouseCountByUserId(Long userId);
    //    查询造型师昵称及图片
    List<TbStyHouse> selectStyHouseByUserId(Long userId);
}
