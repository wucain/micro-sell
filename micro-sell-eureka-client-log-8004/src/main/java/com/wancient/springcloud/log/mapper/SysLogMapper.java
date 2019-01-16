package com.wancient.springcloud.log.mapper;

import com.wancient.springcloud.api.entities.SysLog;

import java.util.List;

public interface SysLogMapper {

    /**
     * 新增
     *
     * @param sysLog
     * @return
     */
    int insert(SysLog sysLog);

    /**
     * 新增部分字段
     *
     * @param sysLog
     * @return
     */
    int insertSelective(SysLog sysLog);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    SysLog selectByPrimaryKey(String id);

    /**
     * 查询全部
     *
     * @param sysLog
     * @return
     */
    List<SysLog> selectAll(SysLog sysLog);

}