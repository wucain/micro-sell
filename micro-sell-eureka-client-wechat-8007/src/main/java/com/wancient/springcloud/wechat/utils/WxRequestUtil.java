package com.wancient.springcloud.wechat.utils;


import com.google.gson.Gson;
import com.wancient.springcloud.api.utils.HttpUtil;
import com.wancient.springcloud.api.wechat.*;
import com.wancient.springcloud.wechat.config.WechatConfig;
import com.wancient.springcloud.wechat.singleton.TokenSingleton;
import lombok.extern.slf4j.Slf4j;
import net.sf.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

/**
 * 微信相关请求
 *
 * @author CainWu
 * @date 2018/8/27 14:56
 */
@Slf4j
public class WxRequestUtil {


    /**
     * 获取token
     *
     * @return
     */
    public AccessToken getAddressOAToken(WechatConfig wechatConfig) {
        AccessToken accessToken = new AccessToken();
        String url = WxUrlUtil.GET_GET_TOKEN_URL.replace("APPID", wechatConfig.getAppid())
                .replace("APPSECRET", wechatConfig.getSecret());
        try {
            String result = HttpUtil.doGet(url);
            log.info("TOKEN请求返回数据:{}", result);
            accessToken = new Gson().fromJson(result, AccessToken.class);
        } catch (Exception e) {
            log.error("获取通讯录token出错：{}", e.getMessage());
        }
        return accessToken;
    }

    /**
     * 根据code获取access_token
     *
     * @param wechatConfig
     * @param code
     * @return
     */
    public AccessToken getAccessToken(WechatConfig wechatConfig, String code) {
        TokenSingleton singleton = TokenSingleton.getInstance();
        String access_token = singleton.getToken(wechatConfig);
        AccessToken accessToken = null;
        String url = WxUrlUtil.GET_ACCESS_TOKEN_URL.replace("APPID", wechatConfig.appid).replace("SECRET", wechatConfig.secret).replace("ACCESS_TOKEN", access_token).replace("CODE", code);
        try {
            log.info("URL:{}", url);
            String result = HttpUtil.doGet(url);
            log.info("请求返回数据：{}", result);
            accessToken = new Gson().fromJson(result, AccessToken.class);
        } catch (Exception e) {
            log.info("错误信息：{}", e);
        }
        return accessToken;
    }

    /**
     * 根据openID获取用户信息
     *
     * @param wechatConfig
     * @param accessToken
     * @return
     */
    public WechatUserInfo getUserInfo(WechatConfig wechatConfig, AccessToken accessToken) {
        WechatUserInfo userInfo = null;
        String url = WxUrlUtil.GET_USER_INFO_URL.replace("ACCESS_TOKEN", accessToken.getAccess_token()).replace("OPENID", accessToken.getOpenid());
        try {
            String result = HttpUtil.doGet(url);
            log.info("获取用户信息,请求返回数据:{}", result);
            userInfo = new Gson().fromJson(result, WechatUserInfo.class);
        } catch (Exception e) {
            log.error("获取用户信息错误{},", e.getMessage());
        }
        return userInfo;
    }

    /**
     * 根据access_token获取api_ticket
     *
     * @param access_token
     * @return
     */
    public WxJsapiTicket getTicket(String access_token) {
        WxJsapiTicket jsapiTicket = null;
        String url = WxUrlUtil.GET_API_TICKET_URL.replace("ACCESS_TOKEN", access_token);
        try {
            String result = HttpUtil.doGet(url);
            log.info("获取api_ticket,请求返回数据:{}", result);
            jsapiTicket = new Gson().fromJson(result, WxJsapiTicket.class);
        } catch (Exception e) {
            log.error("获取api_ticket错误{},", e.getMessage());
        }
        return jsapiTicket;
    }

