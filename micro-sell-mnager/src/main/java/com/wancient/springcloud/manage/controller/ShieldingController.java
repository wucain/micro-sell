package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 屏蔽词
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/21
 * Time: 16:51
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/shielding")
@Controller
public class ShieldingController {

    @RequestMapping("/list")
    public String list() {
        return "/system/system-shielding";
    }
}
