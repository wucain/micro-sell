package com.wancient.springcloud.api.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/14
 * Time: 17:17
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class TypeVo {

    private String name;//分类名称

    private Integer id;//分类id

    private Integer code;//分类code

    private BigDecimal total;
}
