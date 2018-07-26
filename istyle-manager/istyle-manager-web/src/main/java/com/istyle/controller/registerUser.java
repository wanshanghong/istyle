package com.istyle.controller;

import com.istyle.pojo.TbUser;
import com.istyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class registerUser {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
        TbUser tbUser = new TbUser();

        tbUser.setUserName(request.getParameter("fakename"));
        tbUser.setUserPassword(request.getParameter("password1"));
        tbUser.setUserPhone(request.getParameter("tel"));
        tbUser.setUserSex(request.getParameter("sex"));
        tbUser.setUserAge(Integer.valueOf(request.getParameter("age")));
        tbUser.setUserPhoto("/img/headphoto.png");

//        判断号码是否存在
        if (userService.isUserName(request.getParameter("tel"))){
            return "error"; //存在
        }
        else {
            userService.insertUser(tbUser);
            return "index"; //不存在
        }
    }
}
