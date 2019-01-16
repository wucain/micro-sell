package com.wancient.springcloud.product.service.impl;


import com.wancient.springcloud.api.entities.ProductInfo;
import com.wancient.springcloud.product.mapper.ProductInfoMapper;
import com.wancient.springcloud.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/25
 * Time: 8:55
 */
@Service
//@CacheConfig(cacheNames = "productInfo")
public class ProductInfoServiceImpl implements ProductInfoService {


    @Autowired
    private ProductInfoMapper productInfoMapper;

    //@Autowired
    //private ProductCategoryMapper productCategoryMapper;

    /**
     * 根据id查询信息
     *
     * @param productId
     * @return
     */
    @Override
    //@Cacheable(key = "123")
    public ProductInfo findOne(String productId) {
        return productInfoMapper.selectByPrimaryKey(productId);
    }


    /**
     * 查询全部
     *
     * @param productInfo
     * @return
     */
    @Override
    public List<ProductInfo> findAll(ProductInfo productInfo) {
        return productInfoMapper.selectAll(productInfo);
    }


    @Override
    // @CachePut(key = "123")
    public int save(ProductInfo productInfo) {
        return productInfoMapper.insert(productInfo);
    }

    @Override
    public List<ProductInfo> selectByPrimaryKeyIn(String[] arr) {
        return productInfoMapper.selectByPrimaryKeyIn(arr);
    }

    @Override
    public int deleteByPrimaryKey(String productId) {
        return productInfoMapper.deleteByPrimaryKey(productId);
    }

    @Override
    public int deleteByPrimaryKeyIn(String[] arr) {
        return productInfoMapper.deleteByPrimaryKeyIn(arr);
    }

    @Override
    public int insert(ProductInfo productInfo) {
        return productInfoMapper.insert(productInfo);
    }

    @Override
    public int insertSelective(ProductInfo productInfo) {
        return productInfoMapper.insertSelective(productInfo);
    }

    @Override
    public int updateByPrimaryKey(ProductInfo productInfo) {
        return productInfoMapper.updateByPrimaryKey(productInfo);
    }

    @Override
    public int updateByPrimaryKeySelective(ProductInfo productInfo) {
        return productInfoMapper.updateByPrimaryKeySelective(productInfo);
    }


    /**
     * 根据时间和分类type查询统计
     *
     * @param startTime
     * @param endTime
     * @param categoryType
     * @return
     */
   /* @Override
    public List<PriceStatisticsVo> statisticsByTimeAndCategoryId(String startTime, String endTime, Integer categoryType) {
        List<PriceStatisticsVo> list = new ArrayList<>();
        //总统计
        PriceStatisticsVo totalVo = new PriceStatisticsVo();
        //已用总金额
        BigDecimal totalPastPrice = new BigDecimal(0);
        //可用总金额
        BigDecimal totalPrice = new BigDecimal(0);

        PriceStatisticsVo itemVo = null;

        ProductInfo productInfo = new ProductInfo();
        productInfo.setStartTime(startTime);
        productInfo.setEndTime(endTime);
        productInfo.setCategoryType(categoryType == null ? null : categoryType);
        //查询账目信息
        List<ProductInfo> productInfoList = productInfoMapper.selectAll(productInfo);
        //查询全部分类
        // List<ProductCategory> productCategoryList = productCategoryMapper.selectAll(new ProductCategory());
        List<ProductCategory> productCategoryList = null;
        //遍历分类信息
        for (ProductCategory productCategory : productCategoryList) {
            //全部统计总金额
            totalPrice = totalPrice.add(productCategory.getMoney());

            //单个统计
            itemVo = new PriceStatisticsVo();
            //单个分类已用总金额
            BigDecimal itemPastPrice = new BigDecimal(0);
            //遍历账目信息
            for (ProductInfo product : productInfoList) {
                if (productCategory.getCategoryType().equals(product.getCategoryType())) {
                    //全部统计已用总金额
                    totalPastPrice = totalPastPrice.add(product.getProductPrice());
                    //单个统计已用总金额
                    itemPastPrice = itemPastPrice.add(product.getProductPrice());
                }
            }
            //名称
            itemVo.setName(productCategory.getCategoryName());
            //单个分类总金额
            itemVo.setTotalPrice(productCategory.getMoney());
            //单个分类已用总金额
            itemVo.setPastPrice(itemPastPrice);
            //剩余可用金额
            itemVo.setUsablePrice(productCategory.getMoney().subtract(itemPastPrice));
            itemVo.setStartTime(startTime);
            itemVo.setEndTime(endTime);
            list.add(itemVo);

        }
        totalVo.setName("全部");
        totalVo.setTotalPrice(totalPrice);
        totalVo.setStartTime(startTime);
        totalVo.setEndTime(endTime);
        totalVo.setPastPrice(totalPastPrice);
        totalVo.setUsablePrice(totalPrice.subtract(totalPastPrice));
        list.add(0, totalVo);

        return list;
    }*/
}
