package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/10
 * Time: 21:37
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage")
@Controller
public class MainController {

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "/index";
    }

    /**
     * 欢迎页面
     *
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome() {
        return "/index_v1";
    }
}
