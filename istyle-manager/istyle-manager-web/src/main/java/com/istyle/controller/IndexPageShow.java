package com.istyle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页展示
 * 2018年4月3日10:13:02
 * @author 黄文伟
 */
@Controller
public class IndexPageShow {
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }
}
