package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 基础设置
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/21
 * Time: 17:57
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/base")
@Controller
public class BaseController {

    @RequestMapping("/list")
    public String list() {
        return "/system/system-base";
    }
}
