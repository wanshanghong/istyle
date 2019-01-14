package com.istyle.service;

import com.istyle.pojo.TbStyHouse;

import java.util.Map;


/**
 * 造型屋相关
 * @author 黄文伟
 */
public interface StyHouseService {

    /**
     * 造型屋注册
     * @param tbStyHouse 造型屋数据
     */
    void styHouseRegister(TbStyHouse tbStyHouse);

    /**
     * 造型屋登录
     * @param styHouse 造型屋数据，包括号码密码
     * @return map，返回stoken
     */
    Map styHouseLogin(TbStyHouse styHouse);

    /**
     * 登录后跳转主页返回用户名
     * @param styHouse id
     * @return styHouseName
     */
    Map afterLoginGetName(TbStyHouse styHouse);
}
