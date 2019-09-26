package com.hand.api.controller.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description 登录
 * @author 刘梦辉
 * @date 2019/9/23
 */
@Controller
@RequestMapping("/page")
public class PageController {


    @RequestMapping("login")
    public String loginPage(){

        return "login";
    }
}
