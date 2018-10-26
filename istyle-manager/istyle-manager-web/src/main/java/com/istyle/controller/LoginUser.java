package com.istyle.controller;

import com.alibaba.fastjson.JSON;
import com.istyle.pojo.TbUser;
import com.istyle.service.UserService;
import com.util.CollectionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户登录
 * @author 黄文伟
 */
@Controller
public class LoginUser {
    @Autowired
    private UserService userService;

    /**
     * 用户登录操作
     * @param data
     * @return 0
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public int loginUser(@RequestBody String data) {
        System.out.println(data);
        TbUser tbUser = JSON.parseObject(data, TbUser.class);
        userService.loginUser(tbUser);
        return 0;
    }
}
