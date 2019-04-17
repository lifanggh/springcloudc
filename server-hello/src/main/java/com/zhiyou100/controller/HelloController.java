package com.zhiyou100.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.sound.sampled.Port;

@Controller
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class HelloController {
    @Value("${server.port}")
    private String port;
    @RequestMapping("hello.do")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "error")
    public String hello(@RequestParam(defaultValue = "uu") String name){

        return "name"+port +name;
    }

    public String error(String name) {
        return "hahahahhahahaha";
    }
}
