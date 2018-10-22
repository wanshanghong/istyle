package com.istyle.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.istyle.pojo.TbStyHouse;
import com.istyle.pojo.TbStylist;
import com.istyle.pojo.TbUser;
import com.istyle.service.StyHouseService;
import com.istyle.service.StylistService;
import com.istyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户注册
 * @author 黄文伟
 */
@Controller
public class RegisterUser {
    @Autowired
    private UserService userService;
    @Autowired
    private StylistService stylistService;
    @Autowired
    private StyHouseService styHouseService;

    /*@RequestMapping(value = "/register", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public String registerUser(HttpServletRequest request){
        int userType = 1;
//        userType = Integer.valueOf(request.getParameter("userType"));

//        普通用户
        if (userType == 1) {
        TbUser tbUser = new TbUser();

            tbUser.setUserName(request.getParameter("userName"));
            tbUser.setUserPassword(request.getParameter("userPassword"));
            tbUser.setUserPhone(request.getParameter("userPhone"));
            tbUser.setUserSex(request.getParameter("userSex"));
            tbUser.setUserAge(Integer.valueOf(request.getParameter("userAge")));
//        判断号码是否存在
        if (tbUser == null)
            System.out.println("user为空1");
            if (userService.isUserName(request.getParameter("tel"))) {
                return "error"; //存在
            } else {
                userService.insertUser(tbUser);
                return "index"; //不存在
            }
        }//造型师
        else if (userType == 2){
            TbStylist tbStylist = new TbStylist();
            tbStylist.setStylistName(request.getParameter("stylistName"));
            tbStylist.setRealName(request.getParameter("setRealName"));
            tbStylist.setStylistPassword(request.getParameter("setStylistPassword"));
            tbStylist.setStylistSex(request.getParameter("setStylistSex"));
            tbStylist.setStylistAge(Integer.valueOf(request.getParameter("setStylistAge")));
            tbStylist.setStylistPhone(request.getParameter("setStylistPhone"));

            stylistService.stylistRegister(tbStylist);
            return "index";
        }//造型屋
        else if (userType == 3){
            TbStyHouse tbStyHouse = new TbStyHouse();
            tbStyHouse.setStyHouseName(request.getParameter("styHouseName"));
            tbStyHouse.setStyHouseAccount(request.getParameter("StyHouseAccount"));
            tbStyHouse.setStyHousePassword(request.getParameter("StyHousePassword"));
            tbStyHouse.setHeadName(request.getParameter("headName"));
            tbStyHouse.setHeadId(request.getParameter("setHeadId"));
            tbStyHouse.setHeadPhone(request.getParameter("setHeadPhone"));
            tbStyHouse.setStyHousePosition(request.getParameter("setStyHousePosition"));

            styHouseService.styHouseRegister(tbStyHouse);
            return "index";
        }
        else {
            return "error";
        }
    }*/

    @RequestMapping(value = "/userRegister", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String register(String data) {
        TbUser param = JSON.parseObject(data, TbUser.class);
        userService.insertUser(param);
        return "/success";
    }
}
