package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 反馈
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/24
 * Time: 10:58
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/feedback")
@Controller
public class FeedbackController {

    @RequestMapping("/list")
    public String list() {
        return "/feedback/feedback-list";
    }
}
