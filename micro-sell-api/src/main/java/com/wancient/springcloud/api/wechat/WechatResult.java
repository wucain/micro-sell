package com.wancient.springcloud.api.wechat;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/7
 * Time: 22:24
 */
@Data
public class WechatResult {

    /**
     * 错误代码
     **/
    private Integer errcode;

    /**
     * 错误信息
     **/
    private String errmsg;

}
