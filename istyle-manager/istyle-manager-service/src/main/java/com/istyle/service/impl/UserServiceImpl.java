package com.istyle.service.impl;

import com.istyle.mapper.TbSubmissionMapper;
import com.istyle.mapper.TbUserMapper;
import com.istyle.mapper.TbUserUserMapper;
import com.istyle.pojo.TbSubmission;
import com.istyle.pojo.TbUser;
import com.istyle.pojo.TbUserUser;
import com.istyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private TbUserUserMapper tbUserUserMapper;

    //注册用户
    @Override
    public void insertUser(TbUser user){
            tbUserMapper.insertUser(user);
    }

    //判断号码是否存在
    @Override
    public boolean isUserName(String userName) {
        if (tbUserMapper.isUserName(userName) == 0)
            return false; //存在
        else
            return true; //不存在
    }
    @Override
    public Long loginUser(TbUser user) {
        if (tbUserMapper.isNameAndPassword(user) == 1)
            return tbUserMapper.loginUser(user); //返回ID
        else
            return Long.valueOf(-1);
    }

//    修改用户信息
    @Override
    public void updateUser(TbUser user) {
        tbUserMapper.updateById(user);
    }

    @Override
    public TbUser selectUserById(Long userId) {
        return tbUserMapper.selectUserById(userId);
    }

    @Override
    public List<TbUser> selectFollersById(Long userId) {
        List<TbUser> users = tbUserMapper.selectPhotoNameWordById(userId);
        return users;
    }

    @Override
    public Long selectUserCountById(Long userId) {
        return tbUserMapper.selectUserCountById(userId);
    }

    @Override
    public int unFoller(Long userId, Long userId2) {
        TbUserUser tbUserUser = new TbUserUser();
        tbUserUser.setUserId(userId);
        tbUserUser.setUserId2(userId2);
         tbUserUserMapper.updateUsersState(tbUserUser);
         int flag = tbUserUserMapper.selectUsersStateById(tbUserUser);

         if (flag == 1){
             return 0;
         }
         else {
             return 1;
         }
    }

    /**
     * 我的粉丝页面展示
     * @param userId2
     * @return fanCount
     * @return users
     * @return usersState
     * @return fans
     */
    @Override
    public Map myFansPage(Long userId2) {
        Long fanCount;
        List<TbUser> users ;
        List<Integer> usersState = new ArrayList<>();
        Map<String, List> fans = new HashMap<>();
        TbUserUser tbUserUser = new TbUserUser();
        List<Long> userId;
        int flag;

//        获取粉丝数量
        fanCount = tbUserUserMapper.selectFanCountByUserId2(userId2);
//        获取粉丝
        users =tbUserUserMapper.selectUsersByUserId2(userId2);
//        获取粉丝id
        userId = tbUserUserMapper.selectUserIdByUserId2(userId2);

//        获取粉丝是否关注
        tbUserUser.setUserId2(userId2);
        for (Long id :
                userId) {
            tbUserUser.setUserId(id);
            System.out.println(id);
            flag = tbUserUserMapper.selectUsersStateById(tbUserUser);
            System.out.println(flag);
            usersState.add(flag);
        }

        /*Iterator<Long> iterator = userId.iterator();
        while (iterator.hasNext()) {
            tbUserUser.setUserId(Long.valueOf(String.valueOf(iterator)));
            System.out.println(Long.valueOf(String.valueOf(iterator)));
            usersState.add(tbUserUserMapper.selectUsersStateById(tbUserUser));
        }*/

        fans.put("fanCount", Collections.singletonList(fanCount));
        fans.put("users", users);
        fans.put("usersState", usersState);

        return fans;
    }
}
