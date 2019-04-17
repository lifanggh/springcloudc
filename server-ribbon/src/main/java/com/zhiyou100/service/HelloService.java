package com.zhiyou100.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.utils.FallbackMethod;
import com.netflix.ribbon.Ribbon;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class HelloService {
    /**
     * @HystrixCommand该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
     */
    @Resource
    private RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod="error")
    public String helloService() {
        //调用server-hello中的方法
        return restTemplate.getForObject("http://server-hello/hello.do",String.class);
    }
    public  String error(){
        return "---->Ribbon" +"出现故障,在维护中";
    }
}
