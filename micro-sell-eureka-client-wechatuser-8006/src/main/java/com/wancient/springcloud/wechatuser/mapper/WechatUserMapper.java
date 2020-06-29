package com.wancient.springcloud.wechatuser.mapper;

import com.wancient.springcloud.api.entities.WechatUser;

import java.util.List;

public interface WechatUserMapper {

    /**
     * 根据id查询
     *
     * @param wxId
     * @return
     */
    WechatUser selectByPrimaryKey(String wxId);

    /**
     * 根据openid查询
     *
     * @param openid
     * @return
     */
    WechatUser selectByOpenid(String openid);

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    WechatUser selectByUsername(String username);

    /**
     * 查询全部
     *
     * @param wechatUser
     * @return
     */
    List<WechatUser> selectAll(WechatUser wechatUser);

    /**
     * 根据id真删除
     *
     * @param wxId
     * @return
     */
    int deleteByPrimaryKey(String wxId);

    /**
     * 根据主键id批量真删除
     *
     * @param arr
     * @return
     */
    int deleteByPrimaryKeyIn(String[] arr);

    /**
     * 新增
     *
     * @param wechatUser
     * @return
     */
    int insert(WechatUser wechatUser);

    /**
     * 新增部分字段
     *
     * @param wechatUser
     * @return
     */
    int insertSelective(WechatUser wechatUser);

    /**
     * 根据主键部分更新
     *
     * @param wechatUser
     * @return
     */
    int updateByPrimaryKeySelective(WechatUser wechatUser);

    /**
     * 根据主键id更新
     *
     * @param wechatUser
     * @return
     */
    int updateByPrimaryKey(WechatUser wechatUser);
}