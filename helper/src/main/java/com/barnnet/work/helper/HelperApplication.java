package com.barnnet.work.helper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HelperApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelperApplication.class, args);
    }

}
