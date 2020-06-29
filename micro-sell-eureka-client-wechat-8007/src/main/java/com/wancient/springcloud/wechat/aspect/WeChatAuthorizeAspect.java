package com.wancient.springcloud.wechat.aspect;

import com.wancient.springcloud.wechat.exception.AuthorizeException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录切面
 *
 * @author CainWu
 * @date 2018/8/29 11:09
 */
@Aspect
@Component
@Slf4j
public class WeChatAuthorizeAspect {

    /**
     * controller 全部拦截,除登录方法
     */
    @Pointcut("execution(public  *  com.wancient.springcloud.wechat.controller.WechatController.*(..))")
    public void verify() {
    }


    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();

        //1.查询 session
        String openId = (String) session.getAttribute("openId");
        log.info("openid:{}", openId);
        if (openId == null) {
            log.warn("【登录检验】session中找不到登录用户信息");
            throw new AuthorizeException();
        }
    }
}
