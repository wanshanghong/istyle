package com.istyle.mapper;

import com.istyle.pojo.TbUser;
import com.istyle.pojo.TbUserUser;

import java.util.List;

public interface TbUserUserMapper {
//    取消关注
    void updateUsersState(TbUserUser tbUserUser);

    //    根据id查询用户与用户的状态
    int selectUsersStateById(TbUserUser tbUserUser);

//    根据id2查询关注粉丝
    List<TbUser> selectUsersByUserId2(Long userId2);

//    根据id2查询粉丝数量
    Long selectFanCountByUserId2(Long userId2);

//    根据id2查询粉丝id
    List<Long> selectUserIdByUserId2(Long userId2);

//    增加关注
    void updateUsersState2(TbUserUser tbUserUser);

}
