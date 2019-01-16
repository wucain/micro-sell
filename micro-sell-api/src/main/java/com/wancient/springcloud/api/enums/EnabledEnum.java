package com.wancient.springcloud.api.enums;

import lombok.Getter;

/**
 * 是否可用
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/25
 * Time: 9:08
 */
@Getter
public enum EnabledEnum {
    YES(0,"可用"),
    NO(1,"不可用")
    ;

    private Integer code;
    private String message;

    EnabledEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
