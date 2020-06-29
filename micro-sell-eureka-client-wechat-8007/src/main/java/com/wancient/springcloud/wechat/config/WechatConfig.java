package com.wancient.springcloud.wechat.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信用户配置
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/28
 * Time: 23:52
 */
@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatConfig {
    /**
     * 微信appid.
     */
    public String appid;

    /**
     * 微信 secret
     */
    public String secret;

    /**
     * 授权页面
     */
    public String authorize_url;


    /**
     * 系统网址
     */
    public String system;

    /**
     * 系统登录页面
     */
    public String systemlogin;

    public String url;
}
