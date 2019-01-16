package com.wancient.springcloud.api.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/12
 * Time: 21:23
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class MonthStatisticsVo {

    private String month;

    private BigDecimal totalMonty;


}
