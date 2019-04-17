package com.zhiyou100.serverhello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * 服务的提供者
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan(basePackages = "com.zhiyou100")
public class ServerHelloApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerHelloApplication.class, args);
    }

}
