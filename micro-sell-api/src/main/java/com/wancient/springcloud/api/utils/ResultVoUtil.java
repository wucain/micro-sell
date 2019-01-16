package com.wancient.springcloud.api.utils;

import com.wancient.springcloud.api.vo.ResultVo;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/25
 * Time: 23:46
 */
public class ResultVoUtil {

    /**
     * 成功
     *
     * @param object
     * @return
     */
    public static ResultVo success(Object object) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVo success() {
        return success(null);
    }

    public static ResultVo error(Integer code, String msg) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }

    public static ResultVo error(Integer code, String msg, Object object) {
        ResultVo resultVo = new ResultVo();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        resultVo.setData(object);
        return resultVo;
    }
}
