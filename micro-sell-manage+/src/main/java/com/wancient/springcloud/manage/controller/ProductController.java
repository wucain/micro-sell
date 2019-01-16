package com.wancient.springcloud.manage.controller;

import com.wancient.springcloud.api.client.CategoryClientService;
import com.wancient.springcloud.api.client.ProductClientService;
import com.wancient.springcloud.api.entities.ProductCategory;
import com.wancient.springcloud.api.entities.ProductInfo;
import com.wancient.springcloud.api.form.ProductForm;
import com.wancient.springcloud.api.vo.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/20
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
 **/
@RequestMapping("/manage/product")
@Controller
@Slf4j
public class ProductController {

    @Autowired
    private CategoryClientService categoryClientService;

    @Autowired
    private ProductClientService productClientService;

    /**
     * list页面
     *
     * @param categoryId
     * @param startTime
     * @param endTime
     * @param categoryName
     * @param pageSize
     * @param pageNum
     * @param map
     * @return
     */
    @GetMapping("/list.html")
    public String list(@RequestParam(value = "id", required = false, defaultValue = "0") Integer categoryId, @RequestParam(value = "startTime", required = false) String startTime,
                       @RequestParam(value = "endTime", required = false) String endTime, @RequestParam(value = "name", required = false) String categoryName,
                       @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                       Map map) {
        //默认查询当月的全部数据
        ProductForm productForm = new ProductForm();
        productForm.setPageNum(pageNum);
        productForm.setPageSize(pageSize);
        if (categoryId != 0) {
            //根据id找到type
            ProductCategory productCategory = categoryClientService.get(categoryId);
            productForm.setCategoryType(productCategory == null ? null : productCategory.getCategoryType());
        }
        //名称、描述
        if (!StringUtils.isEmpty(categoryName)) {
            productForm.setProductDescription(categoryName);
            productForm.setProductName(categoryName);
        }
        //开始时间
        if (!StringUtils.isEmpty(startTime)) {
            productForm.setStartTime(startTime);
        }
        //结束时间
        if (!StringUtils.isEmpty(endTime)) {
            productForm.setEndTime(endTime);
        }
        ResultVo resultVo = productClientService.list(productForm);
        map.put("resultVo", resultVo);
        return "/product/product-list";
    }

    /**
     * 查询list
     *
     * @param categoryId
     * @param startTime
     * @param endTime
     * @param categoryName
     * @param pageSize
     * @param pageNum
     * @return
     */
    @GetMapping("/list_query.html")
    @ResponseBody
    public ResultVo queryList(@RequestParam(value = "categoryId", required = false, defaultValue = "0") Integer categoryId, @RequestParam(value = "startTime", required = false) String startTime,
                              @RequestParam(value = "endTime", required = false) String endTime, @RequestParam(value = "categoryName", required = false) String categoryName,
                              @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize, @RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum) {
        //默认查询当月的全部数据
        ProductForm productForm = new ProductForm();
        productForm.setPageNum(pageNum);
        productForm.setPageSize(pageSize);
        if (categoryId != 0) {
            //根据id找到type
            ProductCategory productCategory = categoryClientService.get(categoryId);
            productForm.setCategoryType(productCategory == null ? null : productCategory.getCategoryType());
        }
        //名称、描述
        if (!StringUtils.isEmpty(categoryName)) {
            productForm.setProductDescription(categoryName);
            productForm.setProductName(categoryName);
        }
        //开始时间
        if (!StringUtils.isEmpty(startTime)) {
            productForm.setStartTime(startTime);
        }
        //结束时间
        if (!StringUtils.isEmpty(endTime)) {
            productForm.setEndTime(endTime);
        }
        log.info("查询出结果了");
        ResultVo resultVo = productClientService.list(productForm);
        log.info(resultVo.getData().toString());
        return resultVo;
    }

    @RequestMapping("/show/{id}.html")
    public String show(@PathVariable(value = "id", required = false) String productId, Map map) {
        log.info("productId:{}", productId);
        ProductInfo productInfo = new ProductInfo();
        //空或0
        if (!StringUtils.isEmpty(productId) && !"0".equals(productId)) {
            productInfo = productClientService.get(productId);
        }
        map.put("productInfo", productInfo);
        return "/product/product-show";
    }
}
