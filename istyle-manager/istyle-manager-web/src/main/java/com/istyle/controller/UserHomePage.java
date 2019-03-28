package com.istyle.controller;

import com.istyle.pojo.*;
import com.istyle.service.UserService;
import com.util.CastUtil;
import com.util.JWT;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 我的主页
 * @author 黄文伟
 */
@Controller
@RequestMapping("/userHome")
public class    UserHomePage {
    @Autowired
    private UserService userService;

    /**
     * 我的主页跳转至我的信息
     * @param request token身份认证
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value="/index", method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userHomePage(@RequestBody Map<String, String> request) {
        TbUser user = JWT.unsign(request.get("stoken"), TbUser.class);
        TbUser param = userService.selectUserByUserId(user);
        return Response.ok(param);
    }

    /**
     * 打开编辑页面发送用户数据
     * @param request
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/updatePage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userUpdatePage(@RequestBody Map<String, String> request) {
        TbUser user = JWT.unsign(request.get("stoken"), TbUser.class);
        TbUser param = userService.selectUserByUserId(user);
        return Response.ok(param);
    }

    /**
     * 编辑信息
     * @param tbUser 用户数据，包括stoken，userPhoto，userName， userWord， userSex， userAge
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/updateMessage", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userUpdateMessage(@RequestBody TbUser tbUser){
        TbUser user = JWT.unsign(tbUser.getStoken(), TbUser.class);
        userService.updateUser(user, tbUser);
        return Response.ok();
    }

    /**
     * 我的收藏
     * @param request 用户身份认证
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value="/collection", method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userCollection(@RequestBody Map<String, String> request){
        TbUser user = JWT.unsign(request.get("stoken"), TbUser.class);
        Map param = userService.selectCollection(user);
        return Response.ok(param);
    }

    /**
     * 我的关注
     * @param request 用户身份认证
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value="/attention", method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userfollowPage(@RequestBody Map<String, String> request) {
        TbUser user = JWT.unsign(request.get("stoken"), TbUser.class);
        Map param = userService.selectAttentionsById(user);
        return Response.ok(param);
    }

    /**
     * 取消关注
     * @param request 包含 stoken 用户身份认证和 unFollowUserId 被取消关注用户id
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value="/unFollow", method= RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userUnFollow(@RequestBody Map<String, String> request) {
        TbUser user = JWT.unsign(request.get("stoken"), TbUser.class);
        userService.unFollow(user, CastUtil.castLong(request.get("unFollowUserId")));
        return Response.ok();
    }

    /**
     * 我的粉丝页面
     * @param request
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/fans", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userFansPage(@RequestBody Map<String, String> request){
        TbUser user = JWT.unsign(request.get("stoken"), TbUser.class);
        Map param = userService.myFansPage(user);
        return Response.ok(param);
    }

    /**
     * 添加粉丝关注
     * @param request
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/doFanFollow", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userAddFanFollow(@RequestBody Map<String, String> request) {
        TbUser user = JWT.unsign(request.get("stoken"), TbUser.class);
        userService.addFollow(user, CastUtil.castLong(request.get("doFollowUserId")));
        return Response.ok();
    }

    /**
     * 我的投稿展示
     * @param request
     * @return Response
     */
    @ResponseBody
    @RequestMapping(value = "/submission", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response userSubmissionPage(@RequestBody Map<String, String> request){
        TbUser user = JWT.unsign(request.get("stoken"), TbUser.class);
        Map param = userService.mySubmission(user);
        return Response.ok(param);
    }
}
