package com.wancient.springcloud.api.client;

import com.wancient.springcloud.api.entities.ProductInfo;
import com.wancient.springcloud.api.form.ProductForm;
import com.wancient.springcloud.api.vo.ResultVo;
import com.wancient.springcloud.api.vo.YearStatisticsVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/9
 * Time: 10:37
 * To change this template use File | Settings | File Templates.
 **/
@FeignClient(value = "MICRO-PRODUCT")
public interface ProductClientService {

    /**
     * 根据主键id查询
     *
     * @param productId
     * @return
     */
    @GetMapping("/manage/product/index")
    ProductInfo get(@RequestParam("productId") String productId);


    @PostMapping("/manage/product/selectAll")
    ResultVo<List<ProductInfo>> selectAll(@RequestBody ProductInfo productInfo);

    /**
     * 分页查询
     *
     * @param
     * @return
     */
    @GetMapping("/manage/product/list")
    ResultVo list(ProductForm productForm);

    /**
     * 根据主键id真删除
     *
     * @param productId
     * @return
     */
    @GetMapping("/manage/product/delete_true")
    int deleteTrue(@RequestParam("productId") String productId);

    /**
     * 根据主键id逻辑删除
     *
     * @param productId
     * @return
     */
    @GetMapping("/manage/product/delete_false")
    int deleteFalse(@RequestParam("productId") String productId);


    /**
     * 批量真删除
     *
     * @param productIds
     * @return
     */
    @GetMapping("/manage/product/delete_true")
    int deleteTrueByIn(@RequestParam("productIds") String productIds);

    /**
     * 批量逻辑删除
     *
     * @param productIds
     * @return
     */
    @GetMapping("/manage/product/delete_false")
    int deleteFalseByIn(@RequestParam("productIds") String productIds);

    /**
     * 新增
     *
     * @param productForm
     * @return
     */
    @PostMapping("/manage/product/save")
    int insert(ProductForm productForm);


    /**
     * 根据主键id更新
     *
     * @param productForm
     * @return
     */
    @PostMapping("/manage/product/save")
    int update(ProductForm productForm);

    /**
     * 更新状态
     *
     * @param productId
     * @param productStatus
     * @return
     */
    @GetMapping("/manage/product/update_status")
    Integer updateStatus(@RequestParam("productId") String productId, @RequestParam("productStatus") Integer productStatus);


    /**
     * 获取一年每个月的金额
     *
     * @param year
     * @return
     */
    @GetMapping("/manage/product/getYearStatisticsVo")
    YearStatisticsVo getYearStatisticsVo(@RequestParam(value = "year") String year);
}
