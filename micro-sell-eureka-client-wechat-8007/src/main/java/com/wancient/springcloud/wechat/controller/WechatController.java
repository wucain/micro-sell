package com.wancient.springcloud.wechat.controller;


import com.wancient.springcloud.api.constant.CookieConstant;
import com.wancient.springcloud.api.enums.ResultEnum;
import com.wancient.springcloud.api.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 后台用户管理
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/27
 * Time: 22:15
 */
@RestController
@RequestMapping("/weixin/wechat")
@Slf4j
public class WechatController {
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
