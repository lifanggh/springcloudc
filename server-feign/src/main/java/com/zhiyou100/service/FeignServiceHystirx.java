package com.zhiyou100.service;

import org.springframework.stereotype.Component;

/**
 * 定义fallback类
 */
@Component
public class FeignServiceHystirx implements HelloService {
    @Override
    public String hello() {
        return "------>feign"+"服务在维修中,稍等....";
    }
}
