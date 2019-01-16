package com.wancient.springcloud.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/6
 * Time: 10:22
 * To change this template use File | Settings | File Templates.
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages ="com.wancient.springcloud.*.mapper" )
public class EurekaClientUser8002_APP {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientUser8002_APP.class, args);
    }
}
