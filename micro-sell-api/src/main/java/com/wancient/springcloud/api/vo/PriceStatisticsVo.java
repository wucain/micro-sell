package com.wancient.springcloud.api.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 统计Vo
 *
 * @author: Wancient
 * @date: 2018/6/13
 * @time: 18:16
 */
@Data
public class PriceStatisticsVo {

    /**
     * 名称.
     */
    private String name;


    /**
     * 总金额.
     */
    private BigDecimal totalPrice;

    /**
     * 已用金额.
     */
    private BigDecimal pastPrice;

    /**
     * 可用金额.
     */
    private BigDecimal usablePrice;

    /**
     * 开始时间.
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;
}
