package com.wancient.springcloud.product.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wancient.springcloud.api.entities.ProductCategory;
import com.wancient.springcloud.api.entities.ProductInfo;
import com.wancient.springcloud.api.enums.EnabledEnum;
import com.wancient.springcloud.api.form.ProductForm;
import com.wancient.springcloud.api.utils.KeyUtil;
import com.wancient.springcloud.api.utils.ResultVoUtil;
import com.wancient.springcloud.api.utils.TimeUtil;
import com.wancient.springcloud.api.vo.MonthStatisticsVo;
import com.wancient.springcloud.api.vo.PriceStatisticsVo;
import com.wancient.springcloud.api.vo.ResultVo;
import com.wancient.springcloud.api.vo.YearStatisticsVo;
import com.wancient.springcloud.category.service.ProductCategoryService;
import com.wancient.springcloud.product.service.ProductInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

/**
 * 账目管理
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/24
 * Time: 14:46
 */
@RestController
@RequestMapping("/manage/product")
@Slf4j
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;


    /**
     * 分页查询数据
     *
     * @param productForm
     * @return
     */
    @PostMapping("/list")
    public ResultVo list(@RequestBody ProductForm productForm) {
        ProductInfo productInfo = new ProductInfo();
        //复制
        BeanUtils.copyProperties(productForm, productInfo);
        productInfo.setEnabled(EnabledEnum.YES.getCode());

        //分页查询数据
        PageHelper.startPage(productInfo.getPageNum(), productInfo.getPageSize(), " create_time desc");
        List<ProductInfo> productInfoPage = productInfoService.findAll(productInfo);
        PageInfo pageInfo = new PageInfo<ProductInfo>(productInfoPage);
        return ResultVoUtil.success(pageInfo);
    }

    /**
     * 条件查询全部数据
     *
     * @param productInfo
     * @return
     */
    @PostMapping("/selectAll")
    public ResultVo selectAll(@RequestBody ProductInfo productInfo) {
        productInfo.setEnabled(EnabledEnum.YES.getCode());
        List<ProductInfo> productInfoList = productInfoService.findAll(productInfo);
        return ResultVoUtil.success(productInfoList);
    }

    /**
     * 条件查询列表
     *
     * @param page
     * @param size
     * @param keyWord
     * @param categoryName
     * @param startTime
     * @param endTime
     * @return
     */
    @GetMapping("/query_list")
    public ResultVo<Map<String, Object>> queryList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                   @RequestParam(value = "size", defaultValue = "10") Integer size,
                                                   @RequestParam(value = "keyWord") String keyWord,
                                                   @RequestParam(value = "categoryName") String categoryName,
                                                   @RequestParam(value = "startTime") Date startTime,
                                                   @RequestParam(value = "endTime") Date endTime
    ) {
        ProductInfo productInfo = new ProductInfo();

        PageHelper.startPage(1, 10, " create_time desc");
        List<ProductInfo> productInfoList = productInfoService.findAll(productInfo);
        PageInfo pageInfo = new PageInfo<ProductInfo>(productInfoList);
        return ResultVoUtil.success(pageInfo);
    }

    /**
     * 查询单个
     *
     * @param productId
     * @return
     */
    @GetMapping("/index")
    public ProductInfo index(@RequestParam(value = "productId", required = false) String productId) {
        ProductInfo productInfo = new ProductInfo();
        if (!StringUtils.isEmpty(productId)) {
            productInfo = productInfoService.findOne(productId);
        }
        return productInfo;
    }


    /**
     * 保存、更新
     *
     * @param productForm
     * @return
     */
    @PostMapping("/save")
    public Integer save(@RequestBody ProductForm productForm) {
        try {
            ProductInfo productInfo = new ProductInfo();
            //更新
            if (productForm != null && !StringUtils.isEmpty(productForm.getProductId())) {
                productInfo = productInfoService.findOne(productForm.getProductId());
            }
            //新增
            if (StringUtils.isEmpty(productForm.getProductId())) {
                //新增
                productForm.setProductId(KeyUtil.genUniqueKey());
                BeanUtils.copyProperties(productForm, productInfo);
                return productInfoService.insertSelective(productInfo);
            } else {
                //修改
                BeanUtils.copyProperties(productForm, productInfo);
                return productInfoService.updateByPrimaryKey(productInfo);
            }
        } catch (Exception e) {
            log.error("【账目保存、更新】 发生异常{}", e.getMessage());
        }
        return 0;
    }

    /**
     * 上下架
     *
     * @param productId
     * @param productStatus
     * @return
     */
    @GetMapping("/update_status")
    public Integer updateStatus(@RequestParam(value = "productId", required = false) String productId, @RequestParam(value = "productStatus", required = false) Integer productStatus) {
        log.info("进入方法:{},{}", productId, productStatus);
        try {
            ProductInfo productInfo = new ProductInfo();
            //更新
            if (!StringUtils.isEmpty(productId) && !StringUtils.isEmpty(productStatus)) {
                productInfo = productInfoService.findOne(productId);
            } else {
                return 0;
            }
            productInfo.setProductStatus(productStatus);
            return productInfoService.updateByPrimaryKey(productInfo);
        } catch (Exception e) {
            log.error("【更新状态】 发生异常{}", e.getMessage());
        }
        return 0;
    }


    /**
     * 逻辑删除
     *
     * @param productId
     * @return
     */
    @GetMapping("/delete_false")
    public Integer deleteFalse(@RequestParam(value = "productId", required = false) String productId) {
        Integer result = 0;
        if (!StringUtils.isEmpty(productId)) {
            ProductInfo productInfo = productInfoService.findOne(productId);
            if (productInfo != null) {
                productInfo.setEnabled(EnabledEnum.NO.getCode());
                return productInfoService.updateByPrimaryKeySelective(productInfo);
            }
        }
        return result;
    }

    /**
     * 真删除
     *
     * @param productId
     * @return
     */
    @GetMapping("/delete_true")
    public Integer deleteTrue(@RequestParam(value = "productId", required = false) String productId) {
        Integer result = 0;
        if (!StringUtils.isEmpty(productId)) {
            return productInfoService.deleteByPrimaryKey(productId);
        }
        return result;
    }

