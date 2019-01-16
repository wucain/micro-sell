package com.wancient.springcloud.api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品信息vo
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/25
 * Time: 18:38
 */
@Data
public class ProductInfoVo implements Serializable {

    private static final long serialVersionUID = -136395132711368744L;

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
     * 数量
     **/
    private Integer productStock;

    /**
     * 描述
     **/
    private String productDescription;

    /**
     * 支付类型id
     */
    private Integer payType;

    /**
     * 支付类型名称
     */
    private String payTypeName;

    /**
     * 小图
     **/
    private String productIcon;

    /**
     * 商品状态,0正常1下架
     **/
    private Integer productStatus;

    /**
     * 类目编号
     **/
    private Integer categoryType;

    /**
     * 类目名称
     **/
    private String categoryName;

    /**
     * 创建用户id
     **/
    private String createUserId;

    /**
     * 最后更新用户id.
     **/
    private String updateUserId;

    /**
     * 是否可用（0：可用；1：不可用）
     **/
    private Integer enabled;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
