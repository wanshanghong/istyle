package com.istyle.mapper;

import com.istyle.pojo.TbStylist;

import java.util.List;

/**
 * @author 黄文伟
 */
public interface TbStylistMapper {
    /**
     * 根据id查询造型师数量
     * @param userId
     * @return
     */
    Long selectStylistCountByUserId(Long userId);

    /**
     * 根据id查询造型师
     * @param userId
     * @return
     */
    List<TbStylist> selectStylistByUserId(Long userId);

    /**
     * 造型师注册
     * @param tbStylist
     */
    void addStylist(TbStylist tbStylist);

    /**
     * 通过号码和密码查询造型师id、昵称、照片、签名、性别、年龄、电话
     * @param stylist 造型师数据，包括号码和密码
     * @return stylist
     */
    TbStylist selectStylistByPhoneAndPassword(TbStylist stylist);

    /**
     * 判断号码是否注册，返回数量
     * @param stylistPhone
     * @return
     */
    int isStylistPhone(String stylistPhone);


    /**
     * 判断昵称是否注册，返回数量
     * @param stylistName
     * @return
     */
    int isStylistName(String stylistName);

    /**
     * 判断号码和密码是否注册，返回数量
     * @param stylist
     * @return
     */
    int isPhoneAndPassword(TbStylist stylist);

    /**
     * 根据id查询造型师数据
     * @param stylistId id
     * @return stylist
     */
    TbStylist selectStylistById(long stylistId);
}
