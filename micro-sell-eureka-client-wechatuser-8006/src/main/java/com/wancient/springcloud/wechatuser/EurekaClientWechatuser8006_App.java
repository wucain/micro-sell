package com.wancient.springcloud.wechatuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.wancient.springcloud.*.mapper")
public class EurekaClientWechatuser8006_App {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientWechatuser8006_App.class, args);
    }

}
