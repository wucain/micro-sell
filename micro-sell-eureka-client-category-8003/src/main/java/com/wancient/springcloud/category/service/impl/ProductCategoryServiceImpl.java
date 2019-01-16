package com.wancient.springcloud.category.service.impl;

import com.wancient.springcloud.api.entities.ProductCategory;
import com.wancient.springcloud.category.mapper.ProductCategoryMapper;
import com.wancient.springcloud.category.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类目
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/24
 * Time: 13:09
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryMapper mapper;

    /**
     * 根据id主键查询
     *
     * @param categoryId
     * @return
     */
    @Override
    public ProductCategory selectByPrimaryKey(Integer categoryId) {
        return mapper.selectByPrimaryKey(categoryId);
    }


    /**
     * 根据categroyType批量查询
     *
     * @param arr
     * @return
     */
    @Override
    public List<ProductCategory> selectByCategoryTypeIn(Integer[] arr) {
        return mapper.selectByCategoryTypeIn(arr);
    }

    /**
     * 查询全部
     *
     * @param productCategory
     * @return
     */
    @Override
    public List<ProductCategory> selectAll(ProductCategory productCategory) {
        return mapper.selectAll(productCategory);
    }

    /**
     * 根据主键id删除
     *
     * @param categoryId
     * @return
     */
    @Override
    public int deleteByPrimaryKey(Integer categoryId) {
        return mapper.deleteByPrimaryKey(categoryId);
    }

    /**
     * 根据主键id批量真删除
     *
     * @param arr
     * @return
     */
    @Override
    public int deleteByPrimaryKeyIn(Integer[] arr) {
        return mapper.deleteByPrimaryKeyIn(arr);
    }

    /**
     * 新增
     *
     * @param productCategory
     * @return
     */
    @Override
    public int insert(ProductCategory productCategory) {
        return mapper.insert(productCategory);
    }

    /**
     * 新增部分字段
     *
     * @param productCategory
     * @return
     */
    @Override
    public int insertSelective(ProductCategory productCategory) {
        return mapper.insertSelective(productCategory);
    }

    /**
     * 根据主键id更新
     *
     * @param productCategory
     * @return
     */
    @Override
    public int updateByPrimaryKey(ProductCategory productCategory) {
        return mapper.updateByPrimaryKey(productCategory);
    }

    /**
     * 根据主键部分更新
     *
     * @param productCategory
     * @return
     */
    @Override
    public int updateByPrimaryKeySelective(ProductCategory productCategory) {
        return mapper.updateByPrimaryKeySelective(productCategory);
    }
}
