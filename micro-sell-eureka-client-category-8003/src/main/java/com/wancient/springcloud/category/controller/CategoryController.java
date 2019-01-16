package com.wancient.springcloud.category.controller;


import com.wancient.springcloud.api.entities.ProductCategory;
import com.wancient.springcloud.api.enums.ResultEnum;
import com.wancient.springcloud.api.form.CategoryForm;
import com.wancient.springcloud.category.service.ProductCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 后台类目管理
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/26
 * Time: 23:03
 */
@RestController
@RequestMapping("/manage/category")
@Slf4j
public class CategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    /**
     * 获取list
     *
     * @param map
     * @return
     */
    @GetMapping("/list")
    public List<ProductCategory> list(Map<String, Object> map) {
        List<ProductCategory> productCategoryList = productCategoryService.selectAll(new ProductCategory());
        map.put("model", productCategoryList);
        return productCategoryList;
    }

    /**
     * 查询单个
     *
     * @param categoryId
     * @param map
     * @return
     */
    @GetMapping("/index")
    public ProductCategory index(@RequestParam(value = "categoryId", required = false) Integer categoryId,
                                 Map<String, Object> map) {
        log.info("categoryId:", categoryId);
        System.out.println("categoryId:--" + categoryId);
        ProductCategory productCategory = new ProductCategory();
        if (!StringUtils.isEmpty(categoryId) && categoryId != 0) {
            productCategory = productCategoryService.selectByPrimaryKey(categoryId);
        }
        return productCategory;
    }

    public List<ProductCategory> getListByParentId(@RequestParam(value = "parentId", required = false) Integer parentId, Map<String, Object> map) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setParentId(parentId);
        List<ProductCategory> productCategoryList = productCategoryService.selectAll(productCategory);
        map.put("model", productCategoryList);
        return productCategoryList;
    }


    /**
     * 保存、更新
     *
     * @return
     */
    @PostMapping("/save")
    public Integer save(@RequestBody CategoryForm categoryForm) {
        ProductCategory productCategory = new ProductCategory();
        try {
            //id存在先查找-更新
            if (categoryForm != null && !StringUtils.isEmpty(categoryForm.getCategoryId())) {
                productCategory = productCategoryService.selectByPrimaryKey(categoryForm.getCategoryId());
            }
            //复制
            BeanUtils.copyProperties(categoryForm, productCategory);
            //新增
            if (StringUtils.isEmpty(productCategory.getCategoryId())) {
                return productCategoryService.insertSelective(productCategory);
            } else {
                //修改
                return productCategoryService.updateByPrimaryKey(productCategory);
            }
        } catch (Exception e) {
            log.error("【类目保存、更新】 发生异常{}", e.getMessage());
            return 0;
        }
    }

    /**
     * 真删除
     *
     * @return
     */
    @GetMapping("/delete_true")
    public Integer deleteTrue(@RequestParam(value = "categoryId", required = false) Integer categoryId) {
        try {
            if (StringUtils.isEmpty(categoryId)) {
                log.info("参数为空");
                return 0;
            } else {
                return productCategoryService.deleteByPrimaryKey(categoryId);
            }
        } catch (Exception e) {
            log.info("系统异常：{}", e.getMessage());
            return 0;
        }
    }

    /**
     * 逻辑删除
     *
     * @return
     */
    @GetMapping("/delete_false")
    public Integer deleteFalse(@RequestParam(value = "categoryId", required = false) Integer categoryId) {
        try {
            if (StringUtils.isEmpty(categoryId)) {
                log.info("参数为空");
                return 0;
            } else {
                ProductCategory productCategory = productCategoryService.selectByPrimaryKey(categoryId);
                if (productCategory == null) {
                    log.info("数据不存在");
                    return 0;
                }
                productCategory.setEnabled(1);//逻辑删除
                return productCategoryService.updateByPrimaryKeySelective(productCategory);
            }
        } catch (Exception e) {
            log.info("系统异常：{}", e.getMessage());
            return 0;
        }
    }

}
