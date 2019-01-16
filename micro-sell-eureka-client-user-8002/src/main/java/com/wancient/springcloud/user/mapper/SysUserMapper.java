package com.wancient.springcloud.user.mapper;

import com.wancient.springcloud.api.entities.SysUser;

import java.util.List;

public interface SysUserMapper {

    /**
     * 根据id查询
     *
     * @param userId
     * @return
     */
    SysUser selectByPrimaryKey(String userId);

    /**
     * 根据openid查询
     *
     * @param openid
     * @return
     */
    SysUser selectByOpenid(String openid);

    /**
     * 根据用户名查询
     *
     * @param username
     * @return
     */
    SysUser selectByUsername(String username);

    /**
     * 查询全部
     *
     * @param sysUser
     * @return
     */
    List<SysUser> selectAll(SysUser sysUser);

    /**
     * 根据id真删除
     *
     * @param userId
     * @return
     */
    int deleteByPrimaryKey(String userId);

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
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 新增部分字段
     *
     * @param sysUser
     * @return
     */
    int insertSelective(SysUser sysUser);

    /**
     * 根据主键部分更新
     *
     * @param sysUser
     * @return
     */
    int updateByPrimaryKeySelective(SysUser sysUser);

    /**
     * 根据主键id更新
     *
     * @param sysUser
     * @return
     */
    int updateByPrimaryKey(SysUser sysUser);
}