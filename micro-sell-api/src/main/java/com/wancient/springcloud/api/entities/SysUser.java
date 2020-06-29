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
public class SysUser extends PageModel implements Serializable {

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
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

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


    /**
     * 性别（0：女；1：男；null：未知）
     */
    private Boolean gender;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 手机号
     */
    private String phone;
}
