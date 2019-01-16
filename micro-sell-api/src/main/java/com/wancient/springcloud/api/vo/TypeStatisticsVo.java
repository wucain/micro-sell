package com.wancient.springcloud.api.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/14
 * Time: 17:14
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class TypeStatisticsVo {

    private String year;//年份

    private BigDecimal totalMoney;//全年总金额

    private List<TypeVo> typeVoList;

}
