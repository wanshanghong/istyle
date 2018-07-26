package com.istyle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页展示
 * by 黄文伟
 * 2018年4月3日10:13:02
 */

@Controller

public class IndexPageShow {
    @RequestMapping("/")
    public String showIndex() {
        return "index";
    }
}
