package com.istyle.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exception.AppAuthException;
import com.exception.AppUnknownException;
import com.istyle.mapper.StylistMapper;
import com.istyle.mapper.TbStyHouseStylistMapper;
import com.istyle.mapper.TbStylistMapper;
import com.istyle.mapper.TbUserStylistAdvisoryMapper;
import com.istyle.pojo.TbStyHouseStylist;
import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUserStylistAdvisory;
import com.istyle.service.StylistService;
import com.util.CastUtil;
import com.util.JWT;
import com.util.StringUtil;

/**
 * 造型师实现类
 * @author 黄文伟
 */
@Service
public class StylistServiceImpl implements StylistService {
    @Autowired
    private TbStylistMapper tbStylistMapper;
    @Autowired
    private TbStyHouseStylistMapper tbStyHouseStylistMapper;
    @Autowired
    private TbUserStylistAdvisoryMapper tbUserStylistAdvisoryMapper;
    @Autowired
    private StylistMapper StylistMapper;
    
    /**
     * 造型师注册
     * @param tbStylist 造型师数据，有控制层传递过来
     */
    @Override
    public void stylistRegister(TbStylist tbStylist) {
        if (StringUtil.isEmpty(tbStylist.getStylistName())){
            throw new AppAuthException("造型师昵称为空");
        }
        if (StringUtil.isEmpty(tbStylist.getRealName())) {
            throw new AppAuthException("真实姓名为空");
        }
        if (StringUtil.isEmpty(tbStylist.getStylistPassword())) {
            throw new AppAuthException("密码为空");
        }
        if (StringUtil.isEmpty(tbStylist.getStylistSex())) {
            throw new AppAuthException("性别为空");
        }
        if (StringUtil.isEmpty(CastUtil.castString(tbStylist.getStylistAge()))) {
            throw new AppAuthException("年龄为空");
        }
        if (StringUtil.isEmpty(tbStylist.getStylistPhone())) {
            throw new AppAuthException("号码为空");
        }
        if (tbStylistMapper.isStylistPhone(tbStylist.getStylistPhone()) != 0) {
            throw new AppAuthException("号码已注册");
        }
        if (tbStylistMapper.isStylistName(tbStylist.getStylistName()) != 0) {
            throw new AppAuthException("昵称已注册");
        }
        tbStylistMapper.addStylist(tbStylist);
        if (tbStylistMapper.isPhoneAndPassword(tbStylist) == 0) {
            throw new AppUnknownException("注册失败");
        }
    }

    @Override
    public Map stylistLogin(TbStylist stylist) {
        Map<String, String> stokenMap = null;

        if (StringUtil.isEmpty(stylist.getStylistPhone())) {
            throw new AppAuthException("号码为空");
        }
        if (StringUtil.isEmpty(stylist.getStylistPassword())) {
            throw new AppAuthException("密码为空");
        }
        if (tbStylistMapper.isPhoneAndPassword(stylist) != 1) {
            throw new AppAuthException("账号密码错误，登录失败");
        }
        if (tbStylistMapper.isStylistPhone(stylist.getStylistPhone()) != 1) {
            throw new AppAuthException("号码错误");
        }

        TbStylist tbStylist = tbStylistMapper.selectStylistByPhoneAndPassword(stylist);
        if (tbStylist == null) {
            throw new AppUnknownException("登录错误");
        }
        System.out.println("tbStylist:"+tbStylist.toString());
        String stoken = JWT.sign(tbStylist, 24L * 3600L * 30L);

        if (StringUtil.isNotEmpty(stoken)) {
            stokenMap = new HashMap<>(16);
            
            stokenMap.put("stoken", stoken);

            return stokenMap;
        } else {
            throw new AppUnknownException("stoken获取失败，造型师登录错误");
        }
    }

    /**
     * 登录后跳转主页返回用户名
     * @param stylist id
     * @return stylistName
     */
    @Override
    public Map<String, String> afterLoginGetName(TbStylist stylist) {
        String stylistName;

        stylistName = stylist.getStylistName();
        if (StringUtil.isEmpty(stylistName)) {
            throw new AppAuthException("登陆失败，请重新登陆");
        }
        if (stylistName.equals(tbStylistMapper.selectStylistNameById(stylist.getStylistId()))) {
            Map<String, String> map = new HashMap<>(16);
            map.put("stylistName", stylistName);
            return map;
        } else {
            throw new AppAuthException("登陆失败，请重新登陆");
        }
    }
    
    /**
     * 查询造型师的信息数据
     * @param TbStylist 用户数据，包括stylistId
     * @return TbStylist
     */
    @Override
    public TbStylist selectTbStylistByStylistId(TbStylist tbStylist) {
        if (StringUtil.isNotEmpty(CastUtil.castString(tbStylist))) {
        	System.out.println("iohsgoihioeghsoih");
            long stylistId = tbStylist.getStylistId();
            tbStylist = tbStylistMapper.selectTbStylistByStylistId(stylistId);
            return tbStylist;
        }
        else {
            throw new AppAuthException("在我的信息展示时，发现用户id为空，操作错误。");
        }
    }
    
    /**
     * 查询造型师的信息数据包括造型屋
     * @param 包括stylistId
     * @return 
     */
    public Map<String, String> findStylistByStylistId(long stylistId){
    	//stbStyHouseStylistMapper.selectStylistIdByStyHouseId(styHouseId);
    	return null;
    }
    
    /**
     * 造型师回复咨询
     * @param TbUserStylistAdvisory
     * @return 
     */
    public boolean updateAdvisoryByadvisoryId(TbUserStylistAdvisory tbUserStylistAdvisory){
    	return tbUserStylistAdvisoryMapper.updateAdvisoryByadvisoryId(tbUserStylistAdvisory);
    }
    
    /**
     * 联合查找造型屋和造型师
     * @param  stylistId
     * @return
     */
    public TbStyHouseStylist SelectTbStyHouseStylistBystylistId(long stylistId){
		return StylistMapper.SelectTbStyHouseStylistBystylistId(stylistId);
	}
    
    /**
     * 更新造型师
     * @param 
     * @return Response
     */
    public boolean updateStylistMessage(TbStyHouseStylist tbStyHouseStylist){
    	boolean update1=StylistMapper.updateStylistMessage1(tbStyHouseStylist.getTbStylist());
    	
        boolean update2=StylistMapper.updateStylistMessage2(tbStyHouseStylist);
    	return update1&&update2;
    }
}
