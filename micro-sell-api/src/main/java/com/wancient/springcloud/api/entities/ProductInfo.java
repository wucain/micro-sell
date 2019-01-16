package com.wancient.springcloud.api.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wancient.springcloud.api.enums.ProductStatusEnum;
import com.wancient.springcloud.api.utils.EnumUtil;
import com.wancient.springcloud.api.vo.PageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/24
 * Time: 23:03
 */
@Entity
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductInfo extends PageModel implements Serializable {

    private static final long serialVersionUID = 4729084317887563459L;
    /**
     * 商品id
     **/
    @Id
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    public Date getCreateTime() {
        return createTime;
    }


    /**
     * JsonIgnore 不返回json
     */
   /* @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }*/
}
