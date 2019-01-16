package com.wancient.springcloud.manage.aspect;

import com.google.gson.Gson;
import com.wancient.springcloud.api.client.LogClientService;
import com.wancient.springcloud.api.constant.CookieConstant;
import com.wancient.springcloud.api.constant.RedisConstant;
import com.wancient.springcloud.api.entities.SysLog;
import com.wancient.springcloud.api.entities.SysUser;
import com.wancient.springcloud.api.utils.CookieUtil;
import com.wancient.springcloud.api.utils.KeyUtil;
import com.wancient.springcloud.manage.exception.AuthorizeException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/15
 * Time: 15:40
 * To change this template use File | Settings | File Templates.
 **/
@Aspect
@Component
@Slf4j
public class AuthAspect {


    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 抽取公共的切入点表达式
     * 1.本类的引用
     * 2.其他的切面引用
     */
    @Pointcut("execution(public * com.wancient.springcloud.manage.controller.*.*(..))" +
            "&& !execution(public  * com.wancient.springcloud.manage.controller.IndexController.*(..))")
    public void pointCut() {
    }

    /**
     * 前置通知:在目标方法运行之前运行
     *
     * @param joinPoint joinPoint
     */
    @Before("pointCut()")
    public void authStart(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //1.查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.BACK_TOKEN);
        if (cookie == null) {
            log.warn("【登录检验】Cookie中找不到token");
            throw new AuthorizeException();
        }
        //2.去redis查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.BACK_TOKEN_PREFIX, cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("【登录检验】Redis中找不到token");
            throw new AuthorizeException();
        }
    }

    /**
     * 后置通知:在目标方法运行结束运行(无论方法是正常结束还是异常结束)
     *
     * @param joinPoint joinPoint
     */
    @After("pointCut()")
    public void authEnd(JoinPoint joinPoint) {
        //System.out.println("authEnd...");
    }

    /**
     * 返回通知:在目标方法运行正常返回通知
     *
     * @param result result
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void authReturn(Object result) {
        //System.out.println("authReturn...");
    }

    /**
     * 异常通知:在目标方法运行出现异常通知
     *
     * @param exception 异常
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void authThrown(Exception exception) {
        // System.out.println("authThrown...");
    }

    /**
     * 环绕通知:手动引导代码执行
     *
     * @param pdj 可执行体
     * @return return
     * @throws Throwable Throwable
     */
    @Around(value = "pointCut()")
    public Object authAround(ProceedingJoinPoint pdj) throws Throwable {
        // System.out.println("运行...参数列表是:{" + Arrays.asList(pdj.getArgs()) + "}");
        return pdj.proceed();
    }

}
