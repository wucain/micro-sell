package com.wancient.springcloud.wechat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.wancient.springcloud.*.mapper")
public class EurekaClientWechat8007_App {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientWechat8007_App.class, args);
    }

}
