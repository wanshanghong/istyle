package com.istyle.service;

import com.istyle.pojo.TbUser;

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
     * 登录用户
     * @param user
     * @return Map
     */
    Map loginUser(TbUser user);

    /**
     * 通过ID获得用户信息，用于我的信息展示
     * @param user 用户数据
     * @return TbUser
     */
    TbUser selectUserByUserId(TbUser user);

    /**
     * 用户编辑信息
     * @param user1 修改前数据
     * @param user2 修改后数据
     */
    void updateUser(TbUser user1, TbUser user2);

    /**
     * 查询我的收藏数据
     * @param user 用户数据
     * @return Map
     */
    Map selectCollection(TbUser user);

    /**
     * 查询我的关注
     * @param user 用户数据
     * @return
     */
    Map selectAttentionsById(TbUser user);

    /**
     * 取消关注
     * @param user 用户数据
     * @param id2 被取消关注用户id
     */
    void unFollow(TbUser user, long id2);

    /**
     * 我的粉丝展示
     * @param user 用户数据
     * @return Map
     */
    Map myFansPage(TbUser user);

    /**
     * 关注用户
     * @param user 用户数据
     * @Param id2 被关注用户id
     */
    void addFollow(TbUser user, long id2);

    /**
     * 我的投稿界面展示
     * @param user 用户数据
     * @return Map
     */
    Map mySubmission(TbUser user);
}