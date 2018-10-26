package com.istyle.mapper;

import com.istyle.pojo.TbUser;

import java.util.List;

/**
 * @author 黄文伟
 */
public interface TbUserMapper {

    /**
     * 注册用户
     * @param user
     */
    void insertUser(TbUser user);

    /**
     * 判断号码是否使用，返回数量
     * @param userPhone
     * @return
     */
    int isUserName(String userPhone);

    /**
     * 判断账号密码是否正确，返回数量
     * @param user
     * @return
     */
    int isNameAndPassword(TbUser user);

    /**
     * 登录用户
     * @param user
     * @return
     */
    TbUser loginUser(TbUser user);

    /**
     * 根据号码返回ID
     * @param userPhone
     * @return
     */
    Long selectIdByPhone(String userPhone);

    /**
     * 通过id修改信息
     * @param user
     */
    void updateById(TbUser user);

    /**
     * 通过id获取用户资料
     * @param userId
     * @return
     */
    TbUser selectUserById(Long userId);

    /**
     * 通过id获取图片、昵称、签名
     * @param userId
     * @return
     */
    List<TbUser> selectPhotoNameWordById(Long userId);

    /**
     * 根据ID返回数目
     * @param userId
     * @return
     */
    Long selectUserCountById(Long userId);
}
