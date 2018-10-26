package com.istyle.service.impl;

import com.istyle.mapper.TbStyHouseMapper;
import com.istyle.pojo.TbStyHouse;
import com.istyle.service.StyHouseService;
import com.istyle.service.util.PublicUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 造型屋实现接口
 * @author 黄文伟
 */
@Service
public class StyHouseServiceImpl implements StyHouseService {
    PublicUtil publicUtil;
    @Autowired
    private TbStyHouseMapper tbStyHouseMapper;

    /**
     * 根据id查询造型屋数量
     * @param userId
     * @return
     */
    @Override
    public Long selectStyHouseCountByUserId(Long userId) {
        return tbStyHouseMapper.selectStyHouseCountByUserId(userId);
    }

    /**
     * 根据id查询造型屋
     * @param userId
     * @return
     */
    @Override
    public List<TbStyHouse> selectStyHouseByUserId(Long userId) {
        return tbStyHouseMapper.selectStyHouseByUserId(userId);
    }

    /**
     * 造型屋注册
     * @param tbStyHouse
     * @return
     */
    @Override
    public void styHouseRegister(TbStyHouse tbStyHouse) {
        if (publicUtil.isEmpty(tbStyHouse.getStyHouseName())) {
            System.out.println("造型屋名为空");
        }
        if (publicUtil.isEmpty(tbStyHouse.getStyHouseAccount())) {
            System.out.println("造型屋账号为空");
        }
        if (publicUtil.isEmpty(tbStyHouse.getStyHousePassword())) {
            System.out.println("造型屋密码为空");
        }
        if (publicUtil.isEmpty(tbStyHouse.getHeadName())) {
            System.out.println("造型屋负责人姓名为空");
        }
        if (publicUtil.isEmpty(tbStyHouse.getHeadId())) {
            System.out.println("造型屋负责人身份证为空");
        }
        if (publicUtil.isEmpty(tbStyHouse.getHeadPhone())) {
            System.out.println("造型屋负责人号码为空");
        }
        if (publicUtil.isEmpty(tbStyHouse.getStyHousePosition())) {
            System.out.println("造型屋位置为空");
        }

        tbStyHouseMapper.addStyHouse(tbStyHouse);
    }
}
