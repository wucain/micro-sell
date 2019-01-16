package com.wancient.springcloud.api.enums;

import lombok.Getter;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/27
 * Time: 10:05
 */
@Getter
public enum PayStatusEnum  implements CodeEnum{
    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功");

    private Integer code;

    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
