package com.zhiyou100.controller;

import com.zhiyou100.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HelloController {
    @Resource //javax
    private HelloService service;
    @RequestMapping("he.do")
    @ResponseBody
    public String hello(){
        return service.helloService();
    }


}
