package com.istyle.service.impl;

import com.istyle.mapper.TbSubmissionMapper;
import com.istyle.mapper.TbUserMapper;
import com.istyle.pojo.TbSubmission;
import com.istyle.pojo.TbUser;
import com.istyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private TbSubmissionMapper tbSubmissionMapper;

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
    public TbUser selectFollerById(Long userId) {
        return tbUserMapper.selectPhotoNameWordById(userId);
    }
}
