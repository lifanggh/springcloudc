package com.zhiyou100.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "server-hello",fallback=FeignServiceHystirx.class)
public interface HelloService {
   @RequestMapping("hello.do")
    String hello();
}
