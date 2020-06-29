package com.wancient.springcloud.wechatuser.service;

import com.wancient.springcloud.api.entities.WechatUser;

import java.util.List;

/**
 * 卖家端
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/27
 * Time: 21:16
 */
public interface WechatUserService {


    /**
     * 获取用户id
     *
     * @param wxId
     * @return
     */
    WechatUser findByWxId(String wxId);

    /**
     * 根据openid查询用户信息
     *
     * @param openid
     * @return
     */
    WechatUser findWechatUserByOpenid(String openid);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    WechatUser findWechatUserByUsername(String username);


    /**
     * 根据用户名和密码查询用户信息
     *
     * @param username
     * @param password
     * @return
     */
    WechatUser findWechatUserByUsernamePassword(String username, String password);


    /**
     * 获取用户列表
     *
     * @param wechatUser
     * @return
     */
    List<WechatUser> list(WechatUser wechatUser);


    /**
     * 保存用户信息
     *
     * @param wechatUser
     * @return
     */
    Integer insert(WechatUser wechatUser);

    /**
     * 更新用户信息
     *
     * @param wechatUser
     * @return
     */
    Integer update(WechatUser wechatUser);

}
