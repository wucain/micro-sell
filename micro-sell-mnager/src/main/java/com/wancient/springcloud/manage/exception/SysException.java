package com.wancient.springcloud.manage.exception;

import com.wancient.springcloud.api.enums.ResultEnum;
import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/15
 * Time: 10:07
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class SysException extends RuntimeException {

    private Integer code;

    public SysException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public SysException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
