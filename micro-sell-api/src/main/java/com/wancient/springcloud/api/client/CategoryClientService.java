package com.wancient.springcloud.api.client;

import com.wancient.springcloud.api.entities.ProductCategory;
import com.wancient.springcloud.api.form.CategoryForm;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/7
 * Time: 10:21
 * To change this template use File | Settings | File Templates.
 **/
//服务熔断
@FeignClient(value = "MICRO-CATEGORY")
//@FeignClient(value = "MICRO-CATEGORY", fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface CategoryClientService {

    /**
     * 根据主键id查询
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/manage/category/index")
    ProductCategory get(@RequestParam("categoryId") Integer categoryId);


    /**
     * 查询全部
     *
     * @param
     * @return
     */
    @GetMapping("/manage/category/list")
    List<ProductCategory> list();

    /**
     * 根据主键id真删除
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/manage/category/delete_true")
    int deleteTrue(@RequestParam("categoryId") Integer categoryId);

    /**
     * 根据主键id逻辑删除
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/manage/category/delete_false")
    int deleteFalse(@RequestParam("categoryId") Integer categoryId);

    /**
     * 新增
     *
     * @param categoryForm
     * @return
     */
    @PostMapping("/manage/category/save")
    int insert(CategoryForm categoryForm);


    /**
     * 根据主键id更新
     *
     * @param categoryForm
     * @return
     */
    @PostMapping("/manage/category/save")
    int update(CategoryForm categoryForm);


}