//    /**
//     * 根据时间和分类type查询统计
//     *
//     * @param startTime
//     * @param endTime
//     * @param categoryType
//     * @return
//     */
//    @GetMapping("/statisticsByTimeAndCategoryId")
//    public List<PriceStatisticsVo> statisticsByTimeAndCategoryId(@RequestParam(value = "startTime", required = false) String startTime,
//                                                                 @RequestParam(value = "endTime", required = false) String endTime,
//                                                                 @RequestParam(value = "categoryType", required = false) Integer categoryType) {
//        List<PriceStatisticsVo> list = new ArrayList<>();
//        //总统计
//        PriceStatisticsVo totalVo = new PriceStatisticsVo();
//        //已用总金额
//        BigDecimal totalPastPrice = new BigDecimal(0);
//        //可用总金额
//        BigDecimal totalPrice = new BigDecimal(0);
//
//        PriceStatisticsVo itemVo = null;
//
//        ProductInfo productInfo = new ProductInfo();
//        productInfo.setStartTime(startTime);
//        productInfo.setEndTime(endTime);
//        productInfo.setCategoryType(categoryType == null ? null : categoryType);
//        //查询账目信息
//        List<ProductInfo> productInfoList = productInfoService.findAll(productInfo);
//        //查询全部分类
//        List<ProductCategory> productCategoryList = productCategoryService.selectAll(new ProductCategory());
//
//        //遍历分类信息
//        for (ProductCategory productCategory : productCategoryList) {
//            //全部统计总金额
//            totalPrice = totalPrice.add(productCategory.getMoney());
//
//            //单个统计
//            itemVo = new PriceStatisticsVo();
//            //单个分类已用总金额
//            BigDecimal itemPastPrice = new BigDecimal(0);
//            //遍历账目信息
//            for (ProductInfo product : productInfoList) {
//                if (productCategory.getCategoryType().equals(product.getCategoryType())) {
//                    //全部统计已用总金额
//                    totalPastPrice = totalPastPrice.add(product.getProductPrice());
//                    //单个统计已用总金额
//                    itemPastPrice = itemPastPrice.add(product.getProductPrice());
//                }
//            }
//            //名称
//            itemVo.setName(productCategory.getCategoryName());
//            //单个分类总金额
//            itemVo.setTotalPrice(productCategory.getMoney());
//            //单个分类已用总金额
//            itemVo.setPastPrice(itemPastPrice);
//            //剩余可用金额
//            itemVo.setUsablePrice(productCategory.getMoney().subtract(itemPastPrice));
//            itemVo.setStartTime(startTime);
//            itemVo.setEndTime(endTime);
//            list.add(itemVo);
//
//        }
//        totalVo.setName("全部");
//        totalVo.setTotalPrice(totalPrice);
//        totalVo.setStartTime(startTime);
//        totalVo.setEndTime(endTime);
//        totalVo.setPastPrice(totalPastPrice);
//        totalVo.setUsablePrice(totalPrice.subtract(totalPastPrice));
//        list.add(0, totalVo);
//
//        return list;
//    }
}
