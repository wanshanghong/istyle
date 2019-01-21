package com.istyle.service.impl;

import com.exception.AppAuthException;
import com.istyle.mapper.TbStyHouseMapper;
import com.istyle.mapper.TbStyHousePackageMapper;
import com.istyle.mapper.TbStyHouseStylistMapper;
import com.istyle.mapper.TbStylistMapper;
import com.istyle.pojo.TbStyHouse;
import com.istyle.pojo.TbStyHousePackage;
import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUser;
import com.istyle.service.UserBrowseService;
import com.util.CastUtil;
import com.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
                //遍历造型师，获得每个造型师的数据
                for (int j = 0; j < stylistId.size(); j++) {
                    stylists = tbStylistMapper.selectPhotoAndNameById(stylistId.get(j));
                    // 如果容器多于4个，就跳出外循环
                    if (stylists.size() > 4) {
                        break outer;
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
            TbStyHouse styHouse;
            List<TbStyHousePackage> discountPackage;

            styHouse = tbStyHouseMapper.selectNamePhotoPackagePhoneTimeWordByStyHouseId(styHouseId);
            discountPackage = tbStyHousePackageMapper.selectAllPackageByStyHouseId(styHouseId);

            map.put("styHouse", Collections.singletonList(styHouse));
            map.put("discountPackage", discountPackage);

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
    public TbStylist selectStylistById(Long stylistId) {
        TbStylist tbStylist;

        if (StringUtil.isNotEmpty(CastUtil.castString(stylistId))) {
            tbStylist = tbStylistMapper.selectStylistById(stylistId);
        }
        else {
            throw new AppAuthException("在我的信息展示时，发现造型师id为空，操作错误。");
        }

        return tbStylist;
    }

    /**
     * 造型师展示
     * @param stylistId
     * @return
     */
    @Override
    public Map showStylistFans(Long stylistId) {
        if (StringUtil.isNotEmpty(stylistId.toString())) {
            Map<String, List> map = new HashMap<>(16);
            TbStylist stylist;
            List<TbUser> fans;

            stylist = tbStylistMapper.selectPhotoNameSexWord(stylistId);
            fans = tbStylistMapper.selectFansBystylistId(stylistId);

            map.put("stylist", Collections.singletonList(stylist));
            map.put("fans", fans);

            return map;
        } else {
            throw new AppAuthException("造型师Id为空。");
        }
    }
}
