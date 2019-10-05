package com.barnnet.work.helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HelperEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelperEurekaApplication.class, args);
    }

}
