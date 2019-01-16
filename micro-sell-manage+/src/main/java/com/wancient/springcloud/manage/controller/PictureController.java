package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 图片
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/24
 * Time: 11:03
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/picture")
@Controller
public class PictureController {

    @RequestMapping("/list")
    public String list() {
        return "/picture/picture-list";
    }
}
