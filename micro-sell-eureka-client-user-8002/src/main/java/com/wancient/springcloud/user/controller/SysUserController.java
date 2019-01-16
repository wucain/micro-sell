package com.wancient.springcloud.user.controller;


import com.wancient.springcloud.api.constant.CookieConstant;
import com.wancient.springcloud.api.constant.RedisConstant;
import com.wancient.springcloud.api.entities.SysUser;
import com.wancient.springcloud.api.enums.ResultEnum;
import com.wancient.springcloud.api.utils.CookieUtil;
import com.wancient.springcloud.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;

/**
 * 后台用户管理
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/27
 * Time: 22:15
 */
@RestController
@RequestMapping("/manage/user")
@Slf4j
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 账号密码登录
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public SysUser login(@RequestParam("username") String username, @RequestParam("password") String password) {
        log.info("userName:{}", username);
        log.info("password:{}", password);

        //1.openid和数据库中的匹配
        SysUser sysUser = sysUserService.findSysUserByUsernamePassword(username, password);
        // System.out.println(sysUser.toString());
        return sysUser;
    }

    /**
     * 微信登录
     *
     * @param openid
     * @param response
     * @param map
     * @return
     */
    @PostMapping("/wx_login")
    public ModelAndView wxLogin(@RequestParam("openid") String openid, HttpServletResponse response, Map<String, Object> map) {
        //1.openid和数据库中的匹配
        SysUser sysUser = sysUserService.findSysUserByOpenid(openid);
        if (sysUser == null) {
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url", "/seller/product/list");
            return new ModelAndView("common/error", map);
        }
        //2.设置token到redis
        String token = UUID.randomUUID().toString();
        Integer expire = RedisConstant.EXPIRE;
        //key\value\过期时间，时间格式
        // redisTemplate.opsForValue().set(String.format(RedisConstant.FRONT_TOKEN_PREFIX, token), openid, expire, TimeUnit.SECONDS);
        //3.设置token到cookie
        CookieUtil.set(response, CookieConstant.FRONT_TOKEN, token, expire);

        return new ModelAndView("redirect:" + "/seller/order/list", map);
    }

    /**
     * 登出
     *
     * @param request
     * @param response
     * @param map
     * @return
     */
    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response, Map<String, Object> map) {
        //1.从cookie查询
        Cookie cookie = CookieUtil.get(request, CookieConstant.FRONT_TOKEN);
        if (cookie != null) {
            //2.清除redis
            // redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstant.FRONT_TOKEN_PREFIX, cookie.getValue()));
            //3.清除cookie
            CookieUtil.set(response, CookieConstant.FRONT_TOKEN, null, 0);
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);
    }


}
