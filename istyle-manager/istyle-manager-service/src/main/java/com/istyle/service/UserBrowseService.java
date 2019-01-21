package com.istyle.service;

import java.util.Map;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 22:42 2019/1/20
 */
public interface UserBrowseService {
    /**
     * 用户浏览造型屋
     * @param styHousePosition
     * @return
     */
    Map browseStyHouse(String styHousePosition);

    /**
     * 展示造型屋详情页面
     * @param styHouseId
     * @return
     */
    Map showStyHouse(Long styHouseId);
}
