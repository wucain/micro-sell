package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 数据字典
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/20
 * Time: 14:23
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/dictionary")
@Controller
public class DictionaryController {


    @RequestMapping("/list")
    public String list() {
        return "/system/system-dictionary";
    }
}
