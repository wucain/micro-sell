package com.wancient.springcloud.api.form;

import lombok.Data;

/**
 * @author: Wancient
 * @date: 2018/6/14
 * @time: 16:30
 */
@Data
public class DictionaryForm {

    /**
     * id.
     */
    private Integer id;

    /**
     * 编号.
     */
    private String code;

    /**
     * 名称.
     */
    private String name;

    /**
     * 备注.
     */
    private String remark;

    /**
     * 父节点.
     */
    private Integer parentId;

    /**
     * 排序.
     */
    private Integer sorts;

    /**
     * 是否可用（0：可用；1：不可用）.
     */
    private Integer enabled;
}
