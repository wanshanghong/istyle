package com.istyle.controller;

import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUser;
import com.istyle.service.StylistService;
import com.istyle.service.UserBrowseService;
import com.istyle.service.UserService;
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
     * @param stylistId 身份认证
     * @return Response，造型师数据
     */
    @ResponseBody
    @RequestMapping(value = "/stylist/{stylistId}", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistHomePage(@PathVariable("stylistId") Long stylistId, @RequestBody Map<String, String> request) {
        TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
        Long userId = tbUser.getUserId();

        Map param = userBrowseService.selectStylistById(userId, stylistId);
        return Response.ok(param);
    }

    /**
     * 关注造型师
     * @param stylistId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stylist/{stylistId}/addAttention", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistAddAttention(@PathVariable("stylistId") Long stylistId, @RequestBody Map<String, String> request) {
        TbUser tbUser = JWT.unsign(request.get("stoken"), TbUser.class);
        Long userId = tbUser.getUserId();

        userBrowseService.addAttention(userId, stylistId);
        return Response.ok();
    }

    /**
     * 造型师粉丝的展示界面
     * @param stylistId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stylist/{stylistId}/showStylistFan", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistFanShow(@PathVariable("stylistId") Long stylistId) {
        Map param = userBrowseService.showStylistFans(stylistId);
        return Response.ok(param);
    }
}