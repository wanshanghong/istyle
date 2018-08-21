package com.istyle.service.impl;

import com.istyle.mapper.TbStyHouseMapper;
import com.istyle.pojo.TbStyHouse;
import com.istyle.service.StyHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StyHouseServiceImpl implements StyHouseService {
    @Autowired
    private TbStyHouseMapper tbStyHouseMapper;

    @Override
    public Long selectStyHouseCountByUserId(Long userId) {
        return tbStyHouseMapper.selectStylistCountByUserId(userId);
    }

    @Override
    public List<TbStyHouse> selectStyHouseByUserId(Long userId) {
        return tbStyHouseMapper.selectStyHouseByUserId(userId);
    }
}
