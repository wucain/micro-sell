package com.wancient.springcloud.manage.controller;

import com.wancient.springcloud.api.client.CategoryClientService;
import com.wancient.springcloud.api.client.DictionaryClientService;
import com.wancient.springcloud.api.client.ProductClientService;
import com.wancient.springcloud.api.entities.ProductCategory;
import com.wancient.springcloud.api.entities.ProductInfo;
import com.wancient.springcloud.api.entities.SysDictionary;
import com.wancient.springcloud.api.enums.EnabledEnum;
import com.wancient.springcloud.api.form.CategoryForm;
import com.wancient.springcloud.api.form.DictionaryForm;
import com.wancient.springcloud.api.form.ProductForm;
import com.wancient.springcloud.api.utils.ResultVoUtil;
import com.wancient.springcloud.api.utils.TimeUtil;
import com.wancient.springcloud.api.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

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

    @Autowired
    private DictionaryClientService dictionaryClientService;

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
        ResultVo resultVo = productClientService.list(productForm);
        return resultVo;
    }

    /**
     * 显示详情
     *
     * @param productId
     * @param map
     * @return
     */
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

    /**
     * 更改状态（上下架）
     *
     * @param id
     * @param status
     * @return
     */
    @GetMapping("/update_status.html")
    @ResponseBody
    public ResultVo updateStatus(@RequestParam(value = "productId", required = false) String id, @RequestParam(value = "productStatus", required = false) Integer status) {
        if (StringUtils.isEmpty(id) || StringUtils.isEmpty(status)) {
            return ResultVoUtil.error(-1, "参数错误！");
        }
        ProductInfo productInfo = new ProductInfo();
        productInfo.setProductId(id);
        productInfo.setProductStatus(status);
        Integer result = productClientService.updateStatus(id, status);
        if (result == 1) {
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error(1, "保存失败！");
    }

    /**
     * 逻辑删除
     *
     * @param id
     * @return
     */
    @GetMapping("/delete.html")
    @ResponseBody
    public ResultVo deleteFalse(@RequestParam(value = "productId", required = false) String id) {
        if (StringUtils.isEmpty(id)) {
            return ResultVoUtil.error(-1, "参数错误！");
        }
        Integer result = productClientService.deleteFalse(id);
        if (result == 1) {
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error(1, "删除失败！");
    }

    /**
     * 批量逻辑删除
     *
     * @param ids
     * @return
     */
    @GetMapping("/deleteIn.html")
    @ResponseBody
    public ResultVo deleteFalseIn(@RequestParam(value = "productIds", required = false) String ids) {
        if (StringUtils.isEmpty(ids)) {
            return ResultVoUtil.error(-1, "参数错误！");
        }
        Integer result = productClientService.deleteFalseByIn(ids);
        if (result == 1) {
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error(1, "删除失败！");
    }


    /**
     * 新增页面
     *
     * @param map
     * @return
     */
    @GetMapping("/add.html")
    public String add(@RequestParam(value = "productId", required = false) String productId, Map map) {
        ProductInfo productInfo = new ProductInfo();
        if (!StringUtils.isEmpty(productId)) {
            productInfo = productClientService.get(productId);
        }
        map.put("productInfo", productInfo);
        //获取类目列表
        List<ProductCategory> productCategoryList = categoryClientService.list();
        productCategoryList.remove(0);
        map.put("productCategoryList", productCategoryList);
        //获取支付类型
        DictionaryForm dictionaryForm = new DictionaryForm();
        dictionaryForm.setParentId(1);
        ResultVo<List<SysDictionary>> resultVo = dictionaryClientService.list(dictionaryForm);
        List<SysDictionary> payTypeList = resultVo.getData();
        map.put("payTypeList", payTypeList);
        return "/product/product-add1";
    }

    /**
     * 编辑数据
     *
     * @return
     */
    @PostMapping(value = "/edit")
    @ResponseBody
    public ResultVo edit(ProductForm productForm) {
        int result = 0;
        try {
            if (productForm != null && StringUtils.isEmpty(productForm.getProductId())) {
                log.info("新增:{}", productForm.getProductId());
                productForm.setEnabled(EnabledEnum.YES.getCode());
                productForm.setProductStatus(EnabledEnum.YES.getCode());
                result = productClientService.insert(productForm);
            } else if (productForm != null && !StringUtils.isEmpty(productForm.getProductId())) {
                log.info("更新:{}", productForm.getProductId());
                result = productClientService.update(productForm);
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
     * 获取一年每个月的数据
     *
     * @param startYear
     * @param endYear
     * @return
     */
    @GetMapping("/getYearStatisticsVo")
    @ResponseBody
    public List<YearStatisticsVo> getYearStatisticsVo(@RequestParam(value = "startYear", required = false) Integer startYear,
                                                      @RequestParam(value = "endYear", required = false) Integer endYear) {

        Calendar cal = Calendar.getInstance();
        if (StringUtils.isEmpty(startYear) && StringUtils.isEmpty(endYear)) {
            startYear = Integer.valueOf(TimeUtil.getStr(new Date(), "yyyy"));
            endYear = startYear;
        } else if (StringUtils.isEmpty(endYear)) {
            endYear = Integer.valueOf(TimeUtil.getStr(new Date(), "yyyy"));
        } else if (StringUtils.isEmpty(endYear)) {
            startYear = endYear;
        }
        List<YearStatisticsVo> list = new ArrayList<>();
        YearStatisticsVo yearStatisticsVo = null;
        ProductInfo productInfo = null;
        ResultVo<List<ProductInfo>> resultVo = null;
        for (int i = startYear; i <= endYear; i++) {
            List<MonthStatisticsVo> monthStatisticsVoList = new ArrayList<>();
            MonthStatisticsVo monthStatisticsVo = null;
            for (int j = 1; j <= 12; j++) {
                monthStatisticsVo = new MonthStatisticsVo();
                monthStatisticsVo.setMonth(j + "");
                monthStatisticsVo.setTotalMonty(new BigDecimal(0));
                monthStatisticsVoList.add(monthStatisticsVo);
            }

            yearStatisticsVo = new YearStatisticsVo();
            productInfo = new ProductInfo();
            yearStatisticsVo.setYear(i + "");
            productInfo.setStartTime(i + "-1-1 00:00:00");
            productInfo.setEndTime(i + "-12-31 23:59:59");
            //查询账目信息
            resultVo = productClientService.selectAll(productInfo);
            //yearTotal
            BigDecimal yearTotal = new BigDecimal(0.0);
            //遍历账目信息
            for (ProductInfo product : resultVo.getData()) {
                if (product != null) {
                    //全部统计已用总金额
                    yearTotal = yearTotal.add(product.getProductPrice());
                }
                cal.setTime(product.getCreateTime());

                String month = (cal.get(Calendar.MONTH) + 1) + "";//获取月份
                for (MonthStatisticsVo item : monthStatisticsVoList) {
                    if (month.equals(item.getMonth())) {
                        item.setTotalMonty(item.getTotalMonty().add(product.getProductPrice()));
                    }
                }
            }
            yearStatisticsVo.setTotalMoney(yearTotal);
            yearStatisticsVo.setMonthVoList(monthStatisticsVoList);
            list.add(yearStatisticsVo);
        }
        return list;
    }

    /**
     * 获取一年每个分类的数据
     *
     * @param startYear
     * @param endYear
     * @return
     */
    @GetMapping("/getTypeStatisticsVo")
    @ResponseBody
    public List<TypeStatisticsVo> getTypeStatisticsVo(@RequestParam(value = "startYear", required = false) Integer startYear,
                                                      @RequestParam(value = "endYear", required = false) Integer endYear) {

        //设置时间
        if (StringUtils.isEmpty(startYear) && StringUtils.isEmpty(endYear)) {
            startYear = Integer.valueOf(TimeUtil.getStr(new Date(), "yyyy"));
            endYear = startYear;
        } else if (StringUtils.isEmpty(endYear)) {
            endYear = Integer.valueOf(TimeUtil.getStr(new Date(), "yyyy"));
        } else if (StringUtils.isEmpty(endYear)) {
            startYear = endYear;
        }
        List<TypeStatisticsVo> list = new ArrayList<>();
        TypeStatisticsVo typeStatisticsVo = null;
        ProductInfo productInfo = null;
        ResultVo<List<ProductInfo>> resultVo = null;
        //查询全部分类信息
        List<ProductCategory> categoryList = categoryClientService.list();
        if (categoryList.size() > 0) {
            categoryList.remove(0);
        }
        for (int i = startYear; i <= endYear; i++) {

            List<TypeVo> typeVoList = new ArrayList<>();
            TypeVo typeVo = null;
            //初始化值(分类)
            for (int j = 0; j < categoryList.size(); j++) {
                typeVo = new TypeVo();
                typeVo.setName(categoryList.get(j).getCategoryName());
                typeVo.setCode(categoryList.get(j).getCategoryType());
                typeVo.setId(categoryList.get(j).getCategoryId());
                typeVo.setTotal(new BigDecimal(0));
                typeVoList.add(typeVo);
            }

            typeStatisticsVo = new TypeStatisticsVo();
            typeStatisticsVo.setYear(i + "");

            productInfo = new ProductInfo();
            productInfo.setStartTime(i + "-1-1 00:00:00");
            productInfo.setEndTime(i + "-12-31 23:59:59");
            //查询账目信息
            resultVo = productClientService.selectAll(productInfo);


            //yearTotal
            BigDecimal yearTotal = new BigDecimal(0.0);
            //遍历账目信息
            for (ProductInfo product : resultVo.getData()) {
                if (product != null) {
                    //全部统计已用总金额
                    yearTotal = yearTotal.add(product.getProductPrice());
                }
                //获取分类code
                Integer code = product.getCategoryType();
                for (TypeVo item : typeVoList) {
                    if (code.equals(item.getCode())) {
                        item.setTotal(item.getTotal().add(product.getProductPrice()));
                    }
                }
            }
            typeStatisticsVo.setTotalMoney(yearTotal);
            typeStatisticsVo.setTypeVoList(typeVoList);
            list.add(typeStatisticsVo);
        }
        return list;
    }
}
