package com.istyle.service.impl;

import com.istyle.mapper.TbStylistMapper;
import com.istyle.pojo.TbStylist;
import com.istyle.service.StylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StylistServiceImpl implements StylistService {
    @Autowired
    private TbStylistMapper tbStylistMapper;

    @Override
    public Long selectStylistCountByUserId(Long userId) {
        Long id = tbStylistMapper.selectStylistCountByUserId(userId);
        return id;
    }

    @Override
    public List<TbStylist> selectStylistByUserId(Long userId) {
        List<TbStylist> stylists = tbStylistMapper.selectStylistByUserId(userId);
        return stylists;
    }
}
