package com.wancient.springcloud.log.service;

import com.wancient.springcloud.api.entities.SysLog;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/30
 * Time: 23:31
 */
public interface SysLogService {

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    SysLog findOne(String id);

    /**
     * 查询全部
     *
     * @param sysLog
     * @return
     */
    List<SysLog> selectAll(SysLog sysLog);

    /**
     * 保存
     *
     * @param sysLog
     * @return
     */
    int save(SysLog sysLog);
}
