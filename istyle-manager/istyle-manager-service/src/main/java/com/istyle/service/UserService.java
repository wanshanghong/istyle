package com.istyle.service;

import com.istyle.pojo.TbSubmission;
import com.istyle.pojo.TbUser;

import java.util.List;

public interface UserService {
    //注册用户
    void insertUser(TbUser user);
    //判断用户是否存在
    boolean isUserName(String userName);
    //登录用户
    Long loginUser(TbUser user);
//    用户编辑信息
    void updateUser(TbUser user);
//    查询用户信息
    TbUser selectUserById(Long userId);
//    查询我的关注
    TbUser selectFollerById(Long userId);
}
