package com.wancient.springcloud.wechat.singleton;


import com.wancient.springcloud.api.wechat.AccessToken;
import com.wancient.springcloud.api.wechat.WxJsapiTicket;
import com.wancient.springcloud.wechat.config.WechatConfig;
import com.wancient.springcloud.wechat.utils.WxRequestUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Token单例
 *
 * @author: Wancient
 * @date: 2018-7-12
 * @time: 11:36
 */
@Slf4j
public class TokenSingleton {


    /**
     * 缓存accessToken 的Map  ,map中包含 一个accessToken 和 缓存的时间戳
     */
    private Map<String, String> map = new HashMap<String, String>();

    private TokenSingleton() {
    }

    private static volatile TokenSingleton single = null;

    // 静态工厂方法
    public static TokenSingleton getInstance() {
        synchronized (TokenSingleton.class) {
            if (single == null) {
                single = new TokenSingleton();
            }
        }
        return single;
    }

    public Map<String, String> getMap(WechatConfig accountConfig) {
        String access_time = map.get("access_time");
        String access_token = map.get("access_token");

        Long nowDate = System.currentTimeMillis();

        if (access_token != null && access_time != null && nowDate - Long.parseLong(access_time) < 3000 * 1000) {
            log.info("accessToken存在,且没有超时,返回单例");
        } else {
            log.info("accessToken超时或者不存在,重新获取");
            WxRequestUtil requestUtil = new WxRequestUtil();
            AccessToken token = requestUtil.getAddressOAToken(accountConfig);
            map.put("access_time", nowDate + "");
            map.put("access_token", token.getAccess_token());
        }
        String ticket_time = map.get("ticket_time");
        String ticket_token = map.get("ticket_token");
        if (ticket_token != null && ticket_time != null && nowDate - Long.parseLong(ticket_time) < 3000 * 1000) {
            log.info("ticket_token存在,且没有超时,返回单例");
        } else {
            log.info("ticket_token超时或者不存在,重新获取");
            WxRequestUtil requestUtil = new WxRequestUtil();
            WxJsapiTicket ticket = requestUtil.getTicket(map.get("access_token"));
            map.put("ticket_time", nowDate + "");
            map.put("ticket_token", ticket.getTicket());
        }
        log.info("access_token:{}", map.get("access_token"));
        log.info("ticket_token:{}", map.get("ticket_token"));
        return map;
    }

    /**
     * 获取Token
     */
    public String getToken(WechatConfig accountConfig) {
        Map<String, String> tokenMap = getMap(accountConfig);
        String access_token = tokenMap.get("access_token");
        return access_token;
    }

    /**
     * 获取ApiTicket
     */
    public String getApiTicket(WechatConfig accountConfig) {
        Map<String, String> tokenMap = getMap(accountConfig);
        String api_ticket = tokenMap.get("ticket_token");
        return api_ticket;
    }


    public void setMap(Map<String, String> map) {
        this.map = map;
    }

    public static TokenSingleton getSingle() {
        return single;
    }

    public static void setSingle(TokenSingleton single) {
        TokenSingleton.single = single;
    }
}
