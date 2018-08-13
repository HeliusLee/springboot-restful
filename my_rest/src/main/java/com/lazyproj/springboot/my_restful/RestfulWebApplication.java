package com.lazyproj.springboot.my_restful;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lazyproj.springboot.my_restful.dao")
public class RestfulWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(RestfulWebApplication.class);
    }
}
