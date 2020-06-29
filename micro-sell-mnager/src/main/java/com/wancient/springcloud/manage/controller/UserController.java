package com.wancient.springcloud.manage.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.wancient.springcloud.api.client.UserClientService;
import com.wancient.springcloud.api.entities.SysUser;
import com.wancient.springcloud.api.vo.ResultVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

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


    @Autowired
    private UserClientService userClientService;

    /**
     * 用户列表
     *
     * @return
     */
    @GetMapping("/list")
    public String list(@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                       @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                       Map map) {
        SysUser sysUser = new SysUser();
        sysUser.setPageNum(pageNum);
        sysUser.setPageSize(pageSize);
        ResultVo<PageInfo> resultVo = userClientService.list(sysUser);
        map.put("resultVo", resultVo);
        return "/admin/admin-list";
    }

    /**
     * 查询
     *
     * @param pageSize
     * @param pageNum
     * @param username
     * @return
     */
    @GetMapping("/list_query.html")
    @ResponseBody
    public ResultVo listQuery(@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                              @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                              @RequestParam(value = "username", required = false) String username) {
        SysUser sysUser = new SysUser();
        if (!StringUtils.isEmpty(username)) {
           /* sysUser.setEmail(username);
            sysUser.setAddress(username);*/
            sysUser.setUsername(username);
        }
        sysUser.setPageNum(pageNum);
        sysUser.setPageSize(pageSize);
        System.out.println("userInfo:" + sysUser.toString());
        ResultVo<PageInfo> resultVo = userClientService.list(sysUser);
        Gson gson = new Gson();
        System.out.println(gson.toJson(resultVo));
        return resultVo;
    }
}
