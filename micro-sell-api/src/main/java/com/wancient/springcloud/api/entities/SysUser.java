package com.wancient.springcloud.api.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/3/27
 * Time: 13:10
 */
@Data
@Entity
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable {

    @Id
    private String userId;

    /**
     * 用户名
     */
    private String username;


    /**
     * 密码
     */
    private String password;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 创建时间
     */
    private String createTime;

    /**
     * 修改时间
     */
    private String updateTime;

    /**
     * 创建用户id
     */
    private String createUserId;

    /**
     * 最后更新用户id
     */
    private String updateUserId;

    /**
     * 是否可用（0：可用；1：不可用）
     **/
    private Integer enabled;


}
