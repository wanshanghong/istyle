package com.istyle.service.impl;

import com.exception.AppAuthException;
import com.exception.AppUnknownException;
import com.istyle.mapper.TbStylistMapper;
import com.istyle.mapper.TbUserStylistMapper;
import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUser;
import com.istyle.pojo.TbUserStylist;
import com.istyle.service.StylistService;
import com.util.CastUtil;
import com.util.JWT;
import com.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 造型师实现类
 * @author 黄文伟
 */
@Service
public class StylistServiceImpl implements StylistService {
    @Autowired
    private TbStylistMapper tbStylistMapper;
    @Autowired
    private TbUserStylistMapper tbUserStylistMapper;

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
        if (tbStylistMapper.isPhoneAndPassword(tbStylist) != 0) {
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
     * 查询造型师信息数据并返回
     * @param id id
     * @return stylist 造型师数据
     */
    @Override
    public TbStylist selectStylistById(long id) {
        TbStylist tbStylist;

        if (StringUtil.isNotEmpty(CastUtil.castString(id))) {
            tbStylist = tbStylistMapper.selectStylistHomeById(id);
        }
        else {
            throw new AppAuthException("在我的信息展示时，发现造型师id为空，操作错误。");
        }

        return tbStylist;
    }

    /**
     * 根据id查询粉丝数据
     * @param id id
     * @return result 造型师数据、粉丝数据、粉丝数
     */
    @Override
    public Map<String, List> selectFansById(long id) {
        TbStylist tbStylist;
        List<TbUser> fans;
        long fanCount;
        Map<String, List> result = null;

        if (StringUtil.isNotEmpty(CastUtil.castString(id))) {
            tbStylist = tbStylistMapper.selectPhotoNameWordSexById(id);
            fanCount = tbUserStylistMapper.selectFanCountById(id);

            result.put("stylist", (List) tbStylist);
            result.put("fanCount", Collections.singletonList(fanCount));

            if (fanCount != 0) {
                fans = tbUserStylistMapper.selectStylistFanById(id);
                result.put("fans", fans);
            } else {
                result.put("fans", null);
            }
            return result;
        } else {
            throw new AppAuthException("在查询造型师粉丝时，id为空，操作错误");
        }
    }

    /**
     * 关注造型师
     * @param user 用户id
     * @param stylistId 造型师id
     */
    @Override
    public void addAttention(TbUser user, long stylistId) {
        long id = user.getUserId();
        // 用户与造型师状态，0为关注，1为未关注
        Integer status;
        TbUserStylist userStylist = new TbUserStylist();

        if (StringUtil.isEmpty(CastUtil.castString(id))) {
            throw new AppAuthException("在添加造型师关注时发现用户id为空，操作错误");
        }
        if (StringUtil.isEmpty(CastUtil.castString(stylistId))) {
            throw new AppAuthException("在添加造型师关注时发现造型师id为空，操作错误");
        }

        userStylist.setUserId(id);
        userStylist.setStylistId(stylistId);

        status = tbUserStylistMapper.selectStatusByUserIdAndStylistId(userStylist);

        if (status == null) {
            tbUserStylistMapper.insertStatusByUserIdAndStylistId(userStylist);
        } else {
            if (status == 0) {
                throw new AppAuthException("该造型师已关注，请勿重复操作");
            } else {
                tbUserStylistMapper.updateStatusTo0ByUserIdAndStylistId(userStylist);
            }
        }

        // 重新检查是否添加成功，否则抛出异常
        status = tbUserStylistMapper.selectStatusByUserIdAndStylistId(userStylist);
        if (status != 0) {
            throw new AppAuthException("关注失败，请重新关注");
        }
    }
}
