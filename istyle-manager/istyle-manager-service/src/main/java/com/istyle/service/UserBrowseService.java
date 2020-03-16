package com.istyle.service;

import java.util.List;
import java.util.Map;

import com.istyle.pojo.TbUserStylistAdvisory;

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

    /**
     * 造型师展示
     * @param userId 用户id
     * @param stylistId 造型师id
     * @return stylist 造型师数据
     */
    Map selectStylistById(Long userId, Long stylistId);

    /**
     * 展示造型师粉丝
     * @param stylistId
     * @return
     */
    Map showStylistFans(Long stylistId);

    /**
     * 用户关注造型师
     * @param userId
     * @param stylistId
     */
    void addAttention(Long userId, Long stylistId);

    /**
     * 用户提交咨询信息
     * @param userStylistAdvisory
     */
    boolean summitAdvisory(TbUserStylistAdvisory tbUserStylistAdvisory);
    
    /**
     * 查询用户所有咨询
     * @param userId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByUserId(long userId);
    
    
    /**
     * 用户查询已回复咨询
     * @param userId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByUserIdIsReturn(long userId);
    
	/**
	 * 用户查询未回复咨询
	 * @param userId
	 */
	public List<TbUserStylistAdvisory> findUserAdvisoryByUserIdNoReturn(long userId);
	
	/**
     * 造型师查询所有咨询
     * @param stylistId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByStylistId(long stylistId);
    
	/**
     * 造型师查询已回复咨询
     * @param userId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByStylistIdIsReturn(long stylistId);
    
    /**
     * 造型师查询未回复咨询
     * @param userId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByStylistIdNoReturn(long stylistId);
		
	/**
     * 用户查询指定的造型师回复咨询 或 造型师查询指定的用户回复咨询
     * @param userId
     */
	 public List<TbUserStylistAdvisory> findUserAdvisoryByUserIdAndStylistId(long userId,long stylistId);
	 
	/**
     * 用户查询指定的造型师未回复咨询 或 造型师查询指定的用户未回复咨询
     * @param userId stylistId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryUserIdAndStylistIdIsReturn(long userId,long stylistId);
    
	/**
     * 用户查询指定的造型师已回复咨询 或 造型师查询指定的用户已回复咨询
     * @param userId stylistId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByUserIdAndStylistIdNoReturn(long userId,long stylistId);
    
    /**
     * 通过ID查询咨询
     * @param id
     */
    public TbUserStylistAdvisory findUserAdvisoryById(long advisoryId);
}
