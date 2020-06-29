package com.wancient.springcloud.api.client;

import com.wancient.springcloud.api.entities.SysUser;
import com.wancient.springcloud.api.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/15
 * Time: 9:34
 * To change this template use File | Settings | File Templates.
 **/
@FeignClient(value = "MICRO-USER")
public interface UserClientService {

    @PostMapping("/manage/user/login")
    SysUser login(@RequestParam("username") String username, @RequestParam("password") String password);

    @PostMapping("/manage/user/list")
    ResultVo list(@RequestBody SysUser sysUser);

    @PostMapping("/manage/user/save")
    Integer save(@RequestBody SysUser sysUser);

    @GetMapping("/manage/user/get")
    SysUser get(@RequestParam("userId") String userId);

}
