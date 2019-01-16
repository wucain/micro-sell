package com.wancient.springcloud.manage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/10
 * Time: 20:51
 * To change this template use File | Settings | File Templates.
 **/
@EnableDiscoveryClient
//Feign客户端
@EnableFeignClients(basePackages = {"com.wancient.springcloud.api"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class ManageApplication {


    public static void main(String[] args) {
        SpringApplication.run(ManageApplication.class, args);
    }
}
