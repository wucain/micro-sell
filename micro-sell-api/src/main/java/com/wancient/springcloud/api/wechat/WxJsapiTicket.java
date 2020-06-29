package com.wancient.springcloud.api.wechat;

import lombok.Data;

/**
 * @Author cain
 * @date 2019/4/26 17:02
 **/
@Data
public class WxJsapiTicket {

    private String ticket;

    private Integer expires_in;


}
