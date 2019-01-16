package com.wancient.springcloud.eurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by IntelliJ IDEA.
 * User: CainWu
 * Date: 2018/12/5
 * Time: 14:45
 * To change this template use File | Settings | File Templates.
 **/
@SpringBootApplication
@EnableEurekaServer
public class EurekaService8763_APP {

    public static void main(String[] args) {
        SpringApplication.run(EurekaService8763_APP.class, args);
    }
}
