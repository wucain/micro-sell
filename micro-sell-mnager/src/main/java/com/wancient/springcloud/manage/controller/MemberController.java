package com.wancient.springcloud.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 会员
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/24
 * Time: 9:48
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/member")
@Controller
public class MemberController {

    /**
     * 会员列表
     *
     * @return
     */
    @RequestMapping("/list")
    public String list() {
        return "/member/member-list";
    }

    /**
     * 删除的会员
     *
     * @return
     */
    @RequestMapping("/del")
    public String del() {
        return "/member/member-del";
    }

    /**
     * 等级管理
     *
     * @return
     */
    @RequestMapping("/level")
    public String level() {
        return "/member/member-level";
    }

    /**
     * 积分管理
     *
     * @return
     */
    @RequestMapping("/scoreoperation")
    public String scoreoperation() {
        return "/member/scoreoperation";
    }

    /**
     * 浏览记录
     *
     * @return
     */
    @RequestMapping("/record_browse")
    public String recordBrowse() {
        return "/member/member-record-browse";
    }

    /**
     * 下载记录
     *
     * @return
     */
    @RequestMapping("/record_download")
    public String recordDownload() {
        return "/member/member-record-download";
    }

    /**
     * 分享记录
     *
     * @return
     */
    @RequestMapping("/record_share")
    public String recordShare() {
        return "/member/member-record-share";
    }

}
