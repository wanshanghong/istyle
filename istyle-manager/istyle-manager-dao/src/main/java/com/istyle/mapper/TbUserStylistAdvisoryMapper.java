package com.istyle.mapper;

import java.util.List;

import com.istyle.pojo.TbUserStylistAdvisory;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 21:09 2019/2/2
 */
public interface TbUserStylistAdvisoryMapper {
	
    boolean insertadvisory(TbUserStylistAdvisory tbUserStylistAdvisory);
    
    
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
    
    
    /**
     * 造型师回复咨询
    * @param TbUserStylistAdvisory
    * @return
     */
    public boolean updateAdvisoryByadvisoryId(TbUserStylistAdvisory tbUserStylistAdvisory);

}
