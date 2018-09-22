package com.istyle.service;

import com.istyle.pojo.TbSubmission;
import com.istyle.pojo.TbUser;
import com.istyle.pojo.TbUserUser;

import java.util.List;
import java.util.Map;

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
    List<TbUser> selectFollersById(Long userId);

    Long selectUserCountById(Long userId);

//      取消关注
    int unFoller(Long userId, Long userId2);

//    我的粉丝展示
    Map myFansPage(Long userId2);

//     关注用户
    int addFoller(TbUserUser tbUserUser);

//    我的投稿界面展示
    Map mySubmission(Long userId);
}