package com.istyle.service.impl;

import com.istyle.mapper.TbStylistMapper;
import com.istyle.pojo.TbStylist;
import com.istyle.service.StylistService;
import com.istyle.service.util.PublicUtil;
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
    private PublicUtil publicUtil;

    /**
     * 根据id查询造型师数量
     * @param userId
     * @return
     */
    @Override
    public Long selectStylistCountByUserId(Long userId) {
        Long id = tbStylistMapper.selectStylistCountByUserId(userId);
        return id;
    }

    /**
     * 根据id查询造型师
     * @param userId
     * @return
     */
    @Override
    public List<TbStylist> selectStylistByUserId(Long userId) {
        List<TbStylist> stylists = tbStylistMapper.selectStylistByUserId(userId);
        return stylists;
    }

    /**
     * 造型师注册
     * @param tbStylist
     * @return
     */
    @Override
    public void stylistRegister(TbStylist tbStylist) {
        if (publicUtil.isEmpty(tbStylist.getStylistName())){
            System.out.printf("造型师昵称为空");
        }
        if (publicUtil.isEmpty(tbStylist.getRealName())) {
            System.out.println("真实姓名为空");
        }
        if (publicUtil.isEmpty(tbStylist.getStylistPassword())) {
            System.out.println("密码为空");
        }
        if (publicUtil.isEmpty(tbStylist.getStylistPhone())) {
            System.out.println("手机为空");
        }
        tbStylistMapper.addStylist(tbStylist);
    }
}
