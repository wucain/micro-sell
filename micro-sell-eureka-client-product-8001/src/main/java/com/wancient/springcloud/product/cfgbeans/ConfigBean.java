package com.wancient.springcloud.product.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/7
 * Time: 9:19
 * To change this template use File | Settings | File Templates.
 **/
@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced//Ribbon负载均衡配置--Ribbon客户端配置
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
