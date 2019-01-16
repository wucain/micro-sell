package com.wancient.springcloud.log.service.impl;

import com.wancient.springcloud.api.entities.SysLog;
import com.wancient.springcloud.log.mapper.SysLogMapper;
import com.wancient.springcloud.log.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/30
 * Time: 23:33
 */
@Service
public class SysLogServiceImpl implements SysLogService {

    @Autowired
    private SysLogMapper mapper;

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public SysLog findOne(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询全部
     *
     * @param sysLog
     * @return
     */
    @Override
    public List<SysLog> selectAll(SysLog sysLog) {
        return mapper.selectAll(sysLog);
    }

    /**
     * 新增
     *
     * @param sysLog
     * @return
     */
    @Override
    public int save(SysLog sysLog) {
        return mapper.insertSelective(sysLog);
    }
}
