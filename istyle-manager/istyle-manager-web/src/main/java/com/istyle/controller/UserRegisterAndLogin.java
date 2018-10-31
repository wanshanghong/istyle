package com.istyle.controller;

import com.istyle.pojo.TbUser;
import com.istyle.service.UserService;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * 用户注册及登录
 * @author 黄文伟
 */
@Controller
public class UserRegisterAndLogin {
    @Autowired
    private UserService userService;

    /**
     *
     * @param user 用户数据，包括昵称、号码、密码、性别、年龄
     * @return Response
     */
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response register(@RequestBody TbUser user) {
        userService.insertUser(user);
        return Response.ok();
    }

    /**
     * 用户登录操作
     * @param user 用户数据，包括号码和密码
     * @return Response
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response loginUser(@RequestBody TbUser user) {
        Map param = userService.loginUser(user);
        return Response.ok(param);
    }
}
