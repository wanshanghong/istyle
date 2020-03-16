package com.istyle.service;

import com.istyle.pojo.TbStyHouse;
import com.istyle.pojo.TbStyHousePackage;
import com.istyle.pojo.TbStyHouseStylist;

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

    /**
     * 展示造型屋信息页
     * @param styHouse
     * @return
     */
    TbStyHouse showStyHouseIndex(TbStyHouse styHouse);

    /**
     * 造型屋编辑页面展示
     * @param styHouseId
     * @return
     */
    TbStyHouse showEditMessage(long styHouseId);

    /**
     * 编辑造型屋数据
     * @param tbStyHouse
     */
    public boolean updateEditMessage(TbStyHouse tbStyHouse);

    /**
     * 造型屋套餐管理展示接口
     * @param styHouseId
     * @return
     */
    Map showPackageManager(Long styHouseId);

    /**
     * 造型屋套餐发布接口
     * @param tbStyHousePackage
     * @return
     */
    boolean submitPackage(TbStyHousePackage tbStyHousePackage);

    /**
     * 造型屋套餐管理编辑展示接口
     * @param tbStyHousePackage
     * @return
     */
    TbStyHousePackage showeditPackage(TbStyHousePackage tbStyHousePackage);

    /**
     * 造型屋套餐信息修改提交接口
     * @param tbStyHousePackage
     * @return
     */
    boolean submitEditPackage(TbStyHousePackage tbStyHousePackage);

    /**
     * 造型屋套餐管理删除套餐接口
     * @param tbStyHousePackage
     * @return
     */
    boolean deletePackage(TbStyHousePackage tbStyHousePackage);

    /**
     * 造型屋的造型师管理展示接口
     * @param styHouseId
     * @return
     */
    Map selectStylistManager(Long styHouseId);

    /**
     * 造型屋的造型师管理的编辑信息展示接口
     * @return tbStyHouseStylist
     */
    TbStyHouseStylist selectStylist(TbStyHouseStylist tbStyHouseStylist);

    /**
     * 造型屋的造型师信息修改提交接口
     * @param tbStyHouseStylist
     * @return
     */
    boolean submitEditStylist(TbStyHouseStylist tbStyHouseStylist);

    /**
     * 造型屋的造型师发布接口
     * @param tbStyHouseStylist
     * @return
     */
    boolean submitStylist(TbStyHouseStylist tbStyHouseStylist);

    /**
     * 造型屋的造型师管理的删除造型师接口
     * @param tbStyHouseStylist
     * @return
     */
    boolean deleteStylist(TbStyHouseStylist tbStyHouseStylist);
    
    
    /**
     * 查找造型屋信息
     * @param tbStyHouseStylist
     * @return
     */
    public TbStyHouse selectTbStyHouseBystyHouseId(TbStyHouse tbStyHouse);
}
