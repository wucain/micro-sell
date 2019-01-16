package com.wancient.springcloud.api.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/25
 * Time: 22:15
 * To change this template use File | Settings | File Templates.
 **/
@Data
public class CateGoryVo implements Serializable {


    /**
     * id.
     */
    private Integer id;

    /**
     * 名字.
     */
    private String name;

    /**
     * 父级id
     */
    @JsonProperty("pId")
    private Integer pid;


    private Boolean open;

    @JsonProperty("pId")
    public Integer getPid() {
        return pid;
    }


}



