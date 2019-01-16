package com.wancient.springcloud.user.service;

import com.wancient.springcloud.api.entities.SysUser;

/**
 * 卖家端
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/27
 * Time: 21:16
 */
public interface SysUserService {
    /**
     * 根据openid查询卖家端信息
     *
     * @param openid
     * @return
     */
    SysUser findSysUserByOpenid(String openid);

    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    SysUser findSysUserByUsername(String username);


    /**
     * 根据用户名和密码查询用户信息
     *
     * @param username
     * @param password
     * @return
     */
    SysUser findSysUserByUsernamePassword(String username, String password);
}
