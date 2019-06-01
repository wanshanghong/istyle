package com.istyle.service.impl;

import com.exception.AppAuthException;
import com.exception.AppUnknownException;
import com.istyle.mapper.TbStyHouseMapper;
import com.istyle.mapper.TbStyHouseStylistMapper;
import com.istyle.pojo.TbStyHouse;
import com.istyle.pojo.TbStyHousePackage;
import com.istyle.pojo.TbStyHouseStylist;
import com.istyle.service.StyHouseService;
import com.util.JWT;
import com.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 造型屋实现接口
 * @author 黄文伟
 */
@Service
public class StyHouseServiceImpl implements StyHouseService {
    @Autowired
    private TbStyHouseMapper styHouseMapper;
    @Autowired
    private TbStyHouseStylistMapper tbStyHouseStylistMapper;

    /**
     * 造型屋注册
     * @param StyHouse 造型屋数据，包括名字、账号、密码、负责人姓名、负责人身份证、负责人电话、地理位置
     */
    @Override
    public void styHouseRegister(TbStyHouse StyHouse) {
        if (StringUtil.isEmpty(StyHouse.getStyHouseName())) {
            throw new AppAuthException("造型屋名为空");
        }
        if (StringUtil.isEmpty(StyHouse.getStyHouseAccount())) {
            throw new AppAuthException("造型屋账号为空");
        }
        if (StringUtil.isEmpty(StyHouse.getStyHousePassword())) {
            throw new AppAuthException("造型屋密码为空");
        }
        if (StringUtil.isEmpty(StyHouse.getHeadName())) {
            throw new AppAuthException("造型屋负责人姓名为空");
        }
        if (StringUtil.isEmpty(StyHouse.getHeadId())) {
            throw new AppAuthException("造型屋负责人身份证为空");
        }
        if (StringUtil.isEmpty(StyHouse.getHeadPhone())) {
            throw new AppAuthException("造型屋负责人号码为空");
        }
        if (StringUtil.isEmpty(StyHouse.getStyHousePosition())) {
            throw new AppAuthException("造型屋位置为空");
        }
        if (styHouseMapper.isStyHouseAccount(StyHouse.getStyHouseAccount()) != 0) {
            throw new AppAuthException("该账号已注册");
        }

        styHouseMapper.addStyHouse(StyHouse);

        if (styHouseMapper.isAccountAndPassword(StyHouse) == 0) {
            throw new AppUnknownException("造型屋注册失败");
        }
    }

    @Override
    public Map styHouseLogin(TbStyHouse styHouse) {
        Map<String, String> stokenMap;
        System.out.println(2);

        if (StringUtil.isEmpty(styHouse.getStyHouseAccount())) {
            throw new AppAuthException("账号为空");
        }
        if (StringUtil.isEmpty(styHouse.getStyHousePassword())) {
            throw new AppAuthException("密码为空");
        }
        if (styHouseMapper.isAccountAndPassword(styHouse) != 1) {
            throw new AppAuthException("账号密码错误，登录失败");
        }
        if (styHouseMapper.isStyHouseAccount(styHouse.getStyHouseAccount()) != 1) {
            throw new AppAuthException("号码错误");
        }

        TbStyHouse tbStyHouse = styHouseMapper.selectStyHouseByAccountAndPassword(styHouse);
        if (tbStyHouse == null) {
            throw new AppUnknownException("登录错误");
        }

        String stoken = JWT.sign(tbStyHouse, 24L * 3600L * 30L);

        if (StringUtil.isNotEmpty(stoken)) {
            stokenMap = new HashMap<>(16);
            stokenMap.put("stoken", stoken);
            return stokenMap;
        } else {
            throw new AppUnknownException("stoken获取失败，造型屋登录错误");
        }
    }

    /**
     * 登录后跳转主页返回用户名
     * @param styHouse id
     * @return styHouseName
     */
    @Override
    public Map<String, String> afterLoginGetName(TbStyHouse styHouse) {
        String styHouseName;

        styHouseName = styHouse.getStyHouseName();
        if (StringUtil.isEmpty(styHouseName)) {
            throw new AppAuthException("登陆失败，请重新登陆");
        }
        if (styHouseName.equals(styHouseMapper.selectStyHouseNameById(styHouse.getStyHouseId()))) {
            Map<String, String> map = new HashMap<>(16);
            map.put("styHouseName", styHouseName);
            return map;
        } else {
            throw new AppAuthException("登陆失败，请重新登陆");
        }
    }

    @Override
    public TbStyHouse showStyHouseIndex(TbStyHouse styHouse) {
        long styHouseId = styHouse.getStyHouseId();
        TbStyHouse param;
        param = styHouseMapper.selectIndexById(styHouseId);
        return param;
    }

