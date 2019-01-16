package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 日志管理
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/20
 * Time: 11:56
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/log")
@Controller
public class LogController {

    @RequestMapping("/list")
    public String list() {
        return "/system/system-log";
    }
}
