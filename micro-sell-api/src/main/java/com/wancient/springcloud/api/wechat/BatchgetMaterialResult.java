package com.wancient.springcloud.api.wechat;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Author cain
 * @date 2020-6-5 15:24
 **/
@Data
public class BatchgetMaterialResult {

    /**
     * 该类型的素材的总数
     */
    private Integer total_count;
    /**
     * 本次调用获取的素材的数量
     */
    private Integer item_count;

    /**
     * 数据
     */
    private List<BatchgetMaterialItem> item;


}
