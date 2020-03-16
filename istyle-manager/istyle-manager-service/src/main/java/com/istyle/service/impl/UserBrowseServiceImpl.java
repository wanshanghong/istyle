package com.istyle.service.impl;

import static org.springframework.util.StringUtils.isEmpty;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.AppAuthException;
import com.istyle.mapper.TbStyHouseMapper;
import com.istyle.mapper.TbStyHousePackageMapper;
import com.istyle.mapper.TbStyHouseStylistMapper;
import com.istyle.mapper.TbStylistMapper;
import com.istyle.mapper.TbUserStylistAdvisoryMapper;
import com.istyle.mapper.TbUserStylistMapper;
import com.istyle.pojo.TbStyHouse;
import com.istyle.pojo.TbStyHousePackage;
import com.istyle.pojo.TbStyHouseStylist;
import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUser;
import com.istyle.pojo.TbUserStylist;
import com.istyle.pojo.TbUserStylistAdvisory;
import com.istyle.service.UserBrowseService;
import com.istyle.service.util.FileUpload;
import com.util.CastUtil;
import com.util.StringUtil;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 22:43 2019/1/20
 */
@Service
public class UserBrowseServiceImpl implements UserBrowseService {
    @Autowired
    private TbStyHouseMapper tbStyHouseMapper;
    @Autowired
    private TbStyHouseStylistMapper tbStyHouseStylistMapper;
    @Autowired
    private TbStylistMapper tbStylistMapper;
    @Autowired
    private TbStyHousePackageMapper tbStyHousePackageMapper;
    @Autowired
    private TbUserStylistMapper tbUserStylistMapper;
    @Autowired
    private TbUserStylistAdvisoryMapper tbUserStylistAdvisoryMapper;

    /**
     * 用户浏览造型屋
     * @param styHousePosition
     * @return
     */
    @Override
    public Map browseStyHouse(String styHousePosition) {
        if (StringUtil.isNotEmpty(styHousePosition)) {
            Map<String, List> map = new HashMap<>(16);
            List<TbStyHouse> styHouses;
            List<TbStylist> stylists = new ArrayList<>(4);

            styHouses = tbStyHouseMapper.selectPhotoNameAddressPackageByPosition(styHousePosition);

            // 遍历造型屋，获得每个造型屋的造型师
            outer: for (int i = 0; i < styHouses.size(); i++) {
                List<Long> stylistId = tbStyHouseStylistMapper.selectStylistIdByStyHouseId(styHouses.get(i).getStyHouseId());
                // 判断造型屋旗下的造型师数量是否为0，是则跳过内循环
                if (stylistId.size() == 0) {
                    i++;
                } else {
                    //遍历造型师，获得每个造型师的数据
                    for (int j = 0; j < stylistId.size(); j++) {
                        stylists.add(tbStylistMapper.selectPhotoAndNameById(stylistId.get(j)));
                        // 如果容器多于4个，就跳出外循环
                        if (stylists.size() > 4) {
                            break outer;
                        }
                    }
                }
            }

            map.put("styHouses", styHouses);
            map.put("stylists", stylists);

            return map;
        } else {
            throw new AppAuthException("造型屋地址为空。");
        }
    }

    /**
     * 展示造型屋详情页面
     * @param styHouseId
     * @return
     */
    @Override
    public Map showStyHouse(Long styHouseId) {
        if (StringUtil.isNotEmpty(styHouseId.toString())) {
            Map<String, List> map = new HashMap<>(16);
            TbStyHouse styHouse = new TbStyHouse();
            List<TbStyHousePackage> discountPackage;


            styHouse = tbStyHouseMapper.selectNamePhotoPackagePhoneTimeWordByStyHouseId(styHouseId);
            discountPackage = tbStyHousePackageMapper.selectAllPackageByStyHouseId(styHouseId);

            styHouse.setCommentCount(2);
            System.out.println("hh" +styHouse.getCommentCount());
            
            List<TbStyHouseStylist> tbStyHouseStylist=tbStyHouseStylistMapper.selectStylistList(styHouseId);
            System.out.println("tbStyHouseStylist:" +tbStyHouseStylist);
            
            map.put("styHouse", Collections.singletonList(styHouse));
            map.put("discountPackage", discountPackage);
            map.put("tbStyHouseStylist", tbStyHouseStylist);

            return map;
        } else {
            throw new AppAuthException("造型屋Id为空。");
        }
    }

    /**
     * 造型师展示
     * @param stylistId id
     * @return stylist 造型师数据
     */
    @Override
    public Map<String, List> selectStylistById(Long userId, Long stylistId) {
        if (StringUtil.isNotEmpty(CastUtil.castString(stylistId))) {
            Map<String, List> map = new HashMap<>(16);
            TbStylist tbStylist;
            // 该变量判断是否用户是否关注造型师，0为已经关注，1为没关注
            Integer isAttention;
            TbUserStylist tbUserStylist = new TbUserStylist();
            tbUserStylist.setUserId(userId);
            tbUserStylist.setStylistId(stylistId);

            tbStylist = tbStylistMapper.selectStylistById(stylistId);
            isAttention = tbUserStylistMapper.selectStatusByUserIdAndStylistId(tbUserStylist);

            System.out.println(tbStylist.getStylistWord());
            System.out.println(tbStylist.getStylistIntroduction());

            if (isAttention == null) {
                isAttention = 1;
                map.put("isAttention", Collections.singletonList(isAttention));
            } else {
                map.put("isAttention", Collections.singletonList(isAttention));
            }
            map.put("tbStylist", Collections.singletonList(tbStylist));

            return map;
        }
        else {
            throw new AppAuthException("在我的信息展示时，发现造型师id为空，操作错误。");
        }
    }

