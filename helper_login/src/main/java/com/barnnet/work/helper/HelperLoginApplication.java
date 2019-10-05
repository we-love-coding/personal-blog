package com.barnnet.work.helper;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaClient
@SpringBootApplication
/*@MapperScan("com.barnnet.work.*.mapper.*")*/
public class HelperLoginApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelperLoginApplication.class, args);
    }

}
