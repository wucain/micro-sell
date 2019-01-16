package com.wancient.springcloud.api.constant;

/**
 * redis 常量
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/27
 * Time: 23:26
 */
public interface RedisConstant {

    String FRONT_TOKEN_PREFIX = "front_token_%s";
    String BACK_TOKEN_PREFIX = "back_token_%s";
    Integer EXPIRE = 7200;//2小时
}
