package com.istyle.mapper;

import com.istyle.pojo.TbUser;
import com.istyle.pojo.TbUserUser;

import java.util.List;

public interface TbUserUserMapper {
//    取消关注
    void updateUsersStateTo1(TbUserUser tbUserUser);

    //    根据id查询用户与用户的状态
    Integer selectUsersStateById(TbUserUser tbUserUser);

//    根据id2查询关注粉丝
    List<TbUser> selectUsersByUserId2(Long userId2);

//    根据id2查询粉丝数量
    Long selectFanCountByUserId2(Long userId2);

//    根据id2查询粉丝id
    List<Long> selectUserIdByUserId2(Long userId2);

//    修改用户关注
    void updateUsersStateTo0(TbUserUser tbUserUser);

//    增加用户关注
    void addUserStateTo0(TbUserUser tbUserUser);
}
