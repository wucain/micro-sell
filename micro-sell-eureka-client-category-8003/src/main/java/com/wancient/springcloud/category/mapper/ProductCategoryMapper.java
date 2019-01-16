package com.wancient.springcloud.category.mapper;

import com.wancient.springcloud.api.entities.ProductCategory;

import java.util.List;

public interface ProductCategoryMapper {

    /**
     * 根据id查询
     *
     * @param categoryId
     * @return
     */
    ProductCategory selectByPrimaryKey(Integer categoryId);

    /**
     * 根据categoryType查询
     *
     * @param categoryType
     * @return
     */
    ProductCategory selectByCategoryType(Integer categoryType);

    /**
     * 根据categroyType批量查询
     *
     * @param arr
     * @return
     */
    List<ProductCategory> selectByCategoryTypeIn(Integer[] arr);

    /**
     * 查询全部
     *
     * @param productCategory
     * @return
     */
    List<ProductCategory> selectAll(ProductCategory productCategory);

    /**
     * 根据id真删除
     *
     * @param categoryId
     * @return
     */
    int deleteByPrimaryKey(Integer categoryId);

    /**
     * 根据主键id批量真删除
     *
     * @param arr
     * @return
     */
    int deleteByPrimaryKeyIn(Integer[] arr);


    /**
     * 新增
     *
     * @param productCategory
     * @return
     */
    int insert(ProductCategory productCategory);

    /**
     * 新增部分字段
     *
     * @param productCategory
     * @return
     */
    int insertSelective(ProductCategory productCategory);

    /**
     * 根据主键id更新
     *
     * @param productCategory
     * @return
     */
    int updateByPrimaryKey(ProductCategory productCategory);

    /**
     * 根据主键部分更新
     *
     * @param productCategory
     * @return
     */
    int updateByPrimaryKeySelective(ProductCategory productCategory);


}