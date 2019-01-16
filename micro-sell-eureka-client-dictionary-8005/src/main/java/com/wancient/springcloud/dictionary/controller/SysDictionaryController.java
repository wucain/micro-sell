package com.wancient.springcloud.dictionary.controller;

import com.google.gson.Gson;
import com.wancient.springcloud.api.entities.SysDictionary;
import com.wancient.springcloud.api.form.DictionaryForm;
import com.wancient.springcloud.api.utils.KeyUtil;
import com.wancient.springcloud.api.utils.ResultVoUtil;
import com.wancient.springcloud.api.vo.ResultVo;
import com.wancient.springcloud.dictionary.service.SysDictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 字典
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/11
 * Time: 9:46
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/dictionary")
@RestController
@Slf4j
public class SysDictionaryController {

    @Autowired
    private SysDictionaryService sysDictionaryService;


    /**
     * 查询集合
     *
     * @param dictionaryForm
     * @return
     */
    @PostMapping("/list")
    public ResultVo<List<SysDictionary>> list(@RequestBody DictionaryForm dictionaryForm) {
        log.info("日志:{}", dictionaryForm.toString());
        SysDictionary sysDictionary = new SysDictionary();
        //复制
        BeanUtils.copyProperties(dictionaryForm, sysDictionary);
        //分页查询数据
        List<SysDictionary> sysDictionaryList = sysDictionaryService.selectAll(sysDictionary);
        return ResultVoUtil.success(sysDictionaryList);
    }


    /**
     * 保存、更新
     *
     * @param dictionaryForm
     * @return
     */
    @PostMapping("/save")
    public ResultVo<Integer> save(@RequestBody DictionaryForm dictionaryForm) {
        Integer result = 0;
        try {
            SysDictionary sysDictionary = new SysDictionary();
            if (dictionaryForm != null && !StringUtils.isEmpty(dictionaryForm.getId())) {
                sysDictionary = sysDictionaryService.selectByPrimaryKey(dictionaryForm.getId());
            } else {
                dictionaryForm.setCode(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(dictionaryForm, sysDictionary);
            result = sysDictionaryService.insert(sysDictionary);
        } catch (Exception e) {
            log.error("【字典保存、更新】 发生异常{}", e.getMessage());
            result = -1;
        }
        return ResultVoUtil.success(result);
    }
}
