package com.wancient.springcloud.api.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 系统字典表
 *
 * @author: Wancient
 * @date: 2018/6/14
 * @time: 15:30
 */
@Entity
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SysDictionary implements Serializable {

    /**
     * id.
     */
    @Id
    @GeneratedValue
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
     * 创建时间.
     */
    private Date createTime;

    /**
     * 创建用户id.
     */
    private String createUserId;

    /**
     * 修改时间.
     */
    private Date updateTime;

    /**
     * 最后更新用户id.
     */
    private String updateUserId;

    /**
     * 是否可用（0：可用；1：不可用）.
     */
    private Integer enabled;
}
