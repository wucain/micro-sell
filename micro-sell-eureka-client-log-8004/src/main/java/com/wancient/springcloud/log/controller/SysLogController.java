package com.wancient.springcloud.log.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wancient.springcloud.api.entities.ProductInfo;
import com.wancient.springcloud.api.entities.SysLog;
import com.wancient.springcloud.api.enums.EnabledEnum;
import com.wancient.springcloud.api.utils.KeyUtil;
import com.wancient.springcloud.api.utils.ResultVoUtil;
import com.wancient.springcloud.api.vo.ResultVo;
import com.wancient.springcloud.log.service.SysLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/5
 * Time: 16:15
 * To change this template use File | Settings | File Templates.
 **/
@RestController
@RequestMapping("/manage/log")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    /**
     * 根据主键id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/index")
    public SysLog get(@RequestParam("id") String id) {
        return sysLogService.findOne(id);
    }


    /**
     * 查询全部
     *
     * @param
     * @return
     */
    @GetMapping("/list")
    public ResultVo list(@RequestBody SysLog sysLog) {
        //分页查询数据
        PageHelper.startPage(sysLog.getPageNum(), sysLog.getPageSize(), " visit_time desc");
        List<SysLog> logList = sysLogService.selectAll(sysLog);
        PageInfo pageInfo = new PageInfo<SysLog>(logList);
        return ResultVoUtil.success(pageInfo);
    }

    /**
     * 新增
     *
     * @param sysLog
     * @return
     */
    @PostMapping("/save")
    public Integer insert(@RequestBody SysLog sysLog) {
        System.out.println("时间:" + sysLog.getVisitTime());
        return sysLogService.save(sysLog);
    }
}
