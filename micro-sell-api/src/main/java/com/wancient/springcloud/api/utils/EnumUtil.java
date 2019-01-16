package com.wancient.springcloud.api.utils;

import com.wancient.springcloud.api.enums.CodeEnum;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/20
 * Time: 22:40
 */
public class EnumUtil {

    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each : enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
