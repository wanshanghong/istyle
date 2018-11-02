package com.istyle.controller;

import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUser;
import com.istyle.service.StylistService;
import com.util.JWT;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: 黄文伟
 * @description: 用户查看造型师界面
 * @Date:Created in 21:43 2018/10/31
 */
@Controller
@RequestMapping("/stylistPage")
public class StylistPage {
    @Autowired
    private StylistService stylistService;

    /**
     * 造型师主页展示
     * @param id 造型师id
     * @return Response，造型师数据
     */
    @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistHomePage(@RequestParam("stylistId") long id) {
        TbStylist param = stylistService.selectStylistById(id);
        return Response.ok(param);
    }

    @ResponseBody
    @RequestMapping(value = "/AddAttention", method = RequestMethod.POST, produces = {"applicatiopn/json;charset=UTF-8"})
    public Response addAttention(@RequestParam("stoken") String stoken, @RequestParam("stylistId") long stylistId) {
        TbUser user = JWT.unsign(stoken, TbUser.class);
        stylistService.addAttention(user, stylistId);
        return Response.ok();
    }

    /**
     * 造型师粉丝展示
     * @param id 造型师id
     * @return Response 粉丝数据
     */
    @ResponseBody
    @RequestMapping(value = "/stylistFan", method = RequestMethod.POST, produces = {"application/json;charset=UF-8"})
    public Response stylistFanPage(@RequestParam("stylistId") long id) {
        Map param = stylistService.selectFansById(id);
        return Response.ok(param);
    }
}
