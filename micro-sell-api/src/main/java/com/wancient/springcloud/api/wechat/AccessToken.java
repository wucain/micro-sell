package com.wancient.springcloud.api.wechat;

import lombok.Data;

/**
 * token
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/7
 * Time: 22:29
 */
@Data
public class AccessToken extends WechatResult {

    /**
     * 网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
     **/
    private String access_token;

    /**
     * access_token接口调用凭证超时时间，单位（秒）
     */
    private Integer expires_in;

    /**
     * 用户刷新access_token
     */
    private String refresh_token;

    /**
     * 用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
     */
    private String openid;

    /**
     * 用户授权的作用域，使用逗号（,）分隔
     */
    private String scope;

    @Override
    public String toString() {
        return "AccessToken{" +
                "access_token='" + access_token + '\'' +
                ", expires_in=" + expires_in +
                ", refresh_token='" + refresh_token + '\'' +
                ", openid='" + openid + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
