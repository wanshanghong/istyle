package com.istyle.mapper;

import com.istyle.pojo.TbStyHouse;
import com.istyle.pojo.TbStyHousePackage;
import com.istyle.pojo.TbStyHouseStylist;

import org.apache.ibatis.annotations.Param;

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
     * 根据地址查询造型屋头像、名称、简介
     * @param styHousePosition
     * @return styHouse
     */
    List<TbStyHouse> selectPhotoNameAddressPackageByPosition(String styHousePosition);

    /**
     * 根据id查询造型屋的图片、名称、电话、评论、套餐、营业时间、描述、地址
     * @param styHouseId
     * @return
     */
    TbStyHouse selectNamePhotoPackagePhoneTimeWordByStyHouseId(Long styHouseId);

    /**
     * 根据id查询造型屋登陆页信息
     * @param styHouseId
     * @return
     */
    TbStyHouse selectIndexById(Long styHouseId);

    /**
     * 更新造型屋数据
     * @param tbStyHouse
     */
    public boolean updateStyHouse(TbStyHouse tbStyHouse);

    // TODO
    /**
     * 根据id查询造型屋所有套餐信息
     * @param styHouseId
     * @return
     */
    List<TbStyHousePackage> selectPackageList(long styHouseId);

    /**
     * 根据id查询造型屋的套餐数
     * @param styHouseId
     * @return
     */
    int selectPackageCount(long styHouseId);

    /**
     * 添加套餐
     * @param tbStyHousePackage
     * @return
     */
    int insertPackage(TbStyHousePackage tbStyHousePackage);

    /**
     * 根据id查询套餐信息
     * @param styHouseId
     * @param packageId
     * @return
     */
    TbStyHousePackage selectPackageById(@Param("styHouseId")long styHouseId, @Param("packageId")long packageId);

    /**
     * 修改套餐信息
     * @param tbStyHousePackage
     * @return
     */
    int updatePackage(TbStyHousePackage tbStyHousePackage);

    /**
     * 删除套餐
     * @param styHouseId
     * @param packageId
     * @return
     */
    int deletePackage(@Param("styHouseId")long styHouseId, @Param("packageId")long packageId);
    
    /**
     * 查找造型屋信息
     * @param styHouseId
     * @return
     */
    public TbStyHouse selectTbStyHouseBystyHouseId(long styHouseId);
}
