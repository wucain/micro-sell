package com.wancient.springcloud.wechat.handler;

import com.wancient.springcloud.wechat.config.WechatConfig;
import com.wancient.springcloud.wechat.exception.AuthorizeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 异常捕获
 *
 * @author CainWu
 * @date 2018/8/29 11:36
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    @Autowired
    private WechatConfig wechatConfig;

    /**
     * 拦截登录异常 跳转到登 微信受权页面
     *
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(value = AuthorizeException.class)
    public ModelAndView handlerAuthorizeException(HttpServletRequest request) {
        String url = request.getRequestURL().toString();
        log.info("路径1：{}", url);
        String authorizeUrl = wechatConfig.authorize_url.replace("{STATE}", url);
        log.info("路径2：{}", authorizeUrl);
        return new ModelAndView("redirect:" + authorizeUrl);
    }

}
