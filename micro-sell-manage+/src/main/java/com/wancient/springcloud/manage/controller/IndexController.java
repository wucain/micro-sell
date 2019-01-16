package com.wancient.springcloud.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/10
 * Time: 20:47
 * To change this template use File | Settings | File Templates.
 **/
@Controller
@RequestMapping("/manage")
@Slf4j
public class IndexController {

    @RequestMapping("/login")
    public String loginView() {
        log.info("登录页面");
        return "/login";
    }



}
