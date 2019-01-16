package com.wancient.springcloud.api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 商品vo包含商品类目
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/25
 * Time: 18:33
 */
@Data
public class ProductVo implements Serializable {

    private static final long serialVersionUID = 8270275336298489203L;
    @JsonProperty("name")
    private  String categoryName;

    @JsonProperty("type")
    private  Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVo> list;





}
