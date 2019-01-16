package com.wancient.springcloud.manage.controller;

import com.google.gson.Gson;
import com.wancient.springcloud.api.client.UserClientService;
import com.wancient.springcloud.api.constant.CookieConstant;
import com.wancient.springcloud.api.constant.RedisConstant;
import com.wancient.springcloud.api.entities.SysUser;
import com.wancient.springcloud.api.enums.ResultEnum;
import com.wancient.springcloud.api.utils.CookieUtil;
import com.wancient.springcloud.api.utils.ResultVoUtil;
import com.wancient.springcloud.api.vo.ResultVo;
import com.wancient.springcloud.manage.exception.AuthorizeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/10
 * Time: 20:47
 * To change this template use File | Settings | File Templates.
 **/
@Controller
@RequestMapping("/manage")
@Slf4j
public class IndexController {


    @Autowired
    private UserClientService userClientService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/login")
    public String loginView() {
        log.info("登录页面");
        return "/login";
    }

    /**
     * 账号密码登录
     *
     * @param username
     * @param password
     * @param response
     * @param map
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public ResultVo login(@RequestParam("username") String username, @RequestParam("password") String password, HttpServletResponse response, Map<String, Object> map) {
        log.info("userName:{}", username);
        log.info("password:{}", password);

        //1.openid和数据库中的匹配
        SysUser sysUser = userClientService.login(username, password);
        if (sysUser == null) {
            return ResultVoUtil.error(ResultEnum.LOGIN_FAIL.getCode(), ResultEnum.LOGIN_FAIL.getMessage(), "/manage/user/login");
        }
        //2.设置token到redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        Gson gson = new Gson();
        //key\value\过期时间，时间格式
        redisTemplate.opsForValue().set(String.format(RedisConstant.BACK_TOKEN_PREFIX, token), gson.toJson(sysUser), expire, TimeUnit.SECONDS);
        //3.设置token到cookie
        CookieUtil.set(response, CookieConstant.BACK_TOKEN, token, expire);

        return ResultVoUtil.success();
    }

    /**
     * 退出登录
     *
     * @param request
     * @return
     */
    @GetMapping("/logout")
    @ResponseBody
    public ResultVo logout(HttpServletRequest request) {
        boolean flag = false;
        Cookie cookie = CookieUtil.get(request, CookieConstant.BACK_TOKEN);
        System.out.println("cookie:" + cookie);
        if (cookie != null) {
            System.out.println("cookie:" + cookie.getValue());
            //redis删除key
            flag = redisTemplate.delete(String.format(RedisConstant.BACK_TOKEN_PREFIX, cookie.getValue()));
        }
        if (flag) {
            return ResultVoUtil.success();
        } else {
            return ResultVoUtil.error(-1, "退出失败！");
        }

    }


}
