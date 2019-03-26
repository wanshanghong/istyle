package com.istyle.controller;

import com.istyle.pojo.TbStyHouse;
import com.istyle.service.StyHouseService;
import com.util.JWT;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 21:49 2019/3/26
 */
@Controller
@RequestMapping("/styHouseHome")
public class StyHouseHomePage {
    @Autowired
    private StyHouseService styHouseService;

    @RequestMapping(value = "/index", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Response styHouseIndex(@RequestBody Map<String, String> request) {
        TbStyHouse styHouse = JWT.unsign(request.get("stoken"), TbStyHouse.class);
        System.out.println("stoken: "+request.get("stoken"));
        TbStyHouse param = styHouseService.showStyHouseIndex(styHouse);
        return Response.ok(param);
    }
}
