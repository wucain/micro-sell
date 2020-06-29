package com.wancient.springcloud.wechat.controller;

import com.wancient.springcloud.api.entities.SysUser;
import com.wancient.springcloud.api.utils.KeyUtil;
import com.wancient.springcloud.api.wechat.AccessToken;
import com.wancient.springcloud.api.wechat.WechatUserInfo;
import com.wancient.springcloud.wechat.config.WechatConfig;
import com.wancient.springcloud.wechat.utils.WeixinUtil;
import com.wancient.springcloud.wechat.utils.WxRequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * @Author cain
 * @date 2020-6-5 11:07
 **/
@RestController
@RequestMapping("/weixin/wx")
@Slf4j
public class WxController {


    @Autowired
    private WechatConfig wechatConfig;


    @GetMapping("/sign")
    @ResponseBody
    @CrossOrigin  // 允许跨域访问
    public Map<String, String> sgin(HttpServletRequest request, HttpServletResponse response,
                                    @RequestParam(value = "url", required = false) String url) {
        Map<String, String> map = WeixinUtil.getAppWxConfig(wechatConfig, url, url);
        System.out.println(map);
        return map;
    }

    @GetMapping("/get")
    @ResponseBody
    @CrossOrigin  // 允许跨域访问
    public String get(HttpServletRequest request, HttpServletResponse response,
                      @RequestParam(value = "mediaId", required = false) String mediaId) {
        return new WxRequestUtil().getMaterial(wechatConfig, mediaId, null);
    }

    /**
     * 授权页面跳转
     *
     * @param request
     * @param response
     */
    @RequestMapping("/authorize_page")
    public ModelAndView authorizePageJump(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getRequestURL().toString();
        log.info("访问路径：{}", url);
        String authorizeUrl = wechatConfig.authorize_url.replace("{STATE}", url);
        log.info("authorizeUrl：{}", authorizeUrl);
        return new ModelAndView("redirect:" + authorizeUrl);
    }

    /**
     * 微信授权登录
     *
     * @param request
     * @param response
     * @param code
     * @param state    登录前的访问地址
     * @param map
     * @return
     */
    @GetMapping("/login")
    @ResponseBody
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response,
                              @RequestParam(value = "code", required = false) String code,
                              @RequestParam(value = "state", required = false) String state, Map map) {
        //根据code获取access_token
        AccessToken accessToken = new WxRequestUtil().getAccessToken(wechatConfig, code);
        log.info("accessToken信息：{}", accessToken.toString());
        if (accessToken == null || accessToken.getAccess_token() == null) {
            map.put("message", accessToken.getOpenid());
            map.put("code", code);
            return new ModelAndView("/error", map);
        }
        //根据openid获取用户详情
        WechatUserInfo wechatUserInfo = new WxRequestUtil().getUserInfo(wechatConfig, accessToken);
        if (wechatUserInfo.getOpenid() == null) {
            return new ModelAndView("redirect:" + state);
        }
        log.info("wechatUserInfo 信息：{}", wechatUserInfo.toString());
        //记住登录状态
        HttpSession session = request.getSession();

        //1. session
        session.setAttribute("openId", wechatUserInfo.getOpenid());
        return new ModelAndView("redirect:" + state);
    }
}
