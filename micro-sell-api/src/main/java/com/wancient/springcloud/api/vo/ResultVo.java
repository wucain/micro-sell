package com.wancient.springcloud.api.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * http请求最外层返回对象
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/25
 * Time: 18:22
 */
@Data
public class ResultVo<T> implements Serializable  {


    private static final long serialVersionUID = 4352852046722397283L;
    /**
     * 错误码
     **/
    private Integer code;

    /**
     * 提示信息
     **/
    private String msg;

    /**
     * 具体内容
     **/
    private T data;

}
