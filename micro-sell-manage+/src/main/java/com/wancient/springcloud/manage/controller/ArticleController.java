package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文章
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/20
 * Time: 16:15
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/article")
@Controller
public class ArticleController {

    @RequestMapping("/list")
    public String list() {
        return "/article/article-list";
    }
}
