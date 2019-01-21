package com.istyle.controller;

import com.istyle.pojo.TbStylist;
import com.istyle.service.StylistService;
import com.istyle.service.UserBrowseService;
import com.istyle.service.UserService;
import com.util.CastUtil;
import com.util.JWT;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @Author: 黄文伟
 * @description: 用户浏览页面
 * @Date:Created in 15:34 2019/1/16
 */
@Controller
@RequestMapping("/userBrowse")
public class UserBrowsingPage {
    @Autowired
    private UserService userService;
    @Autowired
    private StylistService stylistService;
    @Autowired
    private UserBrowseService userBrowseService;

    /**
     * 用户浏览造型屋界面
     * @param request 造型屋地址
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/styHouse", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userBrowseStyHousePage(@RequestBody Map<String, String> request) {
        String position = request.get("styHousePosition");
        System.out.println(position);
        Map temp = userBrowseService.browseStyHouse(position);
        return Response.ok(temp);
    }

    /**
     * 用户详细查看造型屋界面
     * @param styHouseId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/styHouse/{styHouseId}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response showStyHousePage(@PathVariable("styHouseId") Long styHouseId) {
        Map param = userBrowseService.showStyHouse(styHouseId);
        return Response.ok(param);
    }

    /**
     * 造型师主页展示
     * @param request 身份认证
     * @return Response，造型师数据
     */
    @ResponseBody
    @RequestMapping(value = "/stylist/{stylistId}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistHomePage(@RequestBody Map<String, String> request, @PathVariable("stylistId") Integer stylistId) {
        Long id = CastUtil.castLong(request.get("stylistId"));
        TbStylist param = stylistService.selectStylistById(id);
        return Response.ok(param);
    }
}