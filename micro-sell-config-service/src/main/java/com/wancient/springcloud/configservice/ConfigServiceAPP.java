package com.wancient.springcloud.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/19
 * Time: 10:36
 * To change this template use File | Settings | File Templates.
 **/
@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient
public class ConfigServiceAPP {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServiceAPP.class, args);
    }
}
