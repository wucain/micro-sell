package com.wancient.springcloud.api.wechat;

import lombok.Data;

/**
 * @Author cain
 * @date 2020-6-5 15:22
 **/
@Data
public class BatchgetMaterial {

    /**
     * 素材的类型，图片（image）、视频（video）、语音 （voice）、图文（news）
     */
    private String type;

    /**
     * 从全部素材的该偏移位置开始返回，0表示从第一个素材 返回
     */
    private Integer offset;

    /**
     * 返回素材的数量，取值在1到20之间
     */
    private String count;
}