    @Override
    public TbStyHouse showEditMessage(long styHouseId) {
        TbStyHouse param;
        param = styHouseMapper.selectIndexById(styHouseId);
        return param;
    }

    @Override
    public void updateEditMessage(TbStyHouse tbStyHouse) {
        if (tbStyHouse == null) {
            throw new AppAuthException("更新失败");
        }

        styHouseMapper.updateStyHouse(tbStyHouse);
    }

    @Override
    public Map showPackageManager(Long styHouseId) {
        if (styHouseId == null || styHouseId == 0) {
            throw new AppAuthException("显示失败");
        }

        List<TbStyHousePackage> packages = styHouseMapper.selectPackageList(styHouseId);
        int packageCount = styHouseMapper.selectPackageCount(styHouseId);

        Map<String, Object> result = new HashMap<>(16);
        result.put("packageCount", packageCount);
        result.put("packages", packages);

        return result;
    }

    @Override
    public boolean submitPackage(TbStyHousePackage tbStyHousePackage) {
        if (tbStyHousePackage == null) {
            throw new AppAuthException("发布失败1");
        }

        int flag = styHouseMapper.insertPackage(tbStyHousePackage);

        if (flag > 0) {
            return true;
        } else {
            throw new AppAuthException("发布失败2");
        }
    }

    @Override
    public TbStyHousePackage showeditPackage(TbStyHousePackage tbStyHousePackage) {
        if (tbStyHousePackage == null) {
            throw new AppAuthException("编辑失败1");
        }
        long styHouseId = tbStyHousePackage.getStyHouseId();
        long packageId = tbStyHousePackage.getPackageId();
        TbStyHousePackage styHousePackage = styHouseMapper.selectPackageById(styHouseId, packageId);

        return styHousePackage;
    }

    @Override
    public boolean submitEditPackage(TbStyHousePackage tbStyHousePackage) {
        if (tbStyHousePackage == null) {
            throw new AppAuthException("修改套餐失败1");
        }
        int flag = styHouseMapper.updatePackage(tbStyHousePackage);
        if (flag > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deletePackage(TbStyHousePackage tbStyHousePackage) {
        if (tbStyHousePackage == null) {
            throw new AppAuthException("删除套餐失败1");
        }
        long styHouseId = tbStyHousePackage.getStyHouseId();
        long packageId = tbStyHousePackage.getPackageId();
        int flag = styHouseMapper.deletePackage(styHouseId, packageId);
        if (flag > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Map selectStylistManager(Long styHouseId) {
        if (styHouseId == null || styHouseId == 0) {
            throw new AppAuthException("造型师展示失败");
        }
        List<TbStyHouseStylist> stylists = tbStyHouseStylistMapper.selectStylistList(styHouseId);
        long stylistCount = tbStyHouseStylistMapper.selectStylistCount(styHouseId);

        Map<String, Object> result = new HashMap<>(16);
        result.put("stylistCount", stylistCount);
        result.put("stylists", stylists);

        return result;
    }

    @Override
    public TbStyHouseStylist selectStylist(TbStyHouseStylist tbStyHouseStylist) {
        if (tbStyHouseStylist == null) {
            throw new AppAuthException("造型师编辑展示失败1");
        }
        long styHouseId = tbStyHouseStylist.getStyHouseId();
        long stylistId = tbStyHouseStylist.getStylistId();
        TbStyHouseStylist result = tbStyHouseStylistMapper.selectStylist(styHouseId, stylistId);

        return result;
    }

    @Override
    public boolean submitEditStylist(TbStyHouseStylist tbStyHouseStylist) {
        if (tbStyHouseStylist == null) {
            throw new AppAuthException("造型师信息修改失败1");
        }
        int flae = tbStyHouseStylistMapper.updateStylist(tbStyHouseStylist);
        if (flae > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean submitStylist(TbStyHouseStylist tbStyHouseStylist) {
        if (tbStyHouseStylist == null) {
            throw new AppAuthException("造型师发布失败1");
        }
        int flae = tbStyHouseStylistMapper.insertStylist(tbStyHouseStylist);
        if (flae > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteStylist(TbStyHouseStylist tbStyHouseStylist) {
        if (tbStyHouseStylist == null) {
            throw new AppAuthException("造型师删除失败1");
        }
        long styHouseId = tbStyHouseStylist.getStyHouseId();
        long stylistId = tbStyHouseStylist.getStylistId();
        int flae = tbStyHouseStylistMapper.deleteStylist(styHouseId, stylistId);
        if (flae > 0) {
            return true;
        } else {
            return false;
        }
    }
}
