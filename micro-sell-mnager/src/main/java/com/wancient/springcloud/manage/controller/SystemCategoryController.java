package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统栏目
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/21
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/system_category")
@Controller
public class SystemCategoryController {

    @RequestMapping("/list")
    public String list() {
        return "/system/system-category";
    }
}
