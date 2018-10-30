package com.istyle.controller;

import com.istyle.mapper.TbStylistMapper;
import com.istyle.pojo.TbStylist;
import com.util.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: 黄文伟
 * @description:
 * @Date:Created in 22:17 2018/10/30
 */
@Controller
public class StylistRegister {
    @Autowired
    private TbStylistMapper tbStylistMapper;

    @ResponseBody
    @RequestMapping(value = "/stylistRegister", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public Response stylistRegister(@RequestBody TbStylist stylist) {
        tbStylistMapper.addStylist(stylist);
        return Response.ok();
    }
}
