package com.zhiyou100.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigClientApplication {

    @Value("${foo}")
   private String foo;

    @RequestMapping("foo.do")
    public String getFoo(){
        return foo;
    }


    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

}
