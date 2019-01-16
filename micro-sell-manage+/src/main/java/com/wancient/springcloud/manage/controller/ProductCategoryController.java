package com.wancient.springcloud.manage.controller;


import com.wancient.springcloud.api.client.CategoryClientService;
import com.wancient.springcloud.api.entities.ProductCategory;
import com.wancient.springcloud.api.enums.ResultEnum;
import com.wancient.springcloud.api.form.CategoryForm;
import com.wancient.springcloud.api.utils.ResultVoUtil;
import com.wancient.springcloud.api.vo.CateGoryVo;
import com.wancient.springcloud.api.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/20
 * Time: 16:20
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/product")
@Controller
@Slf4j
public class ProductCategoryController {

    @Autowired
    private CategoryClientService categoryClientService;

    /**
     * 分类页面
     *
     * @return
     */
    @GetMapping("/category/list.html")
    public String list() {
        return "/product/product-category-list";
    }


    /**
     * 获取分类json
     *
     * @return
     */
    @GetMapping("/category/list_json")
    @ResponseBody
    public List<CateGoryVo> getListToJson() {
        //获取类目列表
        List<ProductCategory> productCategoryList = categoryClientService.list();
        List<CateGoryVo> list = new ArrayList<>();
        CateGoryVo cateGoryVo = null;
        for (ProductCategory category : productCategoryList) {
            cateGoryVo = new CateGoryVo();
            cateGoryVo.setId(category.getCategoryId());
            cateGoryVo.setName(category.getCategoryName());
            cateGoryVo.setPid(category.getParentId());
            if (category.getCategoryId() == 0) {
                cateGoryVo.setOpen(true);
            }
            list.add(cateGoryVo);
        }
        return list;
    }

    /**
     * 添加页面
     *
     * @return
     */
    @GetMapping("/category/add.html")
    public String add() {
        return "/product/product-category-add";
    }

    /**
     * 编辑数据
     *
     * @return
     */
    @PostMapping(value = "/category/edit")
    @ResponseBody
    public ResultVo edit(CategoryForm categoryForm) {
        int result = 0;
        try {
            if (categoryForm != null && StringUtils.isEmpty(categoryForm.getCategoryId())) {
                result = categoryClientService.insert(categoryForm);
            } else if (categoryForm != null && !StringUtils.isEmpty(categoryForm.getCategoryId())) {
                result = categoryClientService.update(categoryForm);
            }
        } catch (Exception e) {
            return ResultVoUtil.error(-1, "系统异常！");
        }
        if (result == 0) {
            return ResultVoUtil.error(100, "保存失败！");
        }
        return ResultVoUtil.error(0, "保存成功！");
    }


    /**
     * 获取单个数据
     *
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/category/get/{id}.html")
    public String get(@PathVariable(value = "id") Integer id, Map<String, Object> map) {
        ProductCategory productCategory = categoryClientService.get(id);
        System.out.println("结果：" + productCategory == null ? "空" : productCategory.getCategoryName());
        map.put("productCategory", productCategory);
        return "/product/product-category-add";
    }


    /**
     * 删除
     *
     * @param categoryId
     * @return
     */
    @GetMapping("/category/delete/{id}")
    @ResponseBody
    public ResultVo delete(@PathVariable(value = "id") Integer categoryId) {
        int result = 0;
        try {
            if (StringUtils.isEmpty(categoryId)) {
                return ResultVoUtil.error(1, "参数为空！");
            } else {
                result = categoryClientService.deleteTrue(categoryId);
            }
        } catch (Exception e) {
            return ResultVoUtil.error(-1, "系统异常！");
        }
        if (result == 0) {
            return ResultVoUtil.error(100, "删除失败！");
        }
        return ResultVoUtil.error(0, "删除成功！");
    }
}
