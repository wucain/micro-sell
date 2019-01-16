package com.wancient.springcloud.category;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/6
 * Time: 10:26
 * To change this template use File | Settings | File Templates.
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.wancient.springcloud.category.mapper")
public class EurekaClientCategory8003_APP {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientCategory8003_APP.class, args);
    }
}
