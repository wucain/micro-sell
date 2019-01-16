package com.wancient.springcloud.api.form;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/27
 * Time: 9:08
 */
@Data
public class CategoryForm {

    /**
     * 类目id.
     */
    private Integer categoryId;

    /**
     * 类目名字.
     */
    private String categoryName;

    /**
     * 类目编号.
     */
    private Integer categoryType;

    /**
     * 默认可支配金额
     */
    private BigDecimal defaultMoney;

    /**
     * 备注
     */
    private String remake;

    /**
     * 父级id
     */
    private Integer parentId;
}
