package com.istyle.controller;

import com.istyle.pojo.TbStyHouse;
import com.istyle.service.StyHouseService;
import com.util.JWT;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: 黄文伟
 * @description: 造型屋注册及登录
 * @Date:Created in 19:52 2018/10/31
 */
@Controller
public class StyHouseRegisterAndLogin {
    @Autowired
    private StyHouseService styHouseService;

    /**
     * 造型屋注册
     * @param styHouse 造型屋数据
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/styHouseRegister", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response styHouseRegister(@RequestBody TbStyHouse styHouse) {
        styHouseService.styHouseRegister(styHouse);
        return Response.ok();
    }

    /**
     * 造型屋登录
     * @param styHouse 造型屋数据，包括账号密码
     * @return Response,包含stoken
     */
    @ResponseBody
    @RequestMapping(value = "/styHouseLogin", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response styHouseLogin(@RequestBody TbStyHouse styHouse) {
        Map param = styHouseService.styHouseLogin(styHouse);
        return Response.ok(param);
    }

    /**
     * 登录后跳转主页返回用户名
     * @param request
     * @return Response
     */
    @RequestMapping(value = "/afterStyHouseLogin", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response afterStyHouseLogin(@RequestBody Map<String, String> request) {
        TbStyHouse stylist = JWT.unsign(request.get("stoken"), TbStyHouse.class);
        Map param = styHouseService.afterLoginGetName(stylist);
        return Response.ok(param);
    }
}
