package com.wancient.springcloud.wechat.utils;

/**
 * 微信相关请求地址
 *
 * @author CainWu
 * @date 2018/8/27 14:52
 */
public class WxUrlUtil {


    /**
     * 根据code网页授权access_token URL
     */
    public static final String GET_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";


    /**
     * 刷新access_token
     */
    public static String GET_REFRESH_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/refresh_token?appid=APPID&grant_type=refresh_token&refresh_token=REFRESH_TOKEN";

    /**
     * 获取Token URL
     */

    public static String GET_GET_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";


    /**
     * 拉取用户信息 URL
     */
    public static final String GET_USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";


    /**
     * 获取api_ticket
     */
    public static final String GET_API_TICKET_URL = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=ACCESS_TOKEN&type=jsapi";

    /**
     * 获取临时素材
     */
    public static final String GET_MEDIA_GET_URL = "https://api.weixin.qq.com/cgi-bin/media/get?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

    /**
     * 高清语音素材获取接口
     */
    public static final String GET_MEDIA_GET_JSSDK_URL = "https://api.weixin.qq.com/cgi-bin/media/get/jssdk?access_token=ACCESS_TOKEN&media_id=MEDIA_ID";

    /**
     * 新增其他类型永久素材
     */
    public static final String POST_ADD_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/add_material?access_token=ACCESS_TOKEN&type=TYPE";


    /**
     * 获取永久素材的列表
     */
    public static final String GET_MATERIAL_BATCHGET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN";
    /**
     * 获取永久素材
     */
    public static final String GET_MATERIAL_GET_MATERIAL_URL = "https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN";
}
