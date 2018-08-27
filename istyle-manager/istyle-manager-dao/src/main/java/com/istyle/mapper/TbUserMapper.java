package com.istyle.mapper;

import com.istyle.pojo.TbUser;

public interface TbUserMapper {
    //注册用户
    void insertUser(TbUser user);
    //判断号码是否使用，返回数量
    int isUserName(String userPhone);
//    判断账号密码是否正确，返回数量
    int isNameAndPassword(TbUser user);
    //登录用户
    Long loginUser(TbUser user);
//    根据号码返回ID
    Long selectIdByPhone(String userPhone);
//    通过id修改信息
    void updateById(TbUser user);
//    通过id获取用户资料
    TbUser selectUserById(Long userId);
//    通过id获取图片、昵称、签名
    TbUser selectPhotoNameWordById(Long userId);
}
