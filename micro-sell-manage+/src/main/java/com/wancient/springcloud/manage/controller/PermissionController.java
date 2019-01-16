package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权限管理
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/20
 * Time: 11:54
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/permission")
@Controller
public class PermissionController {

    @RequestMapping("/list")
    public String list() {
        return "/admin/admin-permission";
    }
}
