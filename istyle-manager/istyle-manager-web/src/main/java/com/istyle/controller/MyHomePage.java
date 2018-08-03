package com.istyle.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.istyle.pojo.TbUser;
import com.istyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MyHomePage {
    @Autowired
    private UserService userService;

//    打开编辑页面发送用户数据
    @ResponseBody
    @RequestMapping(value="/myHome/updateUserPage", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public String updatePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Long userId;
        Map<String, String> users = new HashMap<String, String>();
        String json;
        userId = (Long) request.getSession().getAttribute("userId");
        TbUser user = userService.selectUserById(userId);
        users.put("userPhoto", user.getUserPhoto());
        users.put("userName", user.getUserName());
        users.put("userWord", user.getUserWord());
        users.put("userSex", user.getUserSex());
        json = JSONUtils.toJSONString(users);

        System.out.println("前端请求用户数据成功");
        return json;
    }

//    编辑信息
    @ResponseBody
    @RequestMapping("/myHome/updateMessage")
    public String updateUser(HttpServletRequest request){
        TbUser user = new TbUser();
        Map<String, String> map = new HashMap<>();
        String json;

        user.setUserId((Long) request.getSession().getAttribute("userId"));

        if (request.getSession().getAttribute("userId") != null) {
//            user.setUserPhoto(request.getParameter("userPhoto"));
            user.setUserName(request.getParameter("userName"));
            user.setUserWord(request.getParameter("userWord"));
            user.setUserSex(request.getParameter("userSex"));

//            System.out.println(request.getParameter("userPhoto"));
            System.out.println("test1");
            System.out.println(request.getParameter("userName"));
            System.out.println("test2");
            System.out.println(request.getParameter("userWord"));
            System.out.println("test3");
            System.out.println(request.getParameter("userSex"));

            userService.updateUser(user);

            map.put("isOpen", "1");
            System.out.println("test5");
            json = JSONUtils.toJSONString(map);
            System.out.println("test6");
            return json;
        }
        else {
            map.put("isOpen", "0");
            System.out.println("test4");
            json = JSONUtils.toJSONString(map);
            return json;
        }
    }

//    我的主页跳转至我的信息
    @ResponseBody
    @RequestMapping(value="/myHome/index", method= RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public String myHomePage(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Long userId;
        Map<String, String> users = new HashMap<String, String>();
        String json;
        if (request.getSession().getAttribute("userId") != null){
            userId = (Long) request.getSession().getAttribute("userId");
            TbUser user = userService.selectUserById(userId);
            users.put("isOpen", "1");
            users.put("userPhoto", user.getUserPhoto());
            users.put("userName", user.getUserName());
            users.put("userWord", user.getUserWord());
            users.put("userSex", user.getUserSex());
            json = JSONUtils.toJSONString(users);

            System.out.println("2");
        }
        else {
            users.put("isOpen", "0");
            json = JSONUtils.toJSONString(users);
        }
        return json;
    }

//    展示我的信息
    @RequestMapping("/myHome/myMessage")
    @ResponseBody
    public TbUser userPageShoe(HttpServletRequest request){
        TbUser user = userService.selectUserById((Long) request.getSession().getAttribute("userId"));
        return user;
    }
}
