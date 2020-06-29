package com.wancient.springcloud.wechat.utils;


import com.wancient.springcloud.wechat.config.WechatConfig;
import com.wancient.springcloud.wechat.singleton.TokenSingleton;

import java.util.Map;

/**
 * @Author cain
 * @date 2020-5-27 10:28
 **/
public class WeixinUtil {
    /**
     * 单页面引用的分享conf
     *
     * @param requestUrl  加密的请求路由
     * @param redirectUrl 回调路由
     * @return
     */
    public static Map<String, String> getAppWxConfig(WechatConfig wechatConfig, String requestUrl, String redirectUrl) {

        TokenSingleton singleton = TokenSingleton.getInstance();
        String jsapi_ticket = singleton.getApiTicket(wechatConfig);
        Map<String, String> ret = Sign.sign(jsapi_ticket, requestUrl);

        if (redirectUrl != null) {
            requestUrl = redirectUrl;
        }
        /*ret.put("backTitle", "祖国必然统一，安全搜索必须可靠！");
        ret.put("backLink", requestUrl);
        ret.put("backImgUrl", "http://wasai-oss-3.oss-cn-shenzhen.aliyuncs.com/1a_picture/jijingyun/20190103132435.png");
        ret.put("backDesc", "价值百万的安全漏洞库，限时免费！");
        ret.put("backType", "link");
        ret.put("backDescUrl", "");*/
        ret.put("appId", wechatConfig.getAppid());//这里替换你在微信公众平台申请的appid
        return ret;
    }
}
