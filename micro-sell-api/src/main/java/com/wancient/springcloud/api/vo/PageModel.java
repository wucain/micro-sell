package com.wancient.springcloud.api.vo;

import lombok.Data;

import javax.persistence.Transient;
import java.io.Serializable;

/**
 * @author: Wancient
 * @date: 2018/6/7
 * @time: 23:16
 */
@Data
public class PageModel implements Serializable {
    /**
     * 页码
     */
    @Transient
    private int pageNum;

    /**
     * 每页数据
     */
    @Transient
    private int pageSize;

    /**
     * 排序列
     */
    @Transient
    private String orderSort;

    /**
     * 排序方向
     */
    @Transient
    private String orderDirection;

    /**
     * 开始时间
     */
    @Transient
    private String startTime;

    /**
     * 结束时间
     */
    @Transient
    private String endTime;

}
