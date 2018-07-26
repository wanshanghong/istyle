package com.istyle.controller;

import com.istyle.pojo.TbUser;
import com.istyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginUser {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public  String loginUser(HttpServletRequest request, HttpServletResponse response) throws IOException{
        TbUser user = new TbUser();
        user.setUserPhone(request.getParameter("username"));
        user.setUserPassword(request.getParameter("password"));

        if (userService.loginUser(user) == Long.valueOf(-1)){
            System.out.println("2");
            return "error";
        }
        else{
            request.getSession().setAttribute("userId", userService.loginUser(user));
            System.out.println("1");
            return "success";
        }
    }
}
