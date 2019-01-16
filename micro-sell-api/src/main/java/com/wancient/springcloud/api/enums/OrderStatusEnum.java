package com.wancient.springcloud.api.enums;

import lombok.Getter;

/**
 * 订单状态
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/27
 * Time: 10:00
 */
@Getter
public enum OrderStatusEnum implements CodeEnum {
    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2,"已取消")
    ;

    private Integer code;

    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
