package com.zhiyou100.controller;

import com.zhiyou100.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class HelloController {

    @Resource
    private HelloService service;
    @RequestMapping("he.do")
    public String hello(){

        return service.hello();


    }

}
