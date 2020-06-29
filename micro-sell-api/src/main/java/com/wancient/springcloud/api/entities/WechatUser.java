package com.wancient.springcloud.api.entities;


import com.wancient.springcloud.api.vo.PageModel;
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
public class WechatUser extends PageModel implements Serializable {

    @Id
    private String wxId;

    /**
     * 微信openid
     */
    private String openid;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     */
    private String sex;

    /**
     * 用户个人资料填写的省份
     */
    private String province;

    /**
     * 普通用户个人资料填写的城市
     */
    private String city;

    /**
     * 国家，如中国为CN
     */
    private String country;

    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     */
    private String headimgurl;

    /**
     * 用户特权信息，json 数组
     */
    private String privilege;

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     */
    private String unionid;

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
