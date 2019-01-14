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
 * @description: 造型师主页
 * @Date:Created in 21:43 2018/10/31
 */
@Controller
@RequestMapping("/stylistHome")
public class StylistHomePage {
    @Autowired
    private StylistService stylistService;

    /**
     * 造型师主页展示
     * @param request 身份认证
     * @return Response，造型师数据
     */
    @ResponseBody
    @RequestMapping(value = "/index", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistHomePage(@RequestBody Map<String, String> request) {
        TbStylist stylist = JWT.unsign(request.get("stoken"), TbStylist.class);
        TbStylist param = stylistService.selectStylistById(stylist);
        return Response.ok(param);
    }
}
