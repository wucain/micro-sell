package com.wancient.springcloud.manage.aspect;

import com.google.gson.Gson;
import com.wancient.springcloud.api.client.LogClientService;
import com.wancient.springcloud.api.constant.CookieConstant;
import com.wancient.springcloud.api.constant.RedisConstant;
import com.wancient.springcloud.api.entities.SysLog;
import com.wancient.springcloud.api.entities.SysUser;
import com.wancient.springcloud.api.utils.CookieUtil;
import com.wancient.springcloud.api.utils.KeyUtil;
import lombok.extern.slf4j.Slf4j;
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
import java.util.Date;

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
public class LogAspect {

    @Autowired
    private LogClientService logClientService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 抽取公共的切入点表达式
     * 1.本类的引用
     * 2.其他的切面引用
     */
    @Pointcut("execution(* com.wancient.springcloud.manage.controller.*.*(..))")
    public void pointCut() {
    }

    /**
     * 前置通知:在目标方法运行之前运行
     *
     * @param joinPoint joinPoint
     */
    @Before("pointCut()")
    public void logStart(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpServletResponse response = attributes.getResponse();


        SysLog sysLog = new SysLog();

        sysLog.setId(KeyUtil.genUniqueKey());
        //url
        log.info("url={}", request.getRequestURL());
        sysLog.setVisitUrl(request.getRequestURL().toString());
        //请求方式
        log.info("mothod={}", request.getMethod());
        sysLog.setVisitMothod(request.getMethod());
        //ip
        log.info("id={}", request.getRemoteAddr());
        sysLog.setIp(request.getRemoteAddr());
        //类方法 (类名+类方法)
        log.info("class_mothod={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        sysLog.setVisitAction(joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        log.info("args={}", joinPoint.getArgs());
        String par = "";
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            par += "第" + (i + 1) + "个参数为:" + args[i] + ";";
        }

        //1.查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.BACK_TOKEN);
        if (cookie != null) {
            //2.去redis查询
            String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.BACK_TOKEN_PREFIX, cookie.getValue()));
            Gson gson = new Gson();
            SysUser sysUser = gson.fromJson(tokenValue, SysUser.class);
            sysLog.setUserId(sysUser == null ? "" : sysUser.getUserId());
        }

//        Enumeration enu = request.getParameterNames();
//        while (enu.hasMoreElements()) {
//            String paraName = (String) enu.nextElement();
//            System.out.println(paraName + ": " + request.getParameter(paraName));
//        }
        sysLog.setVisitParameter(par);
        //
        // sysLog.setVisitTime(new Date());
        logClientService.insert(sysLog);
    }

    /**
     * 后置通知:在目标方法运行结束运行(无论方法是正常结束还是异常结束)
     *
     * @param joinPoint joinPoint
     */
    @After("pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        //System.out.println("logEnd...");
    }

    /**
     * 返回通知:在目标方法运行正常返回通知
     *
     * @param result result
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void logReturn(Object result) {
        //System.out.println("logReturn...");
    }

    /**
     * 异常通知:在目标方法运行出现异常通知
     *
     * @param exception 异常
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void logThrown(Exception exception) {
        // System.out.println("logThrown...");
    }

    /**
     * 环绕通知:手动引导代码执行
     *
     * @param pdj 可执行体
     * @return return
     * @throws Throwable Throwable
     */
    @Around(value = "pointCut()")
    public Object logAround(ProceedingJoinPoint pdj) throws Throwable {
        // System.out.println("运行...参数列表是:{" + Arrays.asList(pdj.getArgs()) + "}");
        return pdj.proceed();
    }

}
