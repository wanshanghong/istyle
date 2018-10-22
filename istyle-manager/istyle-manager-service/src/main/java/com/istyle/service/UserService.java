package com.istyle.service;

import com.istyle.pojo.TbUser;
import com.istyle.pojo.TbUserUser;

import java.util.List;
import java.util.Map;

/**
 * @author 黄文伟
 */
public interface UserService {

    /**
     * 注册用户
     * @param user
     */
    void insertUser(TbUser user);

    /**
     * 判断用户是否存在
     * @param userName
     * @return
     */
    boolean isUserName(String userName);

    /**
     * 登录用户
     * @param user
     * @return
     * @throws Exception
     */
    TbUser loginUser(TbUser user);

    /**
     * 用户编辑信息
     * @param user
     */
    void updateUser(TbUser user);

    /**
     * 查询用户信息
     * @param userId
     * @return
     */
    TbUser selectUserById(Long userId);

    /**
     * 查询我的关注
     * @param userId
     * @return
     */
    List<TbUser> selectFollersById(Long userId);

    /**
     * 通过id查询用户数量
     * @param userId
     * @return
     */
    Long selectUserCountById(Long userId);


    /**
     * 取消关注
     * @param userId
     * @param userId2
     * @return
     */
    int unFoller(Long userId, Long userId2);

    /**
     * 我的粉丝展示
     * @param userId2
     * @return
     */
    Map myFansPage(Long userId2);

    /**
     * 关注用户
     * @param tbUserUser
     * @return
     */
    int addFoller(TbUserUser tbUserUser);

    /**
     * 我的投稿界面展示
     * @param userId
     * @return
     */
    Map mySubmission(Long userId);
}