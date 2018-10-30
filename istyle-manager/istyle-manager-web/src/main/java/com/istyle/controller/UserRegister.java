package com.istyle.controller;

import com.istyle.pojo.TbUser;
import com.istyle.service.UserService;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 用户注册
 * @author 黄文伟
 */
@Controller
public class UserRegister {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Response register(@RequestBody TbUser user) {
        userService.insertUser(user);
        return Response.ok();
    }
}
