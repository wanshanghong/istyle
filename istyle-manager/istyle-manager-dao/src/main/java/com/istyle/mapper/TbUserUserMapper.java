package com.istyle.mapper;

import com.istyle.pojo.TbUser;
import com.istyle.pojo.TbUserUser;

public interface TbUserUserMapper {
    void updateUsersState(TbUserUser tbUserUser);

    //    根据id查询用户与用户的状态
    int selectUsersStateById(TbUserUser tbUserUser);
}
