package com.istyle.mapper;

import com.istyle.pojo.TbUser;
import com.istyle.pojo.TbUserUser;

import java.util.List;

/**
 * @author 黄文伟
 */
public interface TbUserUserMapper {

    /**
     * 取消关注
     * @param tbUserUser
     */
    void updateUsersStateTo1(TbUserUser tbUserUser);

    /**
     * 根据id查询用户与用户的状态
     * @param tbUserUser
     * @return
     */
    Integer selectUsersStateById(TbUserUser tbUserUser);

    /**
     * 根据id2查询关注粉丝
     * @param userId2
     * @return
     */
    List<TbUser> selectUsersByUserId2(Long userId2);

    /**
     * 根据id2查询粉丝数量
     * @param userId2
     * @return
     */
    Long selectFanCountByUserId2(Long userId2);

    /**
     * 根据id2查询粉丝id
     * @param userId2
     * @return
     */
    List<Long> selectUserIdByUserId2(Long userId2);

    /**
     * 修改用户关注
     * @param tbUserUser
     */
    void updateUsersStateTo0(TbUserUser tbUserUser);

    /**
     * 增加用户关注
     * @param tbUserUser
     */
    void addUserStateTo0(TbUserUser tbUserUser);
}
