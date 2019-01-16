package com.wancient.springcloud.api.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/12
 * Time: 21:22
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class YearStatisticsVo {

    private String year;

    private BigDecimal totalMoney;

    private List<MonthStatisticsVo> monthVoList;
}
