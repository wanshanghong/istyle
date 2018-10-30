package com.istyle.controller;

import com.istyle.pojo.TbUser;
import com.istyle.service.UserService;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 用户登录
 * @author 黄文伟
 */
@Controller
public class UserLogin {
    @Autowired
    private UserService userService;

    /**
     * 用户登录操作
     * @param
     * @return 0
     */
    @RequestMapping(value = "/userLogin", method = RequestMethod.POST)
    @ResponseBody
    public Response loginUser(@RequestBody TbUser user) {
        Map param = userService.loginUser(user);
        return Response.ok(param);
    }
}
