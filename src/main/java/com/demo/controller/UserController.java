package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    //跳转到系统首页
    @RequestMapping("/main")
    public String toMainPage() {
        return "main";
    }

    //跳转到登录页面
    @RequestMapping("/tologin")
    public String tologin() {
        return "tologin";
    }

    //跳转到订单信息页面
    @RequestMapping("/orderinfo")
    public String orderinfo() {
        return "orderinfo";
    }

    /*
     * 用户登录
     * */

}
