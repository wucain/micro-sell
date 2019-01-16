package com.wancient.springcloud.api.client;

import com.wancient.springcloud.api.entities.SysLog;
import com.wancient.springcloud.api.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/15
 * Time: 10:15
 * To change this template use File | Settings | File Templates.
 **/
@FeignClient(value = "MICRO-LOG")
public interface LogClientService {


    /**
     * 根据主键id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/manage/log/index")
    SysLog get(@RequestParam("id") String id);


    /**
     * 查询全部
     *
     * @param
     * @return
     */
    @GetMapping("/manage/log/list")
    List<SysLog> list(@RequestBody SysLog sysLog);

    /**
     * 新增
     *
     * @param sysLog
     * @return
     */
    @PostMapping("/manage/log/save")
    Integer insert(@RequestBody SysLog sysLog);

}