    /**
     * 上传其他永久素材(图片素材的上限为5000，其他类型为1000)
     *
     * @return
     * @throws Exception
     */
    public JSONObject addMaterialEver(String fileurl, String type, String token) {
        try {
            String path = WxUrlUtil.POST_ADD_MATERIAL_URL.replace("ACCESS_TOKEN", token).replace("TYPE", "voice");
            File file = new File(fileurl);
            //上传素材
            String result = connectHttpsByPost(path, null, file);
            result = result.replaceAll("[\\\\]", "");
            System.out.println("result:" + result);
            JSONObject resultJSON = JSONObject.fromObject(result);
            if (resultJSON != null) {
                if (resultJSON.get("media_id") != null) {
                    System.out.println("上传" + type + "永久素材成功");
                    return resultJSON;
                } else {
                    System.out.println("上传" + type + "永久素材失败");
                }
            }
            return null;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取素材列表
     *
     * @param wechatConfig
     * @return
     */
    public String getBatchgetMaterial(WechatConfig wechatConfig, String type, Integer offset, Integer count) {
        TokenSingleton singleton = TokenSingleton.getInstance();
        String access_token = singleton.getToken(wechatConfig);
        String url = WxUrlUtil.GET_MATERIAL_BATCHGET_MATERIAL_URL.replace("ACCESS_TOKEN", access_token);
        BatchgetMaterial material = new BatchgetMaterial();
        material.setType(type);
        Gson gson = new Gson();
        try {
            String result = HttpUtil.doPost(url, gson.toJson(mediaId));
            log.info("获取永久素材,请求返回数据:{}", result);
            return result;
        } catch (Exception e) {
            log.error("获取永久素材错误{},", e.getMessage());
        }
        return "";
    }

    /**
     * 获取永久素材
     *
     * @param wechatConfig
     * @return
     */
    public String getMaterial(WechatConfig wechatConfig, String mediaId, String type) {
        TokenSingleton singleton = TokenSingleton.getInstance();
        String access_token = singleton.getToken(wechatConfig);
        String url = WxUrlUtil.GET_MATERIAL_GET_MATERIAL_URL.replace("ACCESS_TOKEN", access_token);
        Material material = new Material();
        material.setMedia_id(mediaId);
        Gson gson = new Gson();
        try {
            String result = HttpUtil.doPost(url, gson.toJson(mediaId));
            log.info("获取永久素材,请求返回数据:{}", result);
            return result;
        } catch (Exception e) {
            log.error("获取永久素材错误{},", e.getMessage());
        }
        return "";
    }

    public String connectHttpsByPost(String path, String KK, File file) throws IOException, NoSuchAlgorithmException, NoSuchProviderException, KeyManagementException {
        URL urlObj = new URL(path);
        //连接
        HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
        String result = null;
        con.setRequestMethod("POST");
        con.setDoInput(true);

        con.setDoOutput(true);

        con.setUseCaches(false); // post方式不能使用缓存

        // 设置请求头信息
        con.setRequestProperty("Connection", "Keep-Alive");
        con.setRequestProperty("Charset", "UTF-8");
        // 设置边界
        String BOUNDARY = "----------" + System.currentTimeMillis();
        con.setRequestProperty("Content-Type",
                "multipart/form-data; boundary="
                        + BOUNDARY);

        // 请求正文信息
        // 第一部分：
        StringBuilder sb = new StringBuilder();
        sb.append("--"); // 必须多两道线
        sb.append(BOUNDARY);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data;name=\"media\";filelength=\"" + file.length() + "\";filename=\""

                + file.getName() + "\"\r\n");
        sb.append("Content-Type:application/octet-stream\r\n\r\n");
        byte[] head = sb.toString().getBytes("utf-8");
        // 获得输出流
        OutputStream out = new DataOutputStream(con.getOutputStream());
        // 输出表头
        out.write(head);

        // 文件正文部分
        // 把文件已流文件的方式 推入到url中
        DataInputStream in = new DataInputStream(new FileInputStream(file));
        int bytes = 0;
        byte[] bufferOut = new byte[1024];
        while ((bytes = in.read(bufferOut)) != -1) {
            out.write(bufferOut, 0, bytes);
        }
        in.close();
        // 结尾部分
        byte[] foot = ("\r\n--" + BOUNDARY + "--\r\n").getBytes("utf-8");// 定义最后数据分隔线
        out.write(foot);
        out.flush();
        out.close();
        StringBuffer buffer = new StringBuffer();
        BufferedReader reader = null;
        try {
            // 定义BufferedReader输入流来读取URL的响应
            reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            if (result == null) {
                result = buffer.toString();
            }
        } catch (IOException e) {
            System.out.println("发送POST请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return result;
    }

}
