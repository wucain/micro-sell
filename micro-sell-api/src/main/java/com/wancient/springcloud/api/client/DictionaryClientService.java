package com.wancient.springcloud.api.client;

import com.wancient.springcloud.api.entities.ProductCategory;
import com.wancient.springcloud.api.entities.SysDictionary;
import com.wancient.springcloud.api.form.CategoryForm;
import com.wancient.springcloud.api.form.DictionaryForm;
import com.wancient.springcloud.api.vo.ResultVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/11
 * Time: 10:32
 * To change this template use File | Settings | File Templates.
 **/
@FeignClient(value = "MICRO-DICTIONARY")
public interface DictionaryClientService {

    /**
     * 查询全部
     *
     * @param dictionaryForm
     * @return
     */
    @PostMapping("/manage/dictionary/list")
    ResultVo<List<SysDictionary>> list(@RequestBody DictionaryForm dictionaryForm);


    /**
     * 新增
     *
     * @param dictionaryForm
     * @return
     */
    @PostMapping("/manage/dictionary/save")
    ResultVo<Integer> insert(@RequestBody DictionaryForm dictionaryForm);


    /**
     * 根据主键id更新
     *
     * @param dictionaryForm
     * @return
     */
    @PostMapping("/manage/dictionary/save")
    ResultVo<Integer> update(@RequestBody DictionaryForm dictionaryForm);
}
