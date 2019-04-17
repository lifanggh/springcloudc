package com.zhiyou100.serverribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
//服务的提供者
@EnableEurekaClient
//通过该注解想注册中心注册,并向程序的ioc容器注入一个bean
@EnableDiscoveryClient
@EnableHystrix
@ComponentScan(basePackages = "com.zhiyou100")
public class ServerRibbonApplication {
    @Bean
    //表名restTemplat开启负载均衡功能
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(ServerRibbonApplication.class, args);
    }

}
