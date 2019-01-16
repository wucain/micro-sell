package com.wancient.springcloud.api.form;

import com.wancient.springcloud.api.vo.PageModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/26
 * Time: 21:23
 */
@Data
public class ProductForm extends PageModel {

    /**
     * 商品id
     **/
    private String productId;

    /**
     * 商品名称
     **/
    private String productName;

    /**
     * 价格
     **/
    private BigDecimal productPrice;

    /**
     * 描述
     **/
    private String productDescription;

    /**
     * 类目编号
     **/
    private Integer categoryType;

    /**
     * 类目名称
     **/
    private String categoryName;


    /**
     * 支付类型.
     */
    private Integer payType;

    /**
     * 支付类型名称.
     */
    private String payTypeName;

    /**
     * 是否可用（0：可用；1：不可用）
     **/
    private Integer enabled;

    /**
     * 商品状态,0正常1下架
     **/
    private Integer productStatus;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;
}
