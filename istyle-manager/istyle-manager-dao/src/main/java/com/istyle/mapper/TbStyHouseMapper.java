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

    /**
     * 判断造型屋登录账号是否注册，返回数量
     * @param styHouseAccount 造型屋账号
     * @return int 数量
     */
    int isStyHouseAccount(String styHouseAccount);

    /**
     * 判断账号密码是否正确，返回数量
     * @param styHouse 账号密码
     * @return int 数量
     */
    int isAccountAndPassword(TbStyHouse styHouse);

    /**
     * 根据账号密码查询造型屋数据
     * @param styHouse 账号密码
     * @return styHouse
     */
    TbStyHouse selectStyHouseByAccountAndPassword(TbStyHouse styHouse);

    /**
     * 根据id查找昵称
     * @param id id
     * @return styHouseName
     */
    String selectStyHouseNameById(Long id);

    /**
     * 根据地质查询造型屋头像、名称、简介
     * @param styHousePosition
     * @return styHouse
     */
    List<TbStyHouse> selectPhotoNameAddressPackageByPosition(String styHousePosition);
}
