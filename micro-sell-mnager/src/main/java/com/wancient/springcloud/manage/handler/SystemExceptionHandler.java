package com.wancient.springcloud.manage.handler;

import com.wancient.springcloud.api.utils.ResultVoUtil;
import com.wancient.springcloud.api.vo.ResultVo;
import com.wancient.springcloud.manage.exception.AuthorizeException;
import com.wancient.springcloud.manage.exception.SysException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/15
 * Time: 10:06
 * To change this template use File | Settings | File Templates.
 **/
@ControllerAdvice
public class SystemExceptionHandler {

    /**
     * 拦截登录异常 跳转到登录页面
     *
     * @return
     */
    @ExceptionHandler(value = AuthorizeException.class)
    public ModelAndView handlerAuthorizeException() {
        System.out.println("系统错误！");
        return new ModelAndView("redirect:/manage/login");
    }


    @ExceptionHandler(value = SysException.class)
    @ResponseBody
    public ResultVo handlerSellException(SysException e) {
        return ResultVoUtil.error(e.getCode(), e.getMessage());
    }

}
