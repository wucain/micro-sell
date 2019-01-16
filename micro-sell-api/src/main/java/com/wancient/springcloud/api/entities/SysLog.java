package com.wancient.springcloud.api.entities;


import com.wancient.springcloud.api.vo.PageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * 日志表
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/30
 * Time: 23:20
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
public class SysLog extends PageModel implements Serializable {
    @Id
    private String id;
    /**
     * ip地址
     */
    private String ip;
    /**
     * openid
     */
    private String openId;

    /**
     * 登录用户id
     */
    private String userId;

    /**
     * 请求方式
     */
    private String visitMothod;

    /**
     * 访问url
     */
    private String visitUrl;

    /**
     * 访问的方法
     */
    private String visitAction;

    /**
     * 参数
     */
    private String visitParameter;

    /**
     * 访问时间
     */
    private Date visitTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否可用（0：可用；1：不可用）
     */
    private Integer enabled;

}
