package com.istyle.controller;

import com.istyle.pojo.TbStylist;
import com.istyle.service.StylistService;
import com.util.JWT;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: 黄文伟
 * @description: 造型师注册及登录
 * @Date:Created in 22:17 2018/10/30
 */
@Controller
public class StylistRegisterAndLogin {
    @Autowired
    private StylistService stylistService;

    /**
     * 造型师注册
     * @param stylist 造型师数据，包括昵称、姓名、密码、性别、年龄、号码
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/stylistRegister", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistRegister(@RequestBody TbStylist stylist) {
        stylistService.stylistRegister(stylist);
        return Response.ok();
    }

    /**
     * 造型师登录
     * @param stylist 造型师数据，包括号码和密码
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/stylistLogin", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistLogin(@RequestBody TbStylist stylist) {
    	System.out.println("stylist:"+stylist.toString());
        Map param = stylistService.stylistLogin(stylist);
        return Response.ok(param);
    }

    /**
     * 登录后跳转主页返回用户名
     * @param request 身份认证
     * @return Response
     */
    @RequestMapping(value = "/afterStylistLogin", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public Response afterStylistLogin(@RequestBody Map<String, String> request) {
        TbStylist stylist = JWT.unsign(request.get("stoken"), TbStylist.class);
        Map param = stylistService.afterLoginGetName(stylist);
        return Response.ok(param);
    }
}
