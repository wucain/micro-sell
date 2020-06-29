package com.wancient.springcloud.user.service;

import com.wancient.springcloud.api.entities.SysUser;

import java.util.List;

/**
 * 卖家端
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/27
 * Time: 21:16
 */
public interface SysUserService {


    /**
     * 获取用户id
     *
     * @param userId
     * @return
     */
    SysUser findByUserId(String userId);

    /**
     * 根据openid查询用户信息
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


    /**
     * 获取用户列表
     *
     * @param sysUser
     * @return
     */
    List<SysUser> list(SysUser sysUser);


    /**
     * 保存用户信息
     *
     * @param sysUser
     * @return
     */
    Integer insert(SysUser sysUser);

    /**
     * 更新用户信息
     *
     * @param sysUser
     * @return
     */
    Integer update(SysUser sysUser);

}