    /**
     * 展示造型师粉丝
     * @param stylistId
     * @return
     */
    @Override
    public Map showStylistFans(Long stylistId) {
        if (StringUtil.isNotEmpty(stylistId.toString())) {
            Map<String, List> map = new HashMap<>(16);
            TbStylist stylist;
            List<TbUser> fans;
            long fanCount;

            stylist = tbStylistMapper.selectPhotoNameSexWord(stylistId);
            fans = tbStylistMapper.selectFansBystylistId(stylistId);
            fanCount = tbUserStylistMapper.selectCountById(stylistId);


            map.put("stylist", Collections.singletonList(stylist));
            map.put("fans", fans);
            map.put("fanCount", Collections.singletonList(fanCount));

            System.out.printf(fans.get(1).getUserName());

            return map;
        } else {
            throw new AppAuthException("造型师Id为空。");
        }
    }

    /**
     * 用户关注造型师
     * @param userId
     * @param stylistId
     */
    @Override
    public void addAttention(Long userId, Long stylistId) {
        TbUserStylist tbUserStylist = new TbUserStylist();
        Integer flag;

        tbUserStylist.setUserId(userId);
        tbUserStylist.setStylistId(stylistId);

        flag = tbUserStylistMapper.selectStatusByUserIdAndStylistId(tbUserStylist);

        if (flag == null) {
            tbUserStylistMapper.insertStatusByUserIdAndStylistId(tbUserStylist);
        } else if (flag == 0){
            throw new AppAuthException("该造型师已关注。");
        } else {
            tbUserStylistMapper.updateStatusByUserIdAndStylistId(tbUserStylist);
        }

        flag = tbUserStylistMapper.selectStatusByUserIdAndStylistId(tbUserStylist);
        if (flag == null || flag == 1) {
            throw new AppAuthException("关注失败。");
        }
    }

    /**
     * 用户提交咨询信息
     * @param userStylistAdvisory
     */
    @Override
    public boolean summitAdvisory(TbUserStylistAdvisory tbUserStylistAdvisory) {
    	return tbUserStylistAdvisoryMapper.insertadvisory(tbUserStylistAdvisory);
    }
    
    /**
     * 查询用户所有咨询
     * @param userId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByUserId(long userId){
    	return tbUserStylistAdvisoryMapper.findUserAdvisoryByUserId(userId);
    }
    
    /**
     * 用户查询已回复咨询
     * @param userId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByUserIdIsReturn(long userId){
    	return tbUserStylistAdvisoryMapper.findUserAdvisoryByUserIdIsReturn(userId);
    }
    
	/**
	 * 用户查询未回复咨询
	 * @param userId
	 */
	public List<TbUserStylistAdvisory> findUserAdvisoryByUserIdNoReturn(long userId){
		return tbUserStylistAdvisoryMapper.findUserAdvisoryByUserIdNoReturn(userId);
	}
	
	/**
     * 造型师查询所有咨询
     * @param stylistId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByStylistId(long stylistId){
    	return tbUserStylistAdvisoryMapper.findUserAdvisoryByStylistId(stylistId);
    }
    
	/**
     * 造型师查询已回复咨询
     * @param userId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByStylistIdIsReturn(long stylistId){
    	return tbUserStylistAdvisoryMapper.findUserAdvisoryByStylistIdIsReturn(stylistId);
    }
    
    /**
     * 造型师查询未回复咨询
     * @param userId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByStylistIdNoReturn(long stylistId){
    	return tbUserStylistAdvisoryMapper.findUserAdvisoryByStylistIdNoReturn(stylistId);
    }
		
	/**
     * 用户查询指定的造型师回复咨询 或 造型师查询指定的用户回复咨询
     * @param userId
     */
	 public List<TbUserStylistAdvisory> findUserAdvisoryByUserIdAndStylistId(long userId,long stylistId){
		 return tbUserStylistAdvisoryMapper.findUserAdvisoryByUserIdAndStylistId(userId,stylistId);
	 }
	 
	/**
     * 用户查询指定的造型师未回复咨询 或 造型师查询指定的用户未回复咨询
     * @param userId stylistId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryUserIdAndStylistIdIsReturn(long userId,long stylistId){
    	return tbUserStylistAdvisoryMapper.findUserAdvisoryUserIdAndStylistIdIsReturn(userId,stylistId);
    }
    
	/**
     * 用户查询指定的造型师已回复咨询 或 造型师查询指定的用户已回复咨询
     * @param userId stylistId
     */
    public List<TbUserStylistAdvisory> findUserAdvisoryByUserIdAndStylistIdNoReturn(long userId,long stylistId){
    	return tbUserStylistAdvisoryMapper.findUserAdvisoryByUserIdAndStylistIdNoReturn(userId,stylistId);
    }
    
    /**
     * 通过ID查询咨询
     * @param id
     */
    public TbUserStylistAdvisory findUserAdvisoryById(long advisoryId){
    	return tbUserStylistAdvisoryMapper.findUserAdvisoryById(advisoryId);
    }
}
