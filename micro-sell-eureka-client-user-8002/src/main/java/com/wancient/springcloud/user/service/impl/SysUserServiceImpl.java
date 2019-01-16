package com.wancient.springcloud.user.service.impl;

import com.wancient.springcloud.api.entities.SysUser;
import com.wancient.springcloud.api.utils.MD5Util;
import com.wancient.springcloud.user.mapper.SysUserMapper;
import com.wancient.springcloud.user.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/27
 * Time: 21:18
 */
@Service
@Slf4j
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper mapper;

    /**
     * 根据openid查询用户信息
     *
     * @param openid
     * @return
     */
    @Override
    public SysUser findSysUserByOpenid(String openid) {
        SysUser sysUser = mapper.selectByOpenid(openid);
        if (sysUser != null) {
            sysUser.setPassword(StringUtils.EMPTY);
            return sysUser;
        }
        return null;
    }


    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    @Override
    public SysUser findSysUserByUsername(String username) {
        SysUser sysUser = mapper.selectByUsername(username);
        if (sysUser != null) {
            sysUser.setPassword(StringUtils.EMPTY);
            return sysUser;
        }
        return null;
    }


    /**
     * 根据用户名和密码登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public SysUser findSysUserByUsernamePassword(String username, String password) {
        System.out.println("名称：" + username);
        System.out.println("密码：" + password);
        SysUser sysUser = mapper.selectByUsername(username);
        System.out.println("user:" + sysUser.toString());
        if (sysUser != null) {
            if (sysUser.getPassword().equals(MD5Util.MD5EncodeUtf8(password))) {
                sysUser.setPassword(StringUtils.EMPTY);
                return sysUser;
            }
        }
        return null;
    }
}
