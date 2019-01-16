package com.wancient.springcloud.api.entities;

import com.wancient.springcloud.api.vo.PageModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 类目表
 * Created by IntelliJ IDEA.
 * User: Wancient
 * Date: 2018/2/6
 * Time: 22:09
 */
@Entity
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategory extends PageModel implements Serializable {

    /**
     * 类目id.
     */
    @Id
    @GeneratedValue
    private Integer categoryId;

    /**
     * 类目名字.
     */
    private String categoryName;

    /**
     * 类目编号.
     */
    private Integer categoryType;

    /**
     * 父级id
     */
    private Integer parentId;

    /** 创建时间**/
    //private Date createTime;

    /**
     * 创建用户id
     **/
    private String createUserId;

    /** 最后更新时间 **/
    //private  Date updateTime;

    /**
     * 最后更新用户id
     **/
    private String updateUserId;

    /**
     * 是否可用（0：可用；1：可用）
     **/
    private Integer enabled;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 可支配金额
     */
    private BigDecimal money;


    /**
     * 默认可支配金额
     */
    private BigDecimal defaultMoney;

    /**
     * 备注
     */
    private String remake;


    public ProductCategory(String categoryName, Integer categoryType, String createUserId, String updateUserId, Integer enabled) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
        this.createUserId = createUserId;
        this.updateUserId = updateUserId;
        this.enabled = enabled;
    }


}
