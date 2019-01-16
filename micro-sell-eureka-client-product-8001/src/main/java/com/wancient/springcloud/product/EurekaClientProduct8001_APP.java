package com.wancient.springcloud.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/6
 * Time: 10:24
 * To change this template use File | Settings | File Templates.
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.wancient.springcloud.product.mapper")
//Feign客户端
@EnableFeignClients(basePackages = {"com.wancient.springcloud.api"})
public class EurekaClientProduct8001_APP {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientProduct8001_APP.class, args);
    }
}
