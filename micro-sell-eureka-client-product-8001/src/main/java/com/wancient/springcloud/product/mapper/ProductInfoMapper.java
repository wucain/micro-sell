package com.wancient.springcloud.product.mapper;

import com.wancient.springcloud.api.entities.ProductInfo;

import java.util.List;

public interface ProductInfoMapper {
    /**
     * 根据主键id查询
     *
     * @param productId
     * @return
     */
    ProductInfo selectByPrimaryKey(String productId);

    /**
     * 根据主键id批量查询
     *
     * @param arr
     * @return
     */
    List<ProductInfo> selectByPrimaryKeyIn(String[] arr);

    /**
     * 查询全部
     *
     * @param productInfo
     * @return
     */
    List<ProductInfo> selectAll(ProductInfo productInfo);


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