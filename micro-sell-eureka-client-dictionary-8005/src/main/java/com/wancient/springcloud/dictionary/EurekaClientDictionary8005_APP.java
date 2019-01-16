package com.wancient.springcloud.dictionary;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2019/1/10
 * Time: 18:06
 * To change this template use File | Settings | File Templates.
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "com.wancient.springcloud.dictionary.mapper")
public class EurekaClientDictionary8005_APP {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientDictionary8005_APP.class, args);
    }
}
