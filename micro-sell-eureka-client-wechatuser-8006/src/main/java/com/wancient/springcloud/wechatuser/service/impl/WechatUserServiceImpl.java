package com.wancient.springcloud.wechatuser.service.impl;

import com.wancient.springcloud.api.entities.WechatUser;
import com.wancient.springcloud.api.utils.MD5Util;
import com.wancient.springcloud.wechatuser.mapper.WechatUserMapper;
import com.wancient.springcloud.wechatuser.service.WechatUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/27
 * Time: 21:18
 */
@Service
@Slf4j
public class WechatUserServiceImpl implements WechatUserService {

    @Autowired
    private WechatUserMapper mapper;

    /**
     * 获取用户信息
     *
     * @param wxId
     * @return
     */
    @Override
    public WechatUser findByWxId(String wxId) {
        WechatUser sysUser = mapper.selectByPrimaryKey(wxId);
        return sysUser;
    }

    /**
     * 根据openid查询用户信息
     *
     * @param openid
     * @return
     */
    @Override
    public WechatUser findWechatUserByOpenid(String openid) {
        WechatUser sysUser = mapper.selectByOpenid(openid);
        return sysUser;
    }


    /**
     * 根据用户名查询用户信息
     *
     * @param username
     * @return
     */
    @Override
    public WechatUser findWechatUserByUsername(String username) {
        WechatUser sysUser = mapper.selectByUsername(username);
        return sysUser;
    }


    /**
     * 根据用户名和密码登录
     *
     * @param username
     * @param password
     * @return
     */
    @Override
    public WechatUser findWechatUserByUsernamePassword(String username, String password) {
        System.out.println("名称：" + username);
        System.out.println("密码：" + password);
        WechatUser sysUser = mapper.selectByUsername(username);
        System.out.println("user:" + sysUser.toString());
        return sysUser;
    }

    /**
     * 获取用户列表
     *
     * @param sysUser
     * @return
     */
    @Override
    public List<WechatUser> list(WechatUser sysUser) {
        return mapper.selectAll(sysUser);
    }


    /**
     * 新建用户
     *
     * @param sysUser
     * @return
     */
    @Override
    public Integer insert(WechatUser sysUser) {
        return mapper.insertSelective(sysUser);
    }

    /**
     * 更新用户信息
     *
     * @param sysUser
     * @return
     */
    @Override
    public Integer update(WechatUser sysUser) {
        return mapper.updateByPrimaryKeySelective(sysUser);
    }

}
