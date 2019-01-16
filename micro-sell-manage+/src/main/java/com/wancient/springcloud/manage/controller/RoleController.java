package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 角色管理
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/20
 * Time: 11:52
 * To change this template use File | Settings | File Templates.
 **/
@Controller
@RequestMapping("/manage/role")
public class RoleController {

    @RequestMapping("/list")
    public  String list(){
        return  "/admin/admin-role";
    }
}
