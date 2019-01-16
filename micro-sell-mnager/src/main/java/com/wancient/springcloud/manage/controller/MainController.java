package com.wancient.springcloud.manage.controller;

import com.google.gson.Gson;
import com.wancient.springcloud.api.constant.CookieConstant;
import com.wancient.springcloud.api.constant.RedisConstant;
import com.wancient.springcloud.api.entities.SysUser;
import com.wancient.springcloud.api.utils.CookieUtil;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/10
 * Time: 21:37
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage")
@Controller
public class MainController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 首页
     *
     * @return
     */
    @RequestMapping("/index")
    public String index(HttpServletRequest request, Map map) {
        //获取用户信息
        //1.查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.BACK_TOKEN);
        //2.去redis查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.BACK_TOKEN_PREFIX, cookie.getValue()));
        Gson gson = new Gson();
        SysUser sysUser = gson.fromJson(tokenValue, SysUser.class);
        if (sysUser != null) {
            System.out.println("sysUser:" + sysUser.toString());
        } else {
            System.out.println("sysUser is null");
        }
        map.put("sysUser", sysUser);
        return "/index";
    }

    /**
     * 欢迎页面
     *
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome() {
        return "/welcome";
    }
}
