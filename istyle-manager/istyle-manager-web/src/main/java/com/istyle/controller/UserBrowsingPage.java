package com.istyle.controller;

import com.istyle.service.UserService;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: 黄文伟
 * @description: 用户浏览页面
 * @Date:Created in 15:34 2019/1/16
 */
@Controller
public class UserBrowsingPage {
    @Autowired
    private UserService userService;

    /**
     * 用户浏览造型屋界面
     * @param request 造型屋地址
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/userBrowse/styHouseIndex", method = RequestMethod.POST, produces = {"application/json;charser=utf-8"})
    public Response userBrowseStyHousePage(Map<String, String> request) {
        String position = request.get("styHousePosition");
        Map temp = userService.browseStyHouse(position);
        return Response.ok(temp);
    }
}
