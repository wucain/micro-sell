package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用户管理
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/20
 * Time: 11:41
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/user")
@Controller
public class UserController {

    /**
     * 用户列表
     * @return
     */
    @RequestMapping("/list")
    public String list() {
        return "/admin/admin-list";
    }
}
