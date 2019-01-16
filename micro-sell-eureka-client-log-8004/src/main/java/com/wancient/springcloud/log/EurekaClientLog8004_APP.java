package com.wancient.springcloud.log;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/6
 * Time: 10:25
 * To change this template use File | Settings | File Templates.
 **/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages ="com.wancient.springcloud.*.mapper" )
public class EurekaClientLog8004_APP {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientLog8004_APP.class, args);
    }
}
