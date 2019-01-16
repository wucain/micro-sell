package com.wancient.springcloud.product.service;


import com.wancient.springcloud.api.entities.ProductInfo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/25
 * Time: 8:47
 */
public interface ProductInfoService {
    /**
     * 根据id查询信息
     *
     * @param productId
     * @return
     */
    ProductInfo findOne(String productId);

    /**
     * 查询全部
     *
     * @param productInfo
     * @return
     */
    List<ProductInfo> findAll(ProductInfo productInfo);

    /**
     * 新增
     *
     * @param productInfo
     * @return
     */
    int save(ProductInfo productInfo);

    /**
     * 根据时间和分类type查询统计
     *
     * @param startTime
     * @param endTime
     * @param categoryType
     * @return
     */
    //public List<PriceStatisticsVo> statisticsByTimeAndCategoryId(String startTime, String endTime, Integer categoryType);




    /**
     * 根据主键id批量查询
     *
     * @param arr
     * @return
     */
    List<ProductInfo> selectByPrimaryKeyIn(String[] arr);

    /**
     * 根据主键id真删除
     *
     * @param productId
     * @return
     */
    int deleteByPrimaryKey(String productId);

    /**
     * 根据主键id批量真删除
     *
     * @param arr
     * @return
     */
    int deleteByPrimaryKeyIn(String[] arr);

    /**
     * 新增
     *
     * @param productInfo
     * @return
     */
    int insert(ProductInfo productInfo);

    /**
     * 新增部分字段
     *
     * @param record
     * @return
     */
    int insertSelective(ProductInfo record);

    /**
     * 根据主键更新
     *
     * @param productInfo
     * @return
     */
    int updateByPrimaryKey(ProductInfo productInfo);


    /**
     * 根据主键部分更新
     *
     * @param productInfo
     * @return
     */
    int updateByPrimaryKeySelective(ProductInfo productInfo);

}
