package com.istyle.service.impl;

import com.exception.AppAuthException;
import com.exception.AppUnknowException;
import com.istyle.mapper.TbStylistMapper;
import com.istyle.pojo.TbStylist;
import com.istyle.service.StylistService;
import com.util.CastUtil;
import com.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 造型师实现类
 * @author 黄文伟
 */
@Service
public class StylistServiceImpl implements StylistService {
    @Autowired
    private TbStylistMapper tbStylistMapper;

    /**
     * 造型师注册
     * @param tbStylist
     * @return
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
            throw new AppUnknowException("注册失败");
        }
    }
}
