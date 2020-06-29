package com.wancient.springcloud.api.wechat;

import lombok.Data;

/**
 * @Author cain
 * @date 2020-6-5 15:24
 **/
@Data
public class BatchgetMaterialItem {

    /**
     * ID
     */
    private String media_id;
    /**
     * 名称
     */
    private String name;

    /**
     * 数据
     */
    private String update_time;

    /**
     * URL
     */
    private String url;

}
